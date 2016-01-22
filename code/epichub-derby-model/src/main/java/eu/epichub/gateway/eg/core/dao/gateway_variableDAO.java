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

public interface gateway_variableDAO {
	public gateway_variable loadGateway_variableByORMID(long dbID) throws PersistentException;
	public gateway_variable getGateway_variableByORMID(long dbID) throws PersistentException;
	public gateway_variable loadGateway_variableByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_variable getGateway_variableByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_variable loadGateway_variableByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_variable getGateway_variableByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_variable loadGateway_variableByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_variable getGateway_variableByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_variable[] listGateway_variableByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_variable[] listGateway_variableByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_variable(String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_variable(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_variableByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_variableByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_variable[] listGateway_variableByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_variable[] listGateway_variableByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_variable(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_variable(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_variableByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_variableByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_variable loadGateway_variableByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_variable loadGateway_variableByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_variable loadGateway_variableByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_variable loadGateway_variableByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_variable createGateway_variable();
	public boolean save(eu.epichub.gateway.eg.core.gateway_variable lgateway_variable) throws PersistentException;
	public boolean delete(eu.epichub.gateway.eg.core.gateway_variable lgateway_variable) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_variable lgateway_variable) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_variable lgateway_variable, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_variable lgateway_variable) throws PersistentException;
	public boolean evict(eu.epichub.gateway.eg.core.gateway_variable lgateway_variable) throws PersistentException;
	public gateway_variable loadGateway_variableByCriteria(gateway_variableCriteria gateway_variableCriteria);
	public gateway_variable[] listGateway_variableByCriteria(gateway_variableCriteria gateway_variableCriteria);
}
