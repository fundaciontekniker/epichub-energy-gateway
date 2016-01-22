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

public class gateway_setpointCriteria extends AbstractORMCriteria {
	public final LongExpression dbID;
	public final LongExpression variableId;
	public final AssociationExpression variable;
	public final StringExpression name;
	public final StringExpression description;
	public final StringExpression value;
	public final LongExpression time;
	
	public gateway_setpointCriteria(Criteria criteria) {
		super(criteria);
		dbID = new LongExpression("dbID", this);
		variableId = new LongExpression("variable.dbID", this);
		variable = new AssociationExpression("variable", this);
		name = new StringExpression("name", this);
		description = new StringExpression("description", this);
		value = new StringExpression("value", this);
		time = new LongExpression("time", this);
	}
	
	public gateway_setpointCriteria(PersistentSession session) {
		this(session.createCriteria(gateway_setpoint.class));
	}
	
	public gateway_setpointCriteria() throws PersistentException {
		this(eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession());
	}
	
	public gateway_variableCriteria createVariableCriteria() {
		return new gateway_variableCriteria(createCriteria("variable"));
	}
	
	public gateway_setpoint uniqueGateway_setpoint() {
		return (gateway_setpoint) super.uniqueResult();
	}
	
	public gateway_setpoint[] listGateway_setpoint() {
		java.util.List list = super.list();
		return (gateway_setpoint[]) list.toArray(new gateway_setpoint[list.size()]);
	}
}

