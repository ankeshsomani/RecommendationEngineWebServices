/*
 * <Copyright file=CustomOracle9iDialect.java company="Morrisons Club Ltd.">
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
package com.ankesh.myproject.persistence.dialect;

import org.hibernate.dialect.Oracle9iDialect;


/**
 * The Class CustomOracle9iDialect.
 */
public class CustomOracle9iDialect extends Oracle9iDialect {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.dialect.Oracle8iDialect#getQuerySequencesString()
	 */
	@Override
	public String getQuerySequencesString() {
		return "select sequence_name from user_sequences "
				+ "union "
				+ "select synonym_name from user_synonyms us "
				+ "where exists (select 1 from all_objects ao where object_type='SEQUENCE' and "
				+ "us.table_name = ao.object_name)";
	}

}
