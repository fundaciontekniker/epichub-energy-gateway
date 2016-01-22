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

public class gateway_subscriberDAOImpl implements eu.epichub.gateway.eg.core.dao.gateway_subscriberDAO {
	private static final org.apache.log4j.Logger _logger = org.apache.log4j.Logger.getLogger(gateway_subscriberDAOImpl.class);
	public gateway_subscriber loadGateway_subscriberByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_subscriberByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("loadGateway_subscriberByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscriber getGateway_subscriberByORMID(long dbID) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_subscriberByORMID(session, dbID);
		}
		catch (Exception e) {
			_logger.error("getGateway_subscriberByORMID(long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscriber loadGateway_subscriberByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_subscriberByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_subscriberByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscriber getGateway_subscriberByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return getGateway_subscriberByORMID(session, dbID, lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_subscriberByORMID(long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscriber loadGateway_subscriberByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_subscriber) session.load(eu.epichub.gateway.eg.core.gateway_subscriber.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("loadGateway_subscriberByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscriber getGateway_subscriberByORMID(PersistentSession session, long dbID) throws PersistentException {
		try {
			return (gateway_subscriber) session.get(eu.epichub.gateway.eg.core.gateway_subscriber.class, new Long(dbID));
		}
		catch (Exception e) {
			_logger.error("getGateway_subscriberByORMID(PersistentSession session, long dbID)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscriber loadGateway_subscriberByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_subscriber) session.load(eu.epichub.gateway.eg.core.gateway_subscriber.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_subscriberByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscriber getGateway_subscriberByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (gateway_subscriber) session.get(eu.epichub.gateway.eg.core.gateway_subscriber.class, new Long(dbID), lockMode);
		}
		catch (Exception e) {
			_logger.error("getGateway_subscriberByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_subscriber(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_subscriber(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("queryGateway_subscriber(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_subscriber(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return queryGateway_subscriber(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("queryGateway_subscriber(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscriber[] listGateway_subscriberByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_subscriberByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("listGateway_subscriberByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscriber[] listGateway_subscriberByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return listGateway_subscriberByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("listGateway_subscriberByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_subscriber(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_subscriber as gateway_subscriber");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public List queryGateway_subscriber(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_subscriber as gateway_subscriber");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_subscriber", lockMode);
			return query.list();
		}
		catch (Exception e) {
			_logger.error("listGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscriber[] listGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryGateway_subscriber(session, condition, orderBy);
			return (gateway_subscriber[]) list.toArray(new gateway_subscriber[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscriber[] listGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryGateway_subscriber(session, condition, orderBy, lockMode);
			return (gateway_subscriber[]) list.toArray(new gateway_subscriber[list.size()]);
		}
		catch (Exception e) {
			_logger.error("listGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscriber loadGateway_subscriberByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_subscriberByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("loadGateway_subscriberByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscriber loadGateway_subscriberByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return loadGateway_subscriberByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("loadGateway_subscriberByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscriber loadGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		gateway_subscriber[] gateway_subscribers = listGateway_subscriberByQuery(session, condition, orderBy);
		if (gateway_subscribers != null && gateway_subscribers.length > 0)
			return gateway_subscribers[0];
		else
			return null;
	}
	
	public gateway_subscriber loadGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		gateway_subscriber[] gateway_subscribers = listGateway_subscriberByQuery(session, condition, orderBy, lockMode);
		if (gateway_subscribers != null && gateway_subscribers.length > 0)
			return gateway_subscribers[0];
		else
			return null;
	}
	
	public java.util.Iterator iterateGateway_subscriberByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_subscriberByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_subscriberByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_subscriberByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession();
			return iterateGateway_subscriberByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			_logger.error("iterateGateway_subscriberByQuery(String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_subscriber as gateway_subscriber");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public java.util.Iterator iterateGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From eu.epichub.gateway.eg.core.gateway_subscriber as gateway_subscriber");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("gateway_subscriber", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			_logger.error("iterateGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscriber createGateway_subscriber() {
		return new eu.epichub.gateway.eg.core.gateway_subscriber();
	}
	
	public boolean save(eu.epichub.gateway.eg.core.gateway_subscriber lgateway_subscriber) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().saveObject(lgateway_subscriber);
			return true;
		}
		catch (Exception e) {
			_logger.error("save(eu.epichub.gateway.eg.core.gateway_subscriber lgateway_subscriber)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean delete(eu.epichub.gateway.eg.core.gateway_subscriber lgateway_subscriber) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().deleteObject(lgateway_subscriber);
			return true;
		}
		catch (Exception e) {
			_logger.error("delete(eu.epichub.gateway.eg.core.gateway_subscriber lgateway_subscriber)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_subscriber lgateway_subscriber)throws PersistentException {
		try {
			eu.epichub.gateway.eg.core.gateway_subscription[] lSubscriptionss = (eu.epichub.gateway.eg.core.gateway_subscription[])lgateway_subscriber.getSubscriptions().toArray(new eu.epichub.gateway.eg.core.gateway_subscription[lgateway_subscriber.getSubscriptions().size()]);
			for(int i = 0; i < lSubscriptionss.length; i++) {
				lSubscriptionss[i].setSubscriber(null);
			}
			return delete(lgateway_subscriber);
		}
		catch(Exception e) {
			_logger.error("deleteAndDissociate()", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_subscriber lgateway_subscriber, org.orm.PersistentSession session)throws PersistentException {
		try {
			eu.epichub.gateway.eg.core.gateway_subscription[] lSubscriptionss = (eu.epichub.gateway.eg.core.gateway_subscription[])lgateway_subscriber.getSubscriptions().toArray(new eu.epichub.gateway.eg.core.gateway_subscription[lgateway_subscriber.getSubscriptions().size()]);
			for(int i = 0; i < lSubscriptionss.length; i++) {
				lSubscriptionss[i].setSubscriber(null);
			}
			try {
				session.delete(lgateway_subscriber);
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
	
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_subscriber lgateway_subscriber) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().refresh(lgateway_subscriber);
			return true;
		}
		catch (Exception e) {
			_logger.error("refresh(eu.epichub.gateway.eg.core.gateway_subscriber lgateway_subscriber)", e);
			throw new PersistentException(e);
		}
	}
	
	public boolean evict(eu.epichub.gateway.eg.core.gateway_subscriber lgateway_subscriber) throws PersistentException {
		try {
			eu.epichub.gateway.eg.manager.EHReqPersistentManager.instance().getSession().evict(lgateway_subscriber);
			return true;
		}
		catch (Exception e) {
			_logger.error("evict(eu.epichub.gateway.eg.core.gateway_subscriber lgateway_subscriber)", e);
			throw new PersistentException(e);
		}
	}
	
	public gateway_subscriber loadGateway_subscriberByCriteria(gateway_subscriberCriteria gateway_subscriberCriteria) {
		gateway_subscriber[] gateway_subscribers = listGateway_subscriberByCriteria(gateway_subscriberCriteria);
		if(gateway_subscribers == null || gateway_subscribers.length == 0) {
			return null;
		}
		return gateway_subscribers[0];
	}
	
	public gateway_subscriber[] listGateway_subscriberByCriteria(gateway_subscriberCriteria gateway_subscriberCriteria) {
		return gateway_subscriberCriteria.listGateway_subscriber();
	}
}
