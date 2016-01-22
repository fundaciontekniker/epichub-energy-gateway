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

public class gateway_driverDAOImpl implements eu.epichub.gateway.eg.core.dao.gateway_driverDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(gateway_driverDAOImpl.class);
	public gateway_driver loadGateway_driverByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_driverByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("loadGateway_driverByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_driver getGateway_driverByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_driverByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("getGateway_driverByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_driver loadGateway_driverByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_driverByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_driverByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_driver getGateway_driverByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_driverByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_driverByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_driver loadGateway_driverByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_driver) session.load(eu.epichub.gateway.eg.core.gateway_driver.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("loadGateway_driverByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_driver getGateway_driverByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_driver) session.get(eu.epichub.gateway.eg.core.gateway_driver.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("getGateway_driverByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_driver loadGateway_driverByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_driver) session.load(eu.epichub.gateway.eg.core.gateway_driver.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_driverByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_driver getGateway_driverByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_driver) session.get(eu.epichub.gateway.eg.core.gateway_driver.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_driverByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_driver(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_driver(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryGateway_driver(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_driver(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_driver(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryGateway_driver(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_driver[] listGateway_driverByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_driverByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listGateway_driverByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_driver[] listGateway_driverByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_driverByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listGateway_driverByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_driver(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_driver as gateway_driver");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_driverByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_driver(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_driver as gateway_driver");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_driver", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_driverByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_driver[] listGateway_driverByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryGateway_driver(session, condition, orderBy);
			return (gateway_driver[]) list.toArray(new gateway_driver[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_driverByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_driver[] listGateway_driverByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryGateway_driver(session, condition, orderBy, lockMode);
			return (gateway_driver[]) list.toArray(new gateway_driver[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_driverByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_driver loadGateway_driverByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_driverByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadGateway_driverByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_driver loadGateway_driverByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_driverByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_driverByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_driver loadGateway_driverByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		gateway_driver[] gateway_drivers = listGateway_driverByQuery(session, condition, orderBy);
		if (gateway_drivers != null && gateway_drivers.length > 0)
			return gateway_drivers[0];
		else
			return null;
	}
	
	public gateway_driver loadGateway_driverByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		gateway_driver[] gateway_drivers = listGateway_driverByQuery(session, condition, orderBy, lockMode);
		if (gateway_drivers != null && gateway_drivers.length > 0)
			return gateway_drivers[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateGateway_driverByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_driverByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_driverByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_driverByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_driverByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_driverByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_driverByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_driver as gateway_driver");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_driverByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_driverByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_driver as gateway_driver");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_driver", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_driverByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_driver createGateway_driver() {
		return new eu.epichub.gateway.eg.core.gateway_driver();
	}
	
	public boolean save(eu.epichub.gateway.eg.core.gateway_driver lgateway_driver) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().saveObject(lgateway_driver);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(eu.epichub.gateway.eg.core.gateway_driver lgateway_driver)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(eu.epichub.gateway.eg.core.gateway_driver lgateway_driver) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().deleteObject(lgateway_driver);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(eu.epichub.gateway.eg.core.gateway_driver lgateway_driver)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_driver lgateway_driver)throws PersistentException {
		try {
			if(lgateway_driver.getHost() != null) {
				lgateway_driver.getHost().getDrivers().remove(lgateway_driver);
			}
			
			eu.epichub.gateway.eg.core.gateway_device[] lDevicess = (eu.epichub.gateway.eg.core.gateway_device[])lgateway_driver.getDevices().toArray(new eu.epichub.gateway.eg.core.gateway_device[lgateway_driver.getDevices().size()]);
			for(int i = 0; i < lDevicess.length; i++) {
				lDevicess[i].setDriver(null);
			}
			return delete(lgateway_driver);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_driver lgateway_driver, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(lgateway_driver.getHost() != null) {
				lgateway_driver.getHost().getDrivers().remove(lgateway_driver);
			}
			
			eu.epichub.gateway.eg.core.gateway_device[] lDevicess = (eu.epichub.gateway.eg.core.gateway_device[])lgateway_driver.getDevices().toArray(new eu.epichub.gateway.eg.core.gateway_device[lgateway_driver.getDevices().size()]);
			for(int i = 0; i < lDevicess.length; i++) {
				lDevicess[i].setDriver(null);
			}
			try {
				session.delete(lgateway_driver);
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
	
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_driver lgateway_driver) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().refresh(lgateway_driver);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(eu.epichub.gateway.eg.core.gateway_driver lgateway_driver)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(eu.epichub.gateway.eg.core.gateway_driver lgateway_driver) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().evict(lgateway_driver);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(eu.epichub.gateway.eg.core.gateway_driver lgateway_driver)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_driver loadGateway_driverByCriteria(gateway_driverCriteria gateway_driverCriteria) {
		gateway_driver[] gateway_drivers = listGateway_driverByCriteria(gateway_driverCriteria);
		if(gateway_drivers == null || gateway_drivers.length == 0) {
			return null;
		}
		return gateway_drivers[0];
	}
	
	public gateway_driver[] listGateway_driverByCriteria(gateway_driverCriteria gateway_driverCriteria) {
		return gateway_driverCriteria.listGateway_driver();
	}
}
