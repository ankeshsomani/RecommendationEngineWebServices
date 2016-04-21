/*
 * <Copyright file=BaseServiceController.java company="Morrisons Club Ltd.">
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
package com.ankesh.myproject.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ankesh.myproject.common.constants.CommonConstants;
import com.ankesh.myproject.common.constants.NumberConstants;
import com.ankesh.myproject.service.common.ServiceResponse;


/**
 * The Class BaseServiceController.
 */
public class BaseServiceController {
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(BaseServiceController.class);

	/**
	 * Validate input.
	 * 
	 * @param inputString
	 *            the input string
	 * @return true, if successful
	 */
	protected boolean validateInput(String inputString) {
		if (null == inputString || inputString.trim().isEmpty())
			return true;

		return false;
	}


	
	/**
	 * checkAuditResponse
	 * @param auditStatusCode
	 * @return the service response
	 */
	protected ServiceResponse checkAuditResponse(int auditStatusCode) {
		ServiceResponse serviceResponse = null;
		if (auditStatusCode==NumberConstants.NUMBER1) {
			LOGGER.error(CommonConstants.ErrorMessages.PENDING_EXCEPTION_ERROR);			
			serviceResponse = new ServiceResponse(false,CommonConstants.ErrorMessages.PENDING_EXCEPTION_ERROR);
			LOGGER.debug("Return startCommissionCalculation method because of:{} ",	CommonConstants.ErrorMessages.PENDING_EXCEPTION_ERROR);
			return serviceResponse;
		}else if (auditStatusCode==NumberConstants.NUMBER2) 	{
			LOGGER.error(CommonConstants.ErrorMessages.DUPLICATE_EXCEPTION_ERROR);			
			serviceResponse = new ServiceResponse(false,CommonConstants.ErrorMessages.DUPLICATE_EXCEPTION_ERROR);
			LOGGER.debug("Return startCommissionCalculation method because of:{} ",	CommonConstants.ErrorMessages.DUPLICATE_EXCEPTION_ERROR);
			return serviceResponse;
		}
		return serviceResponse;
	}

}
