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

public class gateway_driverCriteria extends AbstractORMCriteria {
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
	
	public gateway_driverCriteria(Criteria criteria) {
		super(criteria);
		dbID = new LongExpression("dbID", this);
		hostId = new LongExpression("host.dbID", this);
		host = new AssociationExpression("host", this);
		id = new StringExpression("id", this);
		name = new StringExpression("name", this);
		state = new StringExpression("state", this);
		subscriptions = new BooleanExpression("subscriptions", this);
		description = new StringExpression("description", this);
		operations = new StringExpression("operations", this);
		devices = new CollectionExpression("devices", this);
		settings = new CollectionExpression("settings", this);
	}
	
	public gateway_driverCriteria(PersistentSession session) {
		this(session.createCriteria(gateway_driver.class));
	}
	
	public gateway_driverCriteria() throws PersistentException {
		this(eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession());
	}
	
	public gateway_hostCriteria createHostCriteria() {
		return new gateway_hostCriteria(createCriteria("host"));
	}
	
	public gateway_deviceCriteria createDevicesCriteria() {
		return new gateway_deviceCriteria(createCriteria("devices"));
	}
	
	public gateway_configOptionCriteria createSettingsCriteria() {
		return new gateway_configOptionCriteria(createCriteria("settings"));
	}
	
	public gateway_driver uniqueGateway_driver() {
		return (gateway_driver) super.uniqueResult();
	}
	
	public gateway_driver[] listGateway_driver() {
		java.util.List list = super.list();
		return (gateway_driver[]) list.toArray(new gateway_driver[list.size()]);
	}
}

