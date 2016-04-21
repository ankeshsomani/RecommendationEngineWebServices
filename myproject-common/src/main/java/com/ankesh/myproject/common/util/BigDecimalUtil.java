/*
 * <Copyright file=BigDecimalUtil.java company="Morrisons Club Ltd.">
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
package com.ankesh.myproject.common.util;

import java.math.BigDecimal;

/**
 * The Class BigDecimalUtil.
 */
public class BigDecimalUtil {
	
	/**
	 * Instantiates a new big decimal util.
	 */
	private BigDecimalUtil() {
	}
	
	/**
	 * Convert big decimal todouble.
	 *
	 * @param bigDecimalVal the big decimal val
	 * @return the double
	 */
	public static double convertBigDecimalTodouble(BigDecimal bigDecimalVal)
	{
		if(bigDecimalVal != null)
		{
			return bigDecimalVal.doubleValue();
		}		
		return 0;
	}
}