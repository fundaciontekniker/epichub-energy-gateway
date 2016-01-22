package epichub.framework.gateway.core.restws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmuc.framework.config.ConfigService;
import org.openmuc.framework.config.RootConfig;
import org.openmuc.framework.server.restws.Activator;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import epichub.framework.gateway.spi.CoreService;
import epichub.framework.gateway.spi.DatabaseService;
import eu.epichub.gateway.eg.core.gateway_device;
import eu.epichub.gateway.eg.core.gateway_driver;
import eu.epichub.gateway.eg.core.gateway_host;
import eu.epichub.gateway.eg.core.gateway_subscription;
import eu.epichub.gateway.eg.core.gateway_variable;
import eu.epichub.gateway.eg.manager.EHReqPersistentManager;

@SuppressWarnings("serial")
public class HomeResourceServlet extends HttpServlet {
	private CoreService coreService;
	private DatabaseService databaseService;

	@Override
	public void init() throws ServletException {
		this.coreService = Activator.getCoreService();
		this.databaseService = Activator.getDatabaseService();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();

		String pathInfo = request.getPathInfo();
		if (pathInfo == null) {
			pathInfo = "/";
		}

		String[] args = pathInfo.split("/");
		String command = "";
		if (args.length > 1) {
			command = args[1];
		}

		String message = "SYSTEM INFO [" + new Date(System.currentTimeMillis())
				+ "]:\n";

		// if(command.equals("TEST"))
		// hostConfig
		// =coreService.TestHostConfig("urn:rixf:eu.epichub/consumer/gateway");
		// else{
		PersistentSession s = null;
		try {
			s = EHReqPersistentManager.instance().getSession();
			s.beginTransaction();

			List<gateway_host> hostList = databaseService.getAllHosts(s);
			message += "\n\n Host(s) found: "+hostList.size() +":\n";
				for (gateway_host hostConfig : hostList) {
					message += "Host[" + hostConfig.getId() + "]: \n";
					for (Object o : hostConfig.getDrivers()) {
						gateway_driver driver = (gateway_driver) o;
						message += " - Driver[" + driver.getId() + "]: "+ driver.getState() + "\n";		
						for (Object o2 : driver.getDevices()) {
							gateway_device device = (gateway_device) o2;
							message += " - - Device[" + device.getId() + "]: "+ device.getState() + "\n";
									
							for (Object o3 : device.getVariables()) {
								gateway_variable variable = (gateway_variable) o3;
								message += " - - -Variable[" + variable.getId()+ "]: " + variable.getState() + "\n";
										
						}
					}
				}
			}
			

			List<gateway_subscription> subList = databaseService.getAllSubscriptions(s);
			message += "\n\n Subscription(s) found: "+subList.size()+ ":\n";
			
			for (gateway_subscription sub : subList) {
				message += " -Subscription[" + sub.getId() + "]: "+ sub.getState() + "\n";
					for (Object o3 : sub.getVariables()) {
						gateway_variable variable = (gateway_variable) o3;
						message += " --Variable[" + variable.getId() + "]\n";
				}
			}
			

			s.getTransaction().commit();
			s.close();
		} catch (Exception e) {
			s.getTransaction().rollback();
			try {
				s.close();
			} catch (PersistentException e1) {
				pw.println(e.getMessage() + "\n");
			}
			pw.println(e.getMessage() + "\n");
		}

		// }

		pw.println(message);
		// response.sendError(HttpServletResponse.SC_NOT_FOUND);
	}
}

/*
 * extends ServerResource {
 * 
 * @Get("json") public Representation getJson() throws IOException {
 * 
 * String message="SYSTEM INFO ["+new Date(System.currentTimeMillis())+"]:\n";
 * 
 * gateway_host hostConfig =WebserviceProvider.getCoreServices().TestHostConfig(
 * "urn:rixf:eu.epichub/consumer/gateway");
 * 
 * for(Object o: hostConfig.getDrivers()){ gateway_driver driver
 * =(gateway_driver)o;
 * message+="Driver["+driver.getId()+"]: "+driver.getState()+"\n"; for(Object
 * o2: driver.getDevices()){ gateway_device device =(gateway_device)o2;
 * message+="-Device["+device.getId()+"]: "+device.getState()+"\n"; for(Object
 * o3: device.getVariables()){ gateway_variable variable =(gateway_variable)o3;
 * message+="--Variable["+variable.getId()+"]: "+variable.getState()+"\n"; }
 * message+="\n"; } message+="\n"; } return new StringRepresentation(message);
 * 
 * }
 * 
 * }
 */
