package epichub.framework.gateway.core.restws;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmuc.framework.data.Record;
import org.openmuc.framework.server.restws.Activator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import epichub.framework.gateway.core.States;
import epichub.framework.gateway.spi.DatabaseService;
import epichub.framework.gateway.spi.CoreService;
import eu.epichub.gateway.eg.core.gateway_subscription;


@SuppressWarnings("serial")
public class CoreResourceServlet extends HttpServlet{
	private CoreService coreService;
	private DatabaseService database;
	private PrintWriter out;
	private int timeout=3000;
	@Override
	public void init() throws ServletException {
		this.coreService = Activator.getCoreService();
		this.database= Activator.getDatabaseService();
		
		try{
			timeout= Integer.parseInt(System.getProperty("epichub.connect_timeout"));
			Activator.getLogger().debug("Using [epichub.connect_timeout] property: "+timeout +" ms");
		}catch(Exception e){
			Activator.getLogger().debug("Error reading [epichub.connect_timeout] property. Using default: 3000 ms");
			timeout=3000;
		}
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json");
		out = response.getWriter();
		String pathInfo = request.getPathInfo();
		
		if (pathInfo == null) {
			pathInfo = "/";
		}
		
		String[] args = pathInfo.split("/");
		if(args.length>1){
			String operation=args[1];
			if(operation.equals("read"))
				read(args);
			else if(operation.equals("write"))
				write(args);
			else if(operation.equals("sub"))
				sub(args);
			else if(operation.equals("unsub"))
				unsub(args);
			else {
				out.println("INVALID OPERATION ["+operation+"]");
				out.println("VALID OPERATIONS ARE: [read][write][sub][unsub]");
				out.println("Expected URL: /epichub/core/{operation}/{arguments}");
			}
		}
		else{
			out.println("AVAILABLE OPERATIONS ARE: [read][write][sub][unsub]");
			out.println("Expected URL: /epichub/core/{operation}/{arguments}");
		}
		
		


	}
	
		private void read(String[] args){	
			String varId="";String centerId="";
			try{
				try{
					centerId=args[2];}catch(Exception e){
					throw new Exception("Could not get site. Expected URL: /epichub/core/read/{site}/{varId}");
				}
				if (!(centerId.equals("bec_center")||centerId.equals("tsg_port")||centerId.equals("nta_airport")||centerId.equals("imp_institute")))
				throw new Exception("Invalid pilot site. Expected: bec_center, tsg_port, nta_airport OR imp_institute");
				
				try{varId= args[3];}catch(Exception e){
					throw new Exception("Could not get varId. Expected URL: /epichub/core/read/{site}/{varId}");
				}
				
			
			if(varId==null || varId.isEmpty()){
				throw new Exception("varId can NOT be empty. Expected URL: /epichub/core/read/{site}/{varId}");
			}
				Record value=(Record) coreService.readData("urn:rixf:eu.epichub/resource/variables/"+centerId+"/"+varId,timeout);
					
				out.println("Value for "+varId+": "+value.getValue());
			}catch(Exception e){
				out.println("Exception reading:"+e.getMessage());
			}
			
		}
		
		private void write(String[] args){	
			String varId="";
			String value="";
			String centerId="";
			try{
				
				try{
					centerId=args[2];}catch(Exception e){
					throw new Exception("Could not get site. Expected URL: /epichub/core/write/{site}/{varId}");
				}
				if (!(centerId.equals("bec_center")||centerId.equals("tsg_port")||centerId.equals("nta_airport")||centerId.equals("imp_institute")))
				throw new Exception("Invalid pilot site. Expected: bec_center, tsg_port, nta_airport OR imp_institute");
				
				try{varId= args[3];}catch(Exception e){
					throw new Exception("Could not get varId. Expected URL: /epichub/core/write/{site}/{varId}/{value}");
				}
				try{value= args[4];}catch(Exception e){
					throw new Exception("Could not get value. Expected URL: /epichub/core/write/{site}/{varId}/{value}");
				}

			if(varId==null || varId.isEmpty()){
				throw new Exception("varId can NOT be empty. Expected URL: /epichub/core/write/{site}/{varId}/{value}");
			}
			if(value==null || value.isEmpty()){
				throw new Exception("value can NOT be empty. Expected URL: /epichub/core/write/{site}/{varId}/{value}");
			}
				coreService.writeData("urn:rixf:eu.epichub/resource/variables/"+centerId+"/"+varId, value, timeout);
				out.println("Write succesfully completed");
			}catch(Exception e){
				out.println("Exception writing:"+e.getMessage());
			}
			
		}		
	
		private void sub(String[] args){	
			String subId="";
			try{
				try{subId= args[2];}catch(Exception e){
					throw new Exception("Could not get subId. Expected URL: /epichub/core/sub/{subId}");
				}
			if(subId==null || subId.isEmpty()){
				throw new Exception("subId can NOT be empty. Expected URL: /epichub/core/sub/{subId}");
			}
				String status=coreService.subscribe("urn:rixf:eu.epichub/subscriptions/"+subId);
				if (status.equals(States.ERROR.name()))
					out.println("Subscription urn:rixf:eu.epichub/subscriptions/"+ subId+" could NOT be loaded. All variables are unavailable");
				else if (status.equals(States.PARTIAL.name()))
					out.println("Subscription urn:rixf:eu.epichub/subscriptions/"+ subId+" partially loaded. Some variables are unavailable");
				else //status.equals(States.STARTED.name()
					out.println("Subscription urn:rixf:eu.epichub/subscriptions/"+ subId+" completely loaded. All variables are available");
				
			}catch(Exception e){
				out.println("Exception loading subscription:"+e.getMessage());
			}
			listSubscriptions();
		}
		
		private void unsub(String[] args){	
			String subId="";
			try{
				try{subId= args[2];}catch(Exception e){
					throw new Exception("Could not get subId. Expected URL: /epichub/core/unsub/{subId}");
				}
			if(subId==null || subId.isEmpty()){
				throw new Exception("subId can NOT be empty. Expected URL: /epichub/core/unsub/{subId}");
			}
				coreService.unsubscribe("urn:rixf:eu.epichub/subscriptions/"+subId);
				out.println("Subscription urn:rixf:eu.epichub/subscriptions/"+ subId+" unloaded");
				
			}catch(Exception e){
				out.println("Exception unloading subscription:"+e.getMessage());
			}
			listSubscriptions();
		}
		
		private void listSubscriptions(){
			out.println();
			try {
				List<gateway_subscription> l =database.getAllSubscriptions();
				out.println("Subscriptions:");
				for(gateway_subscription s:l)
					out.println("-"+s.getId()+"["+s.getState()+"]");
			} catch (Exception e) {
				out.println("Exception listing subscriptions:"+e.getMessage());
			}
		}
}