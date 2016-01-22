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
public class gateway_configOption implements Serializable {
	public gateway_configOption() {
	}
	
	private long dbID;
	
	private String parameter;
	
	private String type;
	
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
	
	/**
	 * parameter name
	 */
	public void setParameter(String value) {
		this.parameter = value;
	}
	
	/**
	 * parameter name
	 */
	public String getParameter() {
		return parameter;
	}
	
	/**
	 * Parameter digital type. Can be string, number or array.
	 */
	public void setType(String value) {
		this.type = value;
	}
	
	/**
	 * Parameter digital type. Can be string, number or array.
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Value of the parameter. If the type is array the value will be a string with a list of values separated by "|" character
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * Value of the parameter. If the type is array the value will be a string with a list of values separated by "|" character
	 */
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return String.valueOf(getDbID());
	}
	
}
