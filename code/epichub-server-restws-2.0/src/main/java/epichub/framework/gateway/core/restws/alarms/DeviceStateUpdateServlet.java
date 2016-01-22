package epichub.framework.gateway.core.restws.alarms;


import javax.servlet.http.HttpServlet;

public class DeviceStateUpdateServlet extends HttpServlet {

	/*private final static Logger log = LoggerFactory.getLogger(DeviceStateUpdate.class);
	@Get("json")
	public Representation getJson() throws IOException {
		log.debug("DeviceStateUpdate getJson");
		String devId = (String) getRequest().getAttributes().get("devId");
		log.debug("DevId:"+ devId);
		String devState = (String) getRequest().getAttributes().get("devState");
		log.debug("DevState:"+ devState);
		
		try {
			
			
			WebserviceProvider.getGatewayService().publish_DeviceStateUpdate(
					"urn:rixf:eu.epichub/resource/devices/tsg_port/"+devId, 
					devState);
			return new StringRepresentation("Device "+"urn:rixf:eu.epichub/resource/devices/tsg_port/"+devId+" state updated to "+devState);
		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
			return new StringRepresentation("Error:" + e.getMessage());
		}
	}*/
}