/*
 * <Copyright file=BasicHeaderAuthenticationFilter.java company="Morrisons Club Ltd.">
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
package com.ankesh.myproject.service.security.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.ankesh.myproject.common.constants.PlatformConstants;


/**
 * The Class BasicHeaderAuthenticationFilter.
 */
@SuppressWarnings(PlatformConstants.WARNINGS_DEPRECATION)
public class BasicHeaderAuthenticationFilter extends BasicAuthenticationFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.web.authentication.www.BasicAuthenticationFilter
	 * #doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
	 * javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		String header = request.getHeader("Authorization");

		if ((header == null) || (!(header.startsWith("Basic ")))) {
			response.addHeader("Access-Control-Allow-Origin", "null");
			response.addHeader("WWW-Authenticate", "xBasic realm=\""
					+ "mcl.co.uk" + "\"");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			PrintWriter writer = response.getWriter();
			writer.println("HTTP Status " + HttpServletResponse.SC_UNAUTHORIZED
					+ " - " + "Invalid Access");
			return;
		} else {
			super.doFilter(request, response, chain);
		}

	}

}
