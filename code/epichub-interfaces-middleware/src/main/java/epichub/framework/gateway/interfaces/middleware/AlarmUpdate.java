package epichub.framework.gateway.interfaces.middleware;

import java.util.List;

public class AlarmUpdate {

	public String alarmId;  
	public String alarmStatus;
	public String alarmSeverity;
	public String alarmMessage;
	public Long alarmOpenDate;	
	public Long alarmCloseDate;
	public List<String> addedDevId; 
	public List<String> removedDevId;
}
