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

public class gateway_hostCriteria extends AbstractORMCriteria {
	public final LongExpression dbID;
	public final LongExpression locationId;
	public final AssociationExpression location;
	public final StringExpression id;
	public final StringExpression URL;
	public final StringExpression state;
	public final StringExpression description;
	public final CollectionExpression drivers;
	public final CollectionExpression settings;
	
	public gateway_hostCriteria(Criteria criteria) {
		super(criteria);
		dbID = new LongExpression("dbID", this);
		locationId = new LongExpression("location.dbID", this);
		location = new AssociationExpression("location", this);
		id = new StringExpression("id", this);
		URL = new StringExpression("URL", this);
		state = new StringExpression("state", this);
		description = new StringExpression("description", this);
		drivers = new CollectionExpression("drivers", this);
		settings = new CollectionExpression("settings", this);
	}
	
	public gateway_hostCriteria(PersistentSession session) {
		this(session.createCriteria(gateway_host.class));
	}
	
	public gateway_hostCriteria() throws PersistentException {
		this(eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession());
	}
	
	public gateway_locationCriteria createLocationCriteria() {
		return new gateway_locationCriteria(createCriteria("location"));
	}
	
	public gateway_driverCriteria createDriversCriteria() {
		return new gateway_driverCriteria(createCriteria("drivers"));
	}
	
	public gateway_configOptionCriteria createSettingsCriteria() {
		return new gateway_configOptionCriteria(createCriteria("settings"));
	}
	
	public gateway_host uniqueGateway_host() {
		return (gateway_host) super.uniqueResult();
	}
	
	public gateway_host[] listGateway_host() {
		java.util.List list = super.list();
		return (gateway_host[]) list.toArray(new gateway_host[list.size()]);
	}
}

