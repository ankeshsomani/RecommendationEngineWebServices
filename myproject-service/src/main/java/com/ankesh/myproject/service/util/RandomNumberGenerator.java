/*
 * <Copyright file=RandomNumberGenerator.java company="Morrisons Club Ltd.">
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
package com.ankesh.myproject.service.util;

import java.util.Random;


/**
 * The Class RandomNumberGenerator.
 */
public class RandomNumberGenerator {

	/**
	 * Instantiates a new random number generator.
	 */
	private RandomNumberGenerator() {
	}

	/**
	 * Generate random number.
	 * 
	 * @return the int
	 */
	public static int generateRandomNumber() {
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		return random.nextInt(9000) + 1000;
	}
}
