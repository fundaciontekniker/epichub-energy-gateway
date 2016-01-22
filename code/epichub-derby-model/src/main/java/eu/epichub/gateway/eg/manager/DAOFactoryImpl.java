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
package eu.epichub.gateway.eg.manager;

import eu.epichub.gateway.eg.core.dao.*;
import eu.epichub.gateway.eg.core.impl.*;

public class DAOFactoryImpl extends DAOFactory {
	private gateway_subscriptionDAO _gateway_subscriptionDAO = new gateway_subscriptionDAOImpl();
	public gateway_subscriptionDAO getgateway_subscriptionDAO() {
		return _gateway_subscriptionDAO;
	}
	
	private gateway_subscriberDAO _gateway_subscriberDAO = new gateway_subscriberDAOImpl();
	public gateway_subscriberDAO getgateway_subscriberDAO() {
		return _gateway_subscriberDAO;
	}
	
	private gateway_variableDAO _gateway_variableDAO = new gateway_variableDAOImpl();
	public gateway_variableDAO getgateway_variableDAO() {
		return _gateway_variableDAO;
	}
	
	private gateway_valueDAO _gateway_valueDAO = new gateway_valueDAOImpl();
	public gateway_valueDAO getgateway_valueDAO() {
		return _gateway_valueDAO;
	}
	
	private gateway_deviceDAO _gateway_deviceDAO = new gateway_deviceDAOImpl();
	public gateway_deviceDAO getgateway_deviceDAO() {
		return _gateway_deviceDAO;
	}
	
	private gateway_driverDAO _gateway_driverDAO = new gateway_driverDAOImpl();
	public gateway_driverDAO getgateway_driverDAO() {
		return _gateway_driverDAO;
	}
	
	private gateway_configOptionDAO _gateway_configOptionDAO = new gateway_configOptionDAOImpl();
	public gateway_configOptionDAO getgateway_configOptionDAO() {
		return _gateway_configOptionDAO;
	}
	
	private gateway_hostDAO _gateway_hostDAO = new gateway_hostDAOImpl();
	public gateway_hostDAO getgateway_hostDAO() {
		return _gateway_hostDAO;
	}
	
	private gateway_setpointDAO _gateway_setpointDAO = new gateway_setpointDAOImpl();
	public gateway_setpointDAO getgateway_setpointDAO() {
		return _gateway_setpointDAO;
	}
	
	private gateway_locationDAO _gateway_locationDAO = new gateway_locationDAOImpl();
	public gateway_locationDAO getgateway_locationDAO() {
		return _gateway_locationDAO;
	}
	
}

