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
package eu.epichub.gateway.eg.core;

import java.io.Serializable;
public class gateway_driver implements Serializable {
	public gateway_driver() {
	}
	
	private long dbID;
	
	private eu.epichub.gateway.eg.core.gateway_host host;
	
	private String id;
	
	private String name;
	
	private String state;
	
	private boolean subscriptions;
	
	private String description;
	
	private String operations;
	
	private java.util.Set devices = new java.util.HashSet();
	
	private java.util.Set settings = new java.util.HashSet();
	
	public void setDbID(long value) {
		this.dbID = value;
	}
	
	public long getDbID() {
		return dbID;
	}
	
	public long getORMID() {
		return getDbID();
	}
	
	public void setId(String value) {
		this.id = value;
	}
	
	public String getId() {
		return id;
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Driver state, can be enabled, disabled o error
	 */
	public void setState(String value) {
		this.state = value;
	}
	
	/**
	 * Driver state, can be enabled, disabled o error
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Indica si el driver es capaz de gestionar subscripciones por si mismo o no
	 */
	public void setSubscriptions(boolean value) {
		this.subscriptions = value;
	}
	
	/**
	 * Indica si el driver es capaz de gestionar subscripciones por si mismo o no
	 */
	public boolean getSubscriptions() {
		return subscriptions;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setOperations(String value) {
		this.operations = value;
	}
	
	public String getOperations() {
		return operations;
	}
	
	public void setHost(eu.epichub.gateway.eg.core.gateway_host value) {
		this.host = value;
	}
	
	public eu.epichub.gateway.eg.core.gateway_host getHost() {
		return host;
	}
	
	public void setDevices(java.util.Set value) {
		this.devices = value;
	}
	
	public java.util.Set getDevices() {
		return devices;
	}
	
	
	public void setSettings(java.util.Set value) {
		this.settings = value;
	}
	
	public java.util.Set getSettings() {
		return settings;
	}
	
	
	public String toString() {
		return String.valueOf(getDbID());
	}
	
}
