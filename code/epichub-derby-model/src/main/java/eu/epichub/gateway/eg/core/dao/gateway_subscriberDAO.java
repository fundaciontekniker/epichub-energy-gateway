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

public interface gateway_subscriberDAO {
	public gateway_subscriber loadGateway_subscriberByORMID(long dbID) throws PersistentException;
	public gateway_subscriber getGateway_subscriberByORMID(long dbID) throws PersistentException;
	public gateway_subscriber loadGateway_subscriberByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_subscriber getGateway_subscriberByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_subscriber loadGateway_subscriberByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_subscriber getGateway_subscriberByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_subscriber loadGateway_subscriberByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_subscriber getGateway_subscriberByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_subscriber[] listGateway_subscriberByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_subscriber[] listGateway_subscriberByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_subscriber(String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_subscriber(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_subscriberByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_subscriberByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_subscriber[] listGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_subscriber[] listGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_subscriber(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_subscriber(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_subscriber loadGateway_subscriberByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_subscriber loadGateway_subscriberByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_subscriber loadGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_subscriber loadGateway_subscriberByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_subscriber createGateway_subscriber();
	public boolean save(eu.epichub.gateway.eg.core.gateway_subscriber lgateway_subscriber) throws PersistentException;
	public boolean delete(eu.epichub.gateway.eg.core.gateway_subscriber lgateway_subscriber) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_subscriber lgateway_subscriber) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_subscriber lgateway_subscriber, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_subscriber lgateway_subscriber) throws PersistentException;
	public boolean evict(eu.epichub.gateway.eg.core.gateway_subscriber lgateway_subscriber) throws PersistentException;
	public gateway_subscriber loadGateway_subscriberByCriteria(gateway_subscriberCriteria gateway_subscriberCriteria);
	public gateway_subscriber[] listGateway_subscriberByCriteria(gateway_subscriberCriteria gateway_subscriberCriteria);
}
