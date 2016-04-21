/*
 * <Copyright file=RequestMappingConstant.java company="Morrisons Club Ltd.">
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
package com.ankesh.myproject.service.common;


/**
 * The constants class for request mappings in cap service.
 */
public class RequestMappingConstant {

	/** The login url. */
	public static final String LOGIN_URL = "/auth";

	/** The agent url. */
	public static final String AGENT_URL = "/agent";

	/** The account url. */
	public static final String ACCOUNT_URL = "/account";
	
	
	public static final String LIKE_URL = "/like";
	public static final String RECOMMEND_URL = "/recommendations/list";
	public static final String PROCESS_RECOMMEND_URL = "/processRecommendations";
	
	public static final String DISLIKE_URL = "/dislike";
 
	/** The EOW url. */
	public static final String EOW_URL = "/eow";

	/** The get agent references url. */
	public static final String GET_AGENT_REFERENCES_URL = "/getReference";

	/** The get territories url. */
	public static final String TERRITORIES_URL = "/territory";

	/** The get territory by id url. */
	public static final String CUSTOMER_URL = "/customer";

	/** The get banking url. */
	public static final String BANKING_URL = "/banking";

	/** The get customer payment url. */
	public static final String PAYMENT_URL = "/payment";

	/** The get cash reconciliation url. */
	public static final String CASH_RECONCILIATION_URL = "/cashReconciliation";
	
	/** The get staff reconciliation url. */
	public static final String STAFF_RECONCILIATION_URL = "/staffReconciliation";

	/** The get generalreferences url. */
	public static final String GENERALREFERENCES_URL = "/generalRefences";

	/** The get commision url. */
	public static final String GET_COMMISION_URL = "/getCommision";

	/** The get accounts url. */
	public static final String GET_LIST_URL = "/list";
	
	/** The get accounts url. */
	public static final String GET_LAST_URL = "/getLast";

	
	public static final String AGENTCODE_REQPARAM = "agentCode";
	
	
	
	
	/** The agentcode reqparam. */
	public static final String USERNAME_REQPARAM = "userName";

	/** The territoryid reqparam. */
	public static final String TERRITORYID_REQPARAM = "territoryId";

	/** The startDate reqparam. */
	public static final String START_DATE_REQPARAM = "startDate";

	/** The endDate reqparam. */
	public static final String END_DATE_REQPARAM = "endDate";

	/** The weekStartDate reqparam. */
	public static final String WEEK_START_DATE_REQPARAM = "weekStartDate";

	/** The weekEndDate reqparam. */
	public static final String WEEK_END_DATE_REQPARAM = "weekEndDate";

	/** The status reqparam. */
	public static final String STATUS_REQPARAM = "status";
	/** The add account url. */
	public static final String GROUP_CODE_REQPARAM = "groupCode";

	/** The submit cash reconciliation url. */
	public static final String SUBMIT_CASH_RECONCILIATION_URL = "/cashReconciliation";

	/** The get commission calculation status url. */
	public static final String GET_COMMISSION_CALCULATION_STATUS_URL = "/getCommissionCalculationStatus";

	/** The start commission calculation url. */
	public static final String START_COMMISSION_CALCULATION_URL = "/startCommissionCalculation";

	/** The update customer url. */
	public static final String UPDATE_URL = "/update";

	/** The add account url. */
	public static final String ADD_URL = "/add";

	/**  The card paymnet request url. */
	public static final String CARD_PAYMENT_REQUEST_URL = "cardPaymentRequest";

	/** the loan card account request url */
	public static final String LOAN_CARD_ACCOUNT_REQUEST_URL="/loanCardAccountRequest";
	
	/**
	 * Instantiates a new request mapping constant.
	 */
	private RequestMappingConstant() {
	}

}
