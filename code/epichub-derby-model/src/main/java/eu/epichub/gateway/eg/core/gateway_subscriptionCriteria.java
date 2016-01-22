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

public class gateway_subscriptionCriteria extends AbstractORMCriteria {
	public final LongExpression dbID;
	public final LongExpression subscriberId;
	public final AssociationExpression subscriber;
	public final StringExpression id;
	public final LongExpression minInt;
	public final LongExpression maxInt;
	public final StringExpression state;
	public final CollectionExpression variables;
	
	public gateway_subscriptionCriteria(Criteria criteria) {
		super(criteria);
		dbID = new LongExpression("dbID", this);
		subscriberId = new LongExpression("subscriber.dbID", this);
		subscriber = new AssociationExpression("subscriber", this);
		id = new StringExpression("id", this);
		minInt = new LongExpression("minInt", this);
		maxInt = new LongExpression("maxInt", this);
		state = new StringExpression("state", this);
		variables = new CollectionExpression("variables", this);
	}
	
	public gateway_subscriptionCriteria(PersistentSession session) {
		this(session.createCriteria(gateway_subscription.class));
	}
	
	public gateway_subscriptionCriteria() throws PersistentException {
		this(eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession());
	}
	
	public gateway_subscriberCriteria createSubscriberCriteria() {
		return new gateway_subscriberCriteria(createCriteria("subscriber"));
	}
	
	public gateway_variableCriteria createVariablesCriteria() {
		return new gateway_variableCriteria(createCriteria("variables"));
	}
	
	public gateway_subscription uniqueGateway_subscription() {
		return (gateway_subscription) super.uniqueResult();
	}
	
	public gateway_subscription[] listGateway_subscription() {
		java.util.List list = super.list();
		return (gateway_subscription[]) list.toArray(new gateway_subscription[list.size()]);
	}
}

