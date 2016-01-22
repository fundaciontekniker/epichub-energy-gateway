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

public interface gateway_configOptionDAO {
	public gateway_configOption loadGateway_configOptionByORMID(long dbID) throws PersistentException;
	public gateway_configOption getGateway_configOptionByORMID(long dbID) throws PersistentException;
	public gateway_configOption loadGateway_configOptionByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_configOption getGateway_configOptionByORMID(long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_configOption loadGateway_configOptionByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_configOption getGateway_configOptionByORMID(PersistentSession session, long dbID) throws PersistentException;
	public gateway_configOption loadGateway_configOptionByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_configOption getGateway_configOptionByORMID(PersistentSession session, long dbID, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_configOption[] listGateway_configOptionByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_configOption[] listGateway_configOptionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_configOption(String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_configOption(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_configOptionByQuery(String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_configOptionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_configOption[] listGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_configOption[] listGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.List queryGateway_configOption(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.List queryGateway_configOption(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public java.util.Iterator iterateGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public java.util.Iterator iterateGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_configOption loadGateway_configOptionByQuery(String condition, String orderBy) throws PersistentException;
	public gateway_configOption loadGateway_configOptionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_configOption loadGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException;
	public gateway_configOption loadGateway_configOptionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException;
	public gateway_configOption createGateway_configOption();
	public boolean save(eu.epichub.gateway.eg.core.gateway_configOption lgateway_configOption) throws PersistentException;
	public boolean delete(eu.epichub.gateway.eg.core.gateway_configOption lgateway_configOption) throws PersistentException;
	public boolean refresh(eu.epichub.gateway.eg.core.gateway_configOption lgateway_configOption) throws PersistentException;
	public boolean evict(eu.epichub.gateway.eg.core.gateway_configOption lgateway_configOption) throws PersistentException;
	public gateway_configOption loadGateway_configOptionByCriteria(gateway_configOptionCriteria gateway_configOptionCriteria);
	public gateway_configOption[] listGateway_configOptionByCriteria(gateway_configOptionCriteria gateway_configOptionCriteria);
}
