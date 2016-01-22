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
public class gateway_host implements Serializable {
	public gateway_host() {
	}
	
	private long dbID;
	
	private eu.epichub.gateway.eg.core.gateway_location location;
	
	private String id;
	
	private String URL;
	
	private String state;
	
	private String description;
	
	private java.util.Set drivers = new java.util.HashSet();
	
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
	
	public void setURL(String value) {
		this.URL = value;
	}
	
	public String getURL() {
		return URL;
	}
	
	/**
	 * Can be enabled, disabled, error
	 */
	public void setState(String value) {
		this.state = value;
	}
	
	/**
	 * Can be enabled, disabled, error
	 */
	public String getState() {
		return state;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setLocation(eu.epichub.gateway.eg.core.gateway_location value) {
		this.location = value;
	}
	
	public eu.epichub.gateway.eg.core.gateway_location getLocation() {
		return location;
	}
	
	public void setDrivers(java.util.Set value) {
		this.drivers = value;
	}
	
	public java.util.Set getDrivers() {
		return drivers;
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
