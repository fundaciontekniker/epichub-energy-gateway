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

public class gateway_hostDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression dbID;
	public final LongExpression locationId;
	public final AssociationExpression location;
	public final StringExpression id;
	public final StringExpression URL;
	public final StringExpression state;
	public final StringExpression description;
	public final CollectionExpression drivers;
	public final CollectionExpression settings;
	
	public gateway_hostDetachedCriteria() {
		super(eu.epichub.gateway.eg.core.gateway_host.class, eu.epichub.gateway.eg.core.gateway_hostCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		locationId = new LongExpression("location.dbID", this.getDetachedCriteria());
		location = new AssociationExpression("location", this.getDetachedCriteria());
		id = new StringExpression("id", this.getDetachedCriteria());
		URL = new StringExpression("URL", this.getDetachedCriteria());
		state = new StringExpression("state", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		drivers = new CollectionExpression("drivers", this.getDetachedCriteria());
		settings = new CollectionExpression("settings", this.getDetachedCriteria());
	}
	
	public gateway_hostDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eu.epichub.gateway.eg.core.gateway_hostCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		locationId = new LongExpression("location.dbID", this.getDetachedCriteria());
		location = new AssociationExpression("location", this.getDetachedCriteria());
		id = new StringExpression("id", this.getDetachedCriteria());
		URL = new StringExpression("URL", this.getDetachedCriteria());
		state = new StringExpression("state", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		drivers = new CollectionExpression("drivers", this.getDetachedCriteria());
		settings = new CollectionExpression("settings", this.getDetachedCriteria());
	}
	
	public gateway_locationDetachedCriteria createLocationCriteria() {
		return new gateway_locationDetachedCriteria(createCriteria("location"));
	}
	
	public gateway_driverDetachedCriteria createDriversCriteria() {
		return new gateway_driverDetachedCriteria(createCriteria("drivers"));
	}
	
	public gateway_configOptionDetachedCriteria createSettingsCriteria() {
		return new gateway_configOptionDetachedCriteria(createCriteria("settings"));
	}
	
	public gateway_host uniqueGateway_host(PersistentSession session) {
		return (gateway_host) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public gateway_host[] listGateway_host(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (gateway_host[]) list.toArray(new gateway_host[list.size()]);
	}
}

