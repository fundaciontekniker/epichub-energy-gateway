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

public class gateway_subscriptionDAOImpl implements eu.epichub.gateway.eg.core.dao.gateway_subscriptionDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(gateway_subscriptionDAOImpl.class);
	public gateway_subscription loadGateway_subscriptionByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_subscriptionByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("loadGateway_subscriptionByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscription getGateway_subscriptionByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_subscriptionByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("getGateway_subscriptionByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscription loadGateway_subscriptionByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_subscriptionByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_subscriptionByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscription getGateway_subscriptionByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_subscriptionByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_subscriptionByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscription loadGateway_subscriptionByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_subscription) session.load(eu.epichub.gateway.eg.core.gateway_subscription.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("loadGateway_subscriptionByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscription getGateway_subscriptionByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_subscription) session.get(eu.epichub.gateway.eg.core.gateway_subscription.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("getGateway_subscriptionByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscription loadGateway_subscriptionByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_subscription) session.load(eu.epichub.gateway.eg.core.gateway_subscription.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_subscriptionByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscription getGateway_subscriptionByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_subscription) session.get(eu.epichub.gateway.eg.core.gateway_subscription.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_subscriptionByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_subscription(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_subscription(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryGateway_subscription(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_subscription(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_subscription(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryGateway_subscription(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscription[] listGateway_subscriptionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_subscriptionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listGateway_subscriptionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscription[] listGateway_subscriptionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_subscriptionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listGateway_subscriptionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_subscription(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_subscription as gateway_subscription");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_subscription(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_subscription as gateway_subscription");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_subscription", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscription[] listGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryGateway_subscription(session, condition, orderBy);
			return (gateway_subscription[]) list.toArray(new gateway_subscription[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscription[] listGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryGateway_subscription(session, condition, orderBy, lockMode);
			return (gateway_subscription[]) list.toArray(new gateway_subscription[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscription loadGateway_subscriptionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_subscriptionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadGateway_subscriptionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscription loadGateway_subscriptionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_subscriptionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_subscriptionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscription loadGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		gateway_subscription[] gateway_subscriptions = listGateway_subscriptionByQuery(session, condition, orderBy);
		if (gateway_subscriptions != null && gateway_subscriptions.length > 0)
			return gateway_subscriptions[0];
		else
			return null;
	}
	
	public gateway_subscription loadGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		gateway_subscription[] gateway_subscriptions = listGateway_subscriptionByQuery(session, condition, orderBy, lockMode);
		if (gateway_subscriptions != null && gateway_subscriptions.length > 0)
			return gateway_subscriptions[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateGateway_subscriptionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_subscriptionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_subscriptionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_subscriptionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_subscriptionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_subscriptionByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_subscription as gateway_subscription");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_subscription as gateway_subscription");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_subscription", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscription createGateway_subscription() {
		return new eu.epichub.gateway.eg.core.gateway_subscription();
	}
	
	public boolean save(eu.epichub.gateway.eg.core.gateway_subscription lgateway_subscription) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().saveObject(lgateway_subscription);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(eu.epichub.gateway.eg.core.gateway_subscription lgateway_subscription)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(eu.epichub.gateway.eg.core.gateway_subscription lgateway_subscription) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().deleteObject(lgateway_subscription);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(eu.epichub.gateway.eg.core.gateway_subscription lgateway_subscription)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_subscription lgateway_subscription)throws PersistentException {
		try {
			if(lgateway_subscription.getSubscriber() != null) {
				lgateway_subscription.getSubscriber().getSubscriptions().remove(lgateway_subscription);
			}
			
			eu.epichub.gateway.eg.core.gateway_variable[] lVariabless = (eu.epichub.gateway.eg.core.gateway_variable[])lgateway_subscription.getVariables().toArray(new eu.epichub.gateway.eg.core.gateway_variable[lgateway_subscription.getVariables().size()]);
			for(int i = 0; i < lVariabless.length; i++) {
				lVariabless[i].getSubscriptions().remove(lgateway_subscription);
			}
			return delete(lgateway_subscription);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_subscription lgateway_subscription, org.orm.PersistentSession session)throws PersistentException {
		try {
			if(lgateway_subscription.getSubscriber() != null) {
				lgateway_subscription.getSubscriber().getSubscriptions().remove(lgateway_subscription);
			}
			
			eu.epichub.gateway.eg.core.gateway_variable[] lVariabless = (eu.epichub.gateway.eg.core.gateway_variable[])lgateway_subscription.getVariables().toArray(new eu.epichub.gateway.eg.core.gateway_variable[lgateway_subscription.getVariables().size()]);
			for(int i = 0; i < lVariabless.length; i++) {
				lVariabless[i].getSubscriptions().remove(lgateway_subscription);
			}
			try {
				session.delete(lgateway_subscription);
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
	
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_subscription lgateway_subscription) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().refresh(lgateway_subscription);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(eu.epichub.gateway.eg.core.gateway_subscription lgateway_subscription)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(eu.epichub.gateway.eg.core.gateway_subscription lgateway_subscription) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().evict(lgateway_subscription);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(eu.epichub.gateway.eg.core.gateway_subscription lgateway_subscription)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscription loadGateway_subscriptionByCriteria(gateway_subscriptionCriteria gateway_subscriptionCriteria) {
		gateway_subscription[] gateway_subscriptions = listGateway_subscriptionByCriteria(gateway_subscriptionCriteria);
		if(gateway_subscriptions == null || gateway_subscriptions.length == 0) {
			return null;
		}
		return gateway_subscriptions[0];
	}
	
	public gateway_subscription[] listGateway_subscriptionByCriteria(gateway_subscriptionCriteria gateway_subscriptionCriteria) {
		return gateway_subscriptionCriteria.listGateway_subscription();
	}
}
