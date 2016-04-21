package com.ankesh.myproject.service.request.dto;

import com.ankesh.myproject.service.common.BaseServiceRequest;
import com.ankesh.myproject.service.dto.UserLikesDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LikeMovieRequest extends BaseServiceRequest {

	@JsonProperty("userLikes")
	private UserLikesDTO userLikesDTO;
	

	public UserLikesDTO getUserLikesDTO() {
		return userLikesDTO;
	}

	public void setUserLikesDTO(UserLikesDTO userLikesDTO) {
		this.userLikesDTO = userLikesDTO;
	}

	
	
	
	
}
