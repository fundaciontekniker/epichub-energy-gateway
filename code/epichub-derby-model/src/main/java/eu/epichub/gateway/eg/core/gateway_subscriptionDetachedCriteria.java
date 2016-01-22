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

public class gateway_subscriptionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression dbID;
	public final LongExpression subscriberId;
	public final AssociationExpression subscriber;
	public final StringExpression id;
	public final LongExpression minInt;
	public final LongExpression maxInt;
	public final StringExpression state;
	public final CollectionExpression variables;
	
	public gateway_subscriptionDetachedCriteria() {
		super(eu.epichub.gateway.eg.core.gateway_subscription.class, eu.epichub.gateway.eg.core.gateway_subscriptionCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		subscriberId = new LongExpression("subscriber.dbID", this.getDetachedCriteria());
		subscriber = new AssociationExpression("subscriber", this.getDetachedCriteria());
		id = new StringExpression("id", this.getDetachedCriteria());
		minInt = new LongExpression("minInt", this.getDetachedCriteria());
		maxInt = new LongExpression("maxInt", this.getDetachedCriteria());
		state = new StringExpression("state", this.getDetachedCriteria());
		variables = new CollectionExpression("variables", this.getDetachedCriteria());
	}
	
	public gateway_subscriptionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eu.epichub.gateway.eg.core.gateway_subscriptionCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		subscriberId = new LongExpression("subscriber.dbID", this.getDetachedCriteria());
		subscriber = new AssociationExpression("subscriber", this.getDetachedCriteria());
		id = new StringExpression("id", this.getDetachedCriteria());
		minInt = new LongExpression("minInt", this.getDetachedCriteria());
		maxInt = new LongExpression("maxInt", this.getDetachedCriteria());
		state = new StringExpression("state", this.getDetachedCriteria());
		variables = new CollectionExpression("variables", this.getDetachedCriteria());
	}
	
	public gateway_subscriberDetachedCriteria createSubscriberCriteria() {
		return new gateway_subscriberDetachedCriteria(createCriteria("subscriber"));
	}
	
	public gateway_variableDetachedCriteria createVariablesCriteria() {
		return new gateway_variableDetachedCriteria(createCriteria("variables"));
	}
	
	public gateway_subscription uniqueGateway_subscription(PersistentSession session) {
		return (gateway_subscription) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public gateway_subscription[] listGateway_subscription(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (gateway_subscription[]) list.toArray(new gateway_subscription[list.size()]);
	}
}

