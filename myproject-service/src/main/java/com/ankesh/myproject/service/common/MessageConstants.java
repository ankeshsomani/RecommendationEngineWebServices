/*
 * <Copyright file=MessageConstants.java company="Morrisons Club Ltd.">
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
package com.ankesh.myproject.service.common;

import com.ankesh.myproject.common.cache.CapServiceCacheItemLoader;


/**
 * The Class CommonConstants.
 * 
 */
public class MessageConstants {

	/**
	 * The Class Attributes.
	 */

	/** The Constant INVALID_USER_MESSAGE. */
	public static final String INVALID_USER_MESSAGE = CapServiceCacheItemLoader
			.getCapServiceConfigVal("INVALID_USER_MESSAGE").trim();

	/** The Constant INVALID_INPUT_PARAM_MESSAGE. */
	public static final String INVALID_INPUT_PARAM_MESSAGE = CapServiceCacheItemLoader
			.getCapServiceConfigVal("INVALID_INPUT_PARAM_MESSAGE").trim();
	
	/** The Constant INVALID_INPUT_PARAM_MESSAGE. */
	public static final String USER_LOCKED_MESSAGE = CapServiceCacheItemLoader
			.getCapServiceConfigVal("USER_LOCKED_MESSAGE").trim();


	/**
	 * Instantiates a new message constants.
	 */
	private MessageConstants() {
	}
}
