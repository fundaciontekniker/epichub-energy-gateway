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

public interface gateway_hostDAO {
	public gateway_host loadGateway_hostByORMID(long dbID) throws PersistentException;
	public gateway_host getGateway_hostByORMID(long dbID) throws PersistentException;
	public gateway_host loadGateway_hostByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_host getGateway_hostByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_host loadGateway_hostByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_host getGateway_hostByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_host loadGateway_hostByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_host getGateway_hostByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_host[] listGateway_hostByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_host[] listGateway_hostByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_host(String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_host(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_hostByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_hostByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_host[] listGateway_hostByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_host[] listGateway_hostByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_host(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_host(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_hostByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_hostByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_host loadGateway_hostByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_host loadGateway_hostByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_host loadGateway_hostByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_host loadGateway_hostByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_host createGateway_host();
	public boolean save(eu.epichub.gateway.eg.core.gateway_host lgateway_host) throws PersistentException;
	public boolean delete(eu.epichub.gateway.eg.core.gateway_host lgateway_host) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_host lgateway_host) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_host lgateway_host, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_host lgateway_host) throws PersistentException;
	public boolean evict(eu.epichub.gateway.eg.core.gateway_host lgateway_host) throws PersistentException;
	public gateway_host loadGateway_hostByCriteria(gateway_hostCriteria gateway_hostCriteria);
	public gateway_host[] listGateway_hostByCriteria(gateway_hostCriteria gateway_hostCriteria);
}
