package epichub.framework.gateway.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openmuc.framework.data.Record;
import org.openmuc.framework.dataaccess.Channel;
import org.openmuc.framework.dataaccess.DataAccessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import epichub.framework.gateway.spi.DatabaseService;
import epichub.framework.gateway.spi.SubscriberService;
import eu.epichub.gateway.eg.core.gateway_subscriber;
import eu.epichub.gateway.eg.core.gateway_subscription;
import eu.epichub.gateway.eg.core.gateway_variable;

public class SubscriberCollection implements SubscriberService {

	private final static Logger log = LoggerFactory.getLogger(SubscriberCollection.class);
	private HashMap<String, SubscriptionThread> colSubs;
	static boolean storeToDB;
	public SubscriberCollection() {
		colSubs = new HashMap<String, SubscriptionThread>();
		
		try {
			storeToDB = Boolean.parseBoolean(System.getProperty("epichub.storeToDB"));
			log.debug("Using [epichub.storeToDB] property: "+ storeToDB );
		} catch (Exception e) {
			log.debug("Error reading [epichub.storeToDB] property. Using default:true");
			storeToDB = true;
		}
		//varCount= new HashMap<String, Integer>();
	}

	@Override
	public void notify(String channelLabel, Record r) {
		/*try {
			gateway_variable var = CoreServiceImpl.getDB().getVariable(channelLabel);
			for(Object o: var.getSubscriptions()){
				gateway_subscription sub =(gateway_subscription) o;
				  col.get(sub.getId()).change(channelLabel,r);
			}
		} catch (Exception e) {
			log.error("Exception notifying:"+e.getMessage());
		}*/
		
		//Avisa a todas las subscripciones
		/*for( SubscriptionThread t: col.values()){
			t.change(channelLabel, r);
		}*/
	}

	@Override
	public void loadSubscription(gateway_subscription sub, List<gateway_variable> varList) {
		//log.debug("loading sub:"+sub.getId());
		
		if (colSubs.containsKey(sub.getId())) {
			//decVars(colSubs.get(sub.getId()));
			colSubs.get(sub.getId()).stopSub(true);
		} 
		colSubs.put(sub.getId(),new SubscriptionThread(sub,varList));
		//incVars(colSubs.get(sub.getId()));
		colSubs.get(sub.getId()).start();
	}

	@Override
	public Boolean isSubscriptionLoaded(String subId) {
		return colSubs.containsKey(subId);
	}

	/*@Override
	public Boolean isVariableSubscribed(String varId) {
		return varCount.get(varId)>0;
	}*/
	
	@Override
	public void unloadSubscription(String subId) {
		if (colSubs.containsKey(subId)) {
			//decVars(colSubs.get(subId));
			colSubs.get(subId).stopSub(true);
			colSubs.remove(subId);
		} else
			log.debug(subId + " is NOT loaded");

	}

	/*private void incVars(SubscriptionThread s){
		for(gateway_variable v:s.varMap.values()){
			if(!varCount.containsKey(v.getId()))
				varCount.put(v.getId(),0);
			varCount.put(v.getId(), varCount.get(v.getId())+1);
		}
	}
	private void decVars(SubscriptionThread s){
		for(gateway_variable v:s.varMap.values()){
			if(varCount.containsKey(v.getId()))
				varCount.put(v.getId(), varCount.get(v.getId())-1);
		}
	}
	
	
	/*
	 * private static String readInput() { BufferedReader stdin = new
	 * BufferedReader(new InputStreamReader(System.in)); String s = null; do try
	 * { s = stdin.readLine(); } catch (IOException e) { System.err.println(e);
	 * } while ((s == null) || (s.length() == 0)); return s; }
	 * 
	 * 
	 * public static void main(String[] args){ SubscriberCollection sb = new
	 * SubscriberCollection(); do { System.out.println("Introduce comando");
	 * String in = readInput();
	 * 
	 * if (in.equals("q")) sb.addSubscriber("A",5000,"Ramon"); if
	 * (in.equals("w")) sb.notifySubscriber("A",
	 * "long: "+System.currentTimeMillis()/1000); if (in.equals("e"))
	 * sb.deleteSubscriber("A");
	 * 
	 * if (in.equals("a")) sb.addSubscriber("B",3000,"Tomas"); if
	 * (in.equals("s")) sb.notifySubscriber("B",
	 * "long: "+System.currentTimeMillis()/1000); if (in.equals("d"))
	 * sb.deleteSubscriber("B");
	 * 
	 * if (in.equals("x")) { for (SubscriberThread s :sb.col.values())
	 * s.stopSub(true); break; } } while (true);
	 * 
	 * System.out.println("FINISH!");
	 * 
	 * }
	 */
	
	// DDBB
	/*protected void setDatabaseService(DatabaseService dbs) {
		log.debug("setting Database");
		database = dbs;
	}

	protected void unsetDatabaseService(DatabaseService dbs) {
		log.debug("unsetting Database");
		database = null;
	}

	static DatabaseService getDB() {
		if (database == null) {
			throw new NullPointerException();
		}
		return database;
	}
	
	// DataAccess
		protected void setDataAccessService(DataAccessService das) {
			log.debug("setting DataAccessService");
			dataaccess = das;
		}

		protected void unsetDataAccessService(DataAccessService das) {
			log.debug("unsetting DataAccessService");
			dataaccess = null;
		}

		static DataAccessService getDataAccess() {
			if (dataaccess == null) {
				throw new NullPointerException();
			}
			return dataaccess;
		}*/
}
