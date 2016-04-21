/*
 * <Copyright file=CustomJsonDateDeserializer.java company="Morrisons Club Ltd.">
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;


/**
 * Custom Json Deserializer for String (yyyy-MM-dd') to java.util.Date
 */
public class CustomJsonDateDeserializer extends JsonDeserializer<Date> {

	/** The Constant YYYYMMDD. */
	private static final String YYYYMMDD = "yyyy-MM-dd";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml
	 * .jackson.core.JsonParser,
	 * com.fasterxml.jackson.databind.DeserializationContext)
	 */
	@Override
	public Date deserialize(JsonParser jsonparser,
			DeserializationContext deserializationcontext) throws IOException {

		if (jsonparser == null)
			return null;

		try {
			final SimpleDateFormat dateFormat = new SimpleDateFormat(YYYYMMDD);
			String stringTimestamp = jsonparser.getText();
			return dateFormat.parse(stringTimestamp);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
