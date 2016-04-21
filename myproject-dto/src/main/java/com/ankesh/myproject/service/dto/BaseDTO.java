/*
 * <Copyright file=BaseDTO.java company="Morrisons Club Ltd.">
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
package com.ankesh.myproject.service.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The Class BaseDTO.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseDTO implements Serializable{


	/** The operation. */
	@JsonProperty("userName")
	private String userName; 

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
