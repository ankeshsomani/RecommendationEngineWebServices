/*
 * <Copyright file=CapServiceCacheItemLoader.java company="Morrisons Club Ltd.">
 * Copyright 2015 
 * All rights reserved
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of the Morrisons Club Ltd. IT Dept.
 * The intellectual and technical concepts contained
 * herein are proprietary to them.
 * 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Morrisons Club Ltd.
 * </copyright>
 * 
 */
package com.ankesh.myproject.common.cache;

import java.util.Map;

import org.springframework.stereotype.Component;


/**
 * The Class CapServiceCacheItemLoader.
 */
@Component
public final class CapServiceCacheItemLoader {

	/** The cap service config map. */
	private static Map<String, String> capServiceConfigMap;

	/** The cap service error codes map. */
	private static Map<String, String> capServiceErrorCodesMap;
	
	/** The cap service enable audit logs **/
	private static String enableDBAuditLogs;

	/** The cap service oracle driver **/
	private static String driverClass;
	
	/** The jdbc database **/
	private static String jdbcUrl;

	/** The jdbc database connection username **/
	private static String jdbcUsername;

	/** The jdbc database connection password **/
	private static String jdbcPassword;
	
	/**
	 * Instantiates a new cap service cache item loader.
	 */
	private CapServiceCacheItemLoader() {
	}

	/**
	 * Gets the cap service config map.
	 * 
	 * @return the cap service config map
	 */
	public static Map<String, String> getCapServiceConfigMap() {
		return capServiceConfigMap;
	}

	/**
	 * Sets the cap service config map.
	 * 
	 * @param capServiceConfigMap
	 *            the cap service config map
	 */
	public static void setCapServiceConfigMap(
			Map<String, String> capServiceConfigMap) {
		CapServiceCacheItemLoader.capServiceConfigMap = capServiceConfigMap;
	}

	/**
	 * Gets the cap service config val.
	 * 
	 * @param configKey
	 *            the config key
	 * @return the cap service config val
	 */
	public static String getCapServiceConfigVal(final String configKey) {
		return getCapServiceConfigMap().get(configKey);
	}

	/**
	 * Gets the cap service error codes map.
	 * 
	 * @return the cap service error codes map
	 */
	public static Map<String, String> getCapServiceErrorCodesMap() {
		return capServiceErrorCodesMap;
	}

	/**
	 * Sets the cap service error codes map.
	 * 
	 * @param capServiceErrorCodesMap
	 *            the cap service error codes map
	 */
	public static void setCapServiceErrorCodesMap(
			Map<String, String> capServiceErrorCodesMap) {
		CapServiceCacheItemLoader.capServiceErrorCodesMap = capServiceErrorCodesMap;
	}

	/**
	 * Gets the cap service error description.
	 * 
	 * @param errorCode
	 *            the error code
	 * @return the cap service error description
	 */
	public static String getCapServiceErrorDescription(final String errorCode) {
		return getCapServiceErrorCodesMap().get(errorCode);
	}
	
	/**
	 * gets the parameter for audit logs settings
	 * @return
	 */
	public static String getEnableDBAuditLogs() {
		return enableDBAuditLogs;
	}

	/**
	 * sets the parameter for audit logs settings
	 * @param enableDBAuditLogs
	 */
	public static void setEnableDBAuditLogs(String enableDBAuditLogs) {
		CapServiceCacheItemLoader.enableDBAuditLogs = enableDBAuditLogs;
	}

	/**
	 * gets the parameter for jdbc driver class
	 * @return
	 */	
	public static String getDriverClass() {
		return driverClass;
	}

	/**
	 * sets the parameter for jdbc Driver
	 * @param driverClass
	 */	
	public static void setDriverClass(String driverClass) {
		CapServiceCacheItemLoader.driverClass = driverClass;
	}

	/**
	 * gets the parameter for jdbc url
	 * @return
	 */	
	public static String getJdbcUrl() {
		return jdbcUrl;
	}

	/**
	 * sets the parameter for jdbc url
	 * @param jdbcUrl
	 */		
	public static void setJdbcUrl(String jdbcUrl) {
		CapServiceCacheItemLoader.jdbcUrl = jdbcUrl;
	}

	/**
	 * gets the parameter for database username
	 * @return
	 */	
	public static String getJdbcUsername() {
		return jdbcUsername;
	}

	/**
	 * sets the parameter for database username
	 * @param jdbcUsername
	 */	
	public static void setJdbcUsername(String jdbcUsername) {
		CapServiceCacheItemLoader.jdbcUsername = jdbcUsername;
	}

	/**
	 * gets the parameter for database password
	 * @return
	 */	
	public static String getJdbcPassword() {
		return jdbcPassword;
	}

	/**
	 * sets the parameter for database password
	 * @param jdbcPassword
	 */	
	public static void setJdbcPassword(String jdbcPassword) {
		CapServiceCacheItemLoader.jdbcPassword = jdbcPassword;
	}

	
}
