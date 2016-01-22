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
package eu.epichub.gateway.eg.core.dao;

import org.orm.*;
import org.hibernate.LockMode;
import eu.epichub.gateway.eg.core.*;

public interface gateway_subscriptionDAO {
	public gateway_subscription loadGateway_subscriptionByORMID(long dbID) throws PersistentException;
	public gateway_subscription getGateway_subscriptionByORMID(long dbID) throws PersistentException;
	public gateway_subscription loadGateway_subscriptionByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_subscription getGateway_subscriptionByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_subscription loadGateway_subscriptionByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_subscription getGateway_subscriptionByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_subscription loadGateway_subscriptionByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_subscription getGateway_subscriptionByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_subscription[] listGateway_subscriptionByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_subscription[] listGateway_subscriptionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_subscription(String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_subscription(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_subscriptionByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_subscriptionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_subscription[] listGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_subscription[] listGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_subscription(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_subscription(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_subscription loadGateway_subscriptionByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_subscription loadGateway_subscriptionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_subscription loadGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_subscription loadGateway_subscriptionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_subscription createGateway_subscription();
	public boolean save(eu.epichub.gateway.eg.core.gateway_subscription lgateway_subscription) throws PersistentException;
	public boolean delete(eu.epichub.gateway.eg.core.gateway_subscription lgateway_subscription) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_subscription lgateway_subscription) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_subscription lgateway_subscription, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_subscription lgateway_subscription) throws PersistentException;
	public boolean evict(eu.epichub.gateway.eg.core.gateway_subscription lgateway_subscription) throws PersistentException;
	public gateway_subscription loadGateway_subscriptionByCriteria(gateway_subscriptionCriteria gateway_subscriptionCriteria);
	public gateway_subscription[] listGateway_subscriptionByCriteria(gateway_subscriptionCriteria gateway_subscriptionCriteria);
}
