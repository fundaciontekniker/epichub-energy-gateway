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

public class gateway_configOptionCriteria extends AbstractORMCriteria {
	public final LongExpression dbID;
	public final StringExpression parameter;
	public final StringExpression type;
	public final StringExpression value;
	
	public gateway_configOptionCriteria(Criteria criteria) {
		super(criteria);
		dbID = new LongExpression("dbID", this);
		parameter = new StringExpression("parameter", this);
		type = new StringExpression("type", this);
		value = new StringExpression("value", this);
	}
	
	public gateway_configOptionCriteria(PersistentSession session) {
		this(session.createCriteria(gateway_configOption.class));
	}
	
	public gateway_configOptionCriteria() throws PersistentException {
		this(eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession());
	}
	
	public gateway_configOption uniqueGateway_configOption() {
		return (gateway_configOption) super.uniqueResult();
	}
	
	public gateway_configOption[] listGateway_configOption() {
		java.util.List list = super.list();
		return (gateway_configOption[]) list.toArray(new gateway_configOption[list.size()]);
	}
}

