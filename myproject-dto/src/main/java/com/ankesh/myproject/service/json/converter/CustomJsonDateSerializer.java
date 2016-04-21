/*
 * <Copyright file=CustomJsonDateSerializer.java company="Morrisons Club Ltd.">
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
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;


/**
 * Custom Json Serializer for java.util.Date to String (yyyy-MM-dd) conversion
 */
public class CustomJsonDateSerializer extends JsonSerializer<Date> {

	/** The Constant YYYYMMDD. */
	private static final String YYYYMMDD = "yyyy-MM-dd";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fasterxml.jackson.databind.JsonSerializer#serialize(java.lang.Object,
	 * com.fasterxml.jackson.core.JsonGenerator,
	 * com.fasterxml.jackson.databind.SerializerProvider)
	 */
	@Override
	public void serialize(Date utilDate, JsonGenerator jsonGenerator,
			SerializerProvider serializerProvider) throws IOException {

		if (utilDate == null)
			return;

		final SimpleDateFormat dateFormat = new SimpleDateFormat(YYYYMMDD);
		String dateString = dateFormat.format(utilDate);
		jsonGenerator.writeString(dateString);
	}
}
