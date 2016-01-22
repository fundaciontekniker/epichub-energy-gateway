package epichub.framework.gateway.db.derby.manage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.PersistentTransaction;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import epichub.framework.gateway.spi.DatabaseService;
import eu.epichub.gateway.eg.core.gateway_configOption;
import eu.epichub.gateway.eg.core.gateway_device;
import eu.epichub.gateway.eg.core.gateway_deviceCriteria;
import eu.epichub.gateway.eg.core.gateway_driver;
import eu.epichub.gateway.eg.core.gateway_driverCriteria;
import eu.epichub.gateway.eg.core.gateway_host;
import eu.epichub.gateway.eg.core.gateway_hostCriteria;
import eu.epichub.gateway.eg.core.gateway_subscriber;
import eu.epichub.gateway.eg.core.gateway_subscriberCriteria;
import eu.epichub.gateway.eg.core.gateway_subscription;
import eu.epichub.gateway.eg.core.gateway_subscriptionCriteria;
import eu.epichub.gateway.eg.core.gateway_value;
import eu.epichub.gateway.eg.core.gateway_valueCriteria;
import eu.epichub.gateway.eg.core.gateway_variable;
import eu.epichub.gateway.eg.core.gateway_variableCriteria;
import eu.epichub.gateway.eg.manager.DAOFactory;
import eu.epichub.gateway.eg.manager.EHReqPersistentManager;


public class DatabaseServiceImpl implements DatabaseService {
	private static final int ROW_COUNT = 100;
	
	private final String start_01 = "Exception starting DatabaseServiceImpl";
	
	private final String addHost_01 = "Exception adding host. Host with that description already exists";
	private final String updateHost_01 = "Exception updating host. Host with that name NOT found";
	private final String deleteHost_01 = "Exception deleting host. Host with that name NOT found";
	
	private final String addDriver_01 = "Exception adding driver. Driver with that ID already exists";
	private final String addDriver_02 = "Exception adding driver. Host with that ID NOT found";
	private final String updateDriver_01 = "Exception updating driver. Driver with that ID NOT found";
	private final String deleteDriver_01 = "Exception deleting driver. Driver with that ID NOT found";

	private final String addDevice_01 = "Exception adding device. Device with that ID already exists";
	private final String addDevice_02 = "Exception adding device. Driver with that ID NOT found";
	private final String updateDevice_01 = "Exception updating device. Device with that ID NOT found";
	private final String deleteDevice_01 = "Exception deleting device. Device with that ID NOT found";
	
	private final String addVariable_01 = "Exception adding variable. Variable with that ID already exists";
	private final String addVariable_02 = "Exception adding variable. Device with that ID NOT found";
	private final String updateVariable_01 = "Exception updating variable. Variable with that ID NOT found";
	private final String deleteVariable_01 = "Exception deleting variable. Variable with that ID NOT found";
	private final String addVariableValue_01 = "Exception deleting variable. Variable with that ID NOT found";
	
	private final String addSubscriber_01 = "Exception adding subscriber. Subscriber with that ID already exists";
	private final String updateSubscriber_01 = "Exception updating subscriber. Subscriber with that ID NOT found";
	private final String deleteSubscriber_01 = "Exception deleting subscriber. Subscriber with that ID NOT found";
	
	private final String addSubscription_01 = "Exception adding subscription. Subscription with that ID already exists";
	private final String addSubscription_02 = "Exception adding subscription. Subscriber with that ID NOT found";
	private final String updateSubscription_01 = "Exception updating subscription. Subscription with that ID NOT found";
	private final String deleteSubscription_01 = "Exception deleting subscription. Subscription with that ID NOT found";

	private final String getHistoricalData_01 = "Exception gettting historical data. Variable with that ID NOT found";
	
	private final static Logger logger = LoggerFactory.getLogger(DatabaseServiceImpl.class);

	protected void activate(ComponentContext context) {
		logger.debug("Activating DatabaseServiceImpl");
		try{
			//getAllDevices();
		}catch(Exception e){
			
		}
	}

	protected void deactivate(ComponentContext context) {
		logger.debug("Deactivating DatabaseServiceImpl");
	}
	
	@Override
	public gateway_host getHost(String host_Id) throws Exception {
		
		PersistentSession s=null;
		gateway_host h=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			h=getHost(host_Id, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return h;
	}

	@Override
	public void addHost(String host_Id, String url, String description) throws Exception {
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			addHost(host_Id, url, description, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
	}
	
	@Override
	public void updateHost(String host_Id, String url, String description)throws Exception{
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			updateHost(host_Id, url, description, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
	}
	@Override
	public void updateHostState(String host_Id, String state)throws Exception{
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			updateHostState(host_Id, state, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
	}
	@Override
	public void deleteHost(String host_Id) throws Exception {
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			deleteHost(host_Id, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		
	}
	
	@Override
	public gateway_driver getDriver(String dId) throws Exception {
		PersistentSession s=null;
		gateway_driver d=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			d=getDriver(dId, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return d;
	}

	
	@Override
	public void addDriver(String driver_Id, String host_Id, String name, String description) throws Exception {
		PersistentSession s=null;
		
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			addDriver(driver_Id, host_Id, name, description, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
	}
	
	@Override
	public void updateDriver(String driver_Id, String name, String description) throws Exception {
		PersistentSession s=null;
		
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			updateDriver(driver_Id, name, description, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
	}
	
	@Override
	public void updateDriverState(String driver_Id, String state) throws Exception {
		PersistentSession s=null;
		
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			updateDriverState(driver_Id, state, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		
	}
	@Override
	public void deleteDriver(String driver_Id) throws Exception {
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			deleteDriver(driver_Id, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
	}
	


	@Override
	public void addDevice(String device_Id, String driver_Id,
			String description, String capabilities, String deviceAddress,
			String interfaceAddress, String type) throws Exception {
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			addDevice(device_Id, driver_Id, description, capabilities, deviceAddress, interfaceAddress, type, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
	}

	@Override
	public void updateDevice(String device_Id, String description,
			String capabilities, String deviceAddress, String interfaceAddress,
			String type) throws Exception {
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			updateDevice(device_Id, description, capabilities, deviceAddress, interfaceAddress, type,s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
	}
	
	
	@Override
	public void updateDeviceState(String device_Id, String state) throws Exception {
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			updateDeviceState(device_Id, state, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		
	}

		
	@Override
	public gateway_device getDevice(String device_Id) throws Exception {
		PersistentSession s=null;
		gateway_device d=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			d=getDevice(device_Id, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return d;
	}

	@Override
	public void deleteDevice(String device_Id) throws Exception {
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			deleteDevice(device_Id, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
	}

	@Override
	public void addVariable(String var_Id, String device_Id,
			String description, String digType, String phyType, String unit,
			String accessType, String path, Long expirationDate,
			Long samplingInterval, Double absoluteError,
			Integer percentageError) throws Exception {
		PersistentSession s=null;

		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			addVariable(var_Id, device_Id, description, digType, phyType, unit, accessType, path, expirationDate, samplingInterval, absoluteError, percentageError, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}		
	}

	@Override
	public void updateVariable(String var_Id, String description,
			String digType, String phyType, String unit, String accessType,
			String path, Long expirationDate, Long samplingInterval,
			Double absoluteError, Integer percentageError)
			throws Exception {
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			updateVariable(var_Id, description, digType, phyType, unit, accessType, path, expirationDate, samplingInterval, absoluteError, percentageError, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}		
	}

	@Override
	public void updateVariableState(String var_Id, String state)
			throws Exception {
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			updateVariableState(var_Id, state,s);

			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		
	}
	
	@Override
	public gateway_variable getVariable(String var_Id) throws Exception {
		PersistentSession s=null;
		gateway_variable v= null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			v=getVariable(var_Id, s);
	
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return v;
	}

	@Override
	public void deleteVariable(String var_Id) throws Exception {
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			deleteVariable(var_Id, s);
	
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
	}

	
	@Override
	public List<gateway_host> getAllHosts() throws Exception {
		PersistentSession s=null;
		List<gateway_host>  l= null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			l= getAllHosts(s);
	
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return l;
	}
	

	@Override
	public List<gateway_driver> getAllDrivers() throws Exception {
		PersistentSession s=null;
		List<gateway_driver>  l= null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			l= getAllDrivers(s);
	
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return l;
	}

	@Override
	public List<gateway_device> getAllDevices() throws Exception {
		PersistentSession s=null;
		List<gateway_device> list = null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			list=getAllDevices(s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return list;
	}
	
	@Override
	public List<gateway_subscriber> getAllSubscribers() throws Exception {
		List<gateway_subscriber> subList = null;
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			subList=getAllSubscribers(s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return subList;
	}
	
	
	@Override
	public List<gateway_variable> getAllVariables() throws Exception {
		List<gateway_variable> subList = null;
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			subList=getAllVariables(s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return subList;
	}
	
	

	@Override
	public List<gateway_subscription> getAllSubscriptions() throws Exception {
		logger.debug("Getting subscriptions");
		List<gateway_subscription> subList = null;
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			subList=getAllSubscriptions(s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			logger.error("EXCEPTION Getting subscriptions:"+e.getMessage());
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return subList;
	}

	




	@Override
	public void addSubscriber(String subscriber_Id, String name,String responseUrl) throws Exception {
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			addSubscriber(subscriber_Id, name, responseUrl, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
	}

	@Override
	public void updateSubscriber(String subscriber_Id, String name,	String responseUrl) throws Exception {
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			updateSubscriber(subscriber_Id, name, responseUrl, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
	}
	
	@Override
	public void deleteSubscriber(String subscriber_Id) throws Exception {
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			deleteSubscriber(subscriber_Id, s);	
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		
	}

	@Override
	public gateway_subscriber getSubscriber(String subscriber_Id) throws Exception {
		PersistentSession s=null;
		gateway_subscriber sub= null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			sub=getSubscriber(subscriber_Id,s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return sub;

	}

	
	@Override
	public void addSubscription(String sub_Id, String subscriber_Id,
			Long minInt, Long maxInt) throws Exception {
		
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			addSubscription(sub_Id, subscriber_Id, minInt, maxInt, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		
	}

	@Override
	public void updateSubscription(String sub_Id, Long minInt, Long maxInt) throws Exception {
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			updateSubscription(sub_Id, minInt, maxInt, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
	}

	@Override
	public void updateSubscriptionState(String sub_Id,String state) throws Exception {
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			updateSubscriptionState(sub_Id, state, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		
	}
	
	@Override
	public gateway_subscription getSubscription(String sub_Id) throws Exception {
		gateway_subscription sub=null;
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			sub=getSubscription(sub_Id, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return sub;
	}

	@Override
	public void deleteSubscription(String sub_Id) throws Exception {
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			deleteSubscription(sub_Id, s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		
	}

	
	///--------------------------------------------------------------------
	
	@Override
	public gateway_host getHost(String host_Id,PersistentSession s) throws Exception {
		try{
		logger.debug("getHost:"+host_Id);
		gateway_hostCriteria hC= new gateway_hostCriteria();
		hC.id.eq(host_Id);
		return DAOFactory.getDAOFactory().getgateway_hostDAO().loadGateway_hostByCriteria(hC);}
		catch(Exception e){
			logger.error("Exception_getHost:"+e.getMessage()); 
			throw e;
		}
	}
	@Override
	public void addHost(String host_Id, String url, String description,PersistentSession s) throws Exception {
		logger.debug("addHost:"+host_Id);
		gateway_host host =DAOFactory.getDAOFactory().getgateway_hostDAO().createGateway_host();
		host.setId(host_Id);
		host.setDescription(description);
		host.setURL(url);
		host.setState("NEW");
		try{
			logger.debug("addHost:"+DAOFactory.getDAOFactory().getgateway_hostDAO().save(host));
		}catch(Exception e){
			logger.error("Error adding host:"+e.getMessage());
		}
	
	}
	@Override
	public void updateHost(String host_Id, String url, String description,PersistentSession s)throws Exception{
		logger.debug("updateHost:"+host_Id);
		gateway_hostCriteria hC= new gateway_hostCriteria();
		hC.id.eq(host_Id);
		gateway_host host = DAOFactory.getDAOFactory().getgateway_hostDAO().loadGateway_hostByCriteria(hC);
		if(host==null){
			throw new Exception(updateHost_01);
		}else{
			host.setDescription(description);
			host.setURL(url);
			try{
				logger.debug("updateHost:"+DAOFactory.getDAOFactory().getgateway_hostDAO().save(host));
			}catch(Exception e){
				logger.error("Error updating host:"+e.getMessage());
			}
		}
	}
	@Override
	public void updateHostState(String host_Id, String state,PersistentSession s)throws Exception{
		logger.debug("updateHostState:"+host_Id+"-->"+state);
		gateway_hostCriteria hC= new gateway_hostCriteria();
		hC.id.eq(host_Id);
		gateway_host host = DAOFactory.getDAOFactory().getgateway_hostDAO().loadGateway_hostByCriteria(hC);
		if(host==null){
			throw new Exception(updateHost_01);
		}else{
			host.setState(state);
			try{
				logger.debug("updateHostState:"+DAOFactory.getDAOFactory().getgateway_hostDAO().save(host));
			}catch(Exception e){
				logger.error("Error updating host state:"+e.getMessage());
				//TODO
			}
		}
	}
	@Override
	public void deleteHost(String host_Id,PersistentSession s) throws Exception {
		logger.debug("deleteHost:"+host_Id);
		gateway_hostCriteria hC= new gateway_hostCriteria();
		hC.id.eq(host_Id);
		gateway_host host = DAOFactory.getDAOFactory().getgateway_hostDAO().loadGateway_hostByCriteria(hC);
		if(host==null){
			throw new Exception(deleteHost_01);
		}else{
			
			try{
				logger.debug("deleteHost:"+DAOFactory.getDAOFactory().getgateway_hostDAO().delete(host));
			}catch(Exception e){
				logger.error("Error deleting host:"+e.getMessage());
				//TODO
			}
		}
	}
	@Override
	public List<gateway_host> getAllHosts(PersistentSession s) throws Exception {
	//	logger.debug("getAllHosts:");
		List<gateway_host> hostList = new ArrayList<gateway_host>();
		gateway_host[] gArr= DAOFactory.getDAOFactory().getgateway_hostDAO().listGateway_hostByCriteria(new gateway_hostCriteria());
		for(gateway_host h:gArr){
			hostList.add(h);
		}
		return hostList;
	}
	

	
	@Override
	public gateway_driver getDriver(String dId,PersistentSession s) throws Exception {
		logger.debug("getDriver:"+dId);
		gateway_driverCriteria dC= new gateway_driverCriteria();
		dC.id.eq(dId);
		return DAOFactory.getDAOFactory().getgateway_driverDAO().loadGateway_driverByCriteria(dC);
	}
	@Override
	public void addDriver(String driver_Id, String host_Id, String name, String description,PersistentSession s) throws Exception {
		logger.debug("addDriver:"+driver_Id +" to["+host_Id+"]");
		gateway_hostCriteria hC= new gateway_hostCriteria();
		hC.id.eq(host_Id);
		gateway_host host=DAOFactory.getDAOFactory().getgateway_hostDAO().loadGateway_hostByCriteria(hC);
		if(host==null)
			throw new Exception(addDriver_02);
		else{
			gateway_driver driver = DAOFactory.getDAOFactory().getgateway_driverDAO().createGateway_driver();
			driver.setId(driver_Id);
			driver.setName(name);
			driver.setDescription(description);
			driver.setState("NEW");
			driver.setSubscriptions(false); //TODO Testear driver?
			driver.setHost(host);
			try{
				logger.debug("addDriver:"+DAOFactory.getDAOFactory().getgateway_driverDAO().save(driver));
			}catch(Exception e){
				logger.error("Error adding driver:"+e.getMessage());
				//TODO
			}
		
		}
	}
	@Override
	public void updateDriver(String driver_Id, String name, String description,PersistentSession s) throws Exception {
		logger.debug("updateDriver:"+driver_Id);
		gateway_driverCriteria dC= new gateway_driverCriteria();
		dC.id.eq(driver_Id);
		gateway_driver driver=DAOFactory.getDAOFactory().getgateway_driverDAO().loadGateway_driverByCriteria(dC);
		if(driver==null)
			throw new Exception(updateDriver_01);
		else{
			driver.setName(name);
			driver.setDescription(description);
			try{
				logger.debug("updateDriver:"+DAOFactory.getDAOFactory().getgateway_driverDAO().save(driver));
			}catch(Exception e){
				logger.error("Error updating driver:"+e.getMessage());
				//TODO
			}
		
		}
	}
	@Override
	public void updateDriverState(String driver_Id, String state,PersistentSession s) throws Exception {
		logger.debug("updateDriverState:"+driver_Id+"-->"+state);
		gateway_driverCriteria dC= new gateway_driverCriteria();
		dC.id.eq(driver_Id);
		gateway_driver driver=DAOFactory.getDAOFactory().getgateway_driverDAO().loadGateway_driverByCriteria(dC);
		if(driver==null)
			throw new Exception(updateDriver_01);
		else{
			driver.setState(state);
			try{
				logger.debug("updateDriverState:"+DAOFactory.getDAOFactory().getgateway_driverDAO().save(driver));
			}catch(Exception e){
				logger.error("Error updating driver state:"+e.getMessage());
				//TODO
			}
		
		}
	}
	@Override
	public void deleteDriver(String driver_Id,PersistentSession s) throws Exception {
		logger.debug("deleteDriver:"+driver_Id);
		gateway_driverCriteria dC= new gateway_driverCriteria();
		dC.id.eq(driver_Id);
		gateway_driver driver=DAOFactory.getDAOFactory().getgateway_driverDAO().loadGateway_driverByCriteria(dC);
		if(driver==null)
			throw new Exception(deleteDriver_01);
		else{
			try{
				logger.debug("deleteDriver:"+DAOFactory.getDAOFactory().getgateway_driverDAO().delete(driver));
			}catch(Exception e){
				logger.error("Error deleting driver:"+e.getMessage());
				//TODO
			}
		}
	}
	
	@Override
	public void addDevice(String device_Id, String driver_Id,
			String description, String capabilities, String deviceAddress,
			String interfaceAddress, String type,PersistentSession s) throws Exception {
		logger.debug("addDevice:"+device_Id +" to["+driver_Id+"]");
		gateway_driverCriteria dC= new gateway_driverCriteria();
		dC.id.eq(driver_Id);
		gateway_driver driver=DAOFactory.getDAOFactory().getgateway_driverDAO().loadGateway_driverByCriteria(dC);
		if(driver==null)
			throw new Exception(addDevice_02);
		else{
			gateway_device device = DAOFactory.getDAOFactory().getgateway_deviceDAO().createGateway_device();
			device.setId(driver_Id);
			device.setDescription(description);
			device.setCapabilities(capabilities);
			device.setDeviceAddress(deviceAddress);
			device.setInterfaceAddress(interfaceAddress);
			device.setType(type);
			device.setDriver(driver);
			device.setState("NEW");
			try{
				logger.debug("addDevice:"+DAOFactory.getDAOFactory().getgateway_deviceDAO().save(device));
			}catch(Exception e){
				logger.error("Error adding device:"+e.getMessage());
				//TODO
			}
			
		}
		
	}

	@Override
	public void updateDevice(String device_Id, String description,
			String capabilities, String deviceAddress, String interfaceAddress,
			String type, PersistentSession s) throws Exception {
		logger.debug("updateDevice:"+device_Id);
		gateway_deviceCriteria dC= new gateway_deviceCriteria();
		dC.id.eq(device_Id);
		gateway_device device=DAOFactory.getDAOFactory().getgateway_deviceDAO().loadGateway_deviceByCriteria(dC);
		if(device==null)
			throw new Exception(updateDevice_01);
		else{
			device.setDescription(description);
			device.setCapabilities(capabilities);
			device.setDeviceAddress(deviceAddress);
			device.setInterfaceAddress(interfaceAddress);
			device.setType(type);
			try{
				logger.debug("updateDevice:"+DAOFactory.getDAOFactory().getgateway_deviceDAO().save(device));
			}catch(Exception e){
				logger.error("Error updating device:"+e.getMessage());
			}
		}	
	}
	@Override
	public void updateDeviceState(String device_Id, String state,PersistentSession s) throws Exception {
		logger.debug("updateDeviceState:"+device_Id+"-->"+state);
		gateway_deviceCriteria dC= new gateway_deviceCriteria();
		dC.id.eq(device_Id);
		gateway_device device=DAOFactory.getDAOFactory().getgateway_deviceDAO().loadGateway_deviceByCriteria(dC);
		if(device==null)
			throw new Exception(updateDevice_01);
		else{
			device.setState(state);
			try{
				logger.debug("updateDevice:"+DAOFactory.getDAOFactory().getgateway_deviceDAO().save(device));
				
			}catch(Exception e){
				logger.error("Error updating device:"+e.getMessage());
				
			}
		}	
	}
	
	@Override
	public gateway_device getDevice(String device_Id,PersistentSession s) throws Exception {
		logger.debug("getDevice:"+device_Id);
		gateway_deviceCriteria dC= new gateway_deviceCriteria();
		dC.id.eq(device_Id);
		return DAOFactory.getDAOFactory().getgateway_deviceDAO().loadGateway_deviceByCriteria(dC);
	}

	@Override
	public void deleteDevice(String device_Id,PersistentSession s) throws Exception {
		logger.debug("deleteDevice:"+device_Id);
		gateway_deviceCriteria dC= new gateway_deviceCriteria();
		dC.id.eq(device_Id);
		gateway_device device=DAOFactory.getDAOFactory().getgateway_deviceDAO().loadGateway_deviceByCriteria(dC);
		if(device==null)
			throw new Exception(deleteDevice_01);
		else{	
			logger.debug("deleteDevice:"+DAOFactory.getDAOFactory().getgateway_deviceDAO().delete(device));
			//TODO
		}
		
	}

	@Override
	public void addVariable(String var_Id, String device_Id,
			String description, String digType, String phyType, String unit,
			String accessType, String path, Long expirationDate,
			Long samplingInterval, Double absoluteError,
			Integer percentageError,PersistentSession s) throws Exception {
		logger.debug("addVariable:"+var_Id +" to["+device_Id+"]");
		gateway_deviceCriteria dC= new gateway_deviceCriteria();
		dC.id.eq(device_Id);
		gateway_device device=DAOFactory.getDAOFactory().getgateway_deviceDAO().loadGateway_deviceByCriteria(dC);
		if(device==null)
			throw new Exception(addVariable_02);
		else{
			gateway_variable var = DAOFactory.getDAOFactory().getgateway_variableDAO().createGateway_variable();
			var.setId(var_Id);
			var.setDescription(description);
			var.setDigType(digType);
			var.setPhyType(phyType);
			var.setUnit(unit);
			var.setAccessType(accessType);
			var.setPath(path);
			if (expirationDate != null)
				var.setExpirationDate(expirationDate);
			if (samplingInterval != null)
				var.setSamplingInterval(samplingInterval);
			if (absoluteError != null)
				var.setAbsoluteError(absoluteError);
			if (percentageError != null)
				var.setPercentageError(percentageError);
			var.setDevice(device);
			var.setState("NEW");
			try{
				logger.debug("addVariable:"+DAOFactory.getDAOFactory().getgateway_variableDAO().save(var));
			}catch(Exception e){
				logger.error("Error adding variable:"+e.getMessage());
				//TODO
			}
			
		}
		
	}

	@Override
	public void updateVariable(String var_Id, String description,
			String digType, String phyType, String unit, String accessType,
			String path, Long expirationDate, Long samplingInterval,
			Double absoluteError, Integer percentageError,PersistentSession s)
			throws Exception {
		logger.debug("updateVariable:"+var_Id );
		gateway_variableCriteria dC= new gateway_variableCriteria();
		dC.id.eq(var_Id);
		gateway_variable var=DAOFactory.getDAOFactory().getgateway_variableDAO().loadGateway_variableByCriteria(dC);
		if(var==null)
			throw new Exception(updateVariable_01);
		else{
			var.setDescription(description);
			var.setDigType(digType);
			var.setPhyType(phyType);
			var.setUnit(unit);
			var.setAccessType(accessType);
			var.setPath(path);
			if (expirationDate != null)
				var.setExpirationDate(expirationDate);
			if (samplingInterval != null)
				var.setSamplingInterval(samplingInterval);
			if (absoluteError != null)
				var.setAbsoluteError(absoluteError);
			if (percentageError != null)
				var.setPercentageError(percentageError);
			try{
				logger.debug("updateVariable:"+DAOFactory.getDAOFactory().getgateway_variableDAO().save(var));
			}catch(Exception e){
				logger.error("Error updating variable:"+e.getMessage());
				//TODO
			}
			
		}
		
	}

	@Override
	public void updateVariableState(String var_Id, String state,PersistentSession s)
			throws Exception {
		logger.debug("updateVariableState:"+var_Id+"-->"+state );
		gateway_variableCriteria dC= new gateway_variableCriteria();
		dC.id.eq(var_Id);
		gateway_variable var=DAOFactory.getDAOFactory().getgateway_variableDAO().loadGateway_variableByCriteria(dC);
		if(var==null)
			throw new Exception(updateVariable_01);
		else{
			var.setState(state);
			try{
				logger.debug("updateVariableState:"+DAOFactory.getDAOFactory().getgateway_variableDAO().save(var));
			}catch(Exception e){
				logger.error("Error updating variable state:"+e.getMessage());
				//TODO
			}
			
		}
		
	}
	
	
	@Override
	public List<gateway_variable> getDeviceVariables(String devId) throws Exception {
		logger.debug("Getting DeviceVariables for "+devId);
		List<gateway_variable> varList = null;
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			varList=getDeviceVariables(devId,s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			e.printStackTrace();
			logger.error("EXCEPTION Getting variable subscriptions:"+e.getMessage());
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return varList;
	}
	
	@Override
	public List<gateway_variable> getDeviceVariables(String devId,PersistentSession s) throws Exception {
		List<gateway_variable> varList = new ArrayList<gateway_variable>();
		for(Object o :getDevice(devId,s).getVariables()){
			gateway_variable sb=(gateway_variable)o;
			varList.add(sb);
		}
		
		return varList;
	}
	
	@Override
	public gateway_variable getVariable(String var_Id,PersistentSession s) throws Exception {
		logger.debug("getVariable:"+var_Id );
		gateway_variableCriteria dC= new gateway_variableCriteria();
		dC.id.eq(var_Id);
		return DAOFactory.getDAOFactory().getgateway_variableDAO().loadGateway_variableByCriteria(dC);
	}

	@Override
	public void deleteVariable(String var_Id,PersistentSession s) throws Exception {
		logger.debug("deleteVariable:"+var_Id );
		gateway_variableCriteria dC= new gateway_variableCriteria();
		dC.id.eq(var_Id);
		gateway_variable var=DAOFactory.getDAOFactory().getgateway_variableDAO().loadGateway_variableByCriteria(dC);
		if(var==null)
			throw new Exception(deleteVariable_01);
		else{
			try{
				logger.debug("deleteVariable:"+DAOFactory.getDAOFactory().getgateway_variableDAO().delete(var));
			}catch(Exception e){
				logger.error("Error deleting variable:"+e.getMessage());
				//TODO
			}		
		}
	}

	
	

	@Override
	public List<gateway_driver> getAllDrivers(PersistentSession s) throws Exception {
		List<gateway_driver> driverList = new ArrayList<gateway_driver>();
		gateway_driver[] gArr= DAOFactory.getDAOFactory().getgateway_driverDAO().listGateway_driverByCriteria(new gateway_driverCriteria());
		for(gateway_driver h:gArr){
			driverList.add(h);
		}
		return driverList;
	}

	
	@Override
	public List<gateway_device> getAllDevices(PersistentSession s) throws Exception {
		List<gateway_device> devList = new ArrayList<gateway_device>();
		gateway_device[] gArr= DAOFactory.getDAOFactory().getgateway_deviceDAO().listGateway_deviceByCriteria(new gateway_deviceCriteria());
		for(gateway_device h:gArr){
			devList.add(h);
		}
		return devList;
	}
		
	@Override
	public List<gateway_variable> getAllVariables(PersistentSession s) throws Exception {
		List<gateway_variable> varList = new ArrayList<gateway_variable>();
		gateway_variable[] gArr= DAOFactory.getDAOFactory().getgateway_variableDAO().listGateway_variableByCriteria(new gateway_variableCriteria());
		for(gateway_variable v:gArr){
			varList.add(v);
		}
		return varList;
	}
	
	@Override
	public List<gateway_subscriber> getAllSubscribers(PersistentSession s) throws Exception {
		List<gateway_subscriber> subList = new ArrayList<gateway_subscriber>();
		gateway_subscriber[] gArr= DAOFactory.getDAOFactory().getgateway_subscriberDAO().listGateway_subscriberByCriteria(new gateway_subscriberCriteria());
		for(gateway_subscriber gs:gArr){
			subList.add(gs);
		}
		return subList;
	}

	@Override
	public List<gateway_subscription> getAllSubscriptions(PersistentSession s) throws Exception {
		List<gateway_subscription> subList = new ArrayList<gateway_subscription>();
		gateway_subscription[] gArr= DAOFactory.getDAOFactory().getgateway_subscriptionDAO().listGateway_subscriptionByCriteria(new gateway_subscriptionCriteria());
		for(gateway_subscription gs:gArr){
			subList.add(gs);
		}
		return subList;
	}

	






	@Override
	public void addSubscriber(String subscriber_Id, String name,String responseUrl,PersistentSession s) throws Exception {
		logger.debug("addSubscriber:"+subscriber_Id);
		gateway_subscriber subscriber =DAOFactory.getDAOFactory().getgateway_subscriberDAO().createGateway_subscriber();
		subscriber.setId(subscriber_Id);
		subscriber.setName(name);
		subscriber.setResponseURL(responseUrl);
		try{
			logger.debug("addSubscriber:"+DAOFactory.getDAOFactory().getgateway_subscriberDAO().save(subscriber));
		}catch(Exception e){
			logger.error("Error adding subscriber:"+e.getMessage());
			//TODO
		}
	}

	@Override
	public void updateSubscriber(String subscriber_Id, String name,	String responseUrl,PersistentSession s) throws Exception {
		gateway_subscriberCriteria sC= new gateway_subscriberCriteria();
		sC.id.eq(subscriber_Id);
		gateway_subscriber subscriber = DAOFactory.getDAOFactory().getgateway_subscriberDAO().loadGateway_subscriberByCriteria(sC);
		if(subscriber==null){
			throw new Exception(updateSubscriber_01);
		}else{
			subscriber.setName(name);
			subscriber.setResponseURL(responseUrl);
			try{
				logger.debug("updateSubscriber:"+DAOFactory.getDAOFactory().getgateway_subscriberDAO().save(subscriber));
			}catch(Exception e){
				logger.error("Error updating subscriber:"+e.getMessage());
				//TODO
			}
		}
	}
	
	@Override
	public void deleteSubscriber(String subscriber_Id,PersistentSession s) throws Exception {
		logger.debug("deleteSubscriber:"+subscriber_Id);
		gateway_subscriberCriteria hC= new gateway_subscriberCriteria();
		hC.id.eq(subscriber_Id);
		gateway_subscriber subscriber = DAOFactory.getDAOFactory().getgateway_subscriberDAO().loadGateway_subscriberByCriteria(hC);
		if(subscriber==null){
			throw new Exception(deleteSubscriber_01);
		}else{
			
			try{
				logger.debug("deleteSubscriber:"+DAOFactory.getDAOFactory().getgateway_subscriberDAO().delete(subscriber));
			}catch(Exception e){
				logger.error("Error deleting subscriber:"+e.getMessage());
				//TODO
			}
		}
		
	}

	@Override
	public gateway_subscriber getSubscriber(String subscriber_Id,PersistentSession s) throws Exception {
		logger.debug("getSubscriber:"+subscriber_Id);
		gateway_subscriberCriteria hC= new gateway_subscriberCriteria();
		hC.id.eq(subscriber_Id);
		return DAOFactory.getDAOFactory().getgateway_subscriberDAO().loadGateway_subscriberByCriteria(hC);

	}

	
	@Override
	public void addSubscription(String sub_Id, String subscriber_Id,
			Long minInt, Long maxInt,PersistentSession s) throws Exception {
		logger.debug("addSubscription:"+sub_Id +" to["+subscriber_Id+"]");
		gateway_subscriberCriteria dC= new gateway_subscriberCriteria();
		dC.id.eq(subscriber_Id);
		gateway_subscriber subscriber=DAOFactory.getDAOFactory().getgateway_subscriberDAO().loadGateway_subscriberByCriteria(dC);
		if(subscriber==null)
			throw new Exception(addSubscription_02);
		else{
			gateway_subscription sub = DAOFactory.getDAOFactory().getgateway_subscriptionDAO().createGateway_subscription();
			sub.setId(sub_Id);
			sub.setMinInt(minInt);
			sub.setMaxInt(maxInt);
			sub.setSubscriber(subscriber);
			sub.setState("NEW");
			try{
				logger.debug("addSubscription:"+DAOFactory.getDAOFactory().getgateway_subscriptionDAO().save(sub));
			}catch(Exception e){
				logger.error("Error adding subscription:"+e.getMessage());
				//TODO
			}
			
		}
		
	}

	@Override
	public void updateSubscription(String sub_Id, Long minInt, Long maxInt,PersistentSession s) throws Exception {
		logger.debug("updateSubscription:"+sub_Id );
		gateway_subscriptionCriteria dC= new gateway_subscriptionCriteria();
		dC.id.eq(sub_Id);
		gateway_subscription sub=DAOFactory.getDAOFactory().getgateway_subscriptionDAO().loadGateway_subscriptionByCriteria(dC);
		if(sub==null)
			throw new Exception(updateSubscription_01);
		else{
			sub.setId(sub_Id);
			sub.setMinInt(minInt);
			sub.setMaxInt(maxInt);
			try{
				logger.debug("updateSubscription:"+DAOFactory.getDAOFactory().getgateway_subscriptionDAO().save(sub));
			}catch(Exception e){
				logger.error("Error updating subscription:"+e.getMessage());
				//TODO
			}
		}
		
	}

	@Override
	public void updateSubscriptionState(String sub_Id,String state,PersistentSession s) throws Exception {
		logger.debug("updateSubscription:"+sub_Id );
			
		gateway_subscriptionCriteria dC= new gateway_subscriptionCriteria();
		dC.id.eq(sub_Id);
		gateway_subscription sub=DAOFactory.getDAOFactory().getgateway_subscriptionDAO().loadGateway_subscriptionByCriteria(dC);
		if(sub==null)
			throw new Exception(updateSubscription_01);
		else{
			sub.setId(sub_Id);
			sub.setState(state);
			try{
				logger.debug("updateSubscriptionState:"+DAOFactory.getDAOFactory().getgateway_subscriptionDAO().save(sub));
			}catch(Exception e){
				logger.error("Error updating subscription state:"+e.getMessage());
				//TODO
			}
		}
		
	}
	
	@Override
	public gateway_subscription getSubscription(String sub_Id,PersistentSession s) throws Exception {
		logger.debug("getSubscription:"+sub_Id );
		gateway_subscriptionCriteria dC= new gateway_subscriptionCriteria();
		dC.id.eq(sub_Id);
		return DAOFactory.getDAOFactory().getgateway_subscriptionDAO().loadGateway_subscriptionByCriteria(dC);	
	}

	@Override
	public void deleteSubscription(String sub_Id,PersistentSession s) throws Exception {
		logger.debug("deleteSubscription:"+sub_Id );
		gateway_subscriptionCriteria dC= new gateway_subscriptionCriteria();
		dC.id.eq(sub_Id);
		gateway_subscription sub=DAOFactory.getDAOFactory().getgateway_subscriptionDAO().loadGateway_subscriptionByCriteria(dC);
		if(sub==null)
			throw new Exception(deleteSubscription_01);
		else{
			try{
				logger.debug("deleteSubscription:"+DAOFactory.getDAOFactory().getgateway_subscriptionDAO().delete(sub));
			}catch(Exception e){
				logger.error("Error deleting subscription:"+e.getMessage());
				//TODO
			}
		}
		
	}

	
	//------------------------------

	@Override
	public void addVariableValue(String var_Id, String value, Long timestamp) throws Exception{

		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			addVariableValue(var_Id,value,timestamp,s);
						
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}	
	};
	
	@Override
	public void addVariableValue(String var_Id, String value, Long timestamp,PersistentSession s) throws Exception{
			logger.debug("addVariableValue: "+var_Id+" -> "+value);
			
			gateway_variable var = getVariable(var_Id, s);
			if(var==null){
				throw new Exception(addVariableValue_01);
			}
			
			gateway_value val= DAOFactory.getDAOFactory().getgateway_valueDAO().createGateway_value();
			val.setVariable(var);
			val.setValue(value);
			val.setTimestamp(timestamp);
			try{
				logger.debug("addVariableValue:"+DAOFactory.getDAOFactory().getgateway_valueDAO().save(val));
			}catch(Exception e){
				logger.error("Error adding Variable Value:"+e.getMessage());
				//TODO
			}
	};

	@Override
	public List<gateway_value> getVariableValues(String varId, Long fromDate, Long toDate) throws Exception{
		List<gateway_value> valueList = null;
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			valueList = new ArrayList<gateway_value>();
			gateway_variableCriteria vC= new gateway_variableCriteria();
			vC.id.eq(varId);
			gateway_variable var=DAOFactory.getDAOFactory().getgateway_variableDAO().loadGateway_variableByCriteria(vC);
			if(fromDate==null)
				fromDate=0l;
			if(toDate==null)
				toDate=System.currentTimeMillis();
			if(var==null)
				throw new Exception(getHistoricalData_01);
			else{
				try{
					gateway_valueCriteria gvC = new gateway_valueCriteria();
					gvC.timestamp.between(fromDate, toDate);
					for(gateway_value v:DAOFactory.getDAOFactory().getgateway_valueDAO().listGateway_valueByCriteria(gvC))
						valueList.add(v);
					logger.debug("getHistoricalData: OK");
					
				}catch(Exception e){
					logger.error("Error getting historical data:"+e.getMessage());
					//TODO
				}	
			}
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			s.getTransaction().rollback();
			s.close();
			throw e;
		}	
		return valueList;
	}
	
	
	
	
	
	
	
	/*@Override
	public List<gateway_variable> getSubscriptionVariables(String sub_Id)throws Exception {
		logger.debug("Getting SubscriptionVariables");
		List<gateway_variable> varList = null;
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			varList= new ArrayList<gateway_variable>();
			for(Object o :getSubscription(sub_Id, s).getVariables()){
				gateway_variable v=(gateway_variable)o;
				varList.add(v);
			}
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			logger.error("EXCEPTION Getting variables:"+e.getMessage());
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return varList;
	}

	@Override
	public List<gateway_variable> getSubscriptionVariables(String sub_Id,
			PersistentSession s) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<gateway_subscription> getVariableSubscriptions(String varId)
			throws Exception {
		logger.debug("Getting VariableSubscriptions");
		List<gateway_subscription> subList = null;
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			subList= new ArrayList<gateway_subscription>();
			for(Object o :getVariable(varId, s).getSubscriptions()){
				gateway_subscription v=(gateway_subscription)o;
				subList.add(v);
			}
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			logger.error("EXCEPTION Getting subscriptions:"+e.getMessage());
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return subList;
	}

	@Override
	public List<gateway_subscription> getVariableSubscriptions(String varId,
			PersistentSession s) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<gateway_configOption> getDeviceSettings(String devId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<gateway_configOption> getDeviceSettings(String devId,
			PersistentSession s) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}*/
	
	
	 
	 @Override
	public List<gateway_variable> getSubscriptionVariables(String sub_Id)throws Exception {
		logger.debug("Getting SubscriptionVariables for "+sub_Id);
		List<gateway_variable> varList = null;
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			varList=getSubscriptionVariables(sub_Id, s);
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			e.printStackTrace();
			logger.error("EXCEPTION Getting subscription variables:"+e.getMessage());
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return varList;
	}

	@Override
	public List<gateway_variable> getSubscriptionVariables(String sub_Id,PersistentSession s)throws Exception {
		List<gateway_variable> varList = new ArrayList<gateway_variable>();
		for(Object o :getSubscription(sub_Id, s).getVariables()){
			gateway_variable v=(gateway_variable)o;
			varList.add(v);
		}
		return varList;
	}
	
	@Override
	public List<gateway_subscription> getVariableSubscriptions(String varId) throws Exception {
		logger.debug("Getting VariableSubscriptions for "+varId);
		List<gateway_subscription> subList = null;
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			
			subList=getVariableSubscriptions(varId,s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			e.printStackTrace();
			logger.error("EXCEPTION Getting variable subscriptions:"+e.getMessage());
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return subList;
	}
	
	@Override
	public List<gateway_subscription> getVariableSubscriptions(String varId,PersistentSession s) throws Exception {
		List<gateway_subscription> subList = new ArrayList<gateway_subscription>();
		for(Object o :getVariable(varId, s).getSubscriptions()){
			gateway_subscription sb=(gateway_subscription)o;
			subList.add(sb);
		}
		
		return subList;
	}
	
	
	@Override
	public List<gateway_configOption> getDeviceSettings(String devId)throws Exception {
		
		logger.debug("Getting DeviceSettings for "+devId);
		List<gateway_configOption> setList = null;
		PersistentSession s=null;
		try{
			s=EHReqPersistentManager.instance().getSession();
			s.beginTransaction();
			setList=getDeviceSettings(devId,s);
			
			s.getTransaction().commit();
			s.close();
		}catch(Exception e){
			e.printStackTrace();
			logger.error("EXCEPTION Getting deviceSettings:"+e.getMessage());
			s.getTransaction().rollback();
			s.close();
			throw e;
		}
		return setList;
	}
	
	@Override
	public List<gateway_configOption> getDeviceSettings(String devId,PersistentSession s)throws Exception {
		
		/*List<gateway_configOption> setList = new ArrayList<gateway_configOption>();
		for(Object o :getDevice(devId, s).getSettings()){
			gateway_configOption co=(gateway_configOption)o;
			setList.add(co);
		}
		return setList;*/
		
		gateway_device d=getDevice(devId, s);
		List<gateway_configOption> setList = DAOFactory.getDAOFactory().getgateway_configOptionDAO().queryGateway_configOption("FK_GATEWAY_DEVICE="+d.getDbID(), "DBID");
		return setList;
	}
	 
	 
	 

}