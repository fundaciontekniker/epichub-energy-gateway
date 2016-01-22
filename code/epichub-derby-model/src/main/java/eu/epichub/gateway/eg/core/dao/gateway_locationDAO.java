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

public interface gateway_locationDAO {
	public gateway_location loadGateway_locationByORMID(long dbID) throws PersistentException;
	public gateway_location getGateway_locationByORMID(long dbID) throws PersistentException;
	public gateway_location loadGateway_locationByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_location getGateway_locationByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_location loadGateway_locationByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_location getGateway_locationByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_location loadGateway_locationByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_location getGateway_locationByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_location[] listGateway_locationByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_location[] listGateway_locationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_location(String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_location(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_locationByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_locationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_location[] listGateway_locationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_location[] listGateway_locationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_location(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_location(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_locationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_locationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_location loadGateway_locationByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_location loadGateway_locationByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_location loadGateway_locationByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_location loadGateway_locationByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_location createGateway_location();
	public boolean save(eu.epichub.gateway.eg.core.gateway_location lgateway_location) throws PersistentException;
	public boolean delete(eu.epichub.gateway.eg.core.gateway_location lgateway_location) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_location lgateway_location) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_location lgateway_location, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_location lgateway_location) throws PersistentException;
	public boolean evict(eu.epichub.gateway.eg.core.gateway_location lgateway_location) throws PersistentException;
	public gateway_location loadGateway_locationByCriteria(gateway_locationCriteria gateway_locationCriteria);
	public gateway_location[] listGateway_locationByCriteria(gateway_locationCriteria gateway_locationCriteria);
}
