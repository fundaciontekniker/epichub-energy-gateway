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

public class gateway_valueDAOImpl implements eu.epichub.gateway.eg.core.dao.gateway_valueDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(gateway_valueDAOImpl.class);
	public gateway_value loadGateway_valueByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_valueByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("loadGateway_valueByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_value getGateway_valueByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_valueByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("getGateway_valueByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_value loadGateway_valueByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_valueByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_valueByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_value getGateway_valueByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_valueByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_valueByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_value loadGateway_valueByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_value) session.load(eu.epichub.gateway.eg.core.gateway_value.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("loadGateway_valueByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_value getGateway_valueByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_value) session.get(eu.epichub.gateway.eg.core.gateway_value.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("getGateway_valueByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_value loadGateway_valueByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_value) session.load(eu.epichub.gateway.eg.core.gateway_value.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_valueByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_value getGateway_valueByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_value) session.get(eu.epichub.gateway.eg.core.gateway_value.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_valueByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_value(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_value(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryGateway_value(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_value(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_value(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryGateway_value(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_value[] listGateway_valueByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_valueByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listGateway_valueByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_value[] listGateway_valueByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_valueByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listGateway_valueByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_value(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_value as gateway_value");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_valueByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_value(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_value as gateway_value");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_value", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_valueByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_value[] listGateway_valueByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryGateway_value(session, condition, orderBy);
			return (gateway_value[]) list.toArray(new gateway_value[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_valueByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_value[] listGateway_valueByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryGateway_value(session, condition, orderBy, lockMode);
			return (gateway_value[]) list.toArray(new gateway_value[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_valueByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_value loadGateway_valueByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_valueByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadGateway_valueByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_value loadGateway_valueByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_valueByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_valueByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_value loadGateway_valueByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		gateway_value[] gateway_values = listGateway_valueByQuery(session, condition, orderBy);
		if (gateway_values != null && gateway_values.length > 0)
			return gateway_values[0];
		else
			return null;
	}
	
	public gateway_value loadGateway_valueByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		gateway_value[] gateway_values = listGateway_valueByQuery(session, condition, orderBy, lockMode);
		if (gateway_values != null && gateway_values.length > 0)
			return gateway_values[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateGateway_valueByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_valueByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_valueByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_valueByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_valueByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_valueByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_valueByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_value as gateway_value");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_valueByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_valueByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_value as gateway_value");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_value", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_valueByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_value createGateway_value() {
		return new eu.epichub.gateway.eg.core.gateway_value();
	}
	
	public boolean save(eu.epichub.gateway.eg.core.gateway_value lgateway_value) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().saveObject(lgateway_value);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(eu.epichub.gateway.eg.core.gateway_value lgateway_value)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(eu.epichub.gateway.eg.core.gateway_value lgateway_value) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().deleteObject(lgateway_value);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(eu.epichub.gateway.eg.core.gateway_value lgateway_value)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_value lgateway_value)throws PersistentException {
		try {
			if(lgateway_value.getVariable() != null) {
				lgateway_value.getVariable().getValues().remove(lgateway_value);
			}
			
			return delete(lgateway_value);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_value lgateway_value, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(lgateway_value.getVariable() != null) {
				lgateway_value.getVariable().getValues().remove(lgateway_value);
			}
			
			try {
				session.delete(lgateway_value);
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
	
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_value lgateway_value) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().refresh(lgateway_value);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(eu.epichub.gateway.eg.core.gateway_value lgateway_value)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(eu.epichub.gateway.eg.core.gateway_value lgateway_value) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().evict(lgateway_value);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(eu.epichub.gateway.eg.core.gateway_value lgateway_value)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_value loadGateway_valueByCriteria(gateway_valueCriteria gateway_valueCriteria) {
		gateway_value[] gateway_values = listGateway_valueByCriteria(gateway_valueCriteria);
		if(gateway_values == null || gateway_values.length == 0) {
			return null;
		}
		return gateway_values[0];
	}
	
	public gateway_value[] listGateway_valueByCriteria(gateway_valueCriteria gateway_valueCriteria) {
		return gateway_valueCriteria.listGateway_value();
	}
}
