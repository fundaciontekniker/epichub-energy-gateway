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

public class gateway_variableDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public gateway_variableDetachedCriteria() {
		super(eu.epichub.gateway.eg.core.gateway_variable.class, eu.epichub.gateway.eg.core.gateway_variableCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		deviceId = new LongExpression("device.dbID", this.getDetachedCriteria());
		device = new AssociationExpression("device", this.getDetachedCriteria());
		id = new StringExpression("id", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		digType = new StringExpression("digType", this.getDetachedCriteria());
		phyType = new StringExpression("phyType", this.getDetachedCriteria());
		unit = new StringExpression("unit", this.getDetachedCriteria());
		state = new StringExpression("state", this.getDetachedCriteria());
		accessType = new StringExpression("accessType", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
		expirationDate = new LongExpression("expirationDate", this.getDetachedCriteria());
		samplingInterval = new LongExpression("samplingInterval", this.getDetachedCriteria());
		absoluteError = new DoubleExpression("absoluteError", this.getDetachedCriteria());
		percentageError = new IntegerExpression("percentageError", this.getDetachedCriteria());
		subscriptions = new CollectionExpression("subscriptions", this.getDetachedCriteria());
		values = new CollectionExpression("values", this.getDetachedCriteria());
		setpoints = new CollectionExpression("setpoints", this.getDetachedCriteria());
	}
	
	public gateway_variableDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eu.epichub.gateway.eg.core.gateway_variableCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		deviceId = new LongExpression("device.dbID", this.getDetachedCriteria());
		device = new AssociationExpression("device", this.getDetachedCriteria());
		id = new StringExpression("id", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		digType = new StringExpression("digType", this.getDetachedCriteria());
		phyType = new StringExpression("phyType", this.getDetachedCriteria());
		unit = new StringExpression("unit", this.getDetachedCriteria());
		state = new StringExpression("state", this.getDetachedCriteria());
		accessType = new StringExpression("accessType", this.getDetachedCriteria());
		path = new StringExpression("path", this.getDetachedCriteria());
		expirationDate = new LongExpression("expirationDate", this.getDetachedCriteria());
		samplingInterval = new LongExpression("samplingInterval", this.getDetachedCriteria());
		absoluteError = new DoubleExpression("absoluteError", this.getDetachedCriteria());
		percentageError = new IntegerExpression("percentageError", this.getDetachedCriteria());
		subscriptions = new CollectionExpression("subscriptions", this.getDetachedCriteria());
		values = new CollectionExpression("values", this.getDetachedCriteria());
		setpoints = new CollectionExpression("setpoints", this.getDetachedCriteria());
	}
	
	public gateway_deviceDetachedCriteria createDeviceCriteria() {
		return new gateway_deviceDetachedCriteria(createCriteria("device"));
	}
	
	public gateway_subscriptionDetachedCriteria createSubscriptionsCriteria() {
		return new gateway_subscriptionDetachedCriteria(createCriteria("subscriptions"));
	}
	
	public gateway_valueDetachedCriteria createValuesCriteria() {
		return new gateway_valueDetachedCriteria(createCriteria("values"));
	}
	
	public gateway_setpointDetachedCriteria createSetpointsCriteria() {
		return new gateway_setpointDetachedCriteria(createCriteria("setpoints"));
	}
	
	public gateway_variable uniqueGateway_variable(PersistentSession session) {
		return (gateway_variable) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public gateway_variable[] listGateway_variable(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (gateway_variable[]) list.toArray(new gateway_variable[list.size()]);
	}
}

