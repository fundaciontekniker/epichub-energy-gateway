package epichub.framework.gateway.spi;

import java.util.List;

import org.openmuc.framework.data.Record;

import eu.epichub.gateway.eg.core.gateway_subscription;
import eu.epichub.gateway.eg.core.gateway_variable;

public interface SubscriberService {

	public void notify(String channelLabel,Record r);

	public void loadSubscription(gateway_subscription sub, List<gateway_variable> varList);
	
	public void unloadSubscription(String subId);

	public Boolean isSubscriptionLoaded(String subId);
	
	//public Boolean isVariableSubscribed(String varId);
}
