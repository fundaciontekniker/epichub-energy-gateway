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
public class gateway_variable implements Serializable {
	public gateway_variable() {
	}
	
	private long dbID;
	
	private eu.epichub.gateway.eg.core.gateway_device device;
	
	private String id;
	
	private String description;
	
	private String digType;
	
	private String phyType;
	
	private String unit;
	
	private String state;
	
	private String accessType = "R/W";
	
	private String path;
	
	private long expirationDate = 0;
	
	private long samplingInterval = 0;
	
	private double absoluteError = 0;
	
	private int percentageError = 0;
	
	private java.util.Set subscriptions = new java.util.HashSet();
	
	private java.util.Set values = new java.util.HashSet();
	
	private java.util.Set setpoints = new java.util.HashSet();
	
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
	
	public void setDigType(String value) {
		this.digType = value;
	}
	
	public String getDigType() {
		return digType;
	}
	
	public void setPhyType(String value) {
		this.phyType = value;
	}
	
	public String getPhyType() {
		return phyType;
	}
	
	public void setUnit(String value) {
		this.unit = value;
	}
	
	public String getUnit() {
		return unit;
	}
	
	/**
	 * State of variable if it is subscribed. Can be enabled, disabled, error
	 */
	public void setState(String value) {
		this.state = value;
	}
	
	/**
	 * State of variable if it is subscribed. Can be enabled, disabled, error
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Acces Type can be Read, Write or Read/Write
	 */
	public void setAccessType(String value) {
		this.accessType = value;
	}
	
	/**
	 * Acces Type can be Read, Write or Read/Write
	 */
	public String getAccessType() {
		return accessType;
	}
	
	/**
	 * Protocol dependent representation
	 */
	public void setPath(String value) {
		this.path = value;
	}
	
	/**
	 * Protocol dependent representation
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * Date of expiration. Variable will be not longer valid
	 */
	public void setExpirationDate(long value) {
		this.expirationDate = value;
	}
	
	/**
	 * Date of expiration. Variable will be not longer valid
	 */
	public long getExpirationDate() {
		return expirationDate;
	}
	
	/**
	 * Sampling interval if it is read periodically.
	 */
	public void setSamplingInterval(long value) {
		this.samplingInterval = value;
	}
	
	/**
	 * Sampling interval if it is read periodically.
	 */
	public long getSamplingInterval() {
		return samplingInterval;
	}
	
	public void setAbsoluteError(double value) {
		this.absoluteError = value;
	}
	
	public double getAbsoluteError() {
		return absoluteError;
	}
	
	public void setPercentageError(int value) {
		this.percentageError = value;
	}
	
	public int getPercentageError() {
		return percentageError;
	}
	
	public void setDevice(eu.epichub.gateway.eg.core.gateway_device value) {
		this.device = value;
	}
	
	public eu.epichub.gateway.eg.core.gateway_device getDevice() {
		return device;
	}
	
	public void setSubscriptions(java.util.Set value) {
		this.subscriptions = value;
	}
	
	public java.util.Set getSubscriptions() {
		return subscriptions;
	}
	
	
	public void setValues(java.util.Set value) {
		this.values = value;
	}
	
	public java.util.Set getValues() {
		return values;
	}
	
	
	public void setSetpoints(java.util.Set value) {
		this.setpoints = value;
	}
	
	public java.util.Set getSetpoints() {
		return setpoints;
	}
	
	
	public String toString() {
		return String.valueOf(getDbID());
	}
	
}
