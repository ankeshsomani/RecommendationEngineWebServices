/*
 * <Copyright file=ServiceFailureException.java company="Morrisons Club Ltd.">
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
package com.ankesh.myproject.common.exceptions;


/**
 * The Class ServiceFailureException.
 */
public class ServiceFailureException extends CapServiceException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new service failure exception.
	 */
	public ServiceFailureException() {
		super();
	}

	/**
	 * Instantiates a new service failure exception.
	 * 
	 * @param msg
	 *            the msg
	 */
	public ServiceFailureException(String msg) {
		super(msg);
	}

	/**
	 * Instantiates a new service failure exception.
	 * 
	 * @param throwable
	 *            the throwable
	 */
	public ServiceFailureException(final Throwable throwable) {
		super(throwable);
	}

	/**
	 * Instantiates a new service failure exception.
	 * 
	 * @param msg
	 *            the msg
	 * @param throwable
	 *            the throwable
	 */
	public ServiceFailureException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}
