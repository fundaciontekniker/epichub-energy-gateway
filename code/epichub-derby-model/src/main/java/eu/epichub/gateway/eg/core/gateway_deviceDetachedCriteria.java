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

public class gateway_deviceDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public gateway_deviceDetachedCriteria() {
		super(eu.epichub.gateway.eg.core.gateway_device.class, eu.epichub.gateway.eg.core.gateway_deviceCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		locationId = new LongExpression("location.dbID", this.getDetachedCriteria());
		location = new AssociationExpression("location", this.getDetachedCriteria());
		driverId = new LongExpression("driver.dbID", this.getDetachedCriteria());
		driver = new AssociationExpression("driver", this.getDetachedCriteria());
		id = new StringExpression("id", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		capabilities = new StringExpression("capabilities", this.getDetachedCriteria());
		deviceAddress = new StringExpression("deviceAddress", this.getDetachedCriteria());
		interfaceAddress = new StringExpression("interfaceAddress", this.getDetachedCriteria());
		state = new StringExpression("state", this.getDetachedCriteria());
		type = new StringExpression("type", this.getDetachedCriteria());
		variables = new CollectionExpression("variables", this.getDetachedCriteria());
		settings = new CollectionExpression("settings", this.getDetachedCriteria());
	}
	
	public gateway_deviceDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eu.epichub.gateway.eg.core.gateway_deviceCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		locationId = new LongExpression("location.dbID", this.getDetachedCriteria());
		location = new AssociationExpression("location", this.getDetachedCriteria());
		driverId = new LongExpression("driver.dbID", this.getDetachedCriteria());
		driver = new AssociationExpression("driver", this.getDetachedCriteria());
		id = new StringExpression("id", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		capabilities = new StringExpression("capabilities", this.getDetachedCriteria());
		deviceAddress = new StringExpression("deviceAddress", this.getDetachedCriteria());
		interfaceAddress = new StringExpression("interfaceAddress", this.getDetachedCriteria());
		state = new StringExpression("state", this.getDetachedCriteria());
		type = new StringExpression("type", this.getDetachedCriteria());
		variables = new CollectionExpression("variables", this.getDetachedCriteria());
		settings = new CollectionExpression("settings", this.getDetachedCriteria());
	}
	
	public gateway_locationDetachedCriteria createLocationCriteria() {
		return new gateway_locationDetachedCriteria(createCriteria("location"));
	}
	
	public gateway_driverDetachedCriteria createDriverCriteria() {
		return new gateway_driverDetachedCriteria(createCriteria("driver"));
	}
	
	public gateway_variableDetachedCriteria createVariablesCriteria() {
		return new gateway_variableDetachedCriteria(createCriteria("variables"));
	}
	
	public gateway_configOptionDetachedCriteria createSettingsCriteria() {
		return new gateway_configOptionDetachedCriteria(createCriteria("settings"));
	}
	
	public gateway_device uniqueGateway_device(PersistentSession session) {
		return (gateway_device) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public gateway_device[] listGateway_device(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (gateway_device[]) list.toArray(new gateway_device[list.size()]);
	}
}

