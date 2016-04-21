/*
 * <Copyright file=ValidationFailureException.java company="Morrisons Club Ltd.">
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
 * The Class ValidationFailureException.
 */
public class ValidationFailureException extends CapServiceException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new validation failure exception.
	 */
	public ValidationFailureException() {
		super();
	}

	/**
	 * Instantiates a new validation failure exception.
	 * 
	 * @param msg
	 *            the msg
	 */
	public ValidationFailureException(String msg) {
		super(msg);
	}

	/**
	 * Instantiates a new validation failure exception.
	 * 
	 * @param throwable
	 *            the throwable
	 */
	public ValidationFailureException(final Throwable throwable) {
		super(throwable);
	}

	/**
	 * Instantiates a new validation failure exception.
	 * 
	 * @param msg
	 *            the msg
	 * @param throwable
	 *            the throwable
	 */
	public ValidationFailureException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}
