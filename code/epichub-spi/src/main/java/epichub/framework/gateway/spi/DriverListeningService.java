package epichub.framework.gateway.spi;

import java.util.List;

public interface DriverListeningService {

	public String getId();
	//public void stopListening(DeviceConnection connection,	List<ChannelRecordContainer> containers)throws UnsupportedOperationException;
	public void stopListening(String intAdr,String devAdr, List<String> chnAdrList)throws UnsupportedOperationException;

	//AGARCIA 13/11/2014  Propuesta nuevas funciones subscripcion
	/*
	public void startSubscription(gateway_subscription gSub)throws UnsupportedOperationException;
	public void stopSubscription(gateway_subscription gSub)throws UnsupportedOperationException;
	 */
}
