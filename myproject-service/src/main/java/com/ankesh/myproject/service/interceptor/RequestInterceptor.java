/*
 * <Copyright file=RequestInterceptor.java company="Morrisons Club Ltd.">
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
package com.ankesh.myproject.service.interceptor;

import java.security.AccessControlException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
 * The Class RequestInterceptor.
 */
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

	/** The service user id. */
	@Value("${com.ankesh.myproject.service.serviceUserID}")
	private String serviceUserID;

	/** The service password. */
	@Value("${com.ankesh.myproject.service.servicePassword}")
	private String servicePassword;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle
	 * (javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		/*if (serviceUserID.equals(request.getHeader("serviceUserID"))
				&& servicePassword.equals(request.getHeader("servicePassword"))) {
			return true;
		} else {
			throw new AccessControlException(
					"User doesn't have access for given service.");
		}*/
		return true;
	}
}
