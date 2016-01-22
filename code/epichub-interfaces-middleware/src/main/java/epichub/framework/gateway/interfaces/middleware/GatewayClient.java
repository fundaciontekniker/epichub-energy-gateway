package epichub.framework.gateway.interfaces.middleware;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;



import javax.xml.ws.BindingProvider;



/*
import javax.xml.ws.WebServiceFeature;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
*/
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.thalesgroup.it.ns.model.alarm.Alarm;
import com.thalesgroup.it.ns.model.alarm.Alarm.ResourceIds;
import com.thalesgroup.it.ns.model.alarm.AlarmSeverity;
import com.thalesgroup.it.ns.model.alarm.AlarmStatus;
import com.thalesgroup.it.ns.model.core.Location;
import com.thalesgroup.it.ns.model.core.Unit;
import com.thalesgroup.it.ns.model.energy.EnergyDataVariable;
import com.thalesgroup.it.ns.model.loc.Point;
import com.thalesgroup.it.ns.model.loc.Position;
import com.thalesgroup.it.ns.model.res.AbstractResource;
import com.thalesgroup.it.ns.model.res.Property;
import com.thalesgroup.it.ns.model.res.Relation;
import com.thalesgroup.it.ns.model.res.Resource;
import com.thalesgroup.it.ns.model.res.Resource.Relations;
import com.thalesgroup.it.ns.model.res.State;
import com.thalesgroup.it.ns.service.alarm.AlarmEvent;
import com.thalesgroup.it.ns.service.alarm.AlarmEvent.AlarmDefinitions;
import com.thalesgroup.it.ns.service.alarm.AlarmEvent.AlarmUpdates;
import com.thalesgroup.it.ns.service.alarm.AlarmUpdate.AdditionalResourceIds;
import com.thalesgroup.it.ns.service.alarm.AlarmUpdate.RemovedResourceIds;
import com.thalesgroup.it.ns.service.core.FastPublishIn;
import com.thalesgroup.it.ns.service.core.Header;
import com.thalesgroup.it.ns.service.core.PublishIn;
import com.thalesgroup.it.ns.service.core.PublishOut;
import com.thalesgroup.it.ns.service.energy_unified.EnergyUnifiedServiceService;
import com.thalesgroup.it.ns.service.energy_unified.EventFaultMessage;
import com.thalesgroup.it.ns.service.energy_unified.OperationFaultMessage;
import com.thalesgroup.it.ns.service.energy_unified.UnifiedService;
import com.thalesgroup.it.ns.service.energy_unified.UnsupportedFaultMessage;
import com.thalesgroup.it.ns.service.res.GetResourcesIn;
import com.thalesgroup.it.ns.service.res.GetResourcesOut;
import com.thalesgroup.it.ns.service.res.ListResourcesIn;
import com.thalesgroup.it.ns.service.res.ListResourcesOut;
import com.thalesgroup.it.ns.service.res.ResourceEvent;
import com.thalesgroup.it.ns.service.res.ResourceEvent.ResourceDefinitions;
import com.thalesgroup.it.ns.service.res.ResourceEvent.ResourceUpdates;
import com.thalesgroup.it.ns.service.res.ResourceFilter;
import com.thalesgroup.it.ns.service.res.ResourceFilter.ResourceTypeIds;
import com.thalesgroup.it.ns.service.res.ResourceUpdate;

import epichub.framework.gateway.spi.CoreService;
import epichub.framework.gateway.spi.DatabaseService;
import eu.epichub.gateway.eg.core.gateway_subscriber;


public class GatewayClient implements GatewayService {
	private final static Logger logger = LoggerFactory.getLogger(GatewayClient.class);

	static String consumerId_gateway;
	static String typeId_states_device = "urn:rixf:eu.epichub/states/device";
	static String typeId_states_variable = "urn:rixf:eu.epichub/states/variable";
	static String typeId_sensor_variable_relation = "urn:rixf:eu.epichub/relations/sensor_device";
	static String typeId_sensor_device_relation = "urn:rixf:eu.epichub/relations/sensor_variable";

	
	private static int TIMEOUT = 5000;
	// -------------------------------
	// private static final QName SERVICE_NAME = new
	// QName("http://it.thalesgroup.com/ns/service/epichub","EpichubServiceService");
	private static final QName SERVICE_NAME = new QName(
			"http://it.thalesgroup.com/ns/service/energy_unified",
			"EnergyUnifiedServiceService");
	//static UnifiedService port;
	
	static HashMap<String,UnifiedService> hashMapPort = null;
	static HashMap<String,String> hashMapSubscribersEndpoint= null;
	

	static Executor pool = Executors.newFixedThreadPool(5);

	private static DatabaseService database;

	static CoreService coreService;
	CheckVariableValuesMiddlewareThread checkVariableValuesMiddlewareThread = null;
	CheckEventsMngrThread checkEventsMngrThread  =null;
	
	boolean initDone =false;
	
	public GatewayClient() throws Exception {
		logger.debug("Creating GatewayClient");
		
		try {
			consumerId_gateway = System.getProperty("wsdl.client.defaultConsumerId");
			if (consumerId_gateway == null) {
				consumerId_gateway = "urn:rixf:eu.epichub/consumer/gateway";
			}
			logger.debug("GatewayClient consumerId_gateway " +consumerId_gateway);
			
			
			//new WaitThread().start();
			
			
/*
			String endpoint = System.getProperty("wsdl.client.url");
			if (endpoint == null) {
				endpoint = "http://epichub_dev:9090/EpichubServicePort";
			}
			logger.debug("Wsdl file path:" + endpoint);
			URL wsdlURL = new URL(endpoint);
			EnergyUnifiedServiceService ss = new EnergyUnifiedServiceService(wsdlURL,
					SERVICE_NAME);
			
			port = ss.getUnifiedServicePort();
			logger.debug("GatewayClient created");
*/
		} catch (Exception e) {
			logger.error("Error creating GatewayClient:" + e.getMessage());
			throw e;
		}
	}

	// ----Setter/Unsetters---------
	protected void activate(ComponentContext context) {
		logger.debug("Activate GatewayClient");
		try {
			/* TestHostConfig("urn:rixf:eu.epichub/consumer/gateway"); */
			
			//logger.debug("GatewayClient activate");
			if(coreService != null)
				logger.debug("GatewayClient coreservice is not null");
			else
				logger.debug("GatewayClient coreservice is null");
			
			if(database != null)
				logger.debug("GatewayClient database is not null");
			else
				logger.debug("GatewayClient database is null");
			
			
			if(database != null && coreService != null){
				logger.debug("GatewayClient call initBundle ");
				initBundle();
			}
			else
				logger.debug("GatewayClient call initBundle NOT DONE");
			
		} catch (Exception e) {
			logger.error("GatewayClient : activate_Exception " + e.getMessage());
		}
	}

	protected void deactivate(ComponentContext context) {
		logger.debug("deactivate GatewayClient start ");
		
		if(checkVariableValuesMiddlewareThread!=null){
			checkVariableValuesMiddlewareThread.setActive(false);
			if(checkVariableValuesMiddlewareThread.getActive())
				logger.debug("deactivate GatewayClient checkVariableValuesMiddlewareThread active value is TRUE");
			else
				logger.debug("deactivate GatewayClient checkVariableValuesMiddlewareThread active value is FALSE");
		}
		else
			logger.debug("deactivate GatewayClient checkVariableValuesMiddlewareThread is null");
		
		if(checkEventsMngrThread !=null){
			checkEventsMngrThread.setActive(false);

			if(checkEventsMngrThread.getActive())
				logger.debug("deactivate GatewayClient checkEventsMngrThread active value is TRUE");
			else
				logger.debug("deactivate GatewayClient checkEventsMngrThread active value is FALSE");
		}
		else
			logger.debug("deactivate GatewayClient checkEventsMngrThread is null");
		
		
		//checkVariableValuesMiddlewareThread = null;
		//checkEventsMngrThread = null;
		logger.debug("deactivate GatewayClient after thread set active false");
		
		
		
		try{
			if(checkVariableValuesMiddlewareThread!=null)
				checkVariableValuesMiddlewareThread.interrupt();
			if(checkEventsMngrThread !=null)
				checkEventsMngrThread.interrupt();
		}catch (Exception e){
			logger.error ("deactivate GatewayClient exceptin on interrupt thread " + e.getMessage());	
		}
		
		logger.debug("deactivate GatewayClient end");
		
	}
	

	@Override
	public void publish_DeviceStateUpdate(String subscriberId,String devId, String state) {

		logger.debug("Invoking deviceStatusChange devId:" + devId + "state:" + state);
		List<String> dL = new ArrayList<String>();
		dL.add(devId);

		List<String> sL = new ArrayList<String>();
		sL.add(state);
		
		publishData(subscriberId,publishDeviceStateUpdate(dL, sL));
		
		/*
		try {		
			port.publish(publishDeviceStateUpdate(dL, sL));
		} catch (OperationFaultMessage e) {
			logger.error("Expected exception: operationFaultMessage has occurred.");
			logger.error(e.toString());
		} catch (UnsupportedFaultMessage e) {
			logger.error("Expected exception: unsupportedFaultMessage has occurred.");
			logger.error(e.toString());
		} catch (EventFaultMessage e) {
			logger.error("Expected exception: eventFaultMessage has occurred.");
			logger.error(e.toString());
		}catch (Exception e) {
			logger.error("Unexpected exception:");
			logger.error(e.getMessage());
		}*/
	}

	@Override
	public String publish_AlarmDefinition(String subscriberId, String devId, String alarmSeverity,
			String alarmType, String alarmStatus, String alarmMessage) {
		logger.debug("Invoking publish_AlarmDefinition...");

		long date = System.currentTimeMillis();
		String alarmId = "urn:rixf:eu.epichub/alarms/alarm_" + date;
		
		publishData(subscriberId,publishAlarmDefinition( devId, alarmId, null,
				alarmType, AlarmStatus.fromValue(alarmStatus),
				AlarmSeverity.fromValue(alarmSeverity), alarmMessage, date));
		/*
		try {
			port.publish(publishAlarmDefinition(devId, alarmId, null,
					alarmType, AlarmStatus.fromValue(alarmStatus),
					AlarmSeverity.fromValue(alarmSeverity), alarmMessage, date));

		} catch (OperationFaultMessage e) {
			logger.error("Expected exception: operationFaultMessage has occurred.");
			logger.error(e.toString());
		} catch (UnsupportedFaultMessage e) {
			logger.error("Expected exception: unsupportedFaultMessage has occurred.");
			logger.error(e.toString());
		} catch (EventFaultMessage e) {
			logger.error("Expected exception: eventFaultMessage has occurred.");
			logger.error(e.toString());
		}catch (Exception e) {
			logger.error("Unexpected exception:");
			logger.error(e.getMessage());
		}*/
		return alarmId;
	}

	@Override
	public void publish_AlarmUpdate(String subscriberId, String alarmId, String devId,
			String alarmStatus, String alarmMessage) {
		logger.debug("Invoking publish_AlarmUpdate...");
		long date = System.currentTimeMillis();
		
		publishData(subscriberId,publishAlarmUpdate(devId, alarmId,
				AlarmStatus.fromValue(alarmStatus), null, alarmMessage,
				null, date));
		
		/*
		try {
			port.publish(publishAlarmUpdate(devId, alarmId,
					AlarmStatus.fromValue(alarmStatus), null, alarmMessage,
					null, date));

		} catch (OperationFaultMessage e) {
			logger.error("Expected exception: operationFaultMessage has occurred.");
			logger.error(e.toString());
		} catch (UnsupportedFaultMessage e) {
			logger.error("Expected exception: unsupportedFaultMessage has occurred.");
			logger.error(e.toString());
		} catch (EventFaultMessage e) {
			logger.error("Expected exception: eventFaultMessage has occurred.");
			logger.error(e.toString());
		}catch (Exception e) {
			logger.error("Unexpected exception:");
			logger.error(e.getMessage());
		}*/
	}

	

	// ------------------------------------------

	public PublishIn publishDeviceStateUpdate(List<String> devId,
			List<String> stateValue) {
		logger.debug("publishDeviceStateUpdate");
		XMLGregorianCalendar xmlg_date = Utils.toXMLGregorianCalendar(new Date(
				System.currentTimeMillis()));

		PublishIn _publish_parameters = new PublishIn();
		_publish_parameters.setHeader(new Header());
		_publish_parameters.getHeader().setConsumerId(consumerId_gateway);
		_publish_parameters.getHeader().setRequestTime(xmlg_date);

		for (int i = 0; i < devId.size(); i++) {
			ResourceEvent rE = new ResourceEvent();
			rE.setTime(xmlg_date);
			rE.setResourceUpdates(new ResourceUpdates());

			ResourceUpdate rU = new ResourceUpdate();
			rU.setResourceId(devId.get(i));

			State rS = new State();
			rS.setTypeId(typeId_states_device);
			rS.setTime(xmlg_date);
			rS.setValue(stateValue.get(i));
			rU.getState().add(rS);

			rE.getResourceUpdates().getUpdate().add(rU);
			_publish_parameters.getEvent().add(rE);
		}
		return _publish_parameters;
	}

	public PublishIn publishAlarmDefinition(String devId, String alarmId,
			String alarmName, String alarmType, AlarmStatus alarmStatus,
			AlarmSeverity alarmSeverity, String alarmMessage, Long alarmOpenDate) {
		XMLGregorianCalendar xmlg_date = Utils.toXMLGregorianCalendar(new Date(
				System.currentTimeMillis()));

		PublishIn _publish_parameters = new PublishIn();
		_publish_parameters.setHeader(new Header());
		_publish_parameters.getHeader().setConsumerId(consumerId_gateway);
		_publish_parameters.getHeader().setRequestTime(xmlg_date);

		AlarmEvent aE = new AlarmEvent();
		aE.setTime(xmlg_date);
		aE.setAlarmDefinitions(new AlarmDefinitions());

		Alarm a = new Alarm();
		a.setId(alarmId);
		a.setTypeId(alarmType);
		a.setSeverity(alarmSeverity);
		a.setStatus(alarmStatus);
		if (alarmMessage != null)
			a.setMessage(alarmMessage);
		if (alarmName != null)
			a.setName(alarmName);
		a.setOpenTime(Utils.toXMLGregorianCalendar(new Date(alarmOpenDate)));
		a.setLocation(getDeviceLocation(devId));
		a.setResourceIds(new ResourceIds());
		a.getResourceIds().getResourceId().add(devId);

		aE.getAlarmDefinitions().getAlarm().add(a);
		_publish_parameters.getEvent().add(aE);
		return _publish_parameters;
	}

	/**
	 *  
	 */
	public PublishIn publishAlarmUpdate(String devId, String alarmId,
			AlarmStatus alarmStatus, AlarmSeverity alarmSeverity,
			String alarmMessage, Long alarmOpenDate, Long alarmCloseDate) {
		XMLGregorianCalendar xmlg_date = Utils.toXMLGregorianCalendar(new Date(
				System.currentTimeMillis()));

		PublishIn _publish_parameters = new PublishIn();
		_publish_parameters.setHeader(new Header());
		_publish_parameters.getHeader().setConsumerId(consumerId_gateway);
		_publish_parameters.getHeader().setRequestTime(xmlg_date);

		AlarmEvent aE = new AlarmEvent();
		aE.setTime(xmlg_date);
		aE.setAlarmUpdates(new AlarmUpdates());

		com.thalesgroup.it.ns.service.alarm.AlarmUpdate aU = new com.thalesgroup.it.ns.service.alarm.AlarmUpdate();
		aU.setAlarmId(alarmId);
		aU.setStatus(alarmStatus);
		if (alarmSeverity != null)
			aU.setSeverity(alarmSeverity);
		if (alarmMessage != null)
			aU.setMessage(alarmMessage);
		if (alarmOpenDate != null)
			aU.setOpenTime(Utils.toXMLGregorianCalendar(new Date(alarmOpenDate)));
		if (alarmCloseDate != null)
			aU.setCloseTime(Utils.toXMLGregorianCalendar(new Date(alarmCloseDate)));

		aU.setRemovedResourceIds(new RemovedResourceIds());
		aU.getRemovedResourceIds().getResourceId().add(devId);

		aE.getAlarmUpdates().getUpdate().add(aU);
		_publish_parameters.getEvent().add(aE);
		return _publish_parameters;
	}

	public FastPublishIn fastPublishDeviceAlarm(String devId, long timestamp,
			String message) {
		FastPublishIn pIn = new FastPublishIn();
		return pIn;
	}

	/**
	 * Crea un objeto eu.epichub.gateway.cdm.Location
	 * <p>
	 * Si se incluyen 'x' e 'y', el objeto devuelto será Position
	 */
	private Location createLocation(String reference, Unit unit, Double x,
			Double y, Double z, Double accuracy, Double v_accuracy) {
		if (x != null && y != null) {
			Position ps = new Position();
			ps.setReferenceId(reference);
			ps.setUnit(unit);
			Point p = new Point();
			p.setX(x);
			p.setY(y);
			p.setZ(z);
			ps.setPoint(p);
			ps.setAccuracy(accuracy);
			ps.setVerticalAccuracy(v_accuracy);
			return ps;
		} else {
			Location l = new Location();
			l.setReferenceId(reference);
			l.setUnit(unit);
			return l;
		}
	}

	// ---Listar por tipo de recuso (llamada)
	public ListResourcesIn ListResourcePerType_Request(String type) {
		XMLGregorianCalendar xmlg_date = Utils.toXMLGregorianCalendar(new Date(
				System.currentTimeMillis()));

		ListResourcesIn _listResourcesIn = new ListResourcesIn();
		_listResourcesIn.setHeader(new Header());
		_listResourcesIn.getHeader().setConsumerId(consumerId_gateway);
		_listResourcesIn.getHeader().setRequestTime(xmlg_date);

		ResourceFilter rF = new ResourceFilter();
		rF.setResourceTypeIds(new ResourceTypeIds());
		rF.getResourceTypeIds().getResourceTypeId().add(type);
		_listResourcesIn.setResourceFilter(rF);
		return _listResourcesIn;
	}

	public void ListResourcePerType_Response(ListResourcesOut _listResourcesOut) {
		for (String rId : _listResourcesOut.getResourceId())
			logger.info(rId);
	}

	
	// ---Listar por tipo de recuso (llamada)
	public static GetResourcesIn GetResources_Request(List<String> ids) {
		XMLGregorianCalendar xmlg_date = Utils.toXMLGregorianCalendar(new Date(
				System.currentTimeMillis()));

		GetResourcesIn _getResourcesIn = new GetResourcesIn();
		_getResourcesIn.setHeader(new Header());
		_getResourcesIn.getHeader().setConsumerId(consumerId_gateway);
		_getResourcesIn.getHeader().setRequestTime(xmlg_date);

		for (String id : ids)
			_getResourcesIn.getResourceId().add(id);
		return _getResourcesIn;
	}
	

	public void GetResource_Response(GetResourcesOut _getResourcesOut) {
		for (AbstractResource r : _getResourcesOut.getResource()) {
			{// Atributos comunes a todos los Abstract Resource
				logger.info("[Abstract Resource] " + "Name:" + r.getName()
						+ "; " + "id:" + r.getId() + "; " + "typeId:"
						+ r.getTypeId() + "; " + "parentId:" + r.getParentId()
						+ "; " + "expirationDate:" + r.getExpiration() + "; "
						+ "Location:" + r.getLocation() + ";");

				// La clase Resource TIENE 3 listas adicionales: Propiedades,
				// Relaciones y Estados
				if (r instanceof Resource) {
					Resource eR = (Resource) r;
					if (eR.getProperties() != null
							&& eR.getProperties().getProperty().size() > 0) {
						logger.info("[Resource: Property List]:");
						for (Property p : eR.getProperties().getProperty())
							logger.info("[" + p.getTypeId() + "]:"
									+ p.getValue());
					}
					;
					if (eR.getRelations() != null
							&& eR.getRelations().getRelation().size() > 0) {
						logger.info("[Resource: Relation List]:");
						for (Relation p : eR.getRelations().getRelation())
							logger.info("[" + p.getTypeId() + "]:"
									+ p.getRelatedId());

					}
					;
					if (eR.getStates() != null
							&& eR.getStates().getState().size() > 0) {
						logger.info("[Resource: State List]:");
						for (State p : eR.getStates().getState())
							logger.info("[" + p.getTypeId() + "]:"
									+ p.getValue() + "{" + p.getTime() + "}");
					}
					;
				}
				// Atributos especificos de EnergyDataVariable
				/*
				 * if(r instanceof EnergyDataVariable) { EnergyDataVariable
				 * eDv=(EnergyDataVariable)r;
				 * logger.info("[ENERGY_DATA_VARIABLE] " +
				 * "samplingUnit:"+eDv.getSamplingInterval()+"; " +
				 * "unit:"+eDv.getEnergyDataUnit()+"; " +
				 * "error(absolute):"+eDv.getAbsoluteMeasureError()+"; " +
				 * "error(%):"+eDv.getPercentageMeasureError()+"; " +
				 * "sePoint:"+eDv.getSetPointConfiguration() );
				 * 
				 * if(eDv.getEnergyDataMeasures()!=null &&
				 * eDv.getEnergyDataMeasures().getEnergyDataMeasure().size()>0){
				 * logger.info("[ENERGY_DATA_VARIABLE: Measures List]:");
				 * for(EnergyDataMeasure
				 * p:eDv.getEnergyDataMeasures().getEnergyDataMeasure())
				 * logger.info("-{"+p.getTime()+"}: "+p.getMeasureValue());
				 * 
				 * }; }
				 */
			}
		}
	}

	@Override
	public void publish_DeviceStateUpdate(String subscriberId,List<String> device_Ids, String state) {
		logger.debug("Invoking deviceStatusChange...");
		try {
			XMLGregorianCalendar xmlg_date = Utils.toXMLGregorianCalendar(new Date(
					System.currentTimeMillis()));

			PublishIn _publish_parameters = new PublishIn();
			_publish_parameters.setHeader(new Header());
			_publish_parameters.getHeader().setConsumerId(consumerId_gateway);
			_publish_parameters.getHeader().setRequestTime(xmlg_date);

			for (String d : device_Ids) {
				ResourceEvent rE = new ResourceEvent();
				rE.setTime(xmlg_date);
				rE.setResourceUpdates(new ResourceUpdates());

				ResourceUpdate rU = new ResourceUpdate();
				rU.setResourceId(d);
				State rS = new State();
				rS.setTypeId(typeId_states_device);
				rS.setTime(xmlg_date);
				rS.setValue(state);
				rU.getState().add(rS);
				rE.getResourceUpdates().getUpdate().add(rU);

				_publish_parameters.getEvent().add(rE);

			}

			publishData(subscriberId,_publish_parameters);
			/*
			PublishOut pOut = port.publish(_publish_parameters);
			logger.info(pOut.toString());
			*/
			logger.debug("deviceStatusChange invoked");
		/*} catch (OperationFaultMessage e) {
			logger.error("Expected exception: operationFaultMessage has occurred.");
			logger.error(e.toString());
		} catch (UnsupportedFaultMessage e) {
			logger.error("Expected exception: unsupportedFaultMessage has occurred.");
			logger.error(e.toString());
		} catch (EventFaultMessage e) {
			logger.error("Expected exception: eventFaultMessage has occurred.");
			logger.error(e.toString());
		*/
		}catch (Exception e) {
			logger.error("Unexpected exception:");
			logger.error(e.getMessage());
		}
	}

	// @Override
	public void publish_DeviceStateUpdate(String subscriberId, List<DeviceState> dS_List) {
		logger.debug("Invoking deviceStatusChange...");
		try {
			XMLGregorianCalendar xmlg_date = Utils.toXMLGregorianCalendar(new Date(
					System.currentTimeMillis()));

			PublishIn _publish_parameters = new PublishIn();
			_publish_parameters.setHeader(new Header());
			_publish_parameters.getHeader().setConsumerId(consumerId_gateway);
			_publish_parameters.getHeader().setRequestTime(xmlg_date);

			for (DeviceState d : dS_List) {
				ResourceEvent rE = new ResourceEvent();
				rE.setTime(xmlg_date);
				rE.setResourceUpdates(new ResourceUpdates());

				ResourceUpdate rU = new ResourceUpdate();
				rU.setResourceId(d.devId);
				State rS = new State();
				rS.setTypeId(typeId_states_device);
				rS.setTime(xmlg_date);
				rS.setValue(d.state);
				rU.getState().add(rS);
				rE.getResourceUpdates().getUpdate().add(rU);

				_publish_parameters.getEvent().add(rE);

			}

			
			
			publishData(subscriberId,_publish_parameters);
			logger.debug("deviceStatusChange invoked");
			/*
			PublishOut pOut = port.publish(_publish_parameters);
			logger.info(pOut.toString());			
		} catch (OperationFaultMessage e) {
			logger.error("Expected exception: operationFaultMessage has occurred.");
			logger.error(e.toString());
		} catch (UnsupportedFaultMessage e) {
			logger.error("Expected exception: unsupportedFaultMessage has occurred.");
			logger.error(e.toString());
		} catch (EventFaultMessage e) {
			logger.error("Expected exception: eventFaultMessage has occurred.");
			logger.error(e.toString());
			*/
		}catch (Exception e) {
			logger.error("Unexpected exception:");
			logger.error(e.getMessage());
		}

	}

	// @Override
	public void publish_AlarmDefinition(String subscriberId, List<AlarmDefinition> aD_List) {
		logger.debug("Invoking publish_AlarmDefinition...");
		try {
			XMLGregorianCalendar xmlg_date = Utils.toXMLGregorianCalendar(new Date(
					System.currentTimeMillis()));

			PublishIn _publish_parameters = new PublishIn();
			_publish_parameters.setHeader(new Header());
			_publish_parameters.getHeader().setConsumerId(consumerId_gateway);
			_publish_parameters.getHeader().setRequestTime(xmlg_date);

			for (AlarmDefinition aDef : aD_List) {
				AlarmEvent aE = new AlarmEvent();
				aE.setTime(xmlg_date);
				aE.setAlarmDefinitions(new AlarmDefinitions());

				Alarm a = new Alarm();
				a.setId(aDef.alarmId);
				if (aDef.alarmType != null)
					a.setTypeId(aDef.alarmType);
				if (aDef.alarmSeverity != null)
					a.setSeverity(AlarmSeverity.valueOf(aDef.alarmSeverity));
				if (aDef.alarmStatus != null)
					a.setStatus(AlarmStatus.valueOf(aDef.alarmStatus));
				if (aDef.alarmMessage != null)
					a.setMessage(aDef.alarmMessage);
				if (aDef.alarmName != null)
					a.setName(aDef.alarmName);
				if (aDef.alarmOpenDate != null)
					a.setOpenTime(Utils.toXMLGregorianCalendar(new Date(
							aDef.alarmOpenDate)));
				if (aDef.alarmCloseDate != null)
					a.setCloseTime(Utils.toXMLGregorianCalendar(new Date(
							aDef.alarmCloseDate)));
				a.setLocation(createLocation(
						"urn:rixf:eu.epichub/genoa/tsg_port", Unit.LAT_LON,
						11.456, 43.456, null, null, null));

				if (aDef.devId.size() > 0) {
					a.setResourceIds(new ResourceIds());
					for (String dId : aDef.devId)
						a.getResourceIds().getResourceId().add(dId);
				}

				aE.getAlarmDefinitions().getAlarm().add(a);
				_publish_parameters.getEvent().add(aE);
			}

			
			
			publishData(subscriberId, _publish_parameters);
			/*
			port.publish(_publish_parameters);

		} catch (OperationFaultMessage e) {
			logger.error("Expected exception: operationFaultMessage has occurred.");
			logger.error(e.toString());
		} catch (UnsupportedFaultMessage e) {
			logger.error("Expected exception: unsupportedFaultMessage has occurred.");
			logger.error(e.toString());
		} catch (EventFaultMessage e) {
			logger.error("Expected exception: eventFaultMessage has occurred.");
			logger.error(e.toString());
			*/
		}catch (Exception e) {
			logger.error("Unexpected exception:");
			logger.error(e.getMessage());
		}
	}

	// @Override
	public void publish_AlarmUpdate( String subscriberId,
			List<epichub.framework.gateway.interfaces.middleware.AlarmUpdate> aU_List) {
		logger.debug("Invoking publish_AlarmUpdate...");
		try {
			XMLGregorianCalendar xmlg_date = Utils.toXMLGregorianCalendar(new Date(
					System.currentTimeMillis()));

			PublishIn _publish_parameters = new PublishIn();
			_publish_parameters.setHeader(new Header());
			_publish_parameters.getHeader().setConsumerId(consumerId_gateway);
			_publish_parameters.getHeader().setRequestTime(xmlg_date);

			AlarmEvent aE = new AlarmEvent();
			aE.setTime(xmlg_date);
			aE.setAlarmUpdates(new AlarmUpdates());

			for (AlarmUpdate aUpd : aU_List) {
				com.thalesgroup.it.ns.service.alarm.AlarmUpdate aU = new com.thalesgroup.it.ns.service.alarm.AlarmUpdate();
				aU.setAlarmId(aUpd.alarmId);
				if (aUpd.alarmStatus != null)
					aU.setStatus(AlarmStatus.valueOf(aUpd.alarmStatus));
				if (aUpd.alarmSeverity != null)
					aU.setSeverity(AlarmSeverity.valueOf(aUpd.alarmSeverity));
				if (aUpd.alarmMessage != null)
					aU.setMessage(aUpd.alarmMessage);
				if (aUpd.alarmOpenDate != null)
					aU.setOpenTime(Utils.toXMLGregorianCalendar(new Date(
							aUpd.alarmOpenDate)));
				if (aUpd.alarmCloseDate != null)
					aU.setCloseTime(Utils.toXMLGregorianCalendar(new Date(
							aUpd.alarmCloseDate)));

				if (aUpd.removedDevId.size() > 0) {
					aU.setRemovedResourceIds(new RemovedResourceIds());
					for (String devId : aUpd.removedDevId)
						aU.getRemovedResourceIds().getResourceId().add(devId);
				}
				if (aUpd.addedDevId.size() > 0) {
					aU.setAdditionalResourceIds(new AdditionalResourceIds());
					for (String devId : aUpd.addedDevId)
						aU.getAdditionalResourceIds().getResourceId()
								.add(devId);
				}

				aE.getAlarmUpdates().getUpdate().add(aU);
				_publish_parameters.getEvent().add(aE);
			}

			publishData(subscriberId, _publish_parameters);
			
			/*
			port.publish(_publish_parameters);

		} catch (OperationFaultMessage e) {
			logger.error("Expected exception: operationFaultMessage has occurred.");
			logger.error(e.toString());
		} catch (UnsupportedFaultMessage e) {
			logger.error("Expected exception: unsupportedFaultMessage has occurred.");
			logger.error(e.toString());
		} catch (EventFaultMessage e) {
			logger.error("Expected exception: eventFaultMessage has occurred.");
			logger.error(e.toString());
			*/
		} catch (Exception e) {
			logger.error("Unexpected exception:");
			logger.error(e.getMessage());
		}
		logger.debug("publish_AlarmUpdate finished");
	}

	@Override
	public void check_publish_DeviceResourceDefinition(String subscriberId, String devId,
			String devName, String devParentId, String devTypeId,
			List<VariableDefinition> resList) 
	{
		
		logger.debug("check_publish_DeviceResourceDefinition NOT IMPLEMENTED . TO BE REVIEWED");
		
			
		GetResourcesIn rIn = new GetResourcesIn();
		rIn.getResourceId().add(devId);
		
		UnifiedService port =  null;		
		port = getPort4SubscriberId (subscriberId);
		
		GetResourcesOut rOut;
		try {
			if (port !=null){
				rOut = port.getResources(rIn);
				
				// GetResource_Response(rOut);
				if (rOut.getResource().size() == 0) {
					logger.info(devId
							+ " not found in middleware. Definition needed");
				} else{
					for (AbstractResource ar : rOut.getResource()) {
						if (ar.getTypeId().contains("resource_type/devices"))
							logger.info(ar.getId() + " - " + ar.getName() + "["
									+ ar.getTypeId() + "]");
					}
				}
			}else
				logger.error("check_publish_DeviceResourceDefinition port is null ");
			
			
		} catch (UnsupportedFaultMessage e) {
			logger.error("UnsupportedFaultMessage exception in check_publish_DeviceResourceDefinition: ", e);
		} catch (OperationFaultMessage e) {
			logger.error("OperationFaultMessage exception in check_publish_DeviceResourceDefinition: ", e);
		}
			
			// if(rOut.getResource().size()==0){
			// publish_DeviceResourceDefinition(devId, devName, devParentId,
			// devTypeId, resList);
			// }
		
			

	}

	@Override
	public void publish_DeviceResourceDefinition(String subscriberId, String devId, String devName,
			String devParentId, String devTypeId,
			List<VariableDefinition> resList) {
		logger.debug("Invoking publish_DeviceDefinition [" + devId + "]...");
		try {
			XMLGregorianCalendar xmlg_date = Utils.toXMLGregorianCalendar(new Date(
					System.currentTimeMillis()));

			PublishIn _publish_parameters = new PublishIn();
			_publish_parameters.setHeader(new Header());
			_publish_parameters.getHeader().setConsumerId(consumerId_gateway);
			_publish_parameters.getHeader().setRequestTime(xmlg_date);

			ResourceEvent rE = new ResourceEvent();
			rE.setTime(xmlg_date);
			rE.setResourceDefinitions(new ResourceDefinitions());

			Resource devRes = new Resource();
			devRes.setId(devId);
			devRes.setName(devName);
			devRes.setParentId(devParentId);
			devRes.setTypeId(devTypeId);
			devRes.setLocation(getDeviceLocation(devId));
			devRes.setRelations(new Relations());

			for (VariableDefinition var : resList) {
				EnergyDataVariable varDef = new EnergyDataVariable();
				varDef.setId(var.varId);
				if (var.name != null)
					varDef.setName(var.name);
				if (var.parentId != null)
					varDef.setParentId(var.parentId);
				if (var.typeId != null)
					varDef.setTypeId(var.typeId);
				if (var.absoluteMeasureError != null)
					varDef.setAbsoluteMeasureError(var.absoluteMeasureError);
				
				if (var.energyDataUnit != null)
					varDef.setEnergyDataUnit(var.energyDataUnit);
				varDef.setRelations(new Relations());

				Relation rel_sd = new Relation();
				rel_sd.setTypeId(typeId_sensor_device_relation);
				rel_sd.setRelatedId(devId);
				varDef.getRelations().getRelation().add(rel_sd);

				Relation rel_sv = new Relation();
				rel_sv.setTypeId(typeId_sensor_variable_relation);
				rel_sv.setRelatedId(var.varId);
				devRes.getRelations().getRelation().add(rel_sv);

				rE.getResourceDefinitions().getResource().add(varDef);
			}

			rE.getResourceDefinitions().getResource().add(devRes);

			_publish_parameters.getEvent().add(rE);

			publishData(subscriberId, _publish_parameters);
			
			/*
			port.publish(_publish_parameters);

		} catch (OperationFaultMessage e) {
			logger.error("Expected exception: operationFaultMessage has occurred.");
			logger.error(e.toString());
		} catch (UnsupportedFaultMessage e) {
			logger.error("Expected exception: unsupportedFaultMessage has occurred.");
			logger.error(e.toString());
		} catch (EventFaultMessage e) {
			logger.error("Expected exception: eventFaultMessage has occurred.");
			logger.error(e.toString());
			*/
		} catch (Exception e) {
			logger.error("Unexpected exception:");
			logger.error(e.getMessage());
		}

		logger.debug("publish_DeviceDefinition [" + devId + "] finished");
	}

	@Override
	public void publish_DeviceResourceUpdate(String suscriberId, String devId, String devState,
			List<VariableUpdate> updList) {
		publish_DeviceResourceUpdate_Call c = new publish_DeviceResourceUpdate_Call(
				suscriberId,devId, devState, updList);
		pool.execute(c);
	}


	private Location getDeviceLocation(String devId) {
		// TODO OBTENER DATOS DE LOCALIZACIÓN A PARTIR DE LAS configOptions del
		// dispositivo
		// De momento devuelve siempre la misma...
		return createLocation("urn:rixf:eu.epichub/genoa/tsg", Unit.LAT_LON,
				11.456, 43.456, null, null, null);
	}

	protected void setDatabaseService(DatabaseService dbs) {
		logger.debug("setting Database");
		database = dbs;
		
		if(database != null && coreService != null){
			logger.debug("setting Database call to initBundle");
			initBundle();
		}
		else{
			logger.debug("setting Database NOT call to initBundle");
		}
	}
	
	protected void unsetDatabaseService(DatabaseService dbs) {
		logger.debug("unsetting Database");
		database = null;
	}

	private void initBundle(){
		if(initDone ==false){
			LoadSubscribersFromDB();
			checkVariablesValuesAtMiddleware();		
			checkEventsAtMiddleware();
			
			initDone =true;
		}
	}

	
	// This method has been renamed due if the name is setCoreService does not work setDatabaseService
	//Anyway never executed this method
	protected void setCoreService(CoreService core) {
		logger.debug("setting CoreService");
		coreService = core;
		
		if(database != null && coreService != null){
			logger.debug("setting CoreService call to initBundle");
			initBundle();
		}
		else{
			logger.debug("setting CoreService NOT call to initBundle");
		}
	}

	protected void unsetCoreService(CoreService core) {
		logger.debug("unsetting CoreService");
		coreService = null;
	}
	
	
	
	static DatabaseService getDB() {
		if (database == null) {
			throw new NullPointerException();
		}
		return database;
	}
	
	public static UnifiedService ReCreateInstancePort(String subscriberId){
		UnifiedService portTemp = null;
		gateway_subscriber subscriber = null;
		if (database != null)
			try {
				subscriber = database.getSubscriber(subscriberId);
				if (subscriber != null){
					logger.debug("ReCreateInstancePort Loaded Subscriber from DB. ");
			
					try{ 								
						portTemp = CreateInstancePort(subscriber);
						
						if (portTemp != null)						
							logger.debug("ReCreateInstancePort portTemp is not NULL");
					}catch (Exception e){
						logger.error("ReCreateInstancePort Exception loading Subscriber " +  subscriberId + "  " + e.getMessage());
					}
				}	else{
					logger.debug("ReCreateInstancePort Subscriber is NULL. ");
				}
			} catch (Exception e) {
				logger.error("Exception loading all Subscribers:" + e.getMessage());
			}
		return portTemp;
	}
	
	public static UnifiedService CreateInstancePort(gateway_subscriber subscriber){
		UnifiedService portTemp = null;
		URL wsdlURLTemp = null;
		EnergyUnifiedServiceService ssTemp = null; 
		String endpointTemp = null;
			
		try{ 
		
			logger.debug("CreateInstancePort subscriber " + " ID: " + subscriber.getId());
			
			if (subscriber != null){			
				endpointTemp =subscriber.getResponseURL();
				logger.debug("CreateInstancePort subscriber endpoint: " + endpointTemp + " ID: " + subscriber.getId());							
				
				
				wsdlURLTemp = new URL(endpointTemp);
					
				if (wsdlURLTemp !=null){
					logger.debug("CreateInstancePort subscriber wsdlURLTemp is NOT NULL : endpoint: " + endpointTemp + " ID: " + subscriber.getId());
														
					ssTemp = null;								
					ssTemp = new EnergyUnifiedServiceService(wsdlURLTemp,SERVICE_NAME);			
					if (ssTemp !=null){
		
						portTemp = ssTemp.getUnifiedServicePort();							
						
						if (portTemp != null){
							logger.debug("CreateInstancePort subscriber portTemp is NOT NULL : endpoint: " + endpointTemp + " ID: " + subscriber.getId());
							
							//set timeout
							Map<String, Object> requestContext = ((BindingProvider)portTemp).getRequestContext();
							requestContext.put("com.sun.xml.internal.ws.request.timeout", TIMEOUT); // Timeout in millis
							requestContext.put("com.sun.xml.internal.ws.connect.timeout", TIMEOUT); // Timeout in millis
							
							logger.debug("CreateInstancePort subscriber portTemp requestContext ADDED : endpoint: " + endpointTemp + " ID: " + subscriber.getId());
																	
							hashMapPort.put(subscriber.getId(), portTemp);					
							hashMapSubscribersEndpoint.put(subscriber.getId(), subscriber.getResponseURL());
							
							logger.debug("CreateInstancePort subscriber added to MAP : endpoint: " + endpointTemp + " ID: " + subscriber.getId());
						}else{
							logger.debug("CreateInstancePort subscriber portTemp is NULL : endpoint: " + endpointTemp + " ID: " + subscriber.getId());
							
						}
					}else{
						logger.error("CreateInstancePort ssTemp is null");
					}
				}else{
					logger.error("CreateInstancePort wsdlURLTemp is null");
				}
			}else{
				logger.debug("CreateInstancePort subscriber is NULL");
			}
		
		}catch (Exception e){
			logger.debug("CreateInstancePort Exception endpoint: " + endpointTemp + " ID: " + subscriber.getId() + " "  + e.getMessage()); 
		}
		
		return portTemp;
	}
	
	public void LoadSubscribersFromDB(){
		//logger.debug("LoadSubscribersFromDB start");
		UnifiedService portTemp = null;
		String endpointTemp = null;
		
		
		if (database != null)
			try {
				List<gateway_subscriber> subscriberList = database.getAllSubscribers();
				logger.debug("Loading Subscribers from DB. Num Subscribers:"+ subscriberList.size());
					
				if(subscriberList != null){					
					if(subscriberList.size()>0 ){						
						hashMapPort = new HashMap<String,UnifiedService>();
						hashMapSubscribersEndpoint = new HashMap<String,String>();
						
						for (gateway_subscriber subscriber : subscriberList ) {
							
							try{ 								
								portTemp = CreateInstancePort(subscriber);
								
								logger.debug("LoadSubscribersFromDB subscriber ADDED to Map endpoint: " + endpointTemp + " ID: " + subscriber.getId());
							}catch (Exception e){
								logger.error("Exception loading Subscriber " +  endpointTemp + "  " + e.getMessage());
							}
						}				
					}else{
						logger.debug(" LoadSubscribersFromDB Subscribers list has no values");
					}
				}else{
					logger.debug(" LoadSubscribersFromDB list of Subscribers is null ");					
				}
				
			} catch (Exception e) {
				logger.error("Exception loading all Subscribers:" + e.getMessage());
			}
		
		//logger.debug("LoadSubscribersFromDB end");		
	}
	
	
	public static UnifiedService getPort4SubscriberId(String subscriberId){
		UnifiedService port =null;	
		boolean portFound = false;
		//logger.debug("GatewayClient getPort4SubscriberId subscriberId to get is " + subscriberId);
		
		if(hashMapPort !=null){		
			//logger.debug("GatewayClient getPort4SubscriberId hashMapPort is  not null");
			
			Iterator<Entry<String, UnifiedService>> it = hashMapPort.entrySet().iterator();
			
			if(it != null){
				//logger.debug("GatewayClient getPort4SubscriberId iterator is not null");
				
				while(it.hasNext()){
					Entry<String, UnifiedService> entry = it.next();
				
					port = entry.getValue();
					
					if(port != null){
						//logger.debug("GatewayClient getPort4SubscriberId port is not null " + entry.getKey());
						
						if(subscriberId.equals(entry.getKey())){
							logger.debug("GatewayClient getPort4SubscriberId port found for subscriberId : " + subscriberId);
							//return port;
							portFound = true;
							break;
						}
					}else
						logger.error("GatewayClient getPort4SubscriberId port is null for subscriberId : " + subscriberId );
				}	
			}else
				logger.error("GatewayClient getPort4SubscriberId iterator is NULL for subscriberId : " + subscriberId);
		}else
			logger.error("GatewayClient getPort4SubscriberId hashMapPort IS NULL for subscriberId : " + subscriberId);
		
		if(portFound){
			logger.debug("GatewayClient getPort4SubscriberId port found for " + subscriberId);
		}
		else{
			logger.error("GatewayClient getPort4SubscriberId port NOT found for " + subscriberId);
			port = null;
		}
		
		logger.debug("GatewayClient getPort4SubscriberId END");		
		
		return port;
	}	

	/*
	public static void publishDataJaxWsProxyFactoryBean(String subscriberId, PublishIn publishInInstance){
        logger.debug("GatewayClient publishData  START ");
        long executionTime = System.currentTimeMillis();
        
        UnifiedService port =  null;
        String endpointUrl = null;
        		
		if(hashMapSubscribersEndpoint != null){
			endpointUrl = hashMapSubscribersEndpoint.get(subscriberId);
		}
		port = getPort4SubscriberId (subscriberId);
		
		if(port != null){
			logger.debug("GatewayClient publishData port is not null for " + subscriberId + " endpointUrl : " +  endpointUrl);
			
			JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		    factory.getInInterceptors().add(new LoggingInInterceptor());
		    factory.getOutInterceptors().add(new LoggingOutInterceptor());
		    factory.setServiceClass(UnifiedService.class);
		    factory.setAddress(endpointUrl);
		      
			UnifiedService portInvoker = (UnifiedService) factory.create();
			Client client = ClientProxy.getClient(portInvoker);
			if (client != null) {
				logger.debug("GatewayClient publishData client is NOT null " );
				HTTPConduit conduit = (HTTPConduit) client.getConduit();
				HTTPClientPolicy policy = new HTTPClientPolicy();
				policy.setConnectionTimeout(TIMEOUT);
				policy.setReceiveTimeout(TIMEOUT);
				conduit.setClient(policy);                               
			}else{
				logger.debug("GatewayClient publishData client is null " );
			}
			try{
				PublishOut pOut =portInvoker.publish(publishInInstance);
			
				//PublishOut pOut = port.publish(publishInInstance);
				if(pOut != null){
					logger.info("GatewayClient publishData  pOut is not null " + subscriberId );
					if(pOut.toString() == null)
						logger.info("GatewayClient publishData subscriberId : " + subscriberId+ "  pOut.toString() is null");
					else
						logger.info( subscriberId+ " - " + pOut.toString());
											
				}
				else
					logger.info("GatewayClient publishData subscriberId : " + subscriberId+ " pOut is null");
				
				//NACHO commented the output check due middleware MOCK return pOut = NULL  
				//if(pOut != null && pOut.toString() != null)
				//	logger.debug("GatewayClient publishData : RETURN value from endpoint is NOT NULL ");	
				//else 
				//	logger.debug("GatewayClient publishData : RETURN value from endpoint is NULL ");
				
					
				if(endpointUrl != null)					
					logger.debug("GatewayClient publishData : Data published to " + subscriberId + " - " + endpointUrl );
				else
					logger.error("GatewayClient publishData : Data published to " + endpointUrl + " value is null");
				
			}
			catch(Exception e){
				logger.debug("SearchException invoking annotateSearchOnto", e);
			         //throw new SearchException("SEARCHPUBLICATIONSSERVICEINDEXSEARCH0", "Error invoking index web service", e);
			}
	        executionTime = System.currentTimeMillis() - executionTime;
	        logger.debug("Index web service client finished returning. Indexing execution time: " + executionTime/1000 + " seconds");
	        //return publications;
	
		}
	
	}
*/
	
	public static void publishData(String subscriberId,PublishIn publishInInstance){		
		logger.debug("GatewayClient publishData START subscriberId " + subscriberId);
		long dummyRandom = new Random().nextLong();
		
		UnifiedService port =  null;		
		port = getPort4SubscriberId (subscriberId);
		
		if(port != null){
			logger.debug("GatewayClient publishData port is not null for " + subscriberId+ " dummyRandom:" + dummyRandom);
		}
		else{
			logger.debug("GatewayClient publishData port is NULL for " + subscriberId+ " dummyRandom:" + dummyRandom + " try to create it again ");
			port = ReCreateInstancePort(subscriberId);
			if(port != null){
				logger.debug("GatewayClient publishData ReCreateInstancePort OK");
			}else{
				logger.debug("GatewayClient publishData ReCreateInstancePort NOK");
			}			
		}
		
		if(port != null){
			try {
				logger.info("GatewayClient publishData port.publish before invocation " + " dummyRandom:" + dummyRandom);	
				
				PublishOut pOut = port.publish(publishInInstance);
				
				logger.info("GatewayClient publishData port.publish invoked " + " dummyRandom:" + dummyRandom);	
				
				if(pOut != null){
					logger.info("GatewayClient publishData  pOut is not null " + subscriberId );
					if(pOut.toString() == null)
						logger.info("GatewayClient publishData subscriberId : " + subscriberId+ "  pOut.toString() is null");
					else
						logger.info( subscriberId+ " - " + pOut.toString());
											
				}
				else
					logger.info("GatewayClient publishData subscriberId : " + subscriberId+ " pOut is null");
				
				//NACHO commented the output check due middleware MOCK return pOut = NULL  
				//if(pOut != null && pOut.toString() != null)
				//	logger.debug("GatewayClient publishData : RETURN value from endpoint is NOT NULL ");	
				//else 
				//	logger.debug("GatewayClient publishData : RETURN value from endpoint is NULL ");
				
				if(hashMapSubscribersEndpoint != null){
				
					String endpointPublished = hashMapSubscribersEndpoint.get(subscriberId);
					
					if(endpointPublished != null)					
						logger.debug("GatewayClient publishData : Data published to " + subscriberId + " - " + endpointPublished );
					else
						logger.error("GatewayClient publishData : Data published to " + endpointPublished + " value is null");
				}else{
					logger.error("GatewayClient publishData : hashMapSubscribersEndpoint is null"  );
				}	

			} catch (UnsupportedFaultMessage e) {
				e.printStackTrace();										
				logger.error("GatewayClient publishData subscriberId : " + subscriberId+ " dummyRandom:" + dummyRandom + " UnsupportedFaultMessage  "+  e.getMessage() );
				
			} catch (OperationFaultMessage e) {
				e.printStackTrace();
				logger.error("GatewayClient publishData subscriberId : " + subscriberId+ " dummyRandom:" + dummyRandom + " OperationFaultMessage  "+  e.getMessage());

			} catch (EventFaultMessage e) {
				e.printStackTrace();
				logger.error("GatewayClient publishData subscriberId : " + subscriberId+ " dummyRandom:" + dummyRandom + " EventFaultMessage  "+  e.getMessage());
			} catch (Exception e){
				e.printStackTrace();
				logger.error("GatewayClient publishData subscriberId : " + subscriberId+ " dummyRandom:" + dummyRandom + " Exception  "+  e.getMessage());
			}
		}
		
		logger.debug("GatewayClient publishData END");
	}

	private void checkVariablesValuesAtMiddleware(){
		checkVariableValuesMiddlewareThread =  new CheckVariableValuesMiddlewareThread(database);
		checkVariableValuesMiddlewareThread.start();
		
		
		/*
		if (database != null){
			logger.debug("CheckVariablesValuesAtMiddleware : launch thread ");
			new CheckVariableValuesMiddlewareThread(database).start();
		}else{
			logger.error("CheckVariablesValuesAtMiddleware : database is null ");			
		}*/
		
	}
	
	private void checkEventsAtMiddleware(){
		if (database != null){
			if (coreService != null){
				logger.debug("checkEventsAtMiddleware : launch thread ");
				checkEventsMngrThread =new CheckEventsMngrThread(database, coreService);
				checkEventsMngrThread.start();
			}else{
				logger.error("checkEventsAtMiddleware : coreService is null ");			
			}
		}else{
			logger.error("checkEventsAtMiddleware : database is null ");			
		}
	}

	private class WaitThread extends Thread {

		
		
		@Override
		public void run() {
			boolean dataRequiredNOK= true;
			
			logger.debug("------------- WAITING FOR REQUIRED DATA instance TO LOAD--------------------------");
			try {
				while(dataRequiredNOK){
				
					if(database == null){				
						logger.debug("---------------------WAIT . DATABASE IS NULL ----------------");
						
						if(coreService == null){
							logger.debug("---------------------WAIT . CORESERVICE IS NULL----------------");
						}
						sleep(3000);
					}else  {
						logger.debug("---------------------WAIT . DATABASE IS OK----------------");
						
						//dataRequiredNOK =false;
						if(coreService == null){
							logger.debug("---------------------WAIT . CORESERVICE IS NULL----------------");
						}else{
							logger.debug("---------------------WAIT . CORESERVICE IS OK----------------");
							dataRequiredNOK =false;
						}
					}
				}
				logger.debug("---------------------WAIT FINISHED. --------------------------");
			} catch (InterruptedException e) {
				logger.debug("---------------------WAIT FINISHED. EXCEPTION ALL READY-----------------------");
			}
						
			//initBundle();
		}
	}
	
	
}
