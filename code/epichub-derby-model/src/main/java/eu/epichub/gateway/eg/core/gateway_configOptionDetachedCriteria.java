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

public class gateway_configOptionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression dbID;
	public final StringExpression parameter;
	public final StringExpression type;
	public final StringExpression value;
	
	public gateway_configOptionDetachedCriteria() {
		super(eu.epichub.gateway.eg.core.gateway_configOption.class, eu.epichub.gateway.eg.core.gateway_configOptionCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		parameter = new StringExpression("parameter", this.getDetachedCriteria());
		type = new StringExpression("type", this.getDetachedCriteria());
		value = new StringExpression("value", this.getDetachedCriteria());
	}
	
	public gateway_configOptionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eu.epichub.gateway.eg.core.gateway_configOptionCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		parameter = new StringExpression("parameter", this.getDetachedCriteria());
		type = new StringExpression("type", this.getDetachedCriteria());
		value = new StringExpression("value", this.getDetachedCriteria());
	}
	
	public gateway_configOption uniqueGateway_configOption(PersistentSession session) {
		return (gateway_configOption) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public gateway_configOption[] listGateway_configOption(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (gateway_configOption[]) list.toArray(new gateway_configOption[list.size()]);
	}
}

