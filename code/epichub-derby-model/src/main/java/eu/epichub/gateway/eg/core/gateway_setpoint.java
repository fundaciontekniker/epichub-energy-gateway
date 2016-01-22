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
public class gateway_setpoint implements Serializable {
	public gateway_setpoint() {
	}
	
	private long dbID;
	
	private eu.epichub.gateway.eg.core.gateway_variable variable;
	
	private String name;
	
	private String description;
	
	private String value;
	
	private long time;
	
	public void setDbID(long value) {
		this.dbID = value;
	}
	
	public long getDbID() {
		return dbID;
	}
	
	public long getORMID() {
		return getDbID();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setTime(long value) {
		this.time = value;
	}
	
	public long getTime() {
		return time;
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
