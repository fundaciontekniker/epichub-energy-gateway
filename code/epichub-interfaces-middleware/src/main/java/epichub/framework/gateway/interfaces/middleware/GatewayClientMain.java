package epichub.framework.gateway.interfaces.middleware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GatewayClientMain {

	final static Logger logger = LoggerFactory.getLogger(GatewayClientMain.class);

	
	public static void main(String[] args) throws Exception {
		GatewayClient c = new GatewayClient();
		String alarmId = "AiD";
		do {
			logger.info("Introduce comando");
			
			String in = readInput();
			if (in.equals("A")) // TODO COMANDO A INTRODUCIR
				c.publish_DeviceStateUpdate("urn:rixf:eu.epichub/consumer/middleware",
						"urn:rixf:eu.epichub/resource/devices/tsg/ppw_sensor_24482",
						"ERROR");
			if (in.equals("B")) // TODO COMANDO A INTRODUCIR
				alarmId = c
						.publish_AlarmDefinition(
								"urn:rixf:eu.epichub/consumer/middleware",
								"urn:rixf:eu.epichub/resource/devices/tsg/ppw_sensor_24482",
								"CRITICAL",
								"urn:rixf:eu.epichub/alarms/types/disconnected_sensor",
								"ALARM_OPEN",
								"PPW energy data collection sensor disconnected from network");
			if (in.equals("C")) // TODO COMANDO A INTRODUCIR
				c.publish_AlarmUpdate(
						"urn:rixf:eu.epichub/consumer/middleware",
						alarmId,
						"urn:rixf:eu.epichub/resource/devices/tsg/ppw_sensor_24482",
						"ALARM_CLOSED",
						"PPW energy data collection sensor now reconnected to the network and working");
			if (in.equals("D")) { //

			}
			if (in.equals("X")) {
				break;
			}
		} while (true);
	}
	
	private static String readInput() {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		String s = null;
		do
			try {
				s = stdin.readLine();
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		while ((s == null) || (s.length() == 0));
		return s;
	}
	
}
