package epichub.framework.gateway.core.restws.alarms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmuc.framework.server.restws.Activator;

import epichub.framework.gateway.spi.CoreService;

public class DeviceSimulationServlet extends HttpServlet {

	private CoreService coreService;
	private PrintWriter out;
	private static String simulationStart_text ="Scheduled simulation is running";
	private static String simulationStop_text ="Scheduled simulation is stopped";

	@Override
	public void init() throws ServletException {
		this.coreService = Activator.getCoreService();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		response.setContentType("application/json");
		out = response.getWriter();
		String pathInfo = request.getPathInfo();

		if (pathInfo == null) {
			pathInfo = "/";
		}
		String[] args = pathInfo.split("/");
		try {
			if (args.length > 1) {
				if (args[1].equals("start"))
					startScheduler();
				else if (args[1].equals("stop"))
					stopScheduler();
				else
					out.println("invalid argument ["+args[1]+"].\n "
							+ "Valid urls:\n"
							+ "- /epichub/deviceSimulation/start\n"
							+ "- /epichub/deviceSimulation/stop\n"
							+ "- /epichub/deviceSimulation/\n");
			} else {
				if (scheduler == null || scheduler.isShutdown()|| scheduler.isTerminated())
					out.println(simulationStop_text);
				else
					out.println(simulationStart_text);
			}

		} catch (Exception e) {
			out.println("Exception changing device state:" + e.getMessage());
		}
	}

	private ScheduledExecutorService scheduler;

	public class ScheduledTask implements Runnable {

		List<String> idList;
		String devState;

		public ScheduledTask(String i, String s) {
			idList = new ArrayList<String>();
			idList.add(i);
			devState = s;
		}

		public ScheduledTask(List<String> iList, String s) {
			idList = iList;
			devState = s;
		}

		public void run() {
			try {
				coreService.updateDeviceState("urn:rixf:eu.epichub/consumer/middleware", idList, devState);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void startScheduler() {
		scheduler = Executors.newScheduledThreadPool(1);

		scheduler.scheduleAtFixedRate(new ScheduledTask("urn:rixf:eu.epichub/resource/devices/tsg_port/ppw_sensor_24484","ERROR"), 0, 720,java.util.concurrent.TimeUnit.SECONDS);
		scheduler.scheduleAtFixedRate(new ScheduledTask("urn:rixf:eu.epichub/resource/devices/tsg_port/ppw_sensor_24484","AVAILABLE"), 60, 720,java.util.concurrent.TimeUnit.SECONDS);

		ArrayList<String> id1 = new ArrayList<String>();
		id1.add("urn:rixf:eu.epichub/resource/devices/tsg_port/ppw_sensor_24486");
		id1.add("urn:rixf:eu.epichub/resource/devices/tsg_port/ppw_sensor_25314");
		scheduler.scheduleAtFixedRate(new ScheduledTask(id1, "ERROR"), 120, 720,java.util.concurrent.TimeUnit.SECONDS);

		scheduler.scheduleAtFixedRate(new ScheduledTask(id1, "AVAILABLE"), 180,720, java.util.concurrent.TimeUnit.SECONDS);

		ArrayList<String> id2 = new ArrayList<String>();
		id2.add("urn:rixf:eu.epichub/resource/devices/tsg_port/ppw_sensor_25315");
		id2.add("urn:rixf:eu.epichub/resource/devices/tsg_port/ppw_sensor_25326");
		id2.add("urn:rixf:eu.epichub/resource/devices/tsg_port/ppw_sensor_26351");
		scheduler.scheduleAtFixedRate(new ScheduledTask(id2, "ERROR"), 240, 720,java.util.concurrent.TimeUnit.SECONDS);
		
		ArrayList<String> id3 = new ArrayList<String>();
		id3.add("urn:rixf:eu.epichub/resource/devices/tsg_port/ppw_sensor_25315");
		id3.add("urn:rixf:eu.epichub/resource/devices/tsg_port/ppw_sensor_25326");
		scheduler.scheduleAtFixedRate(new ScheduledTask(id3, "AVAILABLE"), 300,	720, java.util.concurrent.TimeUnit.SECONDS);

		scheduler.scheduleAtFixedRate(new ScheduledTask("urn:rixf:eu.epichub/resource/devices/tsg_port/ppw_sensor_26351","AVAILABLE"), 360, 720,java.util.concurrent.TimeUnit.SECONDS);
		
		scheduler.scheduleAtFixedRate(new ScheduledTask("urn:rixf:eu.epichub/resource/devices/tsg_port/ppw_sensor_26360","ERROR"), 420, 720,java.util.concurrent.TimeUnit.SECONDS);
		
		scheduler.scheduleAtFixedRate(new ScheduledTask("urn:rixf:eu.epichub/resource/devices/tsg_port/ppw_sensor_26414","ERROR"), 480, 720,java.util.concurrent.TimeUnit.SECONDS);
		
		scheduler.scheduleAtFixedRate(new ScheduledTask("urn:rixf:eu.epichub/resource/devices/tsg_port/ppw_sensor_26414","AVAILABLE"), 540, 720,java.util.concurrent.TimeUnit.SECONDS);
		
		scheduler.scheduleAtFixedRate(new ScheduledTask("urn:rixf:eu.epichub/resource/devices/tsg_port/ppw_sensor_26360","AVAILABLE"), 600, 720,java.util.concurrent.TimeUnit.SECONDS);
	

		out.println(simulationStart_text);
	}

	public void stopScheduler() {
		scheduler.shutdownNow();
		out.println(simulationStop_text);
	}

}
