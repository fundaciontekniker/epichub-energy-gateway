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

public class gateway_locationCriteria extends AbstractORMCriteria {
	public final LongExpression dbID;
	public final StringExpression id;
	public final StringExpression country;
	public final StringExpression city;
	public final StringExpression zip;
	public final StringExpression address;
	public final DoubleExpression lat;
	public final DoubleExpression lon;
	public final DoubleExpression height;
	public final LongExpression hostId;
	public final AssociationExpression host;
	public final LongExpression deviceId;
	public final AssociationExpression device;
	
	public gateway_locationCriteria(Criteria criteria) {
		super(criteria);
		dbID = new LongExpression("dbID", this);
		id = new StringExpression("id", this);
		country = new StringExpression("country", this);
		city = new StringExpression("city", this);
		zip = new StringExpression("zip", this);
		address = new StringExpression("address", this);
		lat = new DoubleExpression("lat", this);
		lon = new DoubleExpression("lon", this);
		height = new DoubleExpression("height", this);
		hostId = new LongExpression("host.dbID", this);
		host = new AssociationExpression("host", this);
		deviceId = new LongExpression("device.dbID", this);
		device = new AssociationExpression("device", this);
	}
	
	public gateway_locationCriteria(PersistentSession session) {
		this(session.createCriteria(gateway_location.class));
	}
	
	public gateway_locationCriteria() throws PersistentException {
		this(eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession());
	}
	
	public gateway_hostCriteria createHostCriteria() {
		return new gateway_hostCriteria(createCriteria("host"));
	}
	
	public gateway_deviceCriteria createDeviceCriteria() {
		return new gateway_deviceCriteria(createCriteria("device"));
	}
	
	public gateway_location uniqueGateway_location() {
		return (gateway_location) super.uniqueResult();
	}
	
	public gateway_location[] listGateway_location() {
		java.util.List list = super.list();
		return (gateway_location[]) list.toArray(new gateway_location[list.size()]);
	}
}

