package com.ankesh.myproject.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ankesh.myproject.common.constants.CommonConstants.Attributes;
import com.ankesh.myproject.common.util.JsonUtil;
import com.ankesh.myproject.service.LikeService;
import com.ankesh.myproject.service.MovieService;
import com.ankesh.myproject.service.SuggestionService;
import com.ankesh.myproject.service.UserService;
import com.ankesh.myproject.service.common.RequestMappingConstant;
import com.ankesh.myproject.service.common.ServiceResponse;
import com.ankesh.myproject.service.request.dto.DislikeMovieRequest;
import com.ankesh.myproject.service.request.dto.LikeMovieRequest;

@RestController
public class LikeServiceController extends BaseServiceController{
	
	@Autowired
	private LikeService likeService;
	 
	@Autowired
	private UserService userService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private SuggestionService suggestionService;
	
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LikeServiceController.class);
	@RequestMapping(value = RequestMappingConstant.LIKE_URL, method = RequestMethod.POST, consumes = Attributes.APPLICATION_JSON, produces = Attributes.APPLICATION_JSON)
	public ServiceResponse likeMovie(@RequestBody String likeRequestJson) {
		ServiceResponse serviceResponse =null;
		System.out.println("In Like service");
		LikeMovieRequest likeMovieRequest=(LikeMovieRequest) JsonUtil.fromJsonUnchecked(likeRequestJson, LikeMovieRequest.class);
		
		System.out.println("User name"+likeMovieRequest.getUserName() +"liked the movie "+likeMovieRequest.getUserLikesDTO().getMovieId());
		if(!userService.checkUserExists(likeMovieRequest.getUserName())){
			userService.addUser(likeMovieRequest.getUserName());
		}
		
		if(!movieService.checkMovieExists(likeMovieRequest.getUserLikesDTO().getMovieId())){
			movieService.addMovie(likeMovieRequest.getUserLikesDTO().getMovieId());
		}
		
		serviceResponse=likeService.like(likeMovieRequest);
		suggestionService.updateSuggestions(likeMovieRequest.getUserName());
		
		serviceResponse=new ServiceResponse(true, null);
		return serviceResponse;
	}
	
	@RequestMapping(value = RequestMappingConstant.DISLIKE_URL, method = RequestMethod.POST, consumes = Attributes.APPLICATION_JSON, produces = Attributes.APPLICATION_JSON)
	public ServiceResponse dislikeMovie(@RequestBody String dislikeRequestJson) {
		ServiceResponse serviceResponse =null;
		System.out.println("In disike service");
		DislikeMovieRequest dislikeMovieRequest=(DislikeMovieRequest) JsonUtil.fromJsonUnchecked(dislikeRequestJson, DislikeMovieRequest.class);
		if(!userService.checkUserExists(dislikeMovieRequest.getUserName())){
			userService.addUser(dislikeMovieRequest.getUserName());
		}
		
		System.out.println("User name"+dislikeMovieRequest.getUserName() +"disliked the movie "+dislikeMovieRequest.getUserLikesDTO().getMovieId());
		if(!movieService.checkMovieExists(dislikeMovieRequest.getUserLikesDTO().getMovieId())){
			movieService.addMovie(dislikeMovieRequest.getUserLikesDTO().getMovieId());
		}
		
		serviceResponse=likeService.dislike(dislikeMovieRequest);
		suggestionService.updateSuggestions(dislikeMovieRequest.getUserName());
		serviceResponse=new ServiceResponse(true, null);
		return serviceResponse;
	}
}
