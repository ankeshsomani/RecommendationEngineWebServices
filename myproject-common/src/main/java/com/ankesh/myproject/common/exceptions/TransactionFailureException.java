/*
 * <Copyright file=TransactionFailureException.java company="Morrisons Club Ltd.">
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
 * The Class TransactionFailureException.
 */
public class TransactionFailureException extends CapServiceException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new transaction failure exception.
	 */
	public TransactionFailureException() {
		super();
	}

	/**
	 * Instantiates a new transaction failure exception.
	 * 
	 * @param msg
	 *            the msg
	 */
	public TransactionFailureException(String msg) {
		super(msg);
	}

	/**
	 * Instantiates a new transaction failure exception.
	 * 
	 * @param throwable
	 *            the throwable
	 */
	public TransactionFailureException(final Throwable throwable) {
		super(throwable);
	}

	/**
	 * Instantiates a new transaction failure exception.
	 * 
	 * @param msg
	 *            the msg
	 * @param throwable
	 *            the throwable
	 */
	public TransactionFailureException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
}
