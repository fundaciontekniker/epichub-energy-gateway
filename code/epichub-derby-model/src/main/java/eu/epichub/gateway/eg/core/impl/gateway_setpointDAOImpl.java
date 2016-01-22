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

public class gateway_setpointDAOImpl implements eu.epichub.gateway.eg.core.dao.gateway_setpointDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(gateway_setpointDAOImpl.class);
	public gateway_setpoint loadGateway_setpointByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_setpointByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("loadGateway_setpointByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_setpoint getGateway_setpointByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_setpointByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("getGateway_setpointByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_setpoint loadGateway_setpointByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_setpointByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_setpointByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_setpoint getGateway_setpointByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_setpointByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_setpointByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_setpoint loadGateway_setpointByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_setpoint) session.load(eu.epichub.gateway.eg.core.gateway_setpoint.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("loadGateway_setpointByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_setpoint getGateway_setpointByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_setpoint) session.get(eu.epichub.gateway.eg.core.gateway_setpoint.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("getGateway_setpointByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_setpoint loadGateway_setpointByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_setpoint) session.load(eu.epichub.gateway.eg.core.gateway_setpoint.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_setpointByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_setpoint getGateway_setpointByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_setpoint) session.get(eu.epichub.gateway.eg.core.gateway_setpoint.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_setpointByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_setpoint(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_setpoint(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryGateway_setpoint(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_setpoint(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_setpoint(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryGateway_setpoint(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_setpoint[] listGateway_setpointByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_setpointByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listGateway_setpointByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_setpoint[] listGateway_setpointByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_setpointByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listGateway_setpointByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_setpoint(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_setpoint as gateway_setpoint");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_setpointByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_setpoint(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_setpoint as gateway_setpoint");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_setpoint", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_setpointByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_setpoint[] listGateway_setpointByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryGateway_setpoint(session, condition, orderBy);
			return (gateway_setpoint[]) list.toArray(new gateway_setpoint[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_setpointByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_setpoint[] listGateway_setpointByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryGateway_setpoint(session, condition, orderBy, lockMode);
			return (gateway_setpoint[]) list.toArray(new gateway_setpoint[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_setpointByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_setpoint loadGateway_setpointByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_setpointByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadGateway_setpointByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_setpoint loadGateway_setpointByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_setpointByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_setpointByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_setpoint loadGateway_setpointByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		gateway_setpoint[] gateway_setpoints = listGateway_setpointByQuery(session, condition, orderBy);
		if (gateway_setpoints != null && gateway_setpoints.length > 0)
			return gateway_setpoints[0];
		else
			return null;
	}
	
	public gateway_setpoint loadGateway_setpointByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		gateway_setpoint[] gateway_setpoints = listGateway_setpointByQuery(session, condition, orderBy, lockMode);
		if (gateway_setpoints != null && gateway_setpoints.length > 0)
			return gateway_setpoints[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateGateway_setpointByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_setpointByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_setpointByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_setpointByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_setpointByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_setpointByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_setpointByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_setpoint as gateway_setpoint");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_setpointByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_setpointByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_setpoint as gateway_setpoint");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_setpoint", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_setpointByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_setpoint createGateway_setpoint() {
		return new eu.epichub.gateway.eg.core.gateway_setpoint();
	}
	
	public boolean save(eu.epichub.gateway.eg.core.gateway_setpoint lgateway_setpoint) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().saveObject(lgateway_setpoint);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(eu.epichub.gateway.eg.core.gateway_setpoint lgateway_setpoint)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(eu.epichub.gateway.eg.core.gateway_setpoint lgateway_setpoint) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().deleteObject(lgateway_setpoint);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(eu.epichub.gateway.eg.core.gateway_setpoint lgateway_setpoint)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_setpoint lgateway_setpoint)throws PersistentException {
		try {
			if(lgateway_setpoint.getVariable() != null) {
				lgateway_setpoint.getVariable().getSetpoints().remove(lgateway_setpoint);
			}
			
			return delete(lgateway_setpoint);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_setpoint lgateway_setpoint, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(lgateway_setpoint.getVariable() != null) {
				lgateway_setpoint.getVariable().getSetpoints().remove(lgateway_setpoint);
			}
			
			try {
				session.delete(lgateway_setpoint);
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
	
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_setpoint lgateway_setpoint) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().refresh(lgateway_setpoint);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(eu.epichub.gateway.eg.core.gateway_setpoint lgateway_setpoint)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(eu.epichub.gateway.eg.core.gateway_setpoint lgateway_setpoint) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().evict(lgateway_setpoint);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(eu.epichub.gateway.eg.core.gateway_setpoint lgateway_setpoint)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_setpoint loadGateway_setpointByCriteria(gateway_setpointCriteria gateway_setpointCriteria) {
		gateway_setpoint[] gateway_setpoints = listGateway_setpointByCriteria(gateway_setpointCriteria);
		if(gateway_setpoints == null || gateway_setpoints.length == 0) {
			return null;
		}
		return gateway_setpoints[0];
	}
	
	public gateway_setpoint[] listGateway_setpointByCriteria(gateway_setpointCriteria gateway_setpointCriteria) {
		return gateway_setpointCriteria.listGateway_setpoint();
	}
}
