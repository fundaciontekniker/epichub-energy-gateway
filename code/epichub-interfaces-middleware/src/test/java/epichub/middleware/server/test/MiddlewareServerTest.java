package epichub.middleware.server.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thalesgroup.it.ns.service.res.GetResourcesOut;

import epichub.framework.gateway.interfaces.middleware.GatewayClient;


public class MiddlewareServerTest {

	/*
	 * NACHO 2015/10/22
	 * Tests inside Eclipse that access to database does not due the database instance is null
	 * With actual configuration database is only accesible inside Apache Felix OSGI server
	 */
	
	public static String RESULT_OK="OK";
	public static String RESULT_ERROR="ERROR";
	public static String RESULT_EXCEPTION="EXCEPTION";
	
	final static Logger log = LoggerFactory.getLogger(MiddlewareServerTest.class);

	private static String device1;
	private static String subscriberId = null;
	
	@BeforeClass
	public static void prepareTest(){
		device1 = "urn:rixf:eu.epichub/resource/devices/bec_center/tibucon_2_1124681296";
		subscriberId = "urn:rixf:eu.epichub/consumer/middleware";
	}
	
	@AfterClass
	public static void resetTest(){
		
	}	
	
	//@org.junit.Test	
	public  void testGetResourcesIn(){
		log.info("*************************************************************" );		
		log.info("testGetResourcesIn: START " );
		String  result= RESULT_OK;
			
		GatewayClient gc = null;
		GetResourcesOut instance = null;
				
		try {
			gc  = new GatewayClient();
			
			gc.LoadSubscribersFromDB();
			
			
			//instance = gc.GetResources(subscriberId, device1);
			
			if(instance!=null)
			{
				log.info("testGetResourcesIn:  is not null");
				Assert.assertTrue(true);
			}
			else
			{
				log.error("testGetResourcesIn:  is NULL " );
				Assert.assertTrue(false);
				result= RESULT_ERROR;
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.assertTrue(false);
			result= RESULT_EXCEPTION;
		} 
		
		
		log.info("testGetResourcesIn: RESULT "  + result );
		log.info("testGetResourcesIn: END " );
		log.info("*************************************************************" );
		log.info("");
		
	}	
}
