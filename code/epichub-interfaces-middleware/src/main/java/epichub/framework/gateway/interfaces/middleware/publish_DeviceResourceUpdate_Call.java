package epichub.framework.gateway.interfaces.middleware;

import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thalesgroup.it.ns.model.energy.EnergyDataMeasure;
import com.thalesgroup.it.ns.model.res.State;
import com.thalesgroup.it.ns.service.core.Header;
import com.thalesgroup.it.ns.service.core.PublishIn;
import com.thalesgroup.it.ns.service.energy.EnergyDataVariableUpdate;
import com.thalesgroup.it.ns.service.energy.EnergyDataVariableUpdate.EnergyDataMeasures;
import com.thalesgroup.it.ns.service.res.ResourceEvent;
import com.thalesgroup.it.ns.service.res.ResourceEvent.ResourceUpdates;
import com.thalesgroup.it.ns.service.res.ResourceUpdate;


public class publish_DeviceResourceUpdate_Call implements Runnable {
	
	final static Logger logger = LoggerFactory.getLogger(publish_DeviceResourceUpdate_Call.class);
	
	private String devId;
	private String subscriberId;
	private String devState;
	private List<VariableUpdate> updList;

	public publish_DeviceResourceUpdate_Call(String subscriberId,String devId,String devState, List<VariableUpdate> updList) {
		this.devId = devId;
		this.devState = devState;
		this.updList = updList;
		this.subscriberId=subscriberId;
	}

	@Override
	public void run() {
		publish_DeviceResourceUpdate_Async(devId,devState, updList);
	}
	
	void publish_DeviceResourceUpdate_Async(String devId,String devState,List<VariableUpdate> updList) {
		logger.debug("Invoking publish_DeviceUpdate["+devId+","+updList.size()+" updates]...");
		try {
			XMLGregorianCalendar xmlg_date = Utils.toXMLGregorianCalendar(new Date(System.currentTimeMillis()));
			
			PublishIn _publish_parameters= new PublishIn();
			_publish_parameters.setHeader(new Header());
			_publish_parameters.getHeader().setConsumerId(GatewayClient.consumerId_gateway);
			_publish_parameters.getHeader().setRequestTime(xmlg_date);
			
			ResourceEvent rE = new ResourceEvent();
			rE.setTime(xmlg_date);
			rE.setResourceUpdates(new ResourceUpdates());
			
			ResourceUpdate devUpd= new ResourceUpdate();
			devUpd.setResourceId(devId);
			State devS = new State();
			devS.setTime(xmlg_date);
			devS.setValue(devState);
			devS.setTypeId(GatewayClient.typeId_states_device);
			devUpd.getState().add(devS);
			
			for(VariableUpdate var: updList){
				EnergyDataVariableUpdate resUpd = new EnergyDataVariableUpdate();
				resUpd.setEnergyDataMeasures(new EnergyDataMeasures());
				
				resUpd.setResourceId(var.varId);
				if(var.percentageMeasureError!=null)
					resUpd.setPercentageMeasureError(var.percentageMeasureError);
				
				EnergyDataMeasure edm= new EnergyDataMeasure();
				if(var.measureTimestamp!=null)
					edm.setTime(Utils.toXMLGregorianCalendar(new Date(var.measureTimestamp)));
				if(var.measureValue!=null)
					edm.setMeasureValue(var.measureValue);
				resUpd.getEnergyDataMeasures().getEnergyDataMeasure().add(edm);
				
				State resS = new State();
				resS.setTypeId(GatewayClient.typeId_states_variable);
				if(var.measureTimestamp!=null)
					resS.setTime(Utils.toXMLGregorianCalendar(new Date(var.measureTimestamp)));
				if(var.state!=null)
					resS.setValue(var.state);
				resUpd.getState().add(resS);
			
				rE.getResourceUpdates().getUpdate().add(resUpd);
			}

			rE.getResourceUpdates().getUpdate().add(devUpd);
			
			_publish_parameters.getEvent().add(rE);
			
			GatewayClient.publishData(subscriberId,_publish_parameters);
			
		/*
		GatewayClient.port.publish(_publish_parameters);			
		} catch (OperationFaultMessage e) {
			GatewayClient.logger.error("Expected exception: operationFaultMessage has occurred.");
			GatewayClient.logger.error(e.toString());
		} catch (UnsupportedFaultMessage e) {
			GatewayClient.logger.error("Expected exception: unsupportedFaultMessage has occurred.");
			GatewayClient.logger.error(e.toString());
		} catch (EventFaultMessage e) {
			GatewayClient.logger.error("Expected exception: eventFaultMessage has occurred.");
			GatewayClient.logger.error(e.toString());
			*/
		} catch (Exception e) {
			logger.error("Unexpected exception:");
			logger.error(e.getMessage());
		}
		logger.debug("publish_DeviceUpdate["+devId+","+updList.size()+" updates] finished");
	}
	
}