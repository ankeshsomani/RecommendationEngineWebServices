/*
 * <Copyright file=DateUtil.java company="Morrisons Club Ltd.">
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.ankesh.myproject.common.constants.CommonConstants;
import com.ankesh.myproject.common.exceptions.CapServiceException;


/**
 * The Class DateUtil.
 */
public final class DateUtil {

	/** The Constant ERROR_MESSAGE_DATE_STRING. */
	private static final String ERROR_MESSAGE_DATE_STRING = "Error occurred while parsing the date string into format:";

	/** The Constant DD_MMM_YYYY. */
	public static final String YYYYMMDDHHMMSSZ = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

	/** The Constant YYYYMMDD. */
	public static final String YYYYMMDD = "yyyy-MM-dd";

	/** The Constant YYYYMMDDHHMMSSZ_SHORT. */
	public static final String YYYYMMDDHHMMSSZ_SHORT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

	/**
	 * Instantiates a new date util.
	 */
	private DateUtil() {
	}

	/**
	 * Date today without time.
	 * 
	 * @return the date
	 */
	public static Date dateToday() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(YYYYMMDDHHMMSSZ);
		Date dateToday = new Date();
		try {
			dateToday = dateFormat.parse(dateFormat.format(dateToday));
		} catch (ParseException e) {
			throw new CapServiceException(ERROR_MESSAGE_DATE_STRING
					+ dateFormat, e);
		}
		return dateToday;
	}

	/**
	 * Date today without time after specified number of days.
	 * 
	 * @param days
	 *            the no of days after today
	 * @return the date
	 */
	public static Date dateTodayPlusDays(int days) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(YYYYMMDDHHMMSSZ);
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, days);
		Date dateTodayPlus = c.getTime();
		try {
			dateTodayPlus = dateFormat.parse(dateFormat.format(dateTodayPlus));
		} catch (ParseException e) {
			throw new CapServiceException(ERROR_MESSAGE_DATE_STRING
					+ dateFormat, e);
		}
		return dateTodayPlus;
	}

	/**
	 * Formatted Date today string without time.
	 * 
	 * @return the string
	 */
	public static String dateTodayString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(YYYYMMDDHHMMSSZ);
		return dateFormat.format(new Date());
	}

	/**
	 * Date converted to string in specified format.
	 * 
	 * @param date
	 *            the date
	 * @param format
	 *            the format
	 * @return the string
	 */
	public static String toDateString(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);
	}

	/**
	 * Date converted to string in default (dd-MMM-yyyy) format.
	 * 
	 * @param date
	 *            the date
	 * @return the string
	 */
	public static String toDateString(Date date) {
		return toDateString(date, YYYYMMDDHHMMSSZ);
	}

	/**
	 * String converted to date in specified format.
	 * 
	 * @param date
	 *            the date string
	 * @param format
	 *            the format
	 * @return the date
	 */
	public static Date toDate(String date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			throw new CapServiceException(ERROR_MESSAGE_DATE_STRING + format, e);
		}
	}

	/**
	 * String converted to date.
	 * 
	 * @param date
	 *            the date string
	 * @return the date
	 */
	public static Date toDate(String date) {
		return toDate(date, YYYYMMDDHHMMSSZ);
	}

	/**
	 * Gets the time difference.
	 * 
	 * @param startTime
	 *            the start time
	 * @param endTime
	 *            the end time
	 * @return the time difference
	 */
	public static String getTimeDifference(Timestamp startTime,
			Timestamp endTime) {
		long timeInMilliseconds = endTime.getTime() - startTime.getTime();
		int seconds = (int) (timeInMilliseconds / 1000);
		int minutes = seconds / 60;
		int milliseconds = (int) (timeInMilliseconds % 1000);
		return minutes + " minute(s) " + seconds + " second(s) " + milliseconds
				+ " millisecond(s)";
	}

	/**
	 * Gets the performance time.
	 * 
	 * @param startTime
	 *            the start time
	 * @return the performance time
	 */
	public static String getPerformanceTime(Timestamp startTime) {
		return getTimeDifference(startTime,
				new Timestamp(System.currentTimeMillis()));
	}
	
	/**
	 * 
	 * @param strInput the Timestamp in UTC format
	 * @return the Corresponding date for London
	 * @throws ParseException
	 */
	public static Date convertUTCTimestampStringToBritishDate(String strInput) {
		TimeZone.setDefault(TimeZone.getTimeZone(CommonConstants.TimeZoneConstants.LONDONTIMEZONE));
		
		final SimpleDateFormat dateFormat = new SimpleDateFormat(YYYYMMDDHHMMSSZ);
		dateFormat.setTimeZone(TimeZone.getTimeZone(CommonConstants.TimeZoneConstants.UTCTIMEZONE));
		String stringTimestamp = strInput;
		Date utilDate =null;
		try{
		utilDate = dateFormat.parse(stringTimestamp);
		} catch (ParseException e) {
			throw new CapServiceException(ERROR_MESSAGE_DATE_STRING
					+ dateFormat, e);
		}
		return utilDate;
	}

}