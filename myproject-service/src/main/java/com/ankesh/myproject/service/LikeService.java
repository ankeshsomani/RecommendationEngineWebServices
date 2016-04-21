package com.ankesh.myproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankesh.myproject.persistence.dao.LikeDao;
import com.ankesh.myproject.persistence.entity.UserLikes;
import com.ankesh.myproject.service.common.ServiceResponse;
import com.ankesh.myproject.service.mapper.UserLikeMapper;
import com.ankesh.myproject.service.request.dto.DislikeMovieRequest;
import com.ankesh.myproject.service.request.dto.LikeMovieRequest;

@Component
public class LikeService {
	

	@Autowired
	private LikeDao userLikesDao;
	
	
	public ServiceResponse like(LikeMovieRequest likeMovieRequest) {
		ServiceResponse serviceResponse=null;
		//Store the data in json format
		//If the user already liked this movie, no need to add a new entry
		System.out.println(likeMovieRequest.getUserLikesDTO().getMovieId());
		UserLikes userLikes = UserLikeMapper.convertToUserLikes(likeMovieRequest.getUserLikesDTO());
		userLikes.setUserName(likeMovieRequest.getUserName());
		
		boolean checkIfEntryExists= userLikesDao.checkLikeEntryExists(userLikes);
		if(!checkIfEntryExists){
			userLikesDao.addLikeEntry(userLikes);
			
		}
		if(userLikesDao.checkDislikeEntryExists(userLikes)){
			userLikesDao.removeDislikesEntry(userLikes);
		}
		serviceResponse= new ServiceResponse(true, null);
				
		return serviceResponse;
		
	}

	public ServiceResponse dislike(DislikeMovieRequest dislikeMovieRequest) {
		ServiceResponse serviceResponse=null;
		//Store the data in json format
		//If the user already liked this movie, no need to add a new entry
		System.out.println(dislikeMovieRequest.getUserLikesDTO().getMovieId());
		UserLikes userLikes = UserLikeMapper.convertToUserLikes(dislikeMovieRequest.getUserLikesDTO());
		userLikes.setUserName(dislikeMovieRequest.getUserName());
		boolean checkIfEntryExists= userLikesDao.checkDislikeEntryExists(userLikes);
		if(!checkIfEntryExists){
			userLikesDao.addDisikeEntry(userLikes);
			
		}
		if(userLikesDao.checkLikeEntryExists(userLikes)){
			userLikesDao.removeLikesEntry(userLikes);
		}
		serviceResponse= new ServiceResponse(true, null);
		return serviceResponse;
	}

}
