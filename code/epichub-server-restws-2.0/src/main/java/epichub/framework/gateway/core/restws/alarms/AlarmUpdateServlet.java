package epichub.framework.gateway.core.restws.alarms;


import java.io.IOException;

import javax.servlet.http.HttpServlet;

import org.openmuc.framework.data.Record;

public class AlarmUpdateServlet extends HttpServlet {

	/*@Get("json")
	public Representation getJson() throws IOException {

		String devId = (String) getRequest().getAttributes().get("devId");
		String alarmId = (String) getRequest().getAttributes().get("alarmId");
		try {
			WebserviceProvider.getGatewayService().publish_AlarmUpdate(
					"urn:rixf:eu.epichub/alarms/"+alarmId, 
					"urn:rixf:eu.epichub/resource/devices/tsg_port/"+devId, 
					"ALARM_CLOSED", 
					"PPW energy data collection sensor now reconnected to the network and working");
			return new StringRepresentation("Alarm "+alarmId+" updated");
		} catch (Exception e) {
			return new StringRepresentation("Error:" + e.getMessage());
		}
	}*/
}