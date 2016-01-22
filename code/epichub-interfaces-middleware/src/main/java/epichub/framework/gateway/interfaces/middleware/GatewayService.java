package epichub.framework.gateway.interfaces.middleware;

import java.util.List;

public interface GatewayService {

	public void publish_DeviceStateUpdate(String subscriberId, String devId,String devState);
	public void publish_DeviceStateUpdate(String subscriberId, List<String> device_Ids, String state);
	public String publish_AlarmDefinition(String subscriberId, String devId, String alarmSeverity, String alarmType, String alarmStatus,String alarmMessage);
	public void publish_AlarmUpdate(String subscriberId, String alarmId, String devId, String alarmStatus,String alarmMessage);
	

	/*public void publish_DeviceStateUpdate(List<DeviceState> dS_List);
	public void publish_AlarmDefinition(List<AlarmDefinition> aD_List);
	public void publish_AlarmUpdate(List<AlarmUpdate> aU_List);*/
	
	public void check_publish_DeviceResourceDefinition(String subscriberId, String devId, String devName,String devParentId, String devTypeId,List<VariableDefinition> resList);
	public void publish_DeviceResourceDefinition(String subscriberId, String devId, String devName,String devParentId, String devTypeId,List<VariableDefinition> resList);
	public void publish_DeviceResourceUpdate(String subscriberId, String devId,String devState,List<VariableUpdate> updList);
	
	
	
}
