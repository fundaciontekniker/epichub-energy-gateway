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
package eu.epichub.gateway.eg.core.impl;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;
import eu.epichub.gateway.eg.core.*;

public class gateway_variableDAOImpl implements eu.epichub.gateway.eg.core.dao.gateway_variableDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(gateway_variableDAOImpl.class);
	public gateway_variable loadGateway_variableByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_variableByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("loadGateway_variableByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_variable getGateway_variableByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_variableByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("getGateway_variableByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_variable loadGateway_variableByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_variableByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_variableByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_variable getGateway_variableByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_variableByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_variableByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_variable loadGateway_variableByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_variable) session.load(eu.epichub.gateway.eg.core.gateway_variable.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("loadGateway_variableByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_variable getGateway_variableByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_variable) session.get(eu.epichub.gateway.eg.core.gateway_variable.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("getGateway_variableByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_variable loadGateway_variableByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_variable) session.load(eu.epichub.gateway.eg.core.gateway_variable.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_variableByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_variable getGateway_variableByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_variable) session.get(eu.epichub.gateway.eg.core.gateway_variable.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_variableByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_variable(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_variable(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryGateway_variable(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_variable(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_variable(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryGateway_variable(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_variable[] listGateway_variableByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_variableByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listGateway_variableByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_variable[] listGateway_variableByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_variableByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listGateway_variableByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_variable(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_variable as gateway_variable");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_variableByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_variable(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_variable as gateway_variable");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_variable", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_variableByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_variable[] listGateway_variableByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryGateway_variable(session, condition, orderBy);
			return (gateway_variable[]) list.toArray(new gateway_variable[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_variableByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_variable[] listGateway_variableByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryGateway_variable(session, condition, orderBy, lockMode);
			return (gateway_variable[]) list.toArray(new gateway_variable[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_variableByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_variable loadGateway_variableByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_variableByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadGateway_variableByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_variable loadGateway_variableByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_variableByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_variableByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_variable loadGateway_variableByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		gateway_variable[] gateway_variables = listGateway_variableByQuery(session, condition, orderBy);
		if (gateway_variables != null && gateway_variables.length > 0)
			return gateway_variables[0];
		else
			return null;
	}
	
	public gateway_variable loadGateway_variableByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		gateway_variable[] gateway_variables = listGateway_variableByQuery(session, condition, orderBy, lockMode);
		if (gateway_variables != null && gateway_variables.length > 0)
			return gateway_variables[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateGateway_variableByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_variableByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_variableByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_variableByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_variableByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_variableByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_variableByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_variable as gateway_variable");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_variableByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_variableByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_variable as gateway_variable");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_variable", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_variableByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_variable createGateway_variable() {
		return new eu.epichub.gateway.eg.core.gateway_variable();
	}
	
	public boolean save(eu.epichub.gateway.eg.core.gateway_variable lgateway_variable) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().saveObject(lgateway_variable);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(eu.epichub.gateway.eg.core.gateway_variable lgateway_variable)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(eu.epichub.gateway.eg.core.gateway_variable lgateway_variable) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().deleteObject(lgateway_variable);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(eu.epichub.gateway.eg.core.gateway_variable lgateway_variable)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_variable lgateway_variable)throws PersistentException {
		try {
			if(lgateway_variable.getDevice() != null) {
				lgateway_variable.getDevice().getVariables().remove(lgateway_variable);
			}
			
			eu.epichub.gateway.eg.core.gateway_subscription[] lSubscriptionss = (eu.epichub.gateway.eg.core.gateway_subscription[])lgateway_variable.getSubscriptions().toArray(new eu.epichub.gateway.eg.core.gateway_subscription[lgateway_variable.getSubscriptions().size()]);
			for(int i = 0; i < lSubscriptionss.length; i++) {
				lSubscriptionss[i].getVariables().remove(lgateway_variable);
			}
			eu.epichub.gateway.eg.core.gateway_value[] lValuess = (eu.epichub.gateway.eg.core.gateway_value[])lgateway_variable.getValues().toArray(new eu.epichub.gateway.eg.core.gateway_value[lgateway_variable.getValues().size()]);
			for(int i = 0; i < lValuess.length; i++) {
				lValuess[i].setVariable(null);
			}
			eu.epichub.gateway.eg.core.gateway_setpoint[] lSetpointss = (eu.epichub.gateway.eg.core.gateway_setpoint[])lgateway_variable.getSetpoints().toArray(new eu.epichub.gateway.eg.core.gateway_setpoint[lgateway_variable.getSetpoints().size()]);
			for(int i = 0; i < lSetpointss.length; i++) {
				lSetpointss[i].setVariable(null);
			}
			return delete(lgateway_variable);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_variable lgateway_variable, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(lgateway_variable.getDevice() != null) {
				lgateway_variable.getDevice().getVariables().remove(lgateway_variable);
			}
			
			eu.epichub.gateway.eg.core.gateway_subscription[] lSubscriptionss = (eu.epichub.gateway.eg.core.gateway_subscription[])lgateway_variable.getSubscriptions().toArray(new eu.epichub.gateway.eg.core.gateway_subscription[lgateway_variable.getSubscriptions().size()]);
			for(int i = 0; i < lSubscriptionss.length; i++) {
				lSubscriptionss[i].getVariables().remove(lgateway_variable);
			}
			eu.epichub.gateway.eg.core.gateway_value[] lValuess = (eu.epichub.gateway.eg.core.gateway_value[])lgateway_variable.getValues().toArray(new eu.epichub.gateway.eg.core.gateway_value[lgateway_variable.getValues().size()]);
			for(int i = 0; i < lValuess.length; i++) {
				lValuess[i].setVariable(null);
			}
			eu.epichub.gateway.eg.core.gateway_setpoint[] lSetpointss = (eu.epichub.gateway.eg.core.gateway_setpoint[])lgateway_variable.getSetpoints().toArray(new eu.epichub.gateway.eg.core.gateway_setpoint[lgateway_variable.getSetpoints().size()]);
			for(int i = 0; i < lSetpointss.length; i++) {
				lSetpointss[i].setVariable(null);
			}
			try {
				session.delete(lgateway_variable);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_variable lgateway_variable) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().refresh(lgateway_variable);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(eu.epichub.gateway.eg.core.gateway_variable lgateway_variable)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(eu.epichub.gateway.eg.core.gateway_variable lgateway_variable) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().evict(lgateway_variable);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(eu.epichub.gateway.eg.core.gateway_variable lgateway_variable)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_variable loadGateway_variableByCriteria(gateway_variableCriteria gateway_variableCriteria) {
		gateway_variable[] gateway_variables = listGateway_variableByCriteria(gateway_variableCriteria);
		if(gateway_variables == null || gateway_variables.length == 0) {
			return null;
		}
		return gateway_variables[0];
	}
	
	public gateway_variable[] listGateway_variableByCriteria(gateway_variableCriteria gateway_variableCriteria) {
		return gateway_variableCriteria.listGateway_variable();
	}
}
