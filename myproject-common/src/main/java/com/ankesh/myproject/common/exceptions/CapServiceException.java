/*
 * <Copyright file=CapServiceException.java company="Morrisons Club Ltd.">
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

import java.io.Serializable;


/**
 * The Class CapServiceException.
 */
public class CapServiceException extends RuntimeException implements
		Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3457150898072649970L;

	/**
	 * Instantiates a new cap service exception.
	 */
	public CapServiceException() {
		super();
	}

	/**
	 * Instantiates a new cap service exception.
	 * 
	 * @param msg
	 *            the msg
	 */
	public CapServiceException(String msg) {
		super(msg);
	}

	/**
	 * Instantiates a new cap service exception.
	 * 
	 * @param throwable
	 *            the throwable
	 */
	public CapServiceException(Throwable throwable) {
		super(throwable);
	}

	/**
	 * Instantiates a new cap service exception.
	 * 
	 * @param msg
	 *            the msg
	 * @param throwable
	 *            the throwable
	 */
	public CapServiceException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	/**
	 * Gets the exception message.
	 * 
	 * @return the exception message
	 */
	public String getExceptionMessage() {
		return this.getMessage();
	}

}
