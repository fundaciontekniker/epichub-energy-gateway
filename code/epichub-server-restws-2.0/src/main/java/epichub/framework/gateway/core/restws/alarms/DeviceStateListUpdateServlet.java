package epichub.framework.gateway.core.restws.alarms;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

import org.openmuc.framework.data.Record;

public class DeviceStateListUpdateServlet extends HttpServlet {

	/*private final static Logger log = LoggerFactory.getLogger(DeviceStateListUpdate.class);
	@Get("json")
	public Representation getJson() throws IOException {
		log.debug("DeviceStateUpdate getJson");
		String arg = (String) getRequest().getAttributes().get("args");
		
		String[] args =arg.split("~");
		List<DeviceState> dList= new ArrayList<DeviceState>();
		for(String d:args){
			String[] p=d.split(",");
			DeviceState ds= new DeviceState();
			ds.devId="urn:rixf:eu.epichub/resource/devices/tsg_port/"+p[0];
			log.debug("DevId:"+ ds.devId);
			ds.state=p[1];log.debug("DevState:"+ ds.state);
			dList.add(ds);
		}

		try {
			WebserviceProvider.getGatewayService().publish_DeviceStateUpdate(dList);
			return new StringRepresentation("DeviceUpdate Succesful");
		} catch (Exception e) {
			log.error("Error:" + e.getMessage());
			return new StringRepresentation("Error:" + e.getMessage());
		}
	}*/
}