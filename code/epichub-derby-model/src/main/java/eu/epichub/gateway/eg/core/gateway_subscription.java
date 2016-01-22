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
public class gateway_subscription implements Serializable {
	public gateway_subscription() {
	}
	
	private long dbID;
	
	private eu.epichub.gateway.eg.core.gateway_subscriber subscriber;
	
	private String id;
	
	private long minInt;
	
	private long maxInt;
	
	private String state;
	
	private java.util.Set variables = new java.util.HashSet();
	
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
	
	public void setMinInt(long value) {
		this.minInt = value;
	}
	
	public long getMinInt() {
		return minInt;
	}
	
	public void setMaxInt(long value) {
		this.maxInt = value;
	}
	
	public long getMaxInt() {
		return maxInt;
	}
	
	public void setState(String value) {
		this.state = value;
	}
	
	public String getState() {
		return state;
	}
	
	public void setVariables(java.util.Set value) {
		this.variables = value;
	}
	
	public java.util.Set getVariables() {
		return variables;
	}
	
	
	public void setSubscriber(eu.epichub.gateway.eg.core.gateway_subscriber value) {
		this.subscriber = value;
	}
	
	public eu.epichub.gateway.eg.core.gateway_subscriber getSubscriber() {
		return subscriber;
	}
	
	public String toString() {
		return String.valueOf(getDbID());
	}
	
}
