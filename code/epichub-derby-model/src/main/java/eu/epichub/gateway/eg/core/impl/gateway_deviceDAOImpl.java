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

public class gateway_deviceDAOImpl implements eu.epichub.gateway.eg.core.dao.gateway_deviceDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(gateway_deviceDAOImpl.class);
	public gateway_device loadGateway_deviceByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_deviceByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("loadGateway_deviceByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_device getGateway_deviceByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_deviceByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("getGateway_deviceByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_device loadGateway_deviceByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_deviceByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_deviceByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_device getGateway_deviceByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_deviceByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_deviceByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_device loadGateway_deviceByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_device) session.load(eu.epichub.gateway.eg.core.gateway_device.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("loadGateway_deviceByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_device getGateway_deviceByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_device) session.get(eu.epichub.gateway.eg.core.gateway_device.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("getGateway_deviceByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_device loadGateway_deviceByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_device) session.load(eu.epichub.gateway.eg.core.gateway_device.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_deviceByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_device getGateway_deviceByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_device) session.get(eu.epichub.gateway.eg.core.gateway_device.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_deviceByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_device(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_device(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryGateway_device(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_device(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_device(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryGateway_device(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_device[] listGateway_deviceByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_deviceByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listGateway_deviceByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_device[] listGateway_deviceByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_deviceByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listGateway_deviceByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_device(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_device as gateway_device");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_deviceByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_device(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_device as gateway_device");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_device", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_deviceByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_device[] listGateway_deviceByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryGateway_device(session, condition, orderBy);
			return (gateway_device[]) list.toArray(new gateway_device[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_deviceByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_device[] listGateway_deviceByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryGateway_device(session, condition, orderBy, lockMode);
			return (gateway_device[]) list.toArray(new gateway_device[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_deviceByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_device loadGateway_deviceByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_deviceByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadGateway_deviceByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_device loadGateway_deviceByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_deviceByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_deviceByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_device loadGateway_deviceByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		gateway_device[] gateway_devices = listGateway_deviceByQuery(session, condition, orderBy);
		if (gateway_devices != null && gateway_devices.length > 0)
			return gateway_devices[0];
		else
			return null;
	}
	
	public gateway_device loadGateway_deviceByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		gateway_device[] gateway_devices = listGateway_deviceByQuery(session, condition, orderBy, lockMode);
		if (gateway_devices != null && gateway_devices.length > 0)
			return gateway_devices[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateGateway_deviceByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_deviceByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_deviceByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_deviceByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_deviceByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_deviceByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_deviceByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_device as gateway_device");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_deviceByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_deviceByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_device as gateway_device");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_device", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_deviceByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_device createGateway_device() {
		return new eu.epichub.gateway.eg.core.gateway_device();
	}
	
	public boolean save(eu.epichub.gateway.eg.core.gateway_device lgateway_device) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().saveObject(lgateway_device);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(eu.epichub.gateway.eg.core.gateway_device lgateway_device)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(eu.epichub.gateway.eg.core.gateway_device lgateway_device) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().deleteObject(lgateway_device);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(eu.epichub.gateway.eg.core.gateway_device lgateway_device)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_device lgateway_device)throws PersistentException {
		try {
			if(lgateway_device.getLocation() != null) {
				lgateway_device.getLocation().setDevice(null);
			}
			
			if(lgateway_device.getDriver() != null) {
				lgateway_device.getDriver().getDevices().remove(lgateway_device);
			}
			
			eu.epichub.gateway.eg.core.gateway_variable[] lVariabless = (eu.epichub.gateway.eg.core.gateway_variable[])lgateway_device.getVariables().toArray(new eu.epichub.gateway.eg.core.gateway_variable[lgateway_device.getVariables().size()]);
			for(int i = 0; i < lVariabless.length; i++) {
				lVariabless[i].setDevice(null);
			}
			return delete(lgateway_device);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_device lgateway_device, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(lgateway_device.getLocation() != null) {
				lgateway_device.getLocation().setDevice(null);
			}
			
			if(lgateway_device.getDriver() != null) {
				lgateway_device.getDriver().getDevices().remove(lgateway_device);
			}
			
			eu.epichub.gateway.eg.core.gateway_variable[] lVariabless = (eu.epichub.gateway.eg.core.gateway_variable[])lgateway_device.getVariables().toArray(new eu.epichub.gateway.eg.core.gateway_variable[lgateway_device.getVariables().size()]);
			for(int i = 0; i < lVariabless.length; i++) {
				lVariabless[i].setDevice(null);
			}
			try {
				session.delete(lgateway_device);
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
	
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_device lgateway_device) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().refresh(lgateway_device);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(eu.epichub.gateway.eg.core.gateway_device lgateway_device)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(eu.epichub.gateway.eg.core.gateway_device lgateway_device) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().evict(lgateway_device);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(eu.epichub.gateway.eg.core.gateway_device lgateway_device)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_device loadGateway_deviceByCriteria(gateway_deviceCriteria gateway_deviceCriteria) {
		gateway_device[] gateway_devices = listGateway_deviceByCriteria(gateway_deviceCriteria);
		if(gateway_devices == null || gateway_devices.length == 0) {
			return null;
		}
		return gateway_devices[0];
	}
	
	public gateway_device[] listGateway_deviceByCriteria(gateway_deviceCriteria gateway_deviceCriteria) {
		return gateway_deviceCriteria.listGateway_device();
	}
}
