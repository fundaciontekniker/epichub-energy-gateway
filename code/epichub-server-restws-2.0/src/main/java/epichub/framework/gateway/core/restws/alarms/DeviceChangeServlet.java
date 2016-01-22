package epichub.framework.gateway.core.restws.alarms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmuc.framework.server.restws.Activator;

import epichub.framework.gateway.interfaces.middleware.GatewayService;
import epichub.framework.gateway.spi.CoreService;
import epichub.framework.gateway.spi.DatabaseService;
import eu.epichub.gateway.eg.core.gateway_device;

public class DeviceChangeServlet extends HttpServlet {

	private CoreService coreService;
	private DatabaseService databaseService;
	private PrintWriter out;

	@Override
	public void init() throws ServletException {
		this.coreService = Activator.getCoreService();
		this.databaseService=Activator.getDatabaseService();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		out = response.getWriter();
		String pathInfo = request.getPathInfo();

		if (pathInfo == null) {
			pathInfo = "/";
		}
		
		String[] args = pathInfo.split("/");
		String devId="";
		String devState="";
		
		try{	
			if (args.length > 1) {

				try {
					devId = args[1];
					devState = args[2];
				} catch (Exception e) {
					throw new Exception("Invalid arguments...");
				}

				coreService.updateDeviceState(
						"urn:rixf:eu.epichub/consumer/middleware",
						"urn:rixf:eu.epichub/resource/devices/tsg_port/"
								+ devId, devState);

				out.println("Device [urn:rixf:eu.epichub/resource/devices/tsg_port/"
						+ devId + "] changed to " + devState);
			}

			else {
				out.println("Device List:");
				List<gateway_device> devList = databaseService.getAllDevices();
				for (gateway_device dev : devList) {
					out.println(dev.getId() + " :" + dev.getState());
				}
			}
		} catch (Exception e) {
				out.println("Exception changing device state:" + e.getMessage());

		}
	
	}
}
