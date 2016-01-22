package epichub.framework.gateway.db.derby;

import java.net.InetAddress;

import org.apache.derby.drda.NetworkServerControl;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DerbyMngActivator implements  BundleActivator{
	private final static int default_port =1527;
	private final static Logger logger = LoggerFactory.getLogger(DerbyMngActivator.class);
	
	private static final String DerbyMngActivator_exception_start01 = "Property derby.port not found. Using default port:1527";
	private static final String DerbyMngActivator_exception_start02 = "Property derby.port is not a integer. Using default port:1527";
	NetworkServerControl server = null;
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		
		int port = default_port;
		try{
			String derby_port =bundleContext.getProperty("derby.port");
			if (derby_port!=null)
				port = Integer.parseInt(derby_port);
			else
				logger.debug(DerbyMngActivator_exception_start01);
		}catch(Exception e){
			logger.debug(DerbyMngActivator_exception_start02);
		}
		
		server = new NetworkServerControl(InetAddress.getByName("0.0.0.0"),port);
		
		server.start (null);
		logger.debug("Derby server started");
		Thread.sleep(3000);
		server.ping();
		logger.debug("Derby server sys info: " + server.getSysinfo());
		logger.debug("Derby server run time info: " + server.getRuntimeInfo());		
		
		
		//
		
	}
	
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		server.shutdown();
	}

}