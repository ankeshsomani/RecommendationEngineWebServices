/*
 * <Copyright file=CustomJsonTimestampDeserializer.java company="Morrisons Club Ltd.">
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
package com.ankesh.myproject.service.json.converter;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.ankesh.myproject.common.constants.CommonConstants;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


/**
 * Custom Json Deserializer for String (yyyy-MM-dd'T'HH:mm:ss.SSS'Z') to
 * java.sql.Timestamp
 */
public class CustomJsonTimestampDeserializer extends
		JsonDeserializer<Timestamp> {

	/** The Constant YYYYMMDDHHMMSS. */
	private static final String YYYYMMDDHHMMSS = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml
	 * .jackson.core.JsonParser,
	 * com.fasterxml.jackson.databind.DeserializationContext)
	 */
	@Override
	public Timestamp deserialize(JsonParser jsonparser,
			DeserializationContext deserializationcontext) throws IOException {

		if (jsonparser == null)
			return null;

		try {
			TimeZone.setDefault(TimeZone.getTimeZone(CommonConstants.TimeZoneConstants.LONDONTIMEZONE));
			
			final SimpleDateFormat dateFormat = new SimpleDateFormat(YYYYMMDDHHMMSS);
			dateFormat.setTimeZone(TimeZone.getTimeZone(CommonConstants.TimeZoneConstants.UTCTIMEZONE));
			String stringTimestamp = jsonparser.getText();
			Date utilDate = dateFormat.parse(stringTimestamp);
			return new Timestamp(utilDate.getTime());
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
