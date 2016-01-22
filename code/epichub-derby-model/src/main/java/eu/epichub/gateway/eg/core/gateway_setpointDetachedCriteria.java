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

public class gateway_setpointDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression dbID;
	public final LongExpression variableId;
	public final AssociationExpression variable;
	public final StringExpression name;
	public final StringExpression description;
	public final StringExpression value;
	public final LongExpression time;
	
	public gateway_setpointDetachedCriteria() {
		super(eu.epichub.gateway.eg.core.gateway_setpoint.class, eu.epichub.gateway.eg.core.gateway_setpointCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		variableId = new LongExpression("variable.dbID", this.getDetachedCriteria());
		variable = new AssociationExpression("variable", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		value = new StringExpression("value", this.getDetachedCriteria());
		time = new LongExpression("time", this.getDetachedCriteria());
	}
	
	public gateway_setpointDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, eu.epichub.gateway.eg.core.gateway_setpointCriteria.class);
		dbID = new LongExpression("dbID", this.getDetachedCriteria());
		variableId = new LongExpression("variable.dbID", this.getDetachedCriteria());
		variable = new AssociationExpression("variable", this.getDetachedCriteria());
		name = new StringExpression("name", this.getDetachedCriteria());
		description = new StringExpression("description", this.getDetachedCriteria());
		value = new StringExpression("value", this.getDetachedCriteria());
		time = new LongExpression("time", this.getDetachedCriteria());
	}
	
	public gateway_variableDetachedCriteria createVariableCriteria() {
		return new gateway_variableDetachedCriteria(createCriteria("variable"));
	}
	
	public gateway_setpoint uniqueGateway_setpoint(PersistentSession session) {
		return (gateway_setpoint) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public gateway_setpoint[] listGateway_setpoint(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (gateway_setpoint[]) list.toArray(new gateway_setpoint[list.size()]);
	}
}

