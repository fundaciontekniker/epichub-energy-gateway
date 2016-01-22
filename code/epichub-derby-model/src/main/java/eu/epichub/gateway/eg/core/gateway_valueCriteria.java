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

public class gateway_valueCriteria extends AbstractORMCriteria {
	public final LongExpression dbID;
	public final LongExpression variableId;
	public final AssociationExpression variable;
	public final LongExpression timestamp;
	public final StringExpression value;
	
	public gateway_valueCriteria(Criteria criteria) {
		super(criteria);
		dbID = new LongExpression("dbID", this);
		variableId = new LongExpression("variable.dbID", this);
		variable = new AssociationExpression("variable", this);
		timestamp = new LongExpression("timestamp", this);
		value = new StringExpression("value", this);
	}
	
	public gateway_valueCriteria(PersistentSession session) {
		this(session.createCriteria(gateway_value.class));
	}
	
	public gateway_valueCriteria() throws PersistentException {
		this(eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession());
	}
	
	public gateway_variableCriteria createVariableCriteria() {
		return new gateway_variableCriteria(createCriteria("variable"));
	}
	
	public gateway_value uniqueGateway_value() {
		return (gateway_value) super.uniqueResult();
	}
	
	public gateway_value[] listGateway_value() {
		java.util.List list = super.list();
		return (gateway_value[]) list.toArray(new gateway_value[list.size()]);
	}
}

