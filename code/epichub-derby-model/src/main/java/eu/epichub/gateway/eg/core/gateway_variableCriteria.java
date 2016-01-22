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

public class gateway_variableCriteria extends AbstractORMCriteria {
	public final LongExpression dbID;
	public final LongExpression deviceId;
	public final AssociationExpression device;
	public final StringExpression id;
	public final StringExpression description;
	public final StringExpression digType;
	public final StringExpression phyType;
	public final StringExpression unit;
	public final StringExpression state;
	public final StringExpression accessType;
	public final StringExpression path;
	public final LongExpression expirationDate;
	public final LongExpression samplingInterval;
	public final DoubleExpression absoluteError;
	public final IntegerExpression percentageError;
	public final CollectionExpression subscriptions;
	public final CollectionExpression values;
	public final CollectionExpression setpoints;
	
	public gateway_variableCriteria(Criteria criteria) {
		super(criteria);
		dbID = new LongExpression("dbID", this);
		deviceId = new LongExpression("device.dbID", this);
		device = new AssociationExpression("device", this);
		id = new StringExpression("id", this);
		description = new StringExpression("description", this);
		digType = new StringExpression("digType", this);
		phyType = new StringExpression("phyType", this);
		unit = new StringExpression("unit", this);
		state = new StringExpression("state", this);
		accessType = new StringExpression("accessType", this);
		path = new StringExpression("path", this);
		expirationDate = new LongExpression("expirationDate", this);
		samplingInterval = new LongExpression("samplingInterval", this);
		absoluteError = new DoubleExpression("absoluteError", this);
		percentageError = new IntegerExpression("percentageError", this);
		subscriptions = new CollectionExpression("subscriptions", this);
		values = new CollectionExpression("values", this);
		setpoints = new CollectionExpression("setpoints", this);
	}
	
	public gateway_variableCriteria(PersistentSession session) {
		this(session.createCriteria(gateway_variable.class));
	}
	
	public gateway_variableCriteria() throws PersistentException {
		this(eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession());
	}
	
	public gateway_deviceCriteria createDeviceCriteria() {
		return new gateway_deviceCriteria(createCriteria("device"));
	}
	
	public gateway_subscriptionCriteria createSubscriptionsCriteria() {
		return new gateway_subscriptionCriteria(createCriteria("subscriptions"));
	}
	
	public gateway_valueCriteria createValuesCriteria() {
		return new gateway_valueCriteria(createCriteria("values"));
	}
	
	public gateway_setpointCriteria createSetpointsCriteria() {
		return new gateway_setpointCriteria(createCriteria("setpoints"));
	}
	
	public gateway_variable uniqueGateway_variable() {
		return (gateway_variable) super.uniqueResult();
	}
	
	public gateway_variable[] listGateway_variable() {
		java.util.List list = super.list();
		return (gateway_variable[]) list.toArray(new gateway_variable[list.size()]);
	}
}

