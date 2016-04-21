/*
 * <Copyright file=DBConstants.java company="Morrisons Club Ltd.">
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
package com.ankesh.myproject.persistence.dao.util;


/**
 * The Interface DBConstants.
 */
public class DBConstants {

	/** The SERVICE_AUDIT_STATUS PROCESSED. */
	public static final String SERVICE_AUDIT_STATUS_PROCESSED = "PROCESSED";

	/** The SERVICE_AUDIT_STATUS PENDING. */
	public static final String SERVICE_AUDIT_STATUS_PENDING = "PENDING";

	/** The service audit status failed. */
	/*
	 * The SERVICE_AUDIT_STATUS FAILED
	 */
	public static final String SERVICE_AUDIT_STATUS_FAILED = "FAILED";

	/** The system. */
	/*
	 * The SYSTEM name variable to insert and update database
	 */
	public static final String SYSTEM = "System";

	/** The stored procedure to process the account. */
	public static final String CALL_PROCESS_ACCOUNT_PROCEDURE = " { call prc_process_account(?,?,?,?) } ";

	/** The stored procedure to process the Bank Transaction. */
	public static final String CALL_PROCESS_BANK_TRANSACTION_PROCEDURE = " { call prc_process_bank_transaction(?,?,?,?) } ";

	/** The stored procedure to submit the reconciliation. */
	public static final String CALL_PROCESS_RECONCILIATION_PROCEDURE = " { call prc_process_reconciliation(?,?,?,?) } ";

	/** The stored procedure to process the customer. */
	public static final String CALL_PROCESS_CUSTOMER_PROCEDURE = " { call prc_process_customer(?,?,?,?) } ";

	/** The stored procedure to process the eow. */
	public static final String CALL_PROCESS_EOW_PROCEDURE = " { call prc_process_eow(?,?,?,?) } ";

	/** The stored procedure to process the customer. */
	public static final String CALL_PROCESS_CARD_PAYMENT_REQUEST_PROCEDURE = " { call prc_process_card_pmt_request(?,?,?,?) } ";

	
	/** The stored procedure to process the loan oncard request . */
	public static final String CALL_PROCESS_LOAN_ONCARD_REQUEST_PROCEDURE = " { call prc_process_loac(?,?,?,?) } ";

	/** The stored procedure to process the customer. */
	public static final String CALL_PROCESS_PENDING_RECORDS_PROCEDURE = " { call prc_process_pending_request(?,?) } ";	


	/** The stored procedure result. */
	public static final String STORED_PROCEDURE_RESULT = "RESULT";

	/** The stored procedure Error Code. */
	public static final String STORED_PROCEDURE_ERROR_CODE = "ERROR_CODE";

	/** The stored procedure Error Description. */
	public static final String STORED_PROCEDURE_ERROR_DESCRIPTION = "ERROR_DESCRIPTION";

	/** Saving Image Type value. */
	public static final String IMAGE_TYPE = "png";

	/** Saving Image Format value. */
	public static final String IMAGE_FORMAT = "base64";

	/**
	 * Instantiates a new DB constants.
	 */
	private DBConstants() {
	}

}
