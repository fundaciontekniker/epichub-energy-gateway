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

public class gateway_driverDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression dbID;
	public final LongExpression hostId;
	public final AssociationExpression host;
	public final StringExpression id;
	public final StringExpression name;
	public final StringExpression state;
	public final BooleanExpression subscriptions;
	public final StringExpression description;
	public final StringExpression operations;
	public final CollectionExpression devices;
	public final CollectionExpression settings;
	
	public gateway_driverDetachedCriteria() {
		super(eu.epichub.gateway.eg.core.gateway_driver.class, eu.epichub.gateway.eg.core.gateway_driverCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		hostId = new LongExpression("host.dbID", this.getDetachedCriteria());
		host = new AssociationExpression("host", this.getDetachedCriteria());
		id = new StringExpression("id", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		state = new StringExpression("state", this.getDetachedCriteria());
		subscriptions = new BooleanExpression("subscriptions", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		operations = new StringExpression("operations", this.getDetachedCriteria());
		devices = new CollectionExpression("devices", this.getDetachedCriteria());
		settings = new CollectionExpression("settings", this.getDetachedCriteria());
	}
	
	public gateway_driverDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eu.epichub.gateway.eg.core.gateway_driverCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		hostId = new LongExpression("host.dbID", this.getDetachedCriteria());
		host = new AssociationExpression("host", this.getDetachedCriteria());
		id = new StringExpression("id", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		state = new StringExpression("state", this.getDetachedCriteria());
		subscriptions = new BooleanExpression("subscriptions", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		operations = new StringExpression("operations", this.getDetachedCriteria());
		devices = new CollectionExpression("devices", this.getDetachedCriteria());
		settings = new CollectionExpression("settings", this.getDetachedCriteria());
	}
	
	public gateway_hostDetachedCriteria createHostCriteria() {
		return new gateway_hostDetachedCriteria(createCriteria("host"));
	}
	
	public gateway_deviceDetachedCriteria createDevicesCriteria() {
		return new gateway_deviceDetachedCriteria(createCriteria("devices"));
	}
	
	public gateway_configOptionDetachedCriteria createSettingsCriteria() {
		return new gateway_configOptionDetachedCriteria(createCriteria("settings"));
	}
	
	public gateway_driver uniqueGateway_driver(PersistentSession session) {
		return (gateway_driver) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public gateway_driver[] listGateway_driver(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (gateway_driver[]) list.toArray(new gateway_driver[list.size()]);
	}
}

