/*
 * <Copyright file=TimestampUtil.java company="Morrisons Club Ltd.">
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

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * The Class TimestampUtil.
 */
public final class TimestampUtil {

	/**
	 * Private constructor for TimestampUtil.
	 */
	private TimestampUtil() {
	}

	/**
	 * Gets the curent timestamp.
	 * 
	 * @return the curent timestamp
	 */
	public static Timestamp getCurentTimestamp() {
		return new Timestamp(System.currentTimeMillis());
	}
	
	/**
	 * Convert date to timestamp.
	 *
	 * @param dateVal the date val
	 * @return the timestamp
	 */
	public static Timestamp convertDateToTimestamp(Date dateVal)
	{
		if(dateVal != null)
		{
			return new Timestamp((dateVal).getTime());
		}
		return null;
	}
	
	/**
	 * This method converts a given time stamp in a specified date format and as per specified time zone
	 * @param timestamp input time stamp
	 * @param format input date format as per which output is required
	 * @param timeZone input time zone in which time stamp needs to be converted
	 * @return
	 */
	public static String convertToTimeStamp(Timestamp timestamp,String format,TimeZone timeZone){
		String strTimeStamp="";
		if (timestamp == null)
			return strTimeStamp;
		final SimpleDateFormat dateFormat = new SimpleDateFormat(format);		
		dateFormat.setTimeZone(timeZone);
		strTimeStamp = dateFormat.format(timestamp);
		return strTimeStamp;
	}
}
