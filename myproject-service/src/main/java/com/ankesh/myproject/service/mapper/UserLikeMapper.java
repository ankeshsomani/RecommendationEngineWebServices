package com.ankesh.myproject.service.mapper;

import com.ankesh.myproject.persistence.entity.UserLikes;
import com.ankesh.myproject.service.dto.UserLikesDTO;

public class UserLikeMapper {
	
	public static UserLikes convertToUserLikes(UserLikesDTO userLikesDTO){
		UserLikes userLikes= new UserLikes();
		userLikes.setMovieId(userLikesDTO.getMovieId());
	//	userLikes.setUserName (userLikesDTO.getUserName());
		return userLikes;
	}

}
