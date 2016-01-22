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

public class gateway_deviceCriteria extends AbstractORMCriteria {
	public final LongExpression dbID;
	public final LongExpression locationId;
	public final AssociationExpression location;
	public final LongExpression driverId;
	public final AssociationExpression driver;
	public final StringExpression id;
	public final StringExpression description;
	public final StringExpression capabilities;
	public final StringExpression deviceAddress;
	public final StringExpression interfaceAddress;
	public final StringExpression state;
	public final StringExpression type;
	public final CollectionExpression variables;
	public final CollectionExpression settings;
	
	public gateway_deviceCriteria(Criteria criteria) {
		super(criteria);
		dbID = new LongExpression("dbID", this);
		locationId = new LongExpression("location.dbID", this);
		location = new AssociationExpression("location", this);
		driverId = new LongExpression("driver.dbID", this);
		driver = new AssociationExpression("driver", this);
		id = new StringExpression("id", this);
		description = new StringExpression("description", this);
		capabilities = new StringExpression("capabilities", this);
		deviceAddress = new StringExpression("deviceAddress", this);
		interfaceAddress = new StringExpression("interfaceAddress", this);
		state = new StringExpression("state", this);
		type = new StringExpression("type", this);
		variables = new CollectionExpression("variables", this);
		settings = new CollectionExpression("settings", this);
	}
	
	public gateway_deviceCriteria(PersistentSession session) {
		this(session.createCriteria(gateway_device.class));
	}
	
	public gateway_deviceCriteria() throws PersistentException {
		this(eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession());
	}
	
	public gateway_locationCriteria createLocationCriteria() {
		return new gateway_locationCriteria(createCriteria("location"));
	}
	
	public gateway_driverCriteria createDriverCriteria() {
		return new gateway_driverCriteria(createCriteria("driver"));
	}
	
	public gateway_variableCriteria createVariablesCriteria() {
		return new gateway_variableCriteria(createCriteria("variables"));
	}
	
	public gateway_configOptionCriteria createSettingsCriteria() {
		return new gateway_configOptionCriteria(createCriteria("settings"));
	}
	
	public gateway_device uniqueGateway_device() {
		return (gateway_device) super.uniqueResult();
	}
	
	public gateway_device[] listGateway_device() {
		java.util.List list = super.list();
		return (gateway_device[]) list.toArray(new gateway_device[list.size()]);
	}
}

