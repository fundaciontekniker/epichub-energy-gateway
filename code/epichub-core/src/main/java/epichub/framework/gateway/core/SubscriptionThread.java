package epichub.framework.gateway.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.openmuc.framework.data.Flag;
import org.openmuc.framework.data.Record;
import org.openmuc.framework.dataaccess.Channel;
import org.openmuc.framework.dataaccess.DataAccessService;
import org.openmuc.framework.dataaccess.LogicalDevice;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import epichub.framework.gateway.interfaces.middleware.VariableUpdate;
import eu.epichub.gateway.eg.core.gateway_device;
import eu.epichub.gateway.eg.core.gateway_driver;
import eu.epichub.gateway.eg.core.gateway_subscriber;
import eu.epichub.gateway.eg.core.gateway_subscription;
import eu.epichub.gateway.eg.core.gateway_variable;
import eu.epichub.gateway.eg.manager.EHReqPersistentManager;

/**
 * This thread will publish subscriptions in two conditions:<br>
 * 1 - maxInt time has passed with no interruptions<br>
 * 2 - it has been externally interrupted and a new value has been detected<br>
 * 
 * @author agarcia
 * 
 */
public class SubscriptionThread extends Thread {
	
	private final static Logger log = LoggerFactory.getLogger(SubscriptionThread.class);

	gateway_subscription subs;
	long minInt;
	//long maxInt;
	
	LinkedHashMap<String,gateway_variable> varMap;
	LinkedHashMap<String,gateway_device> devMap;
	LinkedHashMap<String,Record> recordMap;
	
	boolean active=true;
	long lastSent;
	boolean allChange;
	
	public SubscriptionThread(gateway_subscription s, List<gateway_variable> varList) {
		varMap = new LinkedHashMap<String,gateway_variable>();
		devMap = new LinkedHashMap<String,gateway_device>();
		recordMap= new LinkedHashMap<String, Record>();
		minInt = s.getMinInt();
		//maxInt = s.getMaxInt();
		subs =s;
		allChange =false;
		lastSent =System.currentTimeMillis();
	
		for(gateway_variable var: varList){
			log.debug("Adding "+var+" to sub");
			String id="channel_"+var.getDbID();
			varMap.put(id,var);
			if(!devMap.containsKey(var.getDevice().getId())){
				devMap.put(var.getDevice().getId(), var.getDevice());
			}	
		}		
	}


	public void stopSub(boolean forced){
		log.debug("stopping "+ subs.getId() + ":"+forced);
		active=false;
		if(forced)
			interrupt();
	}
	
	@Override
	public void run() {
		while(active){
			lastSent = System.currentTimeMillis();
			
			readValues();
			
			//checkVariableState();
	
			if(SubscriberCollection.storeToDB)
				saveValuesToDB();
			
			publishSubscription();
			
			try {
				sleep(minInt);
			} catch (InterruptedException e) {
				//no será interrumpido,  excepto por el usuario
				log.error("SubscriptionThread.run Exception " + e.getMessage());
			}
		}
	}
	
	private void readValues(){

		log.debug("readValues START");
		for (String id : varMap.keySet()) {
			//log.debug("readvalues ");
			
			if(CoreServiceImpl.getDataAccess().getChannel(id) !=null)			
				recordMap.put(id, CoreServiceImpl.getDataAccess().getChannel(id).read());
			else
				log.debug("readvalues getChannel(id) is null " + id);
		} 

		log.debug("readValues END");
	}
	
	
	/*private void publishNotifications(){

		LinkedHashMap<String,gateway_device> devMap = new LinkedHashMap<String, gateway_device>();
		LinkedHashMap<String,Integer> devOK = new LinkedHashMap<String, Integer>();
		for (Subs_Channel sC : channelMap.values()) {	
			if (!devOK.containsKey(sC.var.getDevice().getId())){
				devOK.put(sC.var.getDevice().getId(), 0);
				devMap.put(sC.var.getDevice().getId(), sC.var.getDevice());
			}
			int i=devOK.get(sC.var.getDevice().getId())+1;
			devOK.put(sC.var.getDevice().getId(),i);
		}


		for (Subs_Channel sC : channelMap.values()) {	
			Record r =sC.channel.getLatestRecord();
			log.info(sC.var.getId()+" : "+r);
			if(!r.getFlag().equals(Flag.VALID)&& sC.lastFlag.equals(Flag.VALID)){
				sC.var.setState(States.NOT_AVAILABLE.toString());
				int i=devOK.get(sC.var.getDevice().getDbID())-1;
				devOK.put(sC.var.getDevice().getId(),i);
				log.info(sC.var.getId()+" status changed to "+sC.var.getState());
			}
			
			if(r.getFlag().equals(Flag.VALID)&& !sC.lastFlag.equals(Flag.VALID)){
				sC.var.setState(States.AVAILABLE.toString());
				log.info(sC.var.getId()+" status changed to "+sC.var.getState());
			}
			sC.lastFlag=r.getFlag();
		}
		


		for(String devId: devOK.keySet()){
			if(devOK.get(devId)==0){
				if(devMap.get(devId).getState().equals(States.AVAILABLE.name())){
					devMap.get(devId).setState(States.NOT_AVAILABLE.name());
					log.info(devMap.get(devId).getId()+" status changed to "+devMap.get(devId).getState());
					//STORE IN DB
					//SEND STATE UPDATE
					//SEND ALARM DEFINITION
					}
			}else{
				if(devMap.get(devId).getState().equals(States.NOT_AVAILABLE.name())){
					devMap.get(devId).setState(States.AVAILABLE.name());
					log.info(devMap.get(devId).getId()+" status changed to "+devMap.get(devId).getState());
					//STORE IN DB
					//SEND STATE UPDATE
					//SEND ALARM DEFINITION
					}
			}
		}*/

		// PUBLISH VALUES
	  /*PersistentSession s=null;
	   try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			for (Subs_Channel sC : channelMap.values()) {
				SubscriberCollection.getDB().addVariableValue(sC.var.getId(),sC.channel.getLatestRecord().getValue().toString(),lastSent,s);
			}
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			log.error(SubscriptionThread_publishNotifications_01+": "+e.getMessage());
			s.getTransaction().rollback();
			try {
				s.close();
			} catch (PersistentException e1) {
				log.error(SubscriptionThread_publishNotifications_02+": "+e.getMessage());
			}
			
		}	
	
	} */
	
	private void checkVariableState(){
		// Assess variable state
		
				for (String id : varMap.keySet()) {
					log.info(id +": "
							+ "\n ChannelState:"+CoreServiceImpl.getDataAccess().getChannel(id).getChannelState()
							+ "\n DeviceState:"+CoreServiceImpl.getDataAccess().getChannel(id).getDeviceState()
							+ "\n LastRecord:"+recordMap.get(id));
				
					
					switch (recordMap.get(id).getFlag()){
						case VALID: 
						
						case DEVICE_OR_INTERFACE_BUSY:
							
						case NO_VALUE_RECEIVED_YET:
							
						case CONNECTING:
							
						case DISCONNECTING:
							
						case WAITING_FOR_CONNECTION_RETRY:
						
						case ACCESS_METHOD_NOT_SUPPORTED:
							
						case CANNOT_WRITE_NULL_VALUE:
							
						case CHANNEL_DELETED:
							
						case COMM_DEVICE_NOT_CONNECTED:
							
						case CONNECTION_EXCEPTION:
							
						case DISABLED:
							
						case DRIVER_ERROR_CHANNEL_ADDRESS_SYNTAX_INVALID:
							
						case DRIVER_ERROR_CHANNEL_NOT_ACCESSIBLE:
							
						case DRIVER_ERROR_CHANNEL_NOT_PART_OF_SAMPLING_GROUP:
							
						case DRIVER_ERROR_CHANNEL_TEMPORARILY_NOT_ACCESSIBLE:
							
						case DRIVER_ERROR_CHANNEL_VALUE_TYPE_CONVERSION_EXCEPTION:
							
						case DRIVER_ERROR_CHANNEL_WITH_THIS_ADDRESS_NOT_FOUND:
							
						case DRIVER_ERROR_SAMPLING_GROUP_NOT_ACCESSIBLE:
							
						case DRIVER_ERROR_SAMPLING_GROUP_NOT_FOUND:
							
						case DRIVER_ERROR_READ_FAILURE:
							
						case DRIVER_THREW_UNKNOWN_EXCEPTION:
							
						case DRIVER_UNAVAILABLE:
							
						case INFEASIBLE_TO_SAMPLE_CHANNEL_GROUP_IN_ONE_REQUEST:
							
						case SAMPLING_AND_LISTENING_DISABLED:
							
						case STARTED_LATE_AND_TIMED_OUT:
							
						case UNKNOWN_ERROR:
							
						case TIMEOUT:
					}
			}
	}
	
	private void saveValuesToDB(){
		log.debug("saveValuesToDB START");
		for (String id : varMap.keySet()) {
			try {
				
				//log.debug("SubscriptionThread.saveValuestoDB value " + recordMap.get(id).getValue().toString());
				CoreServiceImpl.getDB().addVariableValue(
						varMap.get(id).getId(),
						recordMap.get(id).getValue().toString(),
						recordMap.get(id).getTimestamp());
			} catch (Exception e) {
				log.error("Exception writting subscription value to database."+e.getMessage());
			}
		}

		log.debug("saveValuesToDB END");
	}

	private void publishSubscription() {
		log.debug("publishSubscription START");
		String publishMessage = "";
		try {
			for (gateway_device device : devMap.values()) {
				List<VariableUpdate> updList = new ArrayList<VariableUpdate>();
				publishMessage += "[device "+device+"]:\n";
				for (gateway_variable var : CoreServiceImpl.getDB().getDeviceVariables(device.getId())) {
					
					String id="channel_"+var.getDbID();					
					if(recordMap.containsKey(id)){
						VariableUpdate vupd = new VariableUpdate();
						vupd.varId=var.getId();
											
						if (recordMap.get(id).getFlag().equals(Flag.VALID)) {
							//log.debug("Valid Flag["+id+"]");
							if(var.getState()!=States.AVAILABLE.name()){
								CoreServiceImpl.getDB().updateVariableState(var.getId(), States.AVAILABLE.name());
							}
							vupd.measureValue = recordMap.get(id).getValue().asDouble();
							vupd.measureTimestamp = recordMap.get(id).getTimestamp();
							vupd.state = States.STARTED.name();
							publishMessage += "["+ varMap.get("channel_" + var.getDbID()).getId()+ "("+ new Date(vupd.measureTimestamp)+"):"+ vupd.measureValue+ " "+ varMap.get("channel_" + var.getDbID()).getUnit() + "]\n";
						} else {
							log.debug("publishSubscription Invalid Flag["+id+"]:"+recordMap.get(id).getFlag());
							if(var.getState()!=States.NOT_AVAILABLE.name()){
								CoreServiceImpl.getDB().updateVariableState(var.getId(), States.NOT_AVAILABLE.name());
							}
							vupd.measureTimestamp = recordMap.get(id).getTimestamp();
							if(vupd.measureTimestamp==null){
								vupd.measureTimestamp=System.currentTimeMillis();}
							vupd.state = States.NOT_AVAILABLE.name();
							publishMessage += "["+ varMap.get("channel_" + var.getDbID()).getId() + "("+ new Date(vupd.measureTimestamp)+"):"+recordMap.get(id).getFlag().name() + "]\n";
						}
						updList.add(vupd);
					}					
				}
				
				if(CoreServiceImpl.getPublishService()!=null){
					if(subs == null ){
						log.debug(" subs is null ");						
					}else {
						if(subs.getSubscriber() != null){					
							//log.debug(" subs.getSubscriber() is NOT null ");							
							if(subs.getSubscriber().getId() != null){
								log.debug("publishSubscription before call publish for subscriberId : " +subs.getSubscriber().getId());
								
								CoreServiceImpl.getPublishService().publish_DeviceResourceUpdate(subs.getSubscriber().getId(),device.getId(), "STARTED", updList);
							}else{
								log.debug(" subs.getSubscriber().getId() is null ");
							}
						}
						else{
							log.debug(" subs.getSubscriber() is null ");
						}
					}
				}else{
					log.debug(" CoreServiceImpl.getPublishService() is null ");
				}
			}
			//log.debug("publishSubscription DONE at " + subs.getSubscriber().getResponseURL() + ":\n" + publishMessage);
		} catch (Exception e) {
			log.error("Exception during publishSubscription:"+e.getMessage());
		}

		log.debug("publishSubscription END");
	}
	
	/*private void TestDevices(){
		// Testear
		for (gateway_device device: devMap.values()) {
			device.setState(States.AVAILABLE.name());
			for (Object o3 : device.getVariables()) {
				gateway_variable variable = (gateway_variable) o3;
				variable.setState(States.AVAILABLE.name());
				
					Record r = CoreServiceImpl.getDataAccess().getChannel("channel_"+ variable.getDbID()).read();
					log.debug(variable.getId() + ":" + r.getFlag());
					if (r.getFlag().equals(Flag.DRIVER_UNAVAILABLE)) {
						device.getDriver().setState(r.getFlag().name());
						device.setState(States.NOT_AVAILABLE.name());
						variable.setState(States.NOT_AVAILABLE.name());
					}

					if (r.getFlag().equals(
							Flag.COMM_DEVICE_NOT_CONNECTED)
							|| r.getFlag().equals(Flag.TIMEOUT)
							|| r.getFlag().equals(Flag.CONNECTION_EXCEPTION)) {
						device.setState(States.NOT_AVAILABLE.name());
						variable.setState(States.NOT_AVAILABLE.name());
					}
					
					if (r.getFlag().equals(Flag.DRIVER_THREW_UNKNOWN_EXCEPTION))
						variable.setState(States.NOT_AVAILABLE.name());
					try{CoreServiceImpl.getDB().updateVariableState(variable.getId(),variable.getState());}catch(Exception e){
						log.error("Exception updating variable state:"+e.getMessage());
					}
				}
			try{CoreServiceImpl.getDB().updateDeviceState(device.getId(),device.getState());}catch(Exception e){
				log.error("Exception updating device state:"+e.getMessage());
			}
			}
		//CoreServiceImpl.getDB().updateDriverState(driver.getId(),driver.getState());

	}*/
}

