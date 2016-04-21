/*
 * <Copyright file=CommonConstants.java company="Morrisons Club Ltd.">
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
package com.ankesh.myproject.common.constants;

import com.ankesh.myproject.common.cache.CapServiceCacheItemLoader;


/**
 * The Class CommonConstants.
 */
public class CommonConstants {

	/**
	 * Instantiates a new common constants.
	 */
	private CommonConstants() {
	}
	
	public static class TimeZoneConstants {
		
		/** The Constant UTCTIMEZONE. */
		public static final String UTCTIMEZONE = "UTC";
		
		/** The Constant LONDONTIMEZONE. */
		public static final String LONDONTIMEZONE ="Europe/London";
		
		private TimeZoneConstants(){
			
		}
	}

	/**
	 * The Class Attributes.
	 */
	public static class Attributes {

		/** The Constant APPLICATION_JSON. */
		public static final String APPLICATION_JSON = "application/json";

		/** The Constant RESULT. */
		public static final String RESULT = "result";

		/** The Constant AGENT. */
		public static final String AGENT = "agent";

		/** The Constant CUSTOMER. */
		public static final String RECOMMENDATION = "recommendedMovies";

		public static final String USERNAME = "userName";

		
		/**
		 * Instantiates a new attributes.
		 */
		private Attributes() {
		}
	}

	/**
	 * The Class Request types.
	 */
	public static class RequestTypes {

		/** The Constant UPDATE_ACCOUNT. */
		public static final String UPDATE_ACCOUNT = "updateAccount";

		/** The Constant UPDATE_CUSTOMER. */
		public static final String UPDATE_CUSTOMER = "updateCustomer";

		/** The Constant START_COMMISSION_CALCULATION. */
		public static final String START_COMMISSION_CALCULATION = "startCommissionCalculation";

		/** The Constant SUBMIT_CASH_RECONCILIATION. */
		public static final String SUBMIT_CASH_RECONCILIATION = "submitCashReconciliation";

		/** The Constant SUBMIT_CARD_PAYMENT_REQUEST. */
		public static final String SUBMIT_CARD_PAYMENT_REQUEST = "submitCardPaymentRequest";
		

		/** The Constant SUBMIT_LOAN_CARD_ACCOUNT_REQUEST. */
		
		public static final String SUBMIT_LOAN_CARD_ACCOUNT_REQUEST="submitLoanCardAccountRequest";

		/** The Constant ADD_BANK_TRANSACTION. */
		public static final String ADD_BANK_TRANSACTION = "addBankingTransaction";
		
			/**
		 * Instantiates a new request types.
		 */
		private RequestTypes() {
		}
	}

	/**
	 * constant APPLICATION_ERROR.
	 */

	public static class ErrorMessages {

		/** The Constant APPLICATION_ERROR. */
		public static final String APPLICATION_ERROR = CapServiceCacheItemLoader
				.getCapServiceConfigVal("APPLICATION_ERROR").trim();

		/** The Constant VALIDATION_ERROR. */
		public static final String VALIDATION_ERROR = CapServiceCacheItemLoader
				.getCapServiceConfigVal("VALIDATION_ERROR").trim();

		/** The Constant TRANSACTION_ERROR. */
		public static final String TRANSACTION_ERROR = CapServiceCacheItemLoader
				.getCapServiceConfigVal("TRANSACTION_ERROR").trim();

		/** The Constant RUNTIME_EXCEPTION_ERROR. */
		public static final String RUNTIME_EXCEPTION_ERROR = CapServiceCacheItemLoader
				.getCapServiceConfigVal("RUNTIME_EXCEPTION_ERROR").trim();

		/** The Constant DUPLICATE_EXCEPTION_ERROR. */
		public static final String DUPLICATE_EXCEPTION_ERROR = CapServiceCacheItemLoader
				.getCapServiceConfigVal("DUPLICATE_EXCEPTION_ERROR").trim();
		
		/** The Constant PENDING_EXCEPTION_ERROR. */
		public static final String PENDING_EXCEPTION_ERROR = CapServiceCacheItemLoader
				.getCapServiceConfigVal("PENDING_EXCEPTION_ERROR").trim();

		/**
		 * Instantiates a new error messages.
		 */
		private ErrorMessages() {
		}
	}
	
	/**
	 * 
	 * The Class ApplicationConfiguration.
	 *
	 */
	public static class ApplicationConfiguration{
		
		/** The Constant ENABLE_AUDIT_LOG. */
		
		public static final String ENABLE_AUDIT_LOG =CapServiceCacheItemLoader.getEnableDBAuditLogs();
		public static final String JDBC_DRIVER_CLASS = CapServiceCacheItemLoader.getDriverClass();
		public static final String JDBC_URL = CapServiceCacheItemLoader.getJdbcUrl();
		public static final String JDBC_USERNAME = CapServiceCacheItemLoader.getJdbcUsername();
		public static final String JDBC_PASSWORD = CapServiceCacheItemLoader.getJdbcPassword();
		
		private ApplicationConfiguration(){
			/** Constant for Database details. */
	
		}
		
	}
	
	/**
	 * 
	 * The Class Generic Constants.
	 *
	 */
	public static class GenericConstants{
		
		/** The Constant FALSE. */
		public static final String FALSE ="false";
		
//		public static final String PROPERTIES_FILE_PATH = "/data/tomcat/config/cap/";
		public static final String PROPERTIES_FILE_PATH = "D:\\data\\tomcat\\config\\cap\\";				
		private GenericConstants(){
			
		}
		
	}
}
