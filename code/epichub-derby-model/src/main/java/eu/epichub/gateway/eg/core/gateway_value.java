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
public class gateway_value implements Serializable {
	public gateway_value() {
	}
	
	private long dbID;
	
	private eu.epichub.gateway.eg.core.gateway_variable variable;
	
	private long timestamp;
	
	private String value;
	
	public void setDbID(long value) {
		this.dbID = value;
	}
	
	public long getDbID() {
		return dbID;
	}
	
	public long getORMID() {
		return getDbID();
	}
	
	public void setTimestamp(long value) {
		this.timestamp = value;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setVariable(eu.epichub.gateway.eg.core.gateway_variable value) {
		this.variable = value;
	}
	
	public eu.epichub.gateway.eg.core.gateway_variable getVariable() {
		return variable;
	}
	
	public String toString() {
		return String.valueOf(getDbID());
	}
	
}
