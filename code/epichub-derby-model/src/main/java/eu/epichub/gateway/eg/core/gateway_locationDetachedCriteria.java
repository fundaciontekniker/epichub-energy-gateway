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

public class gateway_locationDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public gateway_locationDetachedCriteria() {
		super(eu.epichub.gateway.eg.core.gateway_location.class, eu.epichub.gateway.eg.core.gateway_locationCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		id = new StringExpression("id", this.getDetachedCriteria());
		country = new StringExpression("country", this.getDetachedCriteria());
		city = new StringExpression("city", this.getDetachedCriteria());
		zip = new StringExpression("zip", this.getDetachedCriteria());
		address = new StringExpression("address", this.getDetachedCriteria());
		lat = new DoubleExpression("lat", this.getDetachedCriteria());
		lon = new DoubleExpression("lon", this.getDetachedCriteria());
		height = new DoubleExpression("height", this.getDetachedCriteria());
		hostId = new LongExpression("host.dbID", this.getDetachedCriteria());
		host = new AssociationExpression("host", this.getDetachedCriteria());
		deviceId = new LongExpression("device.dbID", this.getDetachedCriteria());
		device = new AssociationExpression("device", this.getDetachedCriteria());
	}
	
	public gateway_locationDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eu.epichub.gateway.eg.core.gateway_locationCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		id = new StringExpression("id", this.getDetachedCriteria());
		country = new StringExpression("country", this.getDetachedCriteria());
		city = new StringExpression("city", this.getDetachedCriteria());
		zip = new StringExpression("zip", this.getDetachedCriteria());
		address = new StringExpression("address", this.getDetachedCriteria());
		lat = new DoubleExpression("lat", this.getDetachedCriteria());
		lon = new DoubleExpression("lon", this.getDetachedCriteria());
		height = new DoubleExpression("height", this.getDetachedCriteria());
		hostId = new LongExpression("host.dbID", this.getDetachedCriteria());
		host = new AssociationExpression("host", this.getDetachedCriteria());
		deviceId = new LongExpression("device.dbID", this.getDetachedCriteria());
		device = new AssociationExpression("device", this.getDetachedCriteria());
	}
	
	public gateway_hostDetachedCriteria createHostCriteria() {
		return new gateway_hostDetachedCriteria(createCriteria("host"));
	}
	
	public gateway_deviceDetachedCriteria createDeviceCriteria() {
		return new gateway_deviceDetachedCriteria(createCriteria("device"));
	}
	
	public gateway_location uniqueGateway_location(PersistentSession session) {
		return (gateway_location) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public gateway_location[] listGateway_location(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (gateway_location[]) list.toArray(new gateway_location[list.size()]);
	}
}

