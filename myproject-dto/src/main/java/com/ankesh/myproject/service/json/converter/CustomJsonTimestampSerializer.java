/*
 * <Copyright file=CustomJsonTimestampSerializer.java company="Morrisons Club Ltd.">
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
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.ankesh.myproject.common.constants.CommonConstants;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


/**
 * Custom Json Serializer for java.sql.Timestamp to String
 * (yyyy-MM-dd'T'HH:mm:ss.SSS'Z') conversion
 */
public class CustomJsonTimestampSerializer extends JsonSerializer<Timestamp> {

	/** The Constant YYYYMMDDHHMMSS. */
	public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object,
	 * com.fasterxml.jackson.core.JsonGenerator,
	 * com.fasterxml.jackson.databind.SerializerProvider)
	 */
	@Override
	public void serialize(Timestamp timestamp, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider) throws IOException {
		
		if (timestamp == null)
			return;

		final SimpleDateFormat dateFormat = new SimpleDateFormat(YYYYMMDDHHMMSS);
		dateFormat.setTimeZone(TimeZone.getTimeZone(CommonConstants.TimeZoneConstants.UTCTIMEZONE));
		String dateString = dateFormat.format(timestamp);
		jsonGenerator.writeString(dateString);
	}
}
