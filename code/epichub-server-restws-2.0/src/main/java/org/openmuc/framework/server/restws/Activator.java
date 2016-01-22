/*
 * Copyright 2011-14 Fraunhofer ISE
 *
 * This file is part of OpenMUC.
 * For more information visit http://www.openmuc.org
 *
 * OpenMUC is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * OpenMUC is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with OpenMUC.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.openmuc.framework.server.restws;

import org.openmuc.framework.authentication.AuthenticationService;
import org.openmuc.framework.config.ConfigService;
import org.openmuc.framework.dataaccess.DataAccessService;
import org.openmuc.framework.server.restws.servlets.AddDriverServlet;
import org.openmuc.framework.server.restws.servlets.ChannelResourceServlet;
import org.openmuc.framework.server.restws.servlets.DeviceResourceServlet;
import org.openmuc.framework.server.restws.servlets.DriverResourceServlet;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.http.HttpService;
import org.osgi.util.tracker.ServiceTracker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import epichub.framework.gateway.core.restws.CoreResourceServlet;
import epichub.framework.gateway.core.restws.HomeResourceServlet;
import epichub.framework.gateway.core.restws.alarms.DeviceChangeServlet;
import epichub.framework.gateway.core.restws.alarms.DeviceSimulationServlet;
import epichub.framework.gateway.spi.DatabaseService;
import epichub.framework.gateway.interfaces.middleware.GatewayService;
import epichub.framework.gateway.spi.CoreService;
import eu.epichub.gateway.eg.core.gateway_device;
import eu.epichub.gateway.eg.core.gateway_driver;
import eu.epichub.gateway.eg.core.gateway_host;
import eu.epichub.gateway.eg.core.gateway_subscription;
import eu.epichub.gateway.eg.core.gateway_variable;

public final class Activator {

	private final static Logger logger = LoggerFactory
			.getLogger(Activator.class);

	private static DataAccessService dataAccess = null;
	private static CoreService core = null;
	private static ConfigService configService = null;
	private static DatabaseService database = null;
	// private static GatewayService publish =null;

	private volatile HttpService httpService;

	private ServiceTracker<HttpService, HttpService> httpTracker;

	private volatile ChannelResourceServlet chRServlet;
	private volatile DeviceResourceServlet devRServlet;
	private volatile DriverResourceServlet drvRServlet;
	private volatile AddDriverServlet addDrvServlet;

	private volatile CoreResourceServlet coreRServlet;
	private volatile HomeResourceServlet homeRServlet;
	private volatile DeviceChangeServlet devCServlet;
	private volatile DeviceSimulationServlet devSimServlet;

	protected void activate(ComponentContext context) throws Exception {

		logger.info("Activating REST SERVER");

		chRServlet = new ChannelResourceServlet();
		devRServlet = new DeviceResourceServlet();
		drvRServlet = new DriverResourceServlet();
		addDrvServlet = new AddDriverServlet();
		coreRServlet = new CoreResourceServlet();
		homeRServlet = new HomeResourceServlet();
		devCServlet = new DeviceChangeServlet();
		devSimServlet = new DeviceSimulationServlet();
		registerServlets();

		httpTracker = new ServiceTracker<HttpService, HttpService>(
				context.getBundleContext(), HttpService.class.getName(), null);
		httpTracker.open();
		HttpService httpServiceAct = httpTracker.getService();

		if (httpServiceAct != null && this.httpService == null) {
			setHttpService(httpServiceAct);
		}
	}

	private synchronized void registerServlets() {
		if (httpService != null && chRServlet != null && devRServlet != null
				&& drvRServlet != null && addDrvServlet != null
				&& coreRServlet != null && homeRServlet != null) {
			try {
				httpService.registerServlet("/rest/channel", chRServlet, null,
						null);
				httpService.registerServlet("/rest/device", devRServlet, null,
						null);
				httpService.registerServlet("/rest/driver", drvRServlet, null,
						null);
				httpService.registerServlet("/rest/addDriver", addDrvServlet,
						null, null);

				httpService.registerServlet("/epichub/home", homeRServlet,
						null, null);
				httpService.registerServlet("/epichub/core", coreRServlet,
						null, null);
				httpService.registerServlet("/epichub/deviceUpdate",
						devCServlet, null, null);
				httpService.registerServlet("/epichub/deviceSimulation",
						devSimServlet, null, null);
			} catch (Exception e) {
			}
		}
	}

	protected void setConfigService(ConfigService configService) {
		Activator.configService = configService;
	}

	protected void unsetConfigService(ConfigService configService) {
		Activator.configService = null;
	}

	protected void setHttpService(HttpService httpService) {
		this.httpService = httpService;
		registerServlets();
	}

	protected void unsetHttpService(HttpService httpService) {
		httpService.unregister("/rest/channel");
		httpService.unregister("/rest/device");
		httpService.unregister("/rest/driver");
		httpService.unregister("/rest/addDriver");

		httpService.unregister("/epichub/home");
		httpService.unregister("/epichub/core");
		httpService.unregister("/epichub/deviceUpdate");
		httpService.unregister("/epichub/deviceSimulation");
		this.httpService = null;
	}

	protected void setDataAccessService(DataAccessService dataAccessService) {
		dataAccess = dataAccessService;
	}

	protected void unsetDataAccessService(DataAccessService dataAccessService) {
		dataAccess = null;
	}

	protected void setCoreService(CoreService coreService) {
		core = coreService;
	}

	protected void unsetCoreService(CoreService coreService) {
		core = null;
	}

	protected void setDatabaseService(DatabaseService db) {
		database = db;
	}

	protected void unsetDatabaseService(DatabaseService db) {
		database = db;
	}

	protected void setAuthenticationService(
			AuthenticationService authenticationService) {
	}

	protected void unsetAuthenticationService(
			AuthenticationService authenticationService) {
	}

	public static DataAccessService getDataAccess() {
		if (dataAccess == null) {
			throw new NullPointerException();
		}
		return dataAccess;
	}

	public static ConfigService getConfigService() {
		if (configService == null) {
			throw new NullPointerException();
		}

		return configService;
	}

	public static CoreService getCoreService() {
		if (core == null) {
			throw new NullPointerException();
		}
		return core;
	}

	public static DatabaseService getDatabaseService() {
		if (database == null) {
			throw new NullPointerException();
		}
		return database;
	}

	/*
	 * protected void setPublishService(GatewayService publishService) { publish
	 * = publishService; }
	 * 
	 * protected void unsetPublishService(GatewayService publishService) {
	 * publish = null;
	 * 
	 * } public static GatewayService getPublishService() { if (publish == null)
	 * { throw new NullPointerException(); } return publish; }
	 */

	public static Logger getLogger() {
		return logger;
	}

}
