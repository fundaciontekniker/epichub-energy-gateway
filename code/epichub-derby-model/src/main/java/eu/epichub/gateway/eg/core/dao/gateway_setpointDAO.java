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

public interface gateway_setpointDAO {
	public gateway_setpoint loadGateway_setpointByORMID(long dbID) throws PersistentException;
	public gateway_setpoint getGateway_setpointByORMID(long dbID) throws PersistentException;
	public gateway_setpoint loadGateway_setpointByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_setpoint getGateway_setpointByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_setpoint loadGateway_setpointByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_setpoint getGateway_setpointByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_setpoint loadGateway_setpointByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_setpoint getGateway_setpointByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_setpoint[] listGateway_setpointByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_setpoint[] listGateway_setpointByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_setpoint(String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_setpoint(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_setpointByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_setpointByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_setpoint[] listGateway_setpointByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_setpoint[] listGateway_setpointByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_setpoint(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_setpoint(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_setpointByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_setpointByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_setpoint loadGateway_setpointByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_setpoint loadGateway_setpointByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_setpoint loadGateway_setpointByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_setpoint loadGateway_setpointByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_setpoint createGateway_setpoint();
	public boolean save(eu.epichub.gateway.eg.core.gateway_setpoint lgateway_setpoint) throws PersistentException;
	public boolean delete(eu.epichub.gateway.eg.core.gateway_setpoint lgateway_setpoint) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_setpoint lgateway_setpoint) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_setpoint lgateway_setpoint, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_setpoint lgateway_setpoint) throws PersistentException;
	public boolean evict(eu.epichub.gateway.eg.core.gateway_setpoint lgateway_setpoint) throws PersistentException;
	public gateway_setpoint loadGateway_setpointByCriteria(gateway_setpointCriteria gateway_setpointCriteria);
	public gateway_setpoint[] listGateway_setpointByCriteria(gateway_setpointCriteria gateway_setpointCriteria);
}
