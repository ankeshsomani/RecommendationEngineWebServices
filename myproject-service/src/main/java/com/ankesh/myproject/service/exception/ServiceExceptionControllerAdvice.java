/*
 * <Copyright file=ServiceExceptionControllerAdvice.java company="Morrisons Club Ltd.">
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
package com.ankesh.myproject.service.exception;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ankesh.myproject.common.constants.CommonConstants.ErrorMessages;
import com.ankesh.myproject.common.exceptions.ServiceFailureException;
import com.ankesh.myproject.common.exceptions.TransactionFailureException;
import com.ankesh.myproject.common.exceptions.ValidationFailureException;
import com.ankesh.myproject.service.common.ServiceResponse;


/**
 * The Class ServiceExceptionControllerAdvice.
 */
@ControllerAdvice
public class ServiceExceptionControllerAdvice extends
		ResponseEntityExceptionHandler {

	/** The Constant LOGGER. */
	private static final org.slf4j.Logger LOGGER = LoggerFactory
			.getLogger(ServiceExceptionControllerAdvice.class);

	/**
	 * Handle service failure exception as internal server error.
	 * 
	 * @param ex
	 *            the ex
	 * @param request
	 *            the request
	 * @return the response entity
	 */
	@ExceptionHandler(ServiceFailureException.class)
	protected ResponseEntity<Object> handleServiceFailureException(
			ServiceFailureException ex, WebRequest request) {
		// LOG THE MESSAGE

		LOGGER.error(ex.getMessage(), ex);
		ServiceResponse serviceResponse = new ServiceResponse(false,
				ErrorMessages.APPLICATION_ERROR);
		return handleExceptionInternal(ex, serviceResponse, new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	/**
	 * Handle transaction failure exception as internal server error.
	 * 
	 * @param ex
	 *            the ex
	 * @param request
	 *            the request
	 * @return the response entity
	 */
	@ExceptionHandler(TransactionFailureException.class)
	protected ResponseEntity<Object> handleTransactionFailureException(
			TransactionFailureException ex, WebRequest request) {
		// LOG THE MESSAGE
		LOGGER.error(ex.getMessage(), ex);
		ServiceResponse serviceResponse = new ServiceResponse(false,
				ErrorMessages.TRANSACTION_ERROR);
		return handleExceptionInternal(ex, serviceResponse, new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	/**
	 * Handle validation failure exception as bad request.
	 * 
	 * @param ex
	 *            the ex
	 * @param request
	 *            the request
	 * @return the response entity
	 */
	@ExceptionHandler(ValidationFailureException.class)
	protected ResponseEntity<Object> handleValidationFailureException(
			ValidationFailureException ex, WebRequest request) {
		LOGGER.error(ex.getMessage(), ex);
		ServiceResponse serviceResponse = new ServiceResponse(false,
				ErrorMessages.VALIDATION_ERROR);
		return handleExceptionInternal(ex, serviceResponse, new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);
	}

	/**
	 * Handle service exception.
	 * 
	 * @param ex
	 *            the ex
	 * @param request
	 *            the request
	 * @return the response entity
	 */
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleServiceException(Exception ex,
			WebRequest request) {
		LOGGER.error(ex.getMessage(), ex);
		ServiceResponse serviceResponse = new ServiceResponse(false,
				ErrorMessages.RUNTIME_EXCEPTION_ERROR);
		return handleExceptionInternal(ex, serviceResponse, new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

}
