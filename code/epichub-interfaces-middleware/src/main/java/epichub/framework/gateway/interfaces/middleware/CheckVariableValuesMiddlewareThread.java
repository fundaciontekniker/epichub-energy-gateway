package epichub.framework.gateway.interfaces.middleware;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thalesgroup.it.ns.model.energy.EnergyDataMeasure;
import com.thalesgroup.it.ns.model.energy.EnergyDataVariable;
import com.thalesgroup.it.ns.model.res.AbstractResource;
import com.thalesgroup.it.ns.service.energy_unified.OperationFaultMessage;
import com.thalesgroup.it.ns.service.energy_unified.UnifiedService;
import com.thalesgroup.it.ns.service.energy_unified.UnsupportedFaultMessage;
import com.thalesgroup.it.ns.service.res.GetResourcesIn;
import com.thalesgroup.it.ns.service.res.GetResourcesOut;

import epichub.framework.gateway.spi.DatabaseService;
import eu.epichub.gateway.eg.core.gateway_subscription;
import eu.epichub.gateway.eg.core.gateway_value;
import eu.epichub.gateway.eg.core.gateway_variable;



public class CheckVariableValuesMiddlewareThread extends Thread{
	final static Logger logger = LoggerFactory.getLogger(CheckVariableValuesMiddlewareThread.class);
	
	private boolean active =true;
	
	int check_variables_value_interval = 0;
	int check_variables_value_interval_default = 5000;
	
	int check_variables_value_time_threshold = 0;
	int check_variables_value_time_threshold_default = 2500;
	
	boolean check_variables_value = false;
	String stringCheck_variables_value = null;
	
	private static DatabaseService database;
	
	public CheckVariableValuesMiddlewareThread(DatabaseService db){
				
		database = db;
		
		try{
			stringCheck_variables_value = System.getProperty("epichub.check_variables_value");		
			if(stringCheck_variables_value.equals("true"))
				check_variables_value = true;
		
			logger.debug("CheckVariableValuesMiddlewareThread Using [check_variables_value] property: "+ stringCheck_variables_value );
			
		}catch(Exception e){
			logger.debug("Error reading [epichub.check_variables_value] property. Using default: false");
			check_variables_value=false;
		}
		
		try{
			check_variables_value_interval = Integer.parseInt(System.getProperty("epichub.check_variables_value_interval"));
			if(check_variables_value_interval == 0){
				check_variables_value_interval = check_variables_value_interval_default;
			}
			logger.debug("Using [check_variables_value_interval] property: "+ check_variables_value_interval + " ms");
		}catch(Exception e){
			logger.debug("Error reading [epichub.check_variables_value_interval] property. Using check_variables_value_interval: 60000 ms");
			check_variables_value_interval=60000;
		}
			
		try{
			check_variables_value_time_threshold = Integer.parseInt(System.getProperty("epichub.check_variables_value_time_threshold"));
			if(check_variables_value_time_threshold == 0){
				check_variables_value_time_threshold = check_variables_value_time_threshold_default;
			}
			logger.debug("Using [check_variables_value_time_threshold] property: "+ check_variables_value_time_threshold + " ms");
		}catch(Exception e){
			logger.debug("Error reading [epichub.check_variables_value_time_threshold] property. Using check_variables_value_time_threshold: 20000 ms");
			check_variables_value_time_threshold=20000;
		}
	
	}
	
	@Override
	public void run() {
		
		if(check_variables_value){
			while(active){			
				CheckVariablesValuesAtMiddleware();
				
				try {
					sleep(check_variables_value_interval);
				} catch (InterruptedException e) {
					logger.error("CheckVariablesValuesAtMiddleware interrupted: ", e);
					return;
				}
			}
		}else{
			logger.debug("CheckVariablesValuesMiddlewareThread check_variables_value is set to false");
		}
		
	}
	
	public void setActive(boolean activebool){
		this.active=activebool;
	}
	
	private void CheckVariablesValuesAtMiddleware(){
		
		List<gateway_variable> listVariables = null;		
		List<gateway_subscription> listSubscriptions = null;
		List<String> listResourceid = null;
		String subscriberId = null;
		String variableId = null;
		GetResourcesOut rOut = null;
		gateway_value variableValue =null;
		String variableValueMiddlewareString = null;
		String variableValueDB = null;
		long diffTime =0;
		
		long variableValueTimeMiddleware = 0;
		long variableValueTimeDB = 0;
		XMLGregorianCalendar calendarVariableValueTimeMiddleware = null;
		
		logger.debug ("CheckVariablesValuesAtMiddleware START " );
		
		listSubscriptions = LoadSubscriptionsFromDB();
		for (gateway_subscription subscription : listSubscriptions){
			
			subscriberId = subscription.getSubscriber().getId();
			
			//logger.debug ("CheckVariablesValuesAtMiddleware subscriptionId : " + subscription.getId());						
			//logger.debug ("CheckVariablesValuesAtMiddleware subscriberId : " + subscriberId);
			
			listVariables = LoadVariables4SubscriptionFromDB(subscription.getId());
			
			for (gateway_variable var : listVariables){		
				diffTime =0;
				variableValueMiddlewareString = null;
				variableValueDB = null;
				
				variableId = var.getId() ;
				//logger.debug ("CheckVariablesValuesAtMiddleware varId : " + variableId );
				//logger.debug ("CheckVariablesValuesAtMiddleware deviceId : " + var.getDevice().getId());
												
				variableValue = GetLastValue4VariableFromDB(variableId);
				
				if(variableValue !=null){
					variableValueDB = variableValue.getValue();
					variableValueTimeDB = variableValue.getTimestamp();
					//logger.debug ("CheckVariablesValuesAtMiddleware variableValueDB : " +variableValueDB + " " + variableValueTimeDB);
				}else{
					logger.debug ("CheckVariablesValuesAtMiddleware variableValueDB is null ");
				}
				
				listResourceid = new ArrayList<String>();
				listResourceid.add(variableId);
				
				rOut = GetResources(subscriberId,listResourceid);
				
				if(rOut !=null){
					if (rOut.getResource().size() == 0) {
						logger.debug("CheckVariablesValuesAtMiddleware resourceId not found at Middleware, publish required " + variableId);
					}	else{
						//logger.debug("CheckVariablesValuesAtMiddleware resourceId found at Middleware");
						
						for (AbstractResource ar : rOut.getResource()) {
							//logger.debug("CheckVariablesValuesAtMiddleware " + ar.getId() + " - " + ar.getName() + "["+ ar.getTypeId() + "]");
							
							if (ar.getTypeId().contains("resource_type/variables")){
								
								if(ar.getId().equals(variableId)){
									//logger.debug("CheckVariablesValuesAtMiddleware variableId found " + variableId);
																		
									//Atributos especificos de EnergyDataVariable
									if(ar instanceof EnergyDataVariable)
									{
										EnergyDataVariable eDv=(EnergyDataVariable)ar;
										logger.debug("CheckVariablesValuesAtMiddleware [ENERGY_DATA_VARIABLE] " +
												"samplingUnit:"+eDv.getSamplingInterval()+"; " +
												"unit:"+eDv.getEnergyDataUnit()+"; " +
												"error(absolute):"+eDv.getAbsoluteMeasureError()+"; " +
												"error(%):"+eDv.getPercentageMeasureError()+"; " +
												"sePoint:"+eDv.getSetPointConfiguration() );
										
										if(eDv.getEnergyDataMeasures()!=null && eDv.getEnergyDataMeasures().getEnergyDataMeasure().size()>0){
											logger.debug("CheckVariablesValuesAtMiddleware [ENERGY_DATA_VARIABLE: Measures List]:");
											for(EnergyDataMeasure p:eDv.getEnergyDataMeasures().getEnergyDataMeasure()){
												logger.debug("CheckVariablesValuesAtMiddleware -{"+p.getTime()+"}: "+p.getMeasureValue() );
																							
												calendarVariableValueTimeMiddleware = p.getTime();
												variableValueTimeMiddleware = Utils.toDate(calendarVariableValueTimeMiddleware).getTime();
												
												variableValueMiddlewareString = String.valueOf(p.getMeasureValue());
												
												if(variableValueMiddlewareString != null){
													//logger.debug("CheckVariablesValuesAtMiddleware variableValueMiddlewareString is NOT null " +  variableValueMiddlewareString);
													
													if(variableValueDB != null){
														//logger.debug("CheckVariablesValuesAtMiddleware variableValueDB is NOT null " +  variableValueDB);
														
														if(variableValueMiddlewareString.equals(variableValueDB)){
															logger.debug("CheckVariablesValuesAtMiddleware variableValueDB is equal variableValueMiddlewareString " +  variableValueDB);
														}else{
															logger.debug("CheckVariablesValuesAtMiddleware variableValueDB " +  variableValueDB+ " is NOT equal variableValueMiddlewareString " +  variableValueMiddlewareString);
														}
														
														diffTime = (variableValueTimeMiddleware - variableValueTimeDB);
														if(variableValueTimeMiddleware == variableValueTimeDB){
															logger.debug("CheckVariablesValuesAtMiddleware variableValueTimeDB is equal variableValueTimeMiddleware " +  variableValueTimeDB);
														}else{
															
															//logger.debug("CheckVariablesValuesAtMiddleware variableValueTimeDB " + variableValueTimeDB +" is NOT equal variableValueTimeMiddleware " +variableValueTimeMiddleware +"  Diff "+  diffTime);
															
															if (diffTime >check_variables_value_time_threshold)
																logger.error("CheckVariablesValuesAtMiddleware CHECK_VARIABLE_VALUE_DIFF variableValueTimeMiddleware diffTime "  + diffTime + " is greater than the check_variables_value_time_threshold configured " + check_variables_value_time_threshold);
														}
															
														
													}
												}else{
													logger.debug("CheckVariablesValuesAtMiddleware variableValueMiddlewareString is null");
												}
											}
										};
									}
								}else{
									logger.error("CheckVariablesValuesAtMiddleware variableId NOT found " + variableId);
								}									
							}							
							else{
								logger.error("CheckVariablesValuesAtMiddleware resourceId does not contains resource_type/variables");
							}
						}					
					}
				}else{
					logger.error("CheckVariablesValuesAtMiddleware rOut is null");
				}
			}			
		}		
	}	
	

	public List<gateway_subscription> LoadSubscriptionsFromDB(){
		List<gateway_subscription> list = null;
		//logger.debug("LoadDevicesFromDB start");
		
		if (database != null){
			try {
				list = database.getAllSubscriptions();					
				
				if(list != null){					
					//logger.debug("LoadSubscriptionsFromDB Loaded Subscriptions from DB. Num :"+ list.size());
					
				}else{
					logger.debug("LoadSubscriptionsFromDB list of Subscriptions is null ");					
				}
				
			} catch (Exception e) {
				logger.error("LoadSubscriptionsFromDB Exception loading all Subscriptions:" + e.getMessage());
			}
		}else
			logger.error("LoadSubscriptionsFromDB Database is null ");
		
		//logger.debug("LoadSubscriptionsFromDB end");	
		return list;
	}

	private List<gateway_variable> LoadVariables4SubscriptionFromDB(String subId) {
		List<gateway_variable> list = null;
		try {
			list = database.getSubscriptionVariables(subId);
			if(list != null){					
				//logger.debug("LoadVariables4SubscriptionFromDB Loaded Variables from DB. Num :"+ list.size());
				
			}else{
				logger.debug("LoadVariables4SubscriptionFromDB list of Subscriptions is null ");					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("LoadVariables4SubscriptionFromDB Exception :"  +subId + " " + e.getMessage());			
		}
		
		return list;
	}

	
	
	public GetResourcesOut GetResources(String subscriberId, List<String> listResourceid){
		GetResourcesIn resourcesIn = null;
		UnifiedService port =  null;		
		GetResourcesOut rOut = null;
		
		resourcesIn = GatewayClient.GetResources_Request(listResourceid);
					
		port = GatewayClient.getPort4SubscriberId (subscriberId);		
		
		try {
			if(port !=null){
				rOut = port.getResources(resourcesIn);
				
				// GetResource_Response(rOut);
				if(rOut != null){
					if (rOut.getResource().size() == 0) {
						logger.info("GetResources : listResourceid  not found in middleware. Definition needed");
					} else{
						//logger.info("GetResources : listResourceid found in middleware.");
					}
				}else{
					logger.error("GetResources : rOut is null ");
				}
			}else
				logger.error("GetResources : port is null ");
			
			
		} catch (UnsupportedFaultMessage e) {
			e.printStackTrace();
			logger.error("GetResources : UnsupportedFaultMessage " + e.getMessage());
		} catch (OperationFaultMessage e) {
			e.printStackTrace();
			logger.error("GetResources : OperationFaultMessage " + e.getMessage());
		}
		
		return rOut;
		
	}	

	private gateway_value GetLastValue4VariableFromDB(String varId) {
		gateway_value value = null;
		List<gateway_value> list = null;
		try {
			list  = database.getVariableValues(varId, null, null);
			if(list != null){					
				//logger.debug("LoadVariables4SubscriptionFromDB Loaded Variables from DB. Num :"+ list.size());
				if(list.size()>0){
					value = list.get(list.size()-1);
					//logger.debug("LoadVariables4SubscriptionFromDB Loaded Variables last :"+ value.getTimestamp() + " " +value.getValue());
				}
				else
					logger.debug("LoadVariables4SubscriptionFromDB Loaded Variables list has 0 elements ");
				
			}else{
				logger.debug("LoadVariables4SubscriptionFromDB list of Subscriptions is null ");					
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("LoadVariables4SubscriptionFromDB Exception :"  +varId + " " + e.getMessage());			
		}
		
		return value;
	}

	public boolean getActive() {
		return this.active;
	}
	
}
