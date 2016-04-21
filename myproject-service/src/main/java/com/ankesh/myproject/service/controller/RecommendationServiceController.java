package com.ankesh.myproject.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ankesh.myproject.common.constants.CommonConstants;
import com.ankesh.myproject.common.constants.CommonConstants.Attributes;
import com.ankesh.myproject.common.util.JsonUtil;
import com.ankesh.myproject.service.RecommendationService;
import com.ankesh.myproject.service.common.RequestMappingConstant;
import com.ankesh.myproject.service.common.ServiceResponse;
import com.ankesh.myproject.service.request.dto.ProcessRecommendationRequest;
import com.ankesh.myproject.service.response.dto.RecommendationServiceResponse;

@RestController
public class RecommendationServiceController {
	
	@Autowired
	private RecommendationService recommendationService;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RecommendationServiceController.class);
	 
	@RequestMapping(value = RequestMappingConstant.RECOMMEND_URL, params = {
			RequestMappingConstant.USERNAME_REQPARAM}, method = RequestMethod.GET, produces = Attributes.APPLICATION_JSON)
	public ServiceResponse getRecommendations(
			@RequestParam(value = RequestMappingConstant.USERNAME_REQPARAM, required = true) String userName) {

		LOGGER.info("Start of getRecommendations method , userName : {}",new Object[] { userName });
		 long startTime = System.currentTimeMillis();
		ServiceResponse serviceResponse = null;

		RecommendationServiceResponse recommendationResponse = recommendationService.getRecommendations(userName);
		serviceResponse = new ServiceResponse(true, null);
		serviceResponse.add(CommonConstants.Attributes.USERNAME,
				recommendationResponse.getUserName());
		serviceResponse.add(CommonConstants.Attributes.RECOMMENDATION,
				recommendationResponse.getMovies());
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		LOGGER.info("End of getAccounts() of RecommendationServiceController.API time taken is :{} milliseconds ",elapsedTime);
		return serviceResponse;
	}
	
	@RequestMapping(value = RequestMappingConstant.PROCESS_RECOMMEND_URL, method = RequestMethod.POST, consumes = Attributes.APPLICATION_JSON, produces = Attributes.APPLICATION_JSON)
	public ServiceResponse processRecommendations(@RequestBody String processRecommendationJson) {
		ServiceResponse serviceResponse =null;
		System.out.println("In processRecommendations service");
		ProcessRecommendationRequest processRequest=(ProcessRecommendationRequest) JsonUtil.fromJsonUnchecked(processRecommendationJson, ProcessRecommendationRequest.class);
		
		System.out.println("User name"+processRequest.getUserName() +"requested for processing the recommendations ");
		serviceResponse=recommendationService.processRecommendations(processRequest);
	//	suggestionService.updateSuggestions(dislikeMovieRequest.getUserName());
		serviceResponse=new ServiceResponse(true, null);
		return serviceResponse;
	}
	
	
	
}
