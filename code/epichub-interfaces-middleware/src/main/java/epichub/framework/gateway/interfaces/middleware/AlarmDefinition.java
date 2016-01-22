package epichub.framework.gateway.interfaces.middleware;

import java.util.List;

public class AlarmDefinition {
	
	String alarmId; 
	String alarmName; 
	String alarmType; 
	String alarmStatus;
	String alarmSeverity;
	String alarmMessage;
	Long alarmOpenDate;
	Long alarmCloseDate;
	List<String> devId; 
}
