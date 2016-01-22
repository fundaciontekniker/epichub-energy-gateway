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

public interface gateway_deviceDAO {
	public gateway_device loadGateway_deviceByORMID(long dbID) throws PersistentException;
	public gateway_device getGateway_deviceByORMID(long dbID) throws PersistentException;
	public gateway_device loadGateway_deviceByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_device getGateway_deviceByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_device loadGateway_deviceByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_device getGateway_deviceByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_device loadGateway_deviceByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_device getGateway_deviceByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_device[] listGateway_deviceByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_device[] listGateway_deviceByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_device(String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_device(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_deviceByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_deviceByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_device[] listGateway_deviceByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_device[] listGateway_deviceByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_device(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_device(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_deviceByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_deviceByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_device loadGateway_deviceByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_device loadGateway_deviceByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_device loadGateway_deviceByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_device loadGateway_deviceByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_device createGateway_device();
	public boolean save(eu.epichub.gateway.eg.core.gateway_device lgateway_device) throws PersistentException;
	public boolean delete(eu.epichub.gateway.eg.core.gateway_device lgateway_device) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_device lgateway_device) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_device lgateway_device, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_device lgateway_device) throws PersistentException;
	public boolean evict(eu.epichub.gateway.eg.core.gateway_device lgateway_device) throws PersistentException;
	public gateway_device loadGateway_deviceByCriteria(gateway_deviceCriteria gateway_deviceCriteria);
	public gateway_device[] listGateway_deviceByCriteria(gateway_deviceCriteria gateway_deviceCriteria);
}
