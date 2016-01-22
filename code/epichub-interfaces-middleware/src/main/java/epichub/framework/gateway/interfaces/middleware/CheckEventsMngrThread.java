package epichub.framework.gateway.interfaces.middleware;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.namespace.QName;

import org.openmuc.framework.data.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thalesgroup.it.ns.service.core.CometEvents;
import com.thalesgroup.it.ns.service.core.CometHeader;
import com.thalesgroup.it.ns.service.core.Command;
import com.thalesgroup.it.ns.service.core.CommandEvent;
import com.thalesgroup.it.ns.service.core.Event;
import com.thalesgroup.it.ns.service.core.GetEventsIn;
import com.thalesgroup.it.ns.service.core.GetEventsOut;
import com.thalesgroup.it.ns.service.core.Parameter;
import com.thalesgroup.it.ns.service.core.SimpleValueParam;
import com.thalesgroup.it.ns.service.energy_unified.CometFaultMessage;
import com.thalesgroup.it.ns.service.energy_unified.EnergyUnifiedServiceService;
import com.thalesgroup.it.ns.service.energy_unified.OperationFaultMessage;
import com.thalesgroup.it.ns.service.energy_unified.UnifiedService;
import com.thalesgroup.it.ns.service.energy_unified.UnsupportedFaultMessage;
import com.thalesgroup.it.ns.service.res.GetResourcesIn;
import com.thalesgroup.it.ns.service.res.GetResourcesOut;

import epichub.framework.gateway.spi.CoreService;
import epichub.framework.gateway.spi.DatabaseService;
import eu.epichub.gateway.eg.core.gateway_subscriber;
import eu.epichub.gateway.eg.core.gateway_subscription;


/**
 * @author fdiez
 * Modified : Ignacio Lazaro 
 * Defined as Thread to be integrated in bundle
 */
public class CheckEventsMngrThread extends Thread{

	/**
	 * 
	 */
	
	final static Logger logger = LoggerFactory.getLogger(CheckEventsMngrThread.class);
	
	private static String CONSUMER_ID="urn:rixf:eu.epichub/consumer/bec_center/gatewayTEK";
	//private static String MIDDLEWARE_URL="http://188.226.184.197:9181/cxf/unifiedServiceEndpoint?wsdl";
	//UnifiedService middlewareService = null;
	// private static final QName SERVICE_NAME = new
	// QName("http://it.thalesgroup.com/ns/service/epichub","EpichubServiceService");
	private static final QName SERVICE_NAME = new QName(
			"http://it.thalesgroup.com/ns/service/energy_unified",
			"EnergyUnifiedServiceService");
	
	private boolean active =true;
	
	private String lastToken = null;
	private boolean check_getevents = false;
	
	private int check_getevents_interval =0;
	private int check_getevents_interval_default = 60000;
	DatabaseService database ; 
	
	
	private String var_state_CL_N5_34 = "urn:rixf:eu.epichub/resource/variables/bec_center/state_CL_N5_34";
	private CoreService coreService;
	private int timeout=3000;
	
	
	public CheckEventsMngrThread(DatabaseService db, CoreService core) {
		
		database = db;	
		coreService = core;
		String stringCheck_getevents = null;
		
		try{
			stringCheck_getevents = System.getProperty("epichub.check_getevents");		
			if(stringCheck_getevents.equals("true"))
				check_getevents = true;
		
			logger.debug("CheckEventsMngrThread Using [check_getevents] property: "+ stringCheck_getevents );
			
		}catch(Exception e){
			logger.debug("Error reading [epichub.check_getevents] property. Using default: false");
			check_getevents=false;
		}
		
		try{
			check_getevents_interval = Integer.parseInt(System.getProperty("epichub.check_getevents_interval"));
			if(check_getevents_interval == 0){
				check_getevents_interval = check_getevents_interval_default;
			}
			logger.debug("CheckEventsMngrThread Using [check_getevents_interval] property: "+ check_getevents_interval + " ms");
		}catch(Exception e){
			logger.debug("Error reading [epichub.check_getevents_interval] property. Using default: 60000 ms");
			check_getevents_interval=60000;
		}
		 		
		try{
			timeout= Integer.parseInt(System.getProperty("epichub.connect_timeout"));
			logger.debug("CheckEventsMngrThread Using [epichub.connect_timeout] property: "+timeout +" ms");
		}catch(Exception e){
			logger.debug("Error reading [epichub.connect_timeout] property. Using default: 3000 ms");
			timeout=3000;
		}
		
		//try {
		//	middlewareService = getMiddlewarePort(MIDDLEWARE_URL);
		//} catch (MalformedURLException e) {
		//	logger.error("CheckEventsMngrThread Middleware URL malformed", e);
		//}
	}
	
	
	@Override
	public void run() {
		
		if(check_getevents){
			logger.debug("CheckEventsMngrThread check_getevents is set to true");
			while(active){			
				//logger.debug("CheckEventsMngrThread while loop inside");
				try {
					getEventsMain();				
					
					if (lastToken != null){
				    	  Thread.sleep(check_getevents_interval);
				    }
					
				} catch (InterruptedException e) {
					logger.error("Check getEvents interrupted: "+ e);
					return;
				}
			}
			logger.debug("CheckEventsMngrThread active is false");
		}else{
			logger.debug("CheckEventsMngrThread check_getevents is set to false");
		}
	}
	
	public UnifiedService getMiddlewarePort(String url) throws MalformedURLException{
		UnifiedService port =null;	
		EnergyUnifiedServiceService middlewareEnergyService = null;
		
			
		URL wsdlURL = new URL(url);
		middlewareEnergyService = new EnergyUnifiedServiceService(wsdlURL,SERVICE_NAME);							
		port = middlewareEnergyService.getUnifiedServicePort();							
		
		return port;
	}	
	
	private CometHeader getBasicHeader(){
		CometHeader cometHeader = new CometHeader();
	    cometHeader.setConsumerId(CONSUMER_ID);
	    cometHeader.setRequestTime(Utils.toXMLGregorianCalendar(new Date(System.currentTimeMillis())));
		return cometHeader;
	}
	
	private CometHeader getCometHeader(String lastToken){
		CometHeader cometHeader = getBasicHeader();
		if (lastToken != null){
			cometHeader.setLastToken(lastToken);
		}
		return cometHeader;
	}
	
	public CometEvents getEventsAndToken(String subscriberId) throws UnsupportedFaultMessage, OperationFaultMessage, CometFaultMessage{
		logger.debug("getEventsAndToken invoked");
		CometEvents cometEvents = null;
	    GetEventsIn  getEventsIn = new GetEventsIn();
	    CometHeader cometHeader = getBasicHeader();
        getEventsIn.setHeader(cometHeader);
        GetEventsOut getEventsOut = GetEventsMiddleware(subscriberId, getEventsIn);
        if (getEventsOut == null){
        	logger.debug("GetEventsOut null");
        }
        else {
        	cometEvents = getEventsOut.getGetEvents();
        }
		return cometEvents;
	}
	
	public GetEventsOut GetEventsMiddleware(String subscriberId, GetEventsIn getEventsIn ){
		UnifiedService port =  null;		
		GetEventsOut rOut = null;
				
		try {
		
			port = GatewayClient.getPort4SubscriberId (subscriberId);		
			
			if(port !=null){
				
				rOut  = port.getEvents(getEventsIn);
				
				if(rOut != null){
					//logger.error("GetEventsMiddleware : rOut is NOT null ");
				}else{
					logger.error("GetEventsMiddleware : rOut is null ");
				}
			}else
				logger.error("GetEventsMiddleware : port is null ");
			
		} catch (CometFaultMessage e) {
			e.printStackTrace();
			logger.error("GetEventsMiddleware : CometFaultMessage " + e.getMessage());
		} catch (UnsupportedFaultMessage e) {
			e.printStackTrace();
			logger.error("GetEventsMiddleware : UnsupportedFaultMessage " + e.getMessage());
		} catch (OperationFaultMessage e) {
			e.printStackTrace();
			logger.error("GetEventsMiddleware : OperationFaultMessage " + e.getMessage());
		}
		
		return rOut;
		
	}		
	
	public void getEventsMain() throws InterruptedException{
		
		//logger.debug("getEventsMain START ");
		String subscriberId = null;
	
		List<gateway_subscriber> listSubscribers = LoadSubscribersFromDB();
		for (gateway_subscriber subscriber : listSubscribers){
			
			subscriberId = subscriber.getId();
			
			getEvents(subscriberId);
		}				
		//logger.debug("getEventsMain END ");
	}

	public void getEvents(String subscriberId) throws InterruptedException{
		CometHeader cometHeader = new CometHeader();
	    GetEventsIn getEventsIn = new GetEventsIn();
	    GetEventsOut getEventsOut = null;
	    CometEvents cometEvents = null;
	    List<Event> events = null;
	    Event event = null;
	    long eventMessageCounter = 0;
	    long eventTotalCounter = 0;
	    long milliseconds = 0;
	    long millisecondsStart = 0;
	    long millisecondsFinish = 0;
	    long maxMessages = 0;
	    long maxProcessingTime = 0;
	    
	    //logger.debug("getEvents START for subscriberId " + subscriberId);
	    
	    eventMessageCounter = 0;
	    millisecondsStart = System.currentTimeMillis(); 
		logger.debug("getEvents Processing start at: " + Utils.toXMLGregorianCalendar(new Date(System.currentTimeMillis())).toString());
	    
		try {
	        cometHeader = getCometHeader(lastToken);
	        getEventsIn = new GetEventsIn();
	        getEventsIn.setHeader(cometHeader);
	        getEventsOut = GetEventsMiddleware(subscriberId, getEventsIn);
	        if (getEventsOut == null){
	        	logger.info("getEvents No events response");
	        }
	        else {
	        	cometEvents = getEventsOut.getGetEvents();
	        	if (cometEvents == null){
	        		logger.info("getEvents No cometEvents");
	        	}
	        	else {
	        		lastToken = cometEvents.getResponseToken();
	        		events = cometEvents.getEvent();
	        		if (events == null) {
	        			logger.info("getEvents No events");
	        		}
	        		else {
	        			for (Iterator<Event> iterEvent = events.iterator(); iterEvent.hasNext(); ) {
	        				eventMessageCounter++;
	        			    eventTotalCounter++;
	        				event = iterEvent.next();
	        				if (event instanceof CommandEvent){
	        					//logger.info("getEvents COMMANDEVENT received");
	        					
	        					if(event  != null){
	        						//logger.info("getEvents COMMANDEVENT event is NOT null");
	        						
		        					if (event instanceof CommandEvent){
		        						CommandEvent myevent = (CommandEvent)event;
			        					Date  now = new Date();
		        						
			        					for(Command command :myevent.getCommand()){
			        					
			        						SimpleValueParam objParam = (SimpleValueParam) command.getParam();
			        						if (objParam != null)	{		        						
			        							String value = objParam.getValue();
			        							logger.info("getEvents COMMANDEVENT value " +value + " " + now.getTime());
			        							String var_state_CL_N5_34 = "urn:rixf:eu.epichub/resource/variables/bec_center/state_CL_N5_34";
			        							if(coreService != null)	{		        						
			        								Record valueRead = coreService.readData(var_state_CL_N5_34,timeout);
			        								
			        								logger.debug("Get events read before write " + valueRead.getValue());
			        								coreService.writeData(var_state_CL_N5_34, value, timeout);
			        							}
			        							else
			        								logger.error("getEvents coreService is null at writeData value " +var_state_CL_N5_34 + " " + value);
			        										        							
			        						}else
			        							logger.info("getEvents COMMANDEVENT objParam is null " );
			        					}			        					
		        					}
	        					}else{
	        						logger.info("getEvents COMMANDEVENT event is null");
	        					}
	        					//command
	        					//device
	        					//value
	        					//coreservice,writedata
	        					//coreService.writeData("urn:rixf:eu.epichub/resource/variables/"+centerId+"/"+varId, value, timeout);
	        					
	        				}
	        				else {
	        					//logger.info("getEvents Other event received " +event.toString());
	        				}
	        				//logger.info(event.toString());
	        			}
	        		}
	        	}
	        }
	        if(cometEvents != null){
		        if (cometEvents.getTokenExpires().toGregorianCalendar().before(Utils.toXMLGregorianCalendar(new Date(System.currentTimeMillis())).toGregorianCalendar())){
		        	//FJD reset de token
		        	lastToken = null;
				}
	        }else{
	        	logger.error("getEvents cometEvents is null: ");
	        }
	      } catch (final Exception e) {
	    	  logger.error("getEvents exception: ", e);
	        lastToken = null;
	      }
		  logger.debug("getEvents for subscriberId " + subscriberId);
	      //logger.debug("getEvents Processing finish at: " + Utils.toXMLGregorianCalendar(new Date(System.currentTimeMillis())).toString());
	      //logger.debug("getEvents Events last message: " + eventMessageCounter);
	      //logger.debug("getEvents total Events : " + eventTotalCounter);
	      millisecondsFinish = System.currentTimeMillis();
	      milliseconds = millisecondsFinish - millisecondsStart;
	      logger.debug("getEvents Processing time: " + milliseconds/1000 + " seconds");
	      if (eventMessageCounter > maxMessages) maxMessages = eventMessageCounter;
	      //logger.debug("getEvents Maximun messages: "+ maxMessages);
	      if ( milliseconds > maxProcessingTime)  maxProcessingTime = milliseconds;
	      //logger.debug("getEvents Maximun processing time: " + maxProcessingTime/1000);
	      
    }
	
	//public UnifiedService getMiddlewareService() {
	//	return middlewareService;
	//}

	//public void setMiddlewareService(UnifiedService middlewareService) {
	//	this.middlewareService = middlewareService;
	//}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//CheckEventsMngrThread eventsMngr = new CheckEventsMngrThread();
		//eventsMngr.run();
		logger.info("EventMngr NOT IMPLEMENTED ");
	}

	public List<gateway_subscriber> LoadSubscribersFromDB(){
		List<gateway_subscriber> list = null;
		//logger.debug("LoadSubscribersFromDB start");
		
		if (database != null){
			try {
				list = database.getAllSubscribers();					
				
				if(list != null){					
					//logger.debug("LoadSubscribersFromDB Loaded subscribers from DB. Num :"+ list.size());
					
				}else{
					logger.debug(" LoadSubscribersFromDB list of subscribers is null ");					
				}
				
			} catch (Exception e) {
				logger.error("LoadSubscribersFromDB Exception loading all subscribers:" + e.getMessage());
			}
		}else
			logger.error(" LoadSubscribersFromDB Database is null ");
		
		//logger.debug("LoadSubscribersFromDB end");	
		return list;
	}


	public void setActive(boolean activebool) {
		this.active = activebool;
	}


	public boolean getActive() {
		return this.active;
	}
	
}
