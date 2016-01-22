package epichub.framework.gateway.spi;

import java.util.List;

import org.openmuc.framework.data.Record;

import eu.epichub.gateway.eg.core.gateway_device;
import eu.epichub.gateway.eg.core.gateway_host;
import eu.epichub.gateway.eg.core.gateway_subscription;

public interface CoreService {

	public Record readData(String varId, int timeout)throws Exception;
	public void writeData(String varId,Object value, int timeout)throws Exception;
	public Object readHistoricData(String varId, long from, long to)throws Exception;
	
	public String subscribe(String subId)throws Exception;
	public void unsubscribe(String subId)throws Exception;
	//public List<gateway_subscription> getSubscriptions() throws Exception;
	
	public gateway_host TestHostConfig(String hostId);
	//------
	
	//public void addHost(String host_Id, String url, String description) throws Exception;
	//public void updateHost(String host_Id, String url, String description) throws Exception;
	//public void updateHostState(String host_Id, String state) throws Exception;
	//public gateway_host getHost(String host_Id) throws Exception;
	//public void deleteHost(String host_Id) throws Exception;
	//public void addDevice(String device_Id, String driver_Id, String description, String capabilities, String deviceAddress, String interfaceAddress, String type) throws Exception;
	//public void updateDevice(String device_Id, String description, String capabilities, String deviceAddress, String interfaceAddress, String type) throws Exception;
	public void updateDeviceState(String subscriberId, String device_Id, String state) throws Exception;
	public void updateDeviceState(String subscriberId, List<String> device_Ids, String state) throws Exception;
	//public List<gateway_device> getAllDevices() throws Exception;
	//public gateway_device getDevice(String device_Id) throws Exception;
	//public void deleteDevice(String device_Id) throws Exception;
	
	
	
	/*public Object addDevice()throws Exception;
	public Object deleteDevice()throws Exception;
	public Object updateDevice()throws Exception;
	public Object getDeviceInfo()throws Exception;
	public Object getDevices()throws Exception;
	public Object getConnectedDevices()throws Exception;
	public Object getOperations()throws Exception;*/
}
