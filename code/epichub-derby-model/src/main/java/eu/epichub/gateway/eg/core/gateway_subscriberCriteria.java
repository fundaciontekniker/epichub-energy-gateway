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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class gateway_subscriberCriteria extends AbstractORMCriteria {
	public final LongExpression dbID;
	public final StringExpression id;
	public final StringExpression name;
	public final StringExpression responseURL;
	public final CollectionExpression subscriptions;
	
	public gateway_subscriberCriteria(Criteria criteria) {
		super(criteria);
		dbID = new LongExpression("dbID", this);
		id = new StringExpression("id", this);
		name = new StringExpression("name", this);
		responseURL = new StringExpression("responseURL", this);
		subscriptions = new CollectionExpression("subscriptions", this);
	}
	
	public gateway_subscriberCriteria(PersistentSession session) {
		this(session.createCriteria(gateway_subscriber.class));
	}
	
	public gateway_subscriberCriteria() throws PersistentException {
		this(eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession());
	}
	
	public gateway_subscriptionCriteria createSubscriptionsCriteria() {
		return new gateway_subscriptionCriteria(createCriteria("subscriptions"));
	}
	
	public gateway_subscriber uniqueGateway_subscriber() {
		return (gateway_subscriber) super.uniqueResult();
	}
	
	public gateway_subscriber[] listGateway_subscriber() {
		java.util.List list = super.list();
		return (gateway_subscriber[]) list.toArray(new gateway_subscriber[list.size()]);
	}
}

