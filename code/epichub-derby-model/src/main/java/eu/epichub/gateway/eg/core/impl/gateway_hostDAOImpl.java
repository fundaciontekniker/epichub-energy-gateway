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

public class gateway_hostDAOImpl implements eu.epichub.gateway.eg.core.dao.gateway_hostDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(gateway_hostDAOImpl.class);
	public gateway_host loadGateway_hostByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_hostByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("loadGateway_hostByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_host getGateway_hostByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_hostByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("getGateway_hostByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_host loadGateway_hostByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_hostByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_hostByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_host getGateway_hostByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_hostByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_hostByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_host loadGateway_hostByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_host) session.load(eu.epichub.gateway.eg.core.gateway_host.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("loadGateway_hostByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_host getGateway_hostByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_host) session.get(eu.epichub.gateway.eg.core.gateway_host.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("getGateway_hostByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_host loadGateway_hostByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_host) session.load(eu.epichub.gateway.eg.core.gateway_host.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_hostByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_host getGateway_hostByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_host) session.get(eu.epichub.gateway.eg.core.gateway_host.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_hostByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_host(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_host(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryGateway_host(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_host(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_host(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryGateway_host(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_host[] listGateway_hostByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_hostByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listGateway_hostByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_host[] listGateway_hostByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_hostByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listGateway_hostByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_host(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_host as gateway_host");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_hostByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_host(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_host as gateway_host");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_host", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_hostByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_host[] listGateway_hostByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryGateway_host(session, condition, orderBy);
			return (gateway_host[]) list.toArray(new gateway_host[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_hostByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_host[] listGateway_hostByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryGateway_host(session, condition, orderBy, lockMode);
			return (gateway_host[]) list.toArray(new gateway_host[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_hostByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_host loadGateway_hostByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_hostByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadGateway_hostByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_host loadGateway_hostByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_hostByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_hostByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_host loadGateway_hostByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		gateway_host[] gateway_hosts = listGateway_hostByQuery(session, condition, orderBy);
		if (gateway_hosts != null && gateway_hosts.length > 0)
			return gateway_hosts[0];
		else
			return null;
	}
	
	public gateway_host loadGateway_hostByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		gateway_host[] gateway_hosts = listGateway_hostByQuery(session, condition, orderBy, lockMode);
		if (gateway_hosts != null && gateway_hosts.length > 0)
			return gateway_hosts[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateGateway_hostByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_hostByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_hostByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_hostByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_hostByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_hostByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_hostByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_host as gateway_host");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_hostByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_hostByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_host as gateway_host");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_host", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_hostByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_host createGateway_host() {
		return new eu.epichub.gateway.eg.core.gateway_host();
	}
	
	public boolean save(eu.epichub.gateway.eg.core.gateway_host lgateway_host) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().saveObject(lgateway_host);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(eu.epichub.gateway.eg.core.gateway_host lgateway_host)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(eu.epichub.gateway.eg.core.gateway_host lgateway_host) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().deleteObject(lgateway_host);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(eu.epichub.gateway.eg.core.gateway_host lgateway_host)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_host lgateway_host)throws PersistentException {
		try {
			if(lgateway_host.getLocation() != null) {
				lgateway_host.getLocation().setHost(null);
			}
			
			eu.epichub.gateway.eg.core.gateway_driver[] lDriverss = (eu.epichub.gateway.eg.core.gateway_driver[])lgateway_host.getDrivers().toArray(new eu.epichub.gateway.eg.core.gateway_driver[lgateway_host.getDrivers().size()]);
			for(int i = 0; i < lDriverss.length; i++) {
				lDriverss[i].setHost(null);
			}
			return delete(lgateway_host);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_host lgateway_host, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(lgateway_host.getLocation() != null) {
				lgateway_host.getLocation().setHost(null);
			}
			
			eu.epichub.gateway.eg.core.gateway_driver[] lDriverss = (eu.epichub.gateway.eg.core.gateway_driver[])lgateway_host.getDrivers().toArray(new eu.epichub.gateway.eg.core.gateway_driver[lgateway_host.getDrivers().size()]);
			for(int i = 0; i < lDriverss.length; i++) {
				lDriverss[i].setHost(null);
			}
			try {
				session.delete(lgateway_host);
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
	
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_host lgateway_host) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().refresh(lgateway_host);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(eu.epichub.gateway.eg.core.gateway_host lgateway_host)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(eu.epichub.gateway.eg.core.gateway_host lgateway_host) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().evict(lgateway_host);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(eu.epichub.gateway.eg.core.gateway_host lgateway_host)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_host loadGateway_hostByCriteria(gateway_hostCriteria gateway_hostCriteria) {
		gateway_host[] gateway_hosts = listGateway_hostByCriteria(gateway_hostCriteria);
		if(gateway_hosts == null || gateway_hosts.length == 0) {
			return null;
		}
		return gateway_hosts[0];
	}
	
	public gateway_host[] listGateway_hostByCriteria(gateway_hostCriteria gateway_hostCriteria) {
		return gateway_hostCriteria.listGateway_host();
	}
}
