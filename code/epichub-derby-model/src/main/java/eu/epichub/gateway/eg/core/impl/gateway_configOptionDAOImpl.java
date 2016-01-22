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

public class gateway_configOptionDAOImpl implements eu.epichub.gateway.eg.core.dao.gateway_configOptionDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(gateway_configOptionDAOImpl.class);
	public gateway_configOption loadGateway_configOptionByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_configOptionByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("loadGateway_configOptionByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_configOption getGateway_configOptionByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_configOptionByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("getGateway_configOptionByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_configOption loadGateway_configOptionByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_configOptionByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_configOptionByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_configOption getGateway_configOptionByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_configOptionByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_configOptionByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_configOption loadGateway_configOptionByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_configOption) session.load(eu.epichub.gateway.eg.core.gateway_configOption.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("loadGateway_configOptionByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_configOption getGateway_configOptionByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_configOption) session.get(eu.epichub.gateway.eg.core.gateway_configOption.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("getGateway_configOptionByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_configOption loadGateway_configOptionByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_configOption) session.load(eu.epichub.gateway.eg.core.gateway_configOption.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_configOptionByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_configOption getGateway_configOptionByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_configOption) session.get(eu.epichub.gateway.eg.core.gateway_configOption.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_configOptionByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_configOption(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_configOption(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryGateway_configOption(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_configOption(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_configOption(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryGateway_configOption(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_configOption[] listGateway_configOptionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_configOptionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listGateway_configOptionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_configOption[] listGateway_configOptionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_configOptionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listGateway_configOptionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_configOption(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_configOption as gateway_configOption");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_configOption(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_configOption as gateway_configOption");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_configOption", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_configOption[] listGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryGateway_configOption(session, condition, orderBy);
			return (gateway_configOption[]) list.toArray(new gateway_configOption[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_configOption[] listGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryGateway_configOption(session, condition, orderBy, lockMode);
			return (gateway_configOption[]) list.toArray(new gateway_configOption[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_configOption loadGateway_configOptionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_configOptionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadGateway_configOptionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_configOption loadGateway_configOptionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_configOptionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_configOptionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_configOption loadGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		gateway_configOption[] gateway_configOptions = listGateway_configOptionByQuery(session, condition, orderBy);
		if (gateway_configOptions != null && gateway_configOptions.length > 0)
			return gateway_configOptions[0];
		else
			return null;
	}
	
	public gateway_configOption loadGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		gateway_configOption[] gateway_configOptions = listGateway_configOptionByQuery(session, condition, orderBy, lockMode);
		if (gateway_configOptions != null && gateway_configOptions.length > 0)
			return gateway_configOptions[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateGateway_configOptionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_configOptionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_configOptionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_configOptionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_configOptionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_configOptionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_configOption as gateway_configOption");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_configOption as gateway_configOption");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_configOption", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_configOption createGateway_configOption() {
		return new eu.epichub.gateway.eg.core.gateway_configOption();
	}
	
	public boolean save(eu.epichub.gateway.eg.core.gateway_configOption lgateway_configOption) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().saveObject(lgateway_configOption);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(eu.epichub.gateway.eg.core.gateway_configOption lgateway_configOption)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(eu.epichub.gateway.eg.core.gateway_configOption lgateway_configOption) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().deleteObject(lgateway_configOption);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(eu.epichub.gateway.eg.core.gateway_configOption lgateway_configOption)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_configOption lgateway_configOption) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().refresh(lgateway_configOption);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(eu.epichub.gateway.eg.core.gateway_configOption lgateway_configOption)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(eu.epichub.gateway.eg.core.gateway_configOption lgateway_configOption) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().evict(lgateway_configOption);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(eu.epichub.gateway.eg.core.gateway_configOption lgateway_configOption)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_configOption loadGateway_configOptionByCriteria(gateway_configOptionCriteria gateway_configOptionCriteria) {
		gateway_configOption[] gateway_configOptions = listGateway_configOptionByCriteria(gateway_configOptionCriteria);
		if(gateway_configOptions == null || gateway_configOptions.length == 0) {
			return null;
		}
		return gateway_configOptions[0];
	}
	
	public gateway_configOption[] listGateway_configOptionByCriteria(gateway_configOptionCriteria gateway_configOptionCriteria) {
		return gateway_configOptionCriteria.listGateway_configOption();
	}
}
