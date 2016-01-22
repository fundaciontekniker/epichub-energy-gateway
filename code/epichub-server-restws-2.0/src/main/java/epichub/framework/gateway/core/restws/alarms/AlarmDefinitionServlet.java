package epichub.framework.gateway.core.restws.alarms;

import java.io.IOException;

import javax.servlet.http.HttpServlet;

import org.openmuc.framework.data.Record;

public class AlarmDefinitionServlet extends HttpServlet {

	/*@Get("json")
	public Representation getJson() throws IOException {

		String devId = (String) getRequest().getAttributes().get("devId");
		try {
				String a=WebserviceProvider.getGatewayService().publish_AlarmDefinition(
						"urn:rixf:eu.epichub/resource/devices/tsg_port/"+devId, 
						"CRITICAL", 
						"urn:rixf:eu.epichub/alarms/types/disconnected_sensor", 
						"ALARM_OPEN", 
						"PPW energy data collection sensor disconnected from network");
				return new StringRepresentation("New Alarm defined:"+a);
			} catch (Exception e) {
				return new StringRepresentation("Error:" + e.getMessage());
		}
	}*/

}