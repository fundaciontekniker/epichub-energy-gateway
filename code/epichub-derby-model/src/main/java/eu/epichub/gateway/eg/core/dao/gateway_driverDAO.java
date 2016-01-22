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

public interface gateway_driverDAO {
	public gateway_driver loadGateway_driverByORMID(long dbID) throws PersistentException;
	public gateway_driver getGateway_driverByORMID(long dbID) throws PersistentException;
	public gateway_driver loadGateway_driverByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_driver getGateway_driverByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_driver loadGateway_driverByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_driver getGateway_driverByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_driver loadGateway_driverByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_driver getGateway_driverByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_driver[] listGateway_driverByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_driver[] listGateway_driverByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_driver(String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_driver(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_driverByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_driverByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_driver[] listGateway_driverByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_driver[] listGateway_driverByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_driver(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_driver(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_driverByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_driverByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_driver loadGateway_driverByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_driver loadGateway_driverByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_driver loadGateway_driverByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_driver loadGateway_driverByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_driver createGateway_driver();
	public boolean save(eu.epichub.gateway.eg.core.gateway_driver lgateway_driver) throws PersistentException;
	public boolean delete(eu.epichub.gateway.eg.core.gateway_driver lgateway_driver) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_driver lgateway_driver) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_driver lgateway_driver, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_driver lgateway_driver) throws PersistentException;
	public boolean evict(eu.epichub.gateway.eg.core.gateway_driver lgateway_driver) throws PersistentException;
	public gateway_driver loadGateway_driverByCriteria(gateway_driverCriteria gateway_driverCriteria);
	public gateway_driver[] listGateway_driverByCriteria(gateway_driverCriteria gateway_driverCriteria);
}
