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
public class gateway_subscriber implements Serializable {
	public gateway_subscriber() {
	}
	
	private long dbID;
	
	private String id;
	
	private String name;
	
	private String responseURL;
	
	private java.util.Set subscriptions = new java.util.HashSet();
	
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
	
	public void setResponseURL(String value) {
		this.responseURL = value;
	}
	
	public String getResponseURL() {
		return responseURL;
	}
	
	public void setSubscriptions(java.util.Set value) {
		this.subscriptions = value;
	}
	
	public java.util.Set getSubscriptions() {
		return subscriptions;
	}
	
	
	public String toString() {
		return String.valueOf(getDbID());
	}
	
}
