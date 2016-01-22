package epichub.framework.gateway.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.openmuc.framework.config.ArgumentSyntaxException;
import org.openmuc.framework.config.ChannelConfig;
import org.openmuc.framework.config.ChannelScanInfo;
import org.openmuc.framework.config.ConfigService;
import org.openmuc.framework.config.ConfigWriteException;
import org.openmuc.framework.config.DeviceConfig;
import org.openmuc.framework.config.DeviceScanInfo;
import org.openmuc.framework.config.DriverConfig;
import org.openmuc.framework.config.DriverNotAvailableException;
import org.openmuc.framework.config.IdCollisionException;
import org.openmuc.framework.config.RootConfig;
import org.openmuc.framework.config.ScanException;
import org.openmuc.framework.config.ScanInterruptedException;
import org.openmuc.framework.data.BooleanValue;
import org.openmuc.framework.data.ByteValue;
import org.openmuc.framework.data.DoubleValue;
import org.openmuc.framework.data.Flag;
import org.openmuc.framework.data.FloatValue;
import org.openmuc.framework.data.IntValue;
import org.openmuc.framework.data.LongValue;
import org.openmuc.framework.data.Record;
import org.openmuc.framework.data.ShortValue;
import org.openmuc.framework.data.StringValue;
import org.openmuc.framework.data.Value;
import org.openmuc.framework.data.ValueType;
import org.openmuc.framework.dataaccess.Channel;
import org.openmuc.framework.dataaccess.ChannelState;
import org.openmuc.framework.dataaccess.DataAccessService;
import org.openmuc.framework.dataaccess.DeviceState;
import org.openmuc.framework.driver.spi.ConnectionException;
import org.openmuc.framework.driver.spi.DriverService;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thalesgroup.it.ns.model.alarm.AlarmStatus;

import epichub.framework.gateway.spi.DatabaseService;
import epichub.framework.gateway.interfaces.middleware.GatewayService;
import epichub.framework.gateway.spi.CoreService;
import epichub.framework.gateway.spi.DriverListeningService;
import epichub.framework.gateway.spi.SubscriberService;
import eu.epichub.gateway.eg.core.gateway_configOption;
import eu.epichub.gateway.eg.core.gateway_device;
import eu.epichub.gateway.eg.core.gateway_driver;
import eu.epichub.gateway.eg.core.gateway_host;
import eu.epichub.gateway.eg.core.gateway_subscription;
import eu.epichub.gateway.eg.core.gateway_variable;

public class CoreServiceImpl implements CoreService {

	// -----Exception messages ---
	private static final String DataAccess_NotReady = "DataAcess service is NOT set. Operation unavailable";
	private static final String Database_NotReady = "Database is NOT set. Operation unavailable";
	private static final String ConfigService_NotReady = "Config service is NOT set. Operation unavailable";
	private static final String SubscriptionService_NotReady = "Subscription service is NOT set. Operation unavailable";
	private static final String VariableId_Empty = "Variable Id can NOT be empty";
	private static final String VariabledId_notFoundInDDBB = "Variable NOT found (in DDBB)";
	private static final String Channel_notFound = "Channel NOT found (in gateway)";
	private static final String Device_connectionTimeout = "Connection timeout";
	private static final String Device_readTimeout = "Reading timeout";
	private static final String Device_writeTimeout = "Writing timeout";
	private static final String Device_connectionException = "Connection exception";
	private static final String Subscription_alreadyLoaded = "Subscription already loaded";
	private static final String Subscription_noVariables = "Subscription does NOT have any variable";
	private static final String Subscription_isNotLoaded = "Subscription NOT loaded";
	private static final String SubscriptionId_Empty = "Subscription Id can NOT be empty";
	private static final String SubscriptionId_notFoundInDDBB = "Subscription NOT found (in DDBB)";
	static final String Subscription_timeout = "Subscription timeout";

	private static final String toOpenMUC_Format = "Exception formating value";
	private static final String DeviceStateUpdate_notValidState = "Invalid device state";
	private static final String DeviceStateUpdate_noDeviceFound = "No device ID not found in database";
	private static final String DeviceStateUpdate_sameDeviceState = "Device already in that state";

	private final static Logger log = LoggerFactory.getLogger(CoreServiceImpl.class);
	private final int disabled_openMUC_sampling = -1;

	private static DataAccessService dataAccess = null;
	private static ConfigService configService = null;
	private static DatabaseService database = null;
	private static SubscriberService subsService = null;
	private static CoreService coreService = null;
	private static GatewayService publishService = null;

	private RootConfig rootConfig;
	private WaitThread driverWaitThread;

	private static final String driverState_ENABLED = "ENABLED";
	private static final String driverState_DISABLED = "DISABLED";
	private static final String driverState_WAITING = "WAITING";

	private HashMap<String, String> driverStatusMap = new HashMap<String, String>();
	private HashMap<String, String> deviceAlarms = new HashMap<String, String>();
	private HashMap<String, List<String>> varSubs = new HashMap<String, List<String>>();

	/**
	 * Usado para realizar lecturas "síncronas". Intervalo de comprobación del
	 * FLAG
	 */
	static Integer flagCheckRetryInterval;
	/**
	 * Usado para realizar lecturas "síncronas". Tiempo de espera antes de dar
	 * por fallida una lectura
	 */
	static Integer connectTimeout;
	/**
	 * Al perder la conexión a un dispositivo, tiempo de espera antes de tratar
	 * de reconectar
	 */
	private static Integer connectRetryInterval;
	/** Tiempo de espera para permitir que los drivers se carguen */
	private static Integer driverLoadTimeout;

	// ----CONSTRUCTOR----------
	public CoreServiceImpl() {
		coreService = this;
		try {
			connectTimeout = Integer.parseInt(System.getProperty("epichub.connect_timeout"));
			log.debug("Using [epichub.connect_timeout] property: "+ connectTimeout + " ms");
		} catch (Exception e) {
			log.debug("Error reading [epichub.connect_timeout] property. Using default: 3000 ms");
			connectTimeout = 3000;
		}

		try {
			flagCheckRetryInterval = Integer.parseInt(System.getProperty("epichub.status_check_retry_interval"));
			log.debug("Using [epichub.status_check_retry_interval] property: "+ flagCheckRetryInterval + " ms");
		} catch (Exception e) {
			log.debug("Error reading [epichub.status_check_retry_interval] property. Using default: 100 ms");
			flagCheckRetryInterval = 100;
		}

		try {
			driverLoadTimeout = Integer.parseInt(System.getProperty("epichub.driver_load_timeout"));
			log.debug("Using [epichub.driver_load_timeout] property: "+ driverLoadTimeout + " ms");
		} catch (Exception e) {
			log.debug("Error reading [epichub.driver_load_timeout] property. Using default: 10000 ms");
			driverLoadTimeout = 10000;
		}

		// TODO cargar a partit de config_options
		try {
			connectRetryInterval = Integer.parseInt(System.getProperty("epichub.connect_retry_interval"));
			log.debug("Using [epichub.connect_retry_interval] property: "+ connectRetryInterval + " ms");
		} catch (Exception e) {
			log.debug("Error reading [epichub.connect_retry_interval] property. Using default: 60000 ms");
			connectRetryInterval = 60000;
		}

		driverWaitThread = new WaitThread();
	}

	// ----Setter/Unsetters---------
	protected void activate(ComponentContext context) {
		log.debug("Activate CoreServiceImpl");
		try {
			/* TestHostConfig("urn:rixf:eu.epichub/consumer/gateway"); */
		} catch (Exception e) {
			log.error("activate_Exception");
		}
	}

	protected void deactivate(ComponentContext context) {
		log.debug("Dectivate CoreServiceImpl");
	}

	// DDBB
	protected void setDatabaseService(DatabaseService dbs) {
		log.debug("setting Database");
		database = dbs;
		LoadDriversFromDB();
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

	// --Data Access
	protected void setDataAccessService(DataAccessService dataAccessService) {
		dataAccess = dataAccessService;
	}

	protected void unsetDataAccessService(DataAccessService dataAccessService) {
		dataAccess = null;
	}

	static DataAccessService getDataAccess() {
		if (dataAccess == null) {
			throw new NullPointerException();
		}
		return dataAccess;
	}

	// --Config
	protected void setConfigService(ConfigService cs) {
		configService = cs;
	}

	protected void unsetConfigService(ConfigService cs) {
		configService = null;
	}

	static ConfigService getConfig() {
		if (configService == null) {
			throw new NullPointerException();
		}
		return configService;
	}

	// Subscriber
	protected void setSubscriberService(SubscriberService dbs) {
		log.debug("setting SubscriberService");
		subsService = dbs;
	}

	protected void unsetSubscriberService(SubscriberService dbs) {
		log.debug("unsetting SubscriberService");
		subsService = null;
	}

	// Publish Service
	protected void setPublishService(GatewayService dbs) {
		log.debug("setting PublishService");
		publishService = dbs;
	}

	protected void unsetPublishService(GatewayService dbs) {
		log.debug("unsetting PublishService");
		publishService = null;
	}

	static GatewayService getPublishService() {
		return publishService;
	}

	static gateway_host TestHostConfig() {
		return coreService.TestHostConfig("urn:rixf:eu.epichub/consumer/gateway");
	}

	// --Drivers
	protected void setDriverService(DriverService dls) {
		log.debug("setDriverService:"+dls.getInfo().getId());
		if (driverStatusMap.containsKey(dls.getInfo().getId()) || driverWaitThread.isAlive())
		{	driverStatusMap.put(dls.getInfo().getId(), driverState_ENABLED);}
		else
		{	driverStatusMap.put(dls.getInfo().getId(), driverState_WAITING);}
	
		checkLoadSubscriptions();

	}

	protected void unsetDriverService(DriverService dls) {
		log.debug("unsetDriverService:"+dls.getInfo().getId());
		if (driverStatusMap.containsKey(dls.getInfo().getId())) {
			driverStatusMap.put(dls.getInfo().getId(), driverState_DISABLED);
		}
	}

	// --------------------------------------

	private void LoadDriversFromDB() {
		if (database != null)
			try {
				List<gateway_driver> driverList = database.getAllDrivers();
				log.debug("Loading Drivers from DB. Num Drivers:"+ driverList.size());
					
				for (String dId : driverStatusMap.keySet()) {
					log.debug(dId+": "+driverStatusMap.get(dId));
				}
				for (gateway_driver driv : driverList) {
					if (driverStatusMap.containsKey(driv.getId()))
						driverStatusMap.put(driv.getId(), driverState_ENABLED);
					else
						driverStatusMap.put(driv.getId(), driverState_WAITING);
				}

				driverWaitThread.start();
				checkLoadSubscriptions();

			} catch (Exception e) {
				log.error("Exception loading all drivers:" + e.getMessage());
			}
	}

	private boolean ready=false;
	private void checkLoadSubscriptions() {
		boolean allConected = true;
		for (String dId : driverStatusMap.keySet()) {
			allConected &= driverStatusMap.get(dId).equals(driverState_ENABLED);
		}
		if (allConected&&!ready) {
			ready=true;
			driverWaitThread.interrupt();
		}
	}

	private void LoadSubscriptionsFromDB() {
		if (database != null)
			try {
				log.debug("Loading DB subscription from DB");
				List<gateway_subscription> subscriptionList = database.getAllSubscriptions();
						
				for (gateway_subscription sub : subscriptionList) {
					try {
						// Cargará unicamente aquellas subscripciones que
						// estaban cargadas correctamente
						if (!sub.getState().equals(States.STOPPED.name()))
							subscribe(sub.getId());
						else
							log.info("Subscription:" + sub.getId()
									+ " state is " + sub.getState());
					} catch (Exception e) {
						// TODO SI FALLA LA SUBSCRIPCION A UNA DE LAS VARIABLES:
						// -FALLA LA SUBSCRIPCION-->SE BORRAN TODAS
						// -FALLA LA VARIABLE --> SE MANTIENEN EL RESTO
						log.error("Exception adding subscription:"
								+ sub.getId() + ":" + e.getMessage());
					}
				}

			} catch (Exception e) {
				log.error("Exception loading all subscription:"
						+ e.getMessage());
			}
	}

	/**
	 * Devuelve el objeto gateway_host tras testear: -Drivers disponibles
	 * -Variables y Dispositivos disponibles.
	 * 
	 * Cambiará los estados de cada elemento seún su disponibilidad
	 */
	@Override
	public gateway_host TestHostConfig(String hostId) {
		if (database != null)
			try {
				gateway_host hostConfig = database.getHost(hostId);

				// Abrir todos los canales
				for (Object o : hostConfig.getDrivers()) {
					gateway_driver driver = (gateway_driver) o;
					for (Object o2 : driver.getDevices()) {
						gateway_device device = (gateway_device) o2;
						for (Object o3 : device.getVariables()) {
							gateway_variable variable = (gateway_variable) o3;
							getOrAddChannel(variable);

						}
					}
				}

				// Testear
				for (Object o : hostConfig.getDrivers()) {
					gateway_driver driver = (gateway_driver) o;
					driver.setState(States.AVAILABLE.name());

					for (Object o2 : driver.getDevices()) {
						gateway_device device = (gateway_device) o2;
						device.setState(States.AVAILABLE.name());
						for (Object o3 : device.getVariables()) {
							gateway_variable variable = (gateway_variable) o3;
							variable.setState(States.AVAILABLE.name());
							try {
								Record r = readSingleChannel(
										dataAccess.getChannel("channel_"+ variable.getDbID()),connectTimeout);
								log.debug(variable.getId() + ":" + r.getFlag());
								if (r.getFlag().equals(Flag.DRIVER_UNAVAILABLE)) {
									driver.setState(r.getFlag().name());
									device.setState(States.NOT_AVAILABLE.name());
									variable.setState(States.NOT_AVAILABLE.name());
								}
								if (r.getFlag().equals(
										Flag.COMM_DEVICE_NOT_CONNECTED)
										|| r.getFlag().equals(Flag.TIMEOUT)
										|| r.getFlag().equals(Flag.CONNECTION_EXCEPTION)) {					
									device.setState(States.NOT_AVAILABLE.name());
									variable.setState(States.NOT_AVAILABLE.name());
								}
								if (r.getFlag().equals(Flag.DRIVER_THREW_UNKNOWN_EXCEPTION))
									variable.setState(States.NOT_AVAILABLE.name());
											
								database.updateVariableState(variable.getId(),variable.getState());
										
							} catch (Exception e) {
								log.error("ERROR TESTING [" + variable.getId()	+ "]:" + e.getMessage());
									
							}
						}
						// database.updateDeviceState(device.getId(),device.getState());
					}
					// database.updateDriverState(driver.getId(),driver.getState());
				}

				// Cerrar en los necesarios
				for (Object o : hostConfig.getDrivers()) {
					gateway_driver driver = (gateway_driver) o;
					for (Object o2 : driver.getDevices()) {
						gateway_device device = (gateway_device) o2;
						for (Object o3 : device.getVariables()) {
							gateway_variable variable = (gateway_variable) o3;
							try {
								removeChannel(variable, true);
										
												
							} catch (Exception e) {
								log.error("ERROR CLOSING [" + variable.getId()	+ "]:" + e.getMessage());
									
							}
						}
					}
				}

			} catch (Exception e) {
				log.error("Exception loading host configuration:"+ e.getMessage());
						
			}
		try {
			return database.getHost(hostId);
		} catch (Exception e) {
			return null;
		}
	}

	// ---------------
	/**
	 * Given a identifier, retrieves information about a channel, and then reads
	 * it's actual value
	 */
	@Override
	public Record readData(String varId, int timeout) throws Exception {
		log.debug("readData");
		if (dataAccess == null)
			throw new Exception(DataAccess_NotReady);
		if (configService == null)
			throw new Exception(ConfigService_NotReady);
		if (varId.isEmpty())
			throw new Exception(VariableId_Empty);
		if (database == null)
			throw new Exception(Database_NotReady);

		// Get variable info from DDBB
		gateway_variable v = (gateway_variable) database.getVariable(varId);
		if (v == null)
			throw new Exception(VariabledId_notFoundInDDBB);

		// gets the channel in openMUC, and creates it if i doesn't exist
		getOrAddChannel(v);
		Channel c = dataAccess.getChannel("channel_" + v.getDbID());

		try {
			Record ret = readSingleChannel(c, timeout);
			if(v.getState()!=States.AVAILABLE.name())
				database.updateVariableState(varId,States.AVAILABLE.name());
			removeChannel(v, true);
			return ret;

		} catch (Exception e) {
			if(v.getState()!=States.NOT_AVAILABLE.name())
				database.updateVariableState(varId,States.NOT_AVAILABLE.name());
			removeChannel(v, true);
			throw e;
		}
	}

	/**
	 * Given a identifier, retrieves information about a channel, and then
	 * writes a given value into it
	 */
	@Override
	public void writeData(String varId, Object value, int timeout)
			throws Exception {

		log.debug("writeData");
		if (dataAccess == null)
			throw new Exception(DataAccess_NotReady);
		if (configService == null)
			throw new Exception(ConfigService_NotReady);
		if (varId.isEmpty())
			throw new Exception(VariableId_Empty);

		// Get variable info from DDBB
		gateway_variable v = (gateway_variable) database.getVariable(varId);
		if (v == null)
			throw new Exception(VariabledId_notFoundInDDBB);

		// gets the channel in openMUC, and creates it if i doesn't exist
		getOrAddChannel(v);
		Channel c = dataAccess.getChannel("channel_" + v.getDbID());
		readSingleChannel(c, connectTimeout); // ESPERA A QUE SEA LEGIBLE

		
		
		try {
			
			//log.debug("writeData before writeSingleChannel value " + value);
			
			Flag f = writeSingleChannel(c, value, timeout);
			removeChannel(v, true);
			if(v.getState()!=States.AVAILABLE.name())
				database.updateVariableState(varId,States.AVAILABLE.name());
		} catch (Exception e) {
			log.error("writeData Exception " + e.getMessage());
			if(v.getState()!=States.NOT_AVAILABLE.name())
				database.updateVariableState(varId,States.NOT_AVAILABLE.name());
			removeChannel(v, true);
			throw e;
		}
	}

	/**
	 * Retrieves from DDBB a variable's historical data between two dates
	 */
	@Override
	public Object readHistoricData(String varId, long from, long to)throws Exception {
		log.debug("readHistoricData");
		if (varId.isEmpty())
			throw new Exception(VariableId_Empty);

		// Get variable info from DDBB
		gateway_variable v = (gateway_variable) database.getVariable(varId);
		if (v == null)
			throw new Exception(VariabledId_notFoundInDDBB);

		return database.getVariableValues(varId, from, to);
	}

	@Override
	public String subscribe(String subId) throws Exception {
		log.debug("subscribing to: " + subId);
		if (dataAccess == null)
			throw new Exception(DataAccess_NotReady);
		if (configService == null)
			throw new Exception(ConfigService_NotReady);
		if (subsService == null)
			throw new Exception(SubscriptionService_NotReady);
		if (subId.isEmpty())
			throw new Exception(SubscriptionId_Empty);
		if (database == null)
			throw new Exception(Database_NotReady);

		gateway_subscription s = database.getSubscription(subId);
		if (s == null)
			throw new Exception(SubscriptionId_notFoundInDDBB);

		// // 16/05/2015 Si la subscripción está cargada, se recargará.
		// if (subsService.isSubscriptionLoaded(subId))
		// throw new Exception(Subscription_alreadyLoaded);

		List<gateway_variable> varList = database.getSubscriptionVariables(s.getId());
		if (varList == null || varList.size() == 0) {
			throw new Exception(Subscription_noVariables);
		}

		// Check channel status
		HashMap<String, gateway_variable> channelMap = new HashMap<String, gateway_variable>();
		List<gateway_variable> OkList = new ArrayList<gateway_variable>();
		// List<gateway_variable> ErrorList= new ArrayList<gateway_variable>();

		getOrAddChannels(varList);
		for (gateway_variable v : varList) {
			Channel c = dataAccess.getChannel("channel_" + v.getDbID());
			channelMap.put(c.getId(), v);
		};

		Collection<Callable<Channel>> tasks = new ArrayList<Callable<Channel>>();
		for (String id : channelMap.keySet()) {
			tasks.add(new ReadTaskWithChannel(dataAccess.getChannel(id),connectTimeout));
		}

		ExecutorService executor = Executors.newFixedThreadPool(channelMap.size());
		List<Future<Channel>> results = executor.invokeAll(tasks);
		for (Future<Channel> result : results) {
			try {
				OkList.add(channelMap.get(result.get().getId()));
			} catch (Exception e) {
				log.error("Exception reading:" + e.getMessage());
			}
		}
		executor.shutdown(); // always reclaim resources*/

		for (String id : channelMap.keySet()) {
			if (OkList.contains(channelMap.get(id))) {
				database.updateVariableState(channelMap.get(id).getId(),States.AVAILABLE.name());
				addSubVar(channelMap.get(id).getId(), subId);
				//Channel c = dataAccess.getChannel(id);
				//boolean listen = channelMap.get(id).getDevice().getDriver().getSubscriptions();
				//int minI = (int) s.getMinInt();
				//setSubscription(c, minI, listen);
			} else {
				database.updateVariableState(channelMap.get(id).getId(),States.NOT_AVAILABLE.name());
				removeSubVar(channelMap.get(id).getId(), subId);
				if (!hasSubVar(channelMap.get(id).getId())) {
					Channel c = dataAccess.getChannel(id);
					//unsetSubscription(c);
					removeChannel(channelMap.get(id), true);
				}
			}
		}

		String status;
		if (OkList.size() > 0) {
			subsService.loadSubscription(s, OkList);
			if (channelMap.size() > OkList.size())
				status = States.PARTIAL.name();
			else
				status = States.STARTED.name();
		} else
			status = States.ERROR.name();

		log.debug("Updating subscription state in DDBB to " + status);
		database.updateSubscriptionState(subId, status);
		return status;
	}

	@Override
	public void unsubscribe(String subId) throws Exception {
		log.debug("unsubscribe");
		if (dataAccess == null)
			throw new Exception(DataAccess_NotReady);
		if (configService == null)
			throw new Exception(ConfigService_NotReady);
		if (subId.isEmpty())
			throw new Exception(SubscriptionId_Empty);

		gateway_subscription s = database.getSubscription(subId);
		if (s == null)
			throw new Exception(SubscriptionId_notFoundInDDBB);

		if (subsService.isSubscriptionLoaded(subId)) {
			log.debug("Updating openMUC configuration");
			for (gateway_variable v : database.getSubscriptionVariables(s.getId())) {
				removeSubVar(v.getId(), subId);
				if (!hasSubVar(v.getId())) {
					Channel c = dataAccess.getChannel("channel_" + v.getDbID());
					if (c != null) {
						//unsetSubscription(c);
						removeChannel(v, false);
					}
				}
			}

			log.debug("Removing subscription from SubscriptionService");
			subsService.unloadSubscription(subId);
		}

		log.debug("Updating subscription state in DDBB to STOPPED");
		database.updateSubscriptionState(subId, States.STOPPED.name());
	}

	/*
	 * @Override public List<gateway_subscription> getSubscriptions() throws
	 * Exception{ return database.getAllSubscriptions(); }
	 */

	// ---Private functions-----------------------

	private String createSettingString(List<gateway_configOption> list) {
		String str = "";
		if (list != null) {
			for (gateway_configOption setting : list) {
				str += setting.getParameter() + "=" + setting.getValue() + ";";
			}
			if (str.length() > 0)
				str = str.substring(0, str.length() - 1);
		}
		log.debug("Settings:" + str);
		return str;
	}

	/**
	 * Adds a channel to openmuc. It will also add driver and device if
	 * necessary
	 * 
	 * @throws IdCollisionException
	 */
	private void getOrAddChannel(gateway_variable v)throws IdCollisionException {
		log.debug("addChannel:" + v.getDbID());
		// Channel c = dataAccess.getChannel(v.getId());
		Channel c = dataAccess.getChannel("channel_" + v.getDbID());
		if (c != null)
			return;
		else {
			rootConfig = configService.getConfig();
			DriverConfig dc = rootConfig.getOrAddDriver(v.getDevice().getDriver().getId());
			DeviceConfig dev = dc.getDevice("device_" + v.getDevice().getDbID());
			dc.setConnectRetryInterval(connectRetryInterval);

			if (dev == null) {
				dev = dc.addDevice("device_" + v.getDevice().getDbID());//
				dev.setDeviceAddress(v.getDevice().getDeviceAddress());
				dev.setInterfaceAddress(v.getDevice().getInterfaceAddress());

				try {
					List<gateway_configOption> settings;
					settings = database.getDeviceSettings(v.getDevice().getId());
					dev.setSettings(createSettingString(settings));
				} catch (Exception e) {
					log.error("Exception loading device settings:"+ e.getMessage());
				}
			}

			ChannelConfig chn = dev.getChannel("channel_" + v.getDbID());
			if (chn == null) {
				chn = dev.addChannel("channel_" + v.getDbID());
				chn.setDescription(v.getDescription());
				chn.setValueType(ValueType.valueOf(v.getDigType()));
				chn.setUnit(v.getUnit());
				chn.setChannelAddress(v.getPath());
			}
			configService.setConfig(rootConfig);
			return;
		}
	}

	private void getOrAddChannels(List<gateway_variable> varList)throws IdCollisionException {
		
		rootConfig = configService.getConfig();

		for (gateway_variable v : varList) {
			log.debug("addChannel:" + v.getDbID());
			// Channel c = dataAccess.getChannel(v.getId());
			Channel c = dataAccess.getChannel("channel_" + v.getDbID());
			if (c == null) {
				DriverConfig dc = rootConfig.getOrAddDriver(v.getDevice().getDriver().getId());
				DeviceConfig dev = dc.getDevice("device_"+ v.getDevice().getDbID());
				dc.setConnectRetryInterval(connectRetryInterval);

				if (dev == null) {
					dev = dc.addDevice("device_" + v.getDevice().getDbID());//
					dev.setDeviceAddress(v.getDevice().getDeviceAddress());
					dev.setInterfaceAddress(v.getDevice().getInterfaceAddress());

					try {
						List<gateway_configOption> settings;
						settings = database.getDeviceSettings(v.getDevice()	.getId());
						dev.setSettings(createSettingString(settings));
					} catch (Exception e) {
						log.error("Exception loading device settings:"+ e.getMessage());
					}
				}

				ChannelConfig chn = dev.getChannel("channel_" + v.getDbID());
				if (chn == null) {
					chn = dev.addChannel("channel_" + v.getDbID());
					chn.setDescription(v.getDescription());
					chn.setValueType(ValueType.valueOf(v.getDigType()));
					chn.setUnit(v.getUnit());
					chn.setChannelAddress(v.getPath());
					//chn.setSamplingInterval((int)v.getSamplingInterval());
				}
			}
		}
		configService.setConfig(rootConfig);
	}

	/**
	 * Removes a channel to openmuc. It will also remove driver and device if
	 * they don't have dependencies
	 */
	private void removeChannel(gateway_variable v, boolean check) {
		log.debug("removeChannel:" + v.getId());
		rootConfig = configService.getConfig();
		DriverConfig dc = rootConfig.getDriver(v.getDevice().getDriver().getId());
		DeviceConfig dev = dc.getDevice("device_"+ v.getDevice().getDbID());
		ChannelConfig chn = dev.getChannel("channel_" + v.getDbID());
		if (check) {
			List<gateway_subscription> sList=null;
			try {
				sList=database.getVariableSubscriptions(v.getId());
				if (sList != null && sList.size()==0) {
					chn.delete();
					log.debug("Channel " + v.getId() + " removed");
				}	
			} catch (Exception e) {
				log.error("removeChannel Exception:"+e.getMessage());// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
			/*if (chn.isListening() != null && chn.isListening()) {
			} else if (chn.getSamplingInterval() != null
					&& chn.getSamplingInterval() > 0) {
			} else {
				chn.delete();
				log.debug("Channel " + c.getId() + " removed");
			}*/
			
			
		} else {
			chn.delete();
			log.debug("Channel " + v.getId() + " removed");
		}
		if (dev.getChannels().size() == 0) {
			log.debug("Removing device " + dev.getId());
			dev.delete();
		}
		if (dc.getDevices().size() == 0) {
			log.debug("Removing driver " + dc.getId());
			dc.delete();
		}

		configService.setConfig(rootConfig);
	}

	/**
	 * Reads a single openMUC channel. Can be used to check channel, device and
	 * driver status
	 * 
	 * @throws Exception
	 */
	private Record readSingleChannel(Channel c, long timeout) throws Exception {
		log.debug("readSingleChannel[" + c.getId() + "," + timeout + "]");
		/*
		 * Random rand = new Random(); int randomNum = rand.nextInt((10000 -
		 * 1000) + 1) + 1000; log.debug(c.getId() +" sleeping for "+randomNum);
		 * Thread.sleep(randomNum);
		 */

		if (c.getChannelState().equals(ChannelState.DRIVER_UNAVAILABLE))
			throw new Exception(Flag.DRIVER_UNAVAILABLE.name());

		Record r = c.read();
		int time = 0;
		while (time < timeout) {
			log.debug(c.getId() + " -->" + r.getFlag());
			if (r.getFlag().equals(Flag.VALID))
				return r;
			if (r.getFlag().name().contains("DRIVER_ERROR"))
				throw new Exception(r.getFlag().name());
			if (r.getFlag().equals(Flag.DRIVER_THREW_UNKNOWN_EXCEPTION))
				throw new Exception(Flag.DRIVER_THREW_UNKNOWN_EXCEPTION.name());
			if (r.getFlag().equals(Flag.TIMEOUT))
				throw new Exception(Flag.TIMEOUT.name());
			try {
				Thread.sleep(flagCheckRetryInterval);
				time += flagCheckRetryInterval;
			} catch (InterruptedException e) {
				// e.printStackTrace();
			}
			r = c.read();
		}
		// Operation timed out
		log.error(Device_readTimeout);
		throw new Exception(Device_readTimeout + ". " + r.getFlag().name());
	}

	private Record getSingleChannel(Channel c, long timeout) throws Exception {
		log.debug("readSingleChannel[" + c.getId() + "," + timeout + "]");
		/*
		 * Random rand = new Random(); int randomNum = rand.nextInt((10000 -
		 * 1000) + 1) + 1000; log.debug(c.getId() +" sleeping for "+randomNum);
		 * Thread.sleep(randomNum);
		 */

		if (c.getChannelState().equals(ChannelState.DRIVER_UNAVAILABLE))
			throw new Exception(Flag.DRIVER_UNAVAILABLE.name());

		Record r = c.read();//.getLatestRecord();
		
		int time = 0;
		while (time < timeout) {
			log.debug(c.getId() + " -->" + r.getFlag());
			if (r.getFlag().equals(Flag.VALID))
				return r;
			if (r.getFlag().name().contains("DRIVER_ERROR"))
				throw new Exception(r.getFlag().name());
			if (r.getFlag().equals(Flag.DRIVER_THREW_UNKNOWN_EXCEPTION))
				throw new Exception(Flag.DRIVER_THREW_UNKNOWN_EXCEPTION.name());
			if (r.getFlag().equals(Flag.TIMEOUT))
				throw new Exception(Flag.TIMEOUT.name());
			try {
				Thread.sleep(flagCheckRetryInterval);
				time += flagCheckRetryInterval;
			} catch (InterruptedException e) {
				// e.printStackTrace();
			}
			r = c.read();
		}
		// Operation timed out
		log.error(Device_readTimeout);
		throw new Exception(Device_readTimeout + ". " + r.getFlag().name());
	}
	
	/**
	 * Writes a value in a single openMUC channel.
	 * 
	 * @throws Exception
	 */
	private Flag writeSingleChannel(Channel c, Object v, int timeout)
			throws Exception {
		log.debug("writeSingleChannel[ " + v + " , " + timeout + "]");

		if (c.getChannelState().equals(ChannelState.DRIVER_UNAVAILABLE))
			throw new Exception(Flag.DRIVER_UNAVAILABLE.name());

		Flag f = c.write(toOpenMUC(c, v.toString()));
		
		int time = 0;
		while (time < timeout) {
			if (f.equals(Flag.VALID))
				return f;
			if (f.name().contains("DRIVER_ERROR"))
				throw new Exception(f.name());
			if (f.equals(Flag.DRIVER_THREW_UNKNOWN_EXCEPTION))
				throw new Exception(Flag.DRIVER_THREW_UNKNOWN_EXCEPTION.name());
			if (f.equals(Flag.TIMEOUT))
				throw new Exception(Flag.TIMEOUT.name());
			try {
				Thread.sleep(flagCheckRetryInterval);
				time += flagCheckRetryInterval;
			} catch (InterruptedException e) {
				 //e.printStackTrace();
				 log.error("writeSingleChannel exception " +e.getMessage());
			}
			f = c.read().getFlag();
		}

		log.error(Device_writeTimeout);
		throw new Exception(Device_writeTimeout + ". " + f.name());
	}

	/**
	 * Depending the channel capabilities, starts listening to changes or
	 * establishes a sampling interval (in ms). If it already is subscribed, the
	 * lowest sampling interval will be applied between the actual and the new
	 * subscription
	 * 
	 * @throws IdCollisionException
	 */
	private void setSubscription(Channel c, Integer interval, boolean canListen)throws Exception {
		log.debug("setSubscription:" + c.getId());
		rootConfig = configService.getConfig();
		DriverConfig dc = rootConfig.getDriver(c.getDriverName());
		DeviceConfig dev = dc.getDevice(c.getDeviceName());
		ChannelConfig chn = dev.getChannel(c.getId());
		if (canListen) {
			chn.setListening(true);
		} else {
			if (chn.getSamplingInterval() == null|| chn.getSamplingInterval().equals(disabled_openMUC_sampling))
				chn.setSamplingInterval(interval);
			else if (interval < chn.getSamplingInterval())
				chn.setSamplingInterval(interval);
		}
		configService.setConfig(rootConfig);
	}

	/**
	 * Deletes subscription (listening and sampling) from openMUC configuration
	 */
	private void unsetSubscription(Channel c) {
		log.debug("unsetSubscription:" + c.getId());
		rootConfig = configService.getConfig();
		DriverConfig dc = rootConfig.getDriver(c.getDriverName());
		DeviceConfig dev = dc.getDevice(c.getDeviceName());
		ChannelConfig chn = dev.getChannel(c.getId());
		chn.setSamplingInterval(disabled_openMUC_sampling);
		chn.setListening(false);

		// TODO avisar a drivers
		/*
		 * ArrayList<String> l = new ArrayList<String>();
		 * l.add(chn.getChannelAddress());
		 * drivers.get(dc.getId()).stopListening(
		 * dev.getInterfaceAddress(),dev.getDeviceAddress(), l);
		 */
		configService.setConfig(rootConfig);
	}

	// -----------------------------------------------------
	private Value toOpenMUC(Channel c, String v) throws Exception {
		/*
		 * log.debug("formatting "+v+" to "+c.getValueType()); try{ Value
		 * newValue; switch (c.getValueType()) { case BOOLEAN:{ boolean b
		 * =Boolean.valueOf(v); newValue = new BooleanValue(b);} case BYTE:{
		 * newValue = new ByteValue(Byte.valueOf(v));} case STRING:{ newValue =
		 * new StringValue(v);} case DOUBLE:{ double d =Double.valueOf(v);
		 * newValue = new DoubleValue(d);} case INTEGER:{ int i
		 * =Integer.valueOf(v); newValue = new IntValue(i);} case FLOAT:{
		 * newValue = new FloatValue(Float.valueOf(v));} case LONG:{ newValue =
		 * new LongValue(Long.valueOf(v));} case SHORT:{ newValue = new
		 * ShortValue(Short.valueOf(v));} default:{ newValue = new
		 * DoubleValue(Double.valueOf(v));} } return newValue;
		 * 
		 * }catch(Exception e){ log.error(toOpenMUC_Format+": "+v +" to "+
		 * c.getValueType()); e.printStackTrace(); throw e; }
		 */
		return new StringValue(v);
	}

	/*
	 * @Override public void addDevice(String device_Id, String driver_Id,
	 * String description, String capabilities, String deviceAddress, String
	 * interfaceAddress, String type) throws Exception { // TODO Auto-generated
	 * method stub
	 * 
	 * }
	 * 
	 * @Override public void updateDevice(String device_Id, String description,
	 * String capabilities, String deviceAddress, String interfaceAddress,
	 * String type) throws Exception { // TODO Auto-generated method stub
	 * 
	 * }
	 */

	@Override
	public void updateDeviceState(String subscriberId, String device_Id, String state)throws Exception {
			
		if(database==null){
			throw new Exception(Database_NotReady);
		}
		// check valid state
		if (!(state.equals(States.ERROR.name()) || state.equals(States.AVAILABLE.name())))
			throw new Exception(DeviceStateUpdate_notValidState + ": " + state);
		
		gateway_device dev = database.getDevice(device_Id);
		
		if (dev == null)
			throw new Exception(DeviceStateUpdate_noDeviceFound + ": "	+ device_Id);
		
		if (dev.getState().equals(state))
			throw new Exception(DeviceStateUpdate_sameDeviceState);

		// change in database
		database.updateDeviceState(device_Id, state);

		try {
			// publish change
			publishService.publish_DeviceStateUpdate(subscriberId, device_Id, state);

			if (state.equals(States.ERROR.name())) {
				String alarmId = publishService
						.publish_AlarmDefinition(
								subscriberId, 
								device_Id,
								"CRITICAL",
								"urn:rixf:eu.epichub/alarms/types/disconnected_sensor",
								AlarmStatus.ALARM_OPEN.name(),
								"PPW energy data collection sensor disconnected from network");
				deviceAlarms.put(device_Id, alarmId);
			} else { // States.AVAILABLE.name()
				publishService
						.publish_AlarmUpdate(
								subscriberId, 
								deviceAlarms.get(device_Id),
								device_Id, AlarmStatus.ALARM_CLOSED.name(),
								"PPW energy data collection sensor now reconnected to the network and working");
				deviceAlarms.remove(device_Id);
			}
		} catch (Exception e) {
			log.error("Exception publishing. Changes will persist in database");
			log.error(e.getMessage());
		}
	}

	@Override
	public void updateDeviceState(String subscriberId, List<String> device_Ids, String state)
			throws Exception {
		if(database==null){
			throw new Exception(Database_NotReady);
		}
		// check valid state
		if (!(state.equals(States.ERROR.name()) || state
				.equals(States.AVAILABLE.name())))
			throw new Exception(DeviceStateUpdate_notValidState + ": " + state);

		List<String> filterIds = new ArrayList<String>();
		for (String device_Id : device_Ids) {
			gateway_device dev = database.getDevice(device_Id);
			if (dev == null)
				throw new Exception(DeviceStateUpdate_noDeviceFound + ": "
						+ device_Id);
			if (!dev.getState().equals(state)) {
				filterIds.add(device_Id);
				database.updateDeviceState(device_Id, state);
			}
		}

		try {
			// publish change
			publishService.publish_DeviceStateUpdate(subscriberId, filterIds, state);

			for (String device_Id : filterIds) {
				if (state.equals(States.ERROR.name())) {
					String alarmId = publishService
							.publish_AlarmDefinition(
									subscriberId, 
									device_Id,
									"CRITICAL",
									"urn:rixf:eu.epichub/alarms/types/disconnected_sensor",
									AlarmStatus.ALARM_OPEN.name(),
									"PPW energy data collection sensor disconnected from network");
					deviceAlarms.put(device_Id, alarmId);
				} else { // States.AVAILABLE.name()
					publishService
							.publish_AlarmUpdate(subscriberId, deviceAlarms.get(device_Id),
									device_Id, AlarmStatus.ALARM_CLOSED.name(),
									"PPW energy data collection sensor now reconnected to the network and working");
					deviceAlarms.remove(device_Id);
				}
			}
		} catch (Exception e) {
			log.error("Exception publishing. Changes will persist in database");
			log.error(e.getMessage());
		}
	}

	// -------------

	/*
	 * @Override public gateway_device getDevice(String device_Id) throws
	 * Exception { return database.getDevice(device_Id); }
	 * 
	 * @Override public List<gateway_device> getAllDevices()throws Exception {
	 * return database.getAllDevices(); }
	 * 
	 * @Override public void deleteDevice(String device_Id) throws Exception {
	 * // TODO Auto-generated method stub }
	 * 
	 * @Override public gateway_host getHost(String host_Id) throws Exception {
	 * return database.getHost(host_Id); }
	 */

	// /----------------------------

	private class WaitThread extends Thread {

		@Override
		public void run() {
			log.debug("------------- WAITING FOR DRIVERS TO LOAD--------------------------");
			try {
				sleep(driverLoadTimeout);
				log.debug("---------------------WAIT FINISHED. TIMEOUT--------------------------");
			} catch (InterruptedException e) {
				log.debug("---------------------WAIT FINISHED. ALL READY-----------------------");
			}
			//TODO : NACHO 
			// Comprobar que la configuracion en el middleware coincide con la del gateway 
			// 
			
			
			LoadSubscriptionsFromDB();
		}
	}

	public List<DeviceScanInfo> scanForDevices(String driverId, String settings)
			throws UnsupportedOperationException, DriverNotAvailableException,
			ArgumentSyntaxException, ScanException, ScanInterruptedException {
		return configService.scanForDevices(driverId, settings);
	}

	public List<ChannelScanInfo> scanForChannels(String deviceId,
			String settings) throws UnsupportedOperationException,
			DriverNotAvailableException, ArgumentSyntaxException, ScanException {
		return configService.scanForChannels(deviceId, settings);
	}

	// -------------------------

	private final class ReadTask implements Callable<Record> {
		private final Channel c;
		private final Integer timeout;

		ReadTask(Channel c, Integer timeout) {
			this.c = c;
			this.timeout = timeout;
		}

		@Override
		public Record call() throws Exception {
			return readSingleChannel(c, timeout);
		}
	}

	private final class ReadTaskWithChannel implements Callable<Channel> {
		private final Channel c;
		private final Integer timeout;

		ReadTaskWithChannel(Channel c, Integer timeout) {
			this.c = c;
			this.timeout = timeout;
		}

		@Override
		public Channel call() throws Exception {
			getSingleChannel(c, timeout);
			return c;
		}
	}

	void readChannels(List<String> idList) throws InterruptedException,
			ExecutionException {
		log.debug("readChannels START");
		int numThreads = 4;
		ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		CompletionService<Record> compService = new ExecutorCompletionService<Record>(
				executor);
		for (String id : idList) {
			ReadTask task = new ReadTask(dataAccess.getChannel(id),connectTimeout);
			compService.submit(task);
		}
		for (String id : idList) {
			Future<Record> future = compService.take();
			try {
				log.debug(id + ":" + future.get().getValue());
			} catch (Exception e) {

			}
		}
		executor.shutdown(); // always reclaim resources
		log.debug("readChannels END");
	}

	void readChannelsAndWait(List<String> idList) throws InterruptedException,
			ExecutionException {
		log.debug("readChannelsAndWait START");
		Collection<Callable<Record>> tasks = new ArrayList<Callable<Record>>();
		for (String id : idList) {
			tasks.add(new ReadTask(dataAccess.getChannel(id), connectTimeout));
		}
		int numThreads = 8;
		ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		List<Future<Record>> results = executor.invokeAll(tasks);
		for (Future<Record> result : results) {
			Record record = result.get();
			log.debug("VAL" + record.getValue());
		}
		executor.shutdown(); // always reclaim resources
		log.debug("readChannelsAndWait END");
	}

	private void addSubVar(String varId, String subId) {
		if (!varSubs.containsKey(varId))
			varSubs.put(varId, new ArrayList<String>());
		if (!varSubs.get(varId).contains(subId))
			varSubs.get(varId).add(subId);
	}

	private void removeSubVar(String varId, String subId) {
		if (varSubs.containsKey(varId))
			if (varSubs.get(varId).contains(subId))
				varSubs.get(varId).remove(subId);
	}

	private boolean hasSubVar(String varId) {
		if (varSubs.containsKey(varId))
			return varSubs.get(varId).size() > 0;
		else
			return false;
	}
	/*
	 * private void incVars(SubscriptionThread s){ for(gateway_variable
	 * v:s.varMap.values()){ if(!varCount.containsKey(v.getId()))
	 * varCount.put(v.getId(),0); varCount.put(v.getId(),
	 * varCount.get(v.getId())+1); } } private void decVars(SubscriptionThread
	 * s){ for(gateway_variable v:s.varMap.values()){
	 * if(varCount.containsKey(v.getId())) varCount.put(v.getId(),
	 * varCount.get(v.getId())-1); } }
	 */
}
