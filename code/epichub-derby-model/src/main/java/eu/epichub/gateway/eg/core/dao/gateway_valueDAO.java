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

public interface gateway_valueDAO {
	public gateway_value loadGateway_valueByORMID(long dbID) throws PersistentException;
	public gateway_value getGateway_valueByORMID(long dbID) throws PersistentException;
	public gateway_value loadGateway_valueByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_value getGateway_valueByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_value loadGateway_valueByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_value getGateway_valueByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_value loadGateway_valueByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_value getGateway_valueByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_value[] listGateway_valueByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_value[] listGateway_valueByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_value(String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_value(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_valueByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_valueByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_value[] listGateway_valueByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_value[] listGateway_valueByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_value(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_value(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_valueByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_valueByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_value loadGateway_valueByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_value loadGateway_valueByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_value loadGateway_valueByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_value loadGateway_valueByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_value createGateway_value();
	public boolean save(eu.epichub.gateway.eg.core.gateway_value lgateway_value) throws PersistentException;
	public boolean delete(eu.epichub.gateway.eg.core.gateway_value lgateway_value) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_value lgateway_value) throws PersistentException;
	public boolean deleteAndDissociate(eu.epichub.gateway.eg.core.gateway_value lgateway_value, org.orm.PersistentSession session) throws PersistentException;
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_value lgateway_value) throws PersistentException;
	public boolean evict(eu.epichub.gateway.eg.core.gateway_value lgateway_value) throws PersistentException;
	public gateway_value loadGateway_valueByCriteria(gateway_valueCriteria gateway_valueCriteria);
	public gateway_value[] listGateway_valueByCriteria(gateway_valueCriteria gateway_valueCriteria);
}
