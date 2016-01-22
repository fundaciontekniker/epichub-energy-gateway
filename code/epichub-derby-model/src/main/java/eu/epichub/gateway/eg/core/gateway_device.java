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
public class gateway_device implements Serializable {
	public gateway_device() {
	}
	
	private long dbID;
	
	private eu.epichub.gateway.eg.core.gateway_location location;
	
	private eu.epichub.gateway.eg.core.gateway_driver driver;
	
	private String id;
	
	private String description;
	
	private String capabilities;
	
	private String deviceAddress;
	
	private String interfaceAddress;
	
	private String state;
	
	private String type;
	
	private java.util.Set variables = new java.util.HashSet();
	
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
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setCapabilities(String value) {
		this.capabilities = value;
	}
	
	public String getCapabilities() {
		return capabilities;
	}
	
	public void setDeviceAddress(String value) {
		this.deviceAddress = value;
	}
	
	public String getDeviceAddress() {
		return deviceAddress;
	}
	
	public void setInterfaceAddress(String value) {
		this.interfaceAddress = value;
	}
	
	public String getInterfaceAddress() {
		return interfaceAddress;
	}
	
	/**
	 * Device state can be enabled, disabled, error
	 */
	public void setState(String value) {
		this.state = value;
	}
	
	/**
	 * Device state can be enabled, disabled, error
	 */
	public String getState() {
		return state;
	}
	
	public void setType(String value) {
		this.type = value;
	}
	
	public String getType() {
		return type;
	}
	
	public void setLocation(eu.epichub.gateway.eg.core.gateway_location value) {
		this.location = value;
	}
	
	public eu.epichub.gateway.eg.core.gateway_location getLocation() {
		return location;
	}
	
	public void setVariables(java.util.Set value) {
		this.variables = value;
	}
	
	public java.util.Set getVariables() {
		return variables;
	}
	
	
	public void setSettings(java.util.Set value) {
		this.settings = value;
	}
	
	public java.util.Set getSettings() {
		return settings;
	}
	
	
	public void setDriver(eu.epichub.gateway.eg.core.gateway_driver value) {
		this.driver = value;
	}
	
	public eu.epichub.gateway.eg.core.gateway_driver getDriver() {
		return driver;
	}
	
	java.util.List alarms;
	
	public String toString() {
		return String.valueOf(getDbID());
	}
	
}
