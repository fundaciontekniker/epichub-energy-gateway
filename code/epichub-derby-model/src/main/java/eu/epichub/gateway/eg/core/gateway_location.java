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
public class gateway_location implements Serializable {
	public gateway_location() {
	}
	
	private long dbID;
	
	private String id;
	
	private String country;
	
	private String city;
	
	private String zip;
	
	private String address;
	
	private double lat;
	
	private double lon;
	
	private double height;
	
	private eu.epichub.gateway.eg.core.gateway_host host;
	
	private eu.epichub.gateway.eg.core.gateway_device device;
	
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
	
	public void setCountry(String value) {
		this.country = value;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCity(String value) {
		this.city = value;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setZip(String value) {
		this.zip = value;
	}
	
	public String getZip() {
		return zip;
	}
	
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setLat(double value) {
		this.lat = value;
	}
	
	public double getLat() {
		return lat;
	}
	
	public void setLon(double value) {
		this.lon = value;
	}
	
	public double getLon() {
		return lon;
	}
	
	public void setHeight(double value) {
		this.height = value;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHost(eu.epichub.gateway.eg.core.gateway_host value) {
		this.host = value;
	}
	
	public eu.epichub.gateway.eg.core.gateway_host getHost() {
		return host;
	}
	
	public void setDevice(eu.epichub.gateway.eg.core.gateway_device value) {
		this.device = value;
	}
	
	public eu.epichub.gateway.eg.core.gateway_device getDevice() {
		return device;
	}
	
	public String toString() {
		return String.valueOf(getDbID());
	}
	
}
