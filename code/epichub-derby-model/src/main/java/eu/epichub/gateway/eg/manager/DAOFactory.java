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

public abstract class DAOFactory {
	private static DAOFactory _factory = new DAOFactoryImpl();
	
	public static DAOFactory getDAOFactory() {
		return _factory;
	}
	
	public abstract gateway_subscriptionDAO getgateway_subscriptionDAO();
	public abstract gateway_subscriberDAO getgateway_subscriberDAO();
	public abstract gateway_variableDAO getgateway_variableDAO();
	public abstract gateway_valueDAO getgateway_valueDAO();
	public abstract gateway_deviceDAO getgateway_deviceDAO();
	public abstract gateway_driverDAO getgateway_driverDAO();
	public abstract gateway_configOptionDAO getgateway_configOptionDAO();
	public abstract gateway_hostDAO getgateway_hostDAO();
	public abstract gateway_setpointDAO getgateway_setpointDAO();
	public abstract gateway_locationDAO getgateway_locationDAO();
}

