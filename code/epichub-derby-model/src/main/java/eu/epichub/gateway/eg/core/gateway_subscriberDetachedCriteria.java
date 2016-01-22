/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Evaluation
 */
package eu.epichub.gateway.eg.core;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class gateway_subscriberDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression dbID;
	public final StringExpression id;
	public final StringExpression name;
	public final StringExpression responseURL;
	public final CollectionExpression subscriptions;
	
	public gateway_subscriberDetachedCriteria() {
		super(eu.epichub.gateway.eg.core.gateway_subscriber.class, eu.epichub.gateway.eg.core.gateway_subscriberCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		id = new StringExpression("id", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		responseURL = new StringExpression("responseURL", this.getDetachedCriteria());
		subscriptions = new CollectionExpression("subscriptions", this.getDetachedCriteria());
	}
	
	public gateway_subscriberDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eu.epichub.gateway.eg.core.gateway_subscriberCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		id = new StringExpression("id", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		responseURL = new StringExpression("responseURL", this.getDetachedCriteria());
		subscriptions = new CollectionExpression("subscriptions", this.getDetachedCriteria());
	}
	
	public gateway_subscriptionDetachedCriteria createSubscriptionsCriteria() {
		return new gateway_subscriptionDetachedCriteria(createCriteria("subscriptions"));
	}
	
	public gateway_subscriber uniqueGateway_subscriber(PersistentSession session) {
		return (gateway_subscriber) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public gateway_subscriber[] listGateway_subscriber(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (gateway_subscriber[]) list.toArray(new gateway_subscriber[list.size()]);
	}
}

