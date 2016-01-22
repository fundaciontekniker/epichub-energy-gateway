package epichub.framework.gateway.spi;

import java.util.List;

import org.orm.PersistentSession;

import eu.epichub.gateway.eg.core.gateway_configOption;
import eu.epichub.gateway.eg.core.gateway_device;
import eu.epichub.gateway.eg.core.gateway_driver;
import eu.epichub.gateway.eg.core.gateway_host;
import eu.epichub.gateway.eg.core.gateway_subscriber;
import eu.epichub.gateway.eg.core.gateway_subscription;
import eu.epichub.gateway.eg.core.gateway_value;
import eu.epichub.gateway.eg.core.gateway_variable;

public interface DatabaseService {

	public void addHost(String host_Id, String url, String description) throws Exception;
	public void updateHost(String host_Id, String url, String description) throws Exception;
	public void updateHostState(String host_Id, String state) throws Exception;
	public gateway_host getHost(String host_Id) throws Exception;
	public void deleteHost(String host_Id) throws Exception;
	public List<gateway_host> getAllHosts() throws Exception;
	
	public void addDriver(String driver_Id, String host_Id, String name, String description) throws Exception;
	public void updateDriver(String driver_Id, String name, String description) throws Exception;
	public void updateDriverState(String driver_Id, String state) throws Exception;
	public gateway_driver getDriver(String driver_Id) throws Exception;
	public void deleteDriver(String driver_Id) throws Exception;
	public List<gateway_driver> getAllDrivers() throws Exception;
	
	public void addDevice(String device_Id, String driver_Id, String description, String capabilities, String deviceAddress, String interfaceAddress, String type) throws Exception;
	public void updateDevice(String device_Id, String description, String capabilities, String deviceAddress, String interfaceAddress, String type) throws Exception;
	public void updateDeviceState(String device_Id, String state) throws Exception;
	public gateway_device getDevice(String device_Id) throws Exception;
	public void deleteDevice(String device_Id) throws Exception;
	public List<gateway_device> getAllDevices() throws Exception;	
	
	public void addVariable(String var_Id, String device_Id,  String description, String digType, String phyType, String unit, String accessType, String path, Long expirationDate, Long samplingInterval,Double absoluteError,Integer percentageError) throws Exception;
	public void updateVariable(String var_Id,  String description, String digType, String phyType, String unit, String accessType, String path, Long expirationDate, Long samplingInterval,Double absoluteError,Integer percentageError) throws Exception;
	public void updateVariableState(String var_Id, String state) throws Exception;
	public gateway_variable getVariable(String var_Id) throws Exception;
	public void deleteVariable(String var_Id) throws Exception;
	public List<gateway_variable> getAllVariables() throws Exception;
	
	public void addVariableValue(String var_Id, String value,  Long timestamp) throws Exception;
	public List<gateway_value> getVariableValues(String varId, Long fromDate, Long toDate) throws Exception ;
	
	public void addSubscriber(String subscriber_Id, String name, String responseUrl) throws Exception;
	public void updateSubscriber(String subscriber_Id, String name, String responseUrl) throws Exception;
	public gateway_subscriber getSubscriber(String subscriber_Id) throws Exception;
	public void deleteSubscriber(String subscriber_Id) throws Exception;
	public List<gateway_subscriber> getAllSubscribers() throws Exception;	
	
	public void addSubscription(String sub_Id, String subscriber_Id,  Long minInt, Long maxInt) throws Exception;
	public void updateSubscription(String sub_Id, Long minInt, Long maxInt) throws Exception;
	public void updateSubscriptionState(String sub_Id, String state) throws Exception;
	public gateway_subscription getSubscription(String sub_Id) throws Exception;
	public void deleteSubscription(String sub_Id) throws Exception;
	public List<gateway_subscription> getAllSubscriptions() throws Exception;		
	
	//--
	public void addHost(String host_Id, String url, String description, PersistentSession s) throws Exception;
	public void updateHost(String host_Id, String url, String description, PersistentSession s) throws Exception;
	public void updateHostState(String host_Id, String state, PersistentSession s) throws Exception;
	public gateway_host getHost(String host_Id, PersistentSession s) throws Exception;
	public void deleteHost(String host_Id, PersistentSession s) throws Exception;
	public List<gateway_host> getAllHosts(PersistentSession s) throws Exception;
	
	public void addDriver(String driver_Id, String host_Id, String name, String description, PersistentSession s) throws Exception;
	public void updateDriver(String driver_Id, String name, String description, PersistentSession s) throws Exception;
	public void updateDriverState(String driver_Id, String state, PersistentSession s) throws Exception;
	public gateway_driver getDriver(String driver_Id, PersistentSession s) throws Exception;
	public void deleteDriver(String driver_Id, PersistentSession s) throws Exception;
	public List<gateway_driver> getAllDrivers(PersistentSession s) throws Exception;
	
	public void addDevice(String device_Id, String driver_Id, String description, String capabilities, String deviceAddress, String interfaceAddress, String type, PersistentSession s) throws Exception;
	public void updateDevice(String device_Id, String description, String capabilities, String deviceAddress, String interfaceAddress, String type, PersistentSession s) throws Exception;
	public void updateDeviceState(String device_Id, String state, PersistentSession s) throws Exception;
	public gateway_device getDevice(String device_Id, PersistentSession s) throws Exception;
	public void deleteDevice(String device_Id, PersistentSession s) throws Exception;
	public List<gateway_device> getAllDevices(PersistentSession s) throws Exception;	
	public List<gateway_variable> getDeviceVariables(String devId) throws Exception;
	public List<gateway_variable> getDeviceVariables(String devId,PersistentSession s) throws Exception;
	public List<gateway_configOption> getDeviceSettings(String devId) throws Exception;
	public List<gateway_configOption> getDeviceSettings(String devId,PersistentSession s) throws Exception;
	
	public void addVariable(String var_Id, String device_Id,  String description, String digType, String phyType, String unit, String accessType, String path, Long expirationDate, Long samplingInterval,Double absoluteError,Integer percentageError, PersistentSession s) throws Exception;
	public void updateVariable(String var_Id,  String description, String digType, String phyType, String unit, String accessType, String path, Long expirationDate, Long samplingInterval,Double absoluteError,Integer percentageError, PersistentSession s) throws Exception;
	public void updateVariableState(String var_Id, String state, PersistentSession s) throws Exception;
	public gateway_variable getVariable(String var_Id, PersistentSession s) throws Exception;
	public void deleteVariable(String var_Id, PersistentSession s) throws Exception;
	public void addVariableValue(String var_Id, String value, Long timestamp, PersistentSession s) throws Exception;	
	public List<gateway_variable> getAllVariables(PersistentSession s) throws Exception;	
	public List<gateway_subscription> getVariableSubscriptions(String varId) throws Exception;
	public List<gateway_subscription> getVariableSubscriptions(String varId,PersistentSession s) throws Exception;
	
	public void addSubscriber(String subscriber_Id, String name, String responseUrl, PersistentSession s) throws Exception;
	public void updateSubscriber(String subscriber_Id, String name, String responseUrl, PersistentSession s) throws Exception;
	public gateway_subscriber getSubscriber(String subscriber_Id, PersistentSession s) throws Exception;
	public void deleteSubscriber(String subscriber_Id, PersistentSession s) throws Exception;
	public List<gateway_subscriber> getAllSubscribers(PersistentSession s) throws Exception;	
	
	public void addSubscription(String sub_Id, String subscriber_Id,  Long minInt, Long maxInt, PersistentSession s) throws Exception;
	public void updateSubscription(String sub_Id, Long minInt, Long maxInt, PersistentSession s) throws Exception;
	public void updateSubscriptionState(String sub_Id, String state, PersistentSession s) throws Exception;
	public gateway_subscription getSubscription(String sub_Id, PersistentSession s) throws Exception;
	public void deleteSubscription(String sub_Id, PersistentSession s) throws Exception;
	public List<gateway_subscription> getAllSubscriptions(PersistentSession s) throws Exception;
	public List<gateway_variable> getSubscriptionVariables(String subId) throws Exception;
	public List<gateway_variable> getSubscriptionVariables(String sub_Id,PersistentSession s) throws Exception;
		

	
}
