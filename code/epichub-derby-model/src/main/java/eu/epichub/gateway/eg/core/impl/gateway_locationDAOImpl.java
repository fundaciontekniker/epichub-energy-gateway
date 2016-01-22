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

public class gateway_locationDAOImpl implements eu.epichub.gateway.eg.core.dao.gateway_locationDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(gateway_locationDAOImpl.class);
	public gateway_location loadGateway_locationByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_locationByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("loadGateway_locationByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_location getGateway_locationByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_locationByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("getGateway_locationByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_location loadGateway_locationByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_locationByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_locationByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_location getGateway_locationByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_locationByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_locationByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_location loadGateway_locationByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_location) session.load(eu.epichub.gateway.eg.core.gateway_location.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("loadGateway_locationByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_location getGateway_locationByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_location) session.get(eu.epichub.gateway.eg.core.gateway_location.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("getGateway_locationByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_location loadGateway_locationByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_location) session.load(eu.epichub.gateway.eg.core.gateway_location.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_locationByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_location getGateway_locationByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_location) session.get(eu.epichub.gateway.eg.core.gateway_location.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_locationByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_location(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_location(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryGateway_location(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_location(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_location(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryGateway_location(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_location[] listGateway_locationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_locationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listGateway_locationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_location[] listGateway_locationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_locationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listGateway_locationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_location(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_location as gateway_location");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_locationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_location(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_location as gateway_location");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_location", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_locationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_location[] listGateway_locationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryGateway_location(session, condition, orderBy);
			return (gateway_location[]) list.toArray(new gateway_location[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_locationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_location[] listGateway_locationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryGateway_location(session, condition, orderBy, lockMode);
			return (gateway_location[]) list.toArray(new gateway_location[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_locationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_location loadGateway_locationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_locationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadGateway_locationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_location loadGateway_locationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_locationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_locationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_location loadGateway_locationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		gateway_location[] gateway_locations = listGateway_locationByQuery(session, condition, orderBy);
		if (gateway_locations != null && gateway_locations.length > 0)
			return gateway_locations[0];
		else
			return null;
	}
	
	public gateway_location loadGateway_locationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		gateway_location[] gateway_locations = listGateway_locationByQuery(session, condition, orderBy, lockMode);
		if (gateway_locations != null && gateway_locations.length > 0)
			return gateway_locations[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateGateway_locationByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_locationByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_locationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_locationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_locationByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_locationByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_locationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_location as gateway_location");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_locationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_locationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_location as gateway_location");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_location", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_locationByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_location createGateway_location() {
		return new eu.epichub.gateway.eg.core.gateway_location();
	}
	
	public boolean save(eu.epichub.gateway.eg.core.gateway_location lgateway_location) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().saveObject(lgateway_location);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(eu.epichub.gateway.eg.core.gateway_location lgateway_location)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(eu.epichub.gateway.eg.core.gateway_location lgateway_location) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().deleteObject(lgateway_location);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(eu.epichub.gateway.eg.core.gateway_location lgateway_location)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_location lgateway_location)throws PersistentException {
		try {
			if(lgateway_location.getHost() != null) {
				lgateway_location.getHost().setLocation(null);
			}
			
			if(lgateway_location.getDevice() != null) {
				lgateway_location.getDevice().setLocation(null);
			}
			
			return delete(lgateway_location);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_location lgateway_location, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(lgateway_location.getHost() != null) {
				lgateway_location.getHost().setLocation(null);
			}
			
			if(lgateway_location.getDevice() != null) {
				lgateway_location.getDevice().setLocation(null);
			}
			
			try {
				session.delete(lgateway_location);
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
	
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_location lgateway_location) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().refresh(lgateway_location);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(eu.epichub.gateway.eg.core.gateway_location lgateway_location)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(eu.epichub.gateway.eg.core.gateway_location lgateway_location) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().evict(lgateway_location);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(eu.epichub.gateway.eg.core.gateway_location lgateway_location)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_location loadGateway_locationByCriteria(gateway_locationCriteria gateway_locationCriteria) {
		gateway_location[] gateway_locations = listGateway_locationByCriteria(gateway_locationCriteria);
		if(gateway_locations == null || gateway_locations.length == 0) {
			return null;
		}
		return gateway_locations[0];
	}
	
	public gateway_location[] listGateway_locationByCriteria(gateway_locationCriteria gateway_locationCriteria) {
		return gateway_locationCriteria.listGateway_location();
	}
}
