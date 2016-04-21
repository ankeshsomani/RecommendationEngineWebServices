package com.ankesh.myproject.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankesh.myproject.persistence.dao.MovieDao;
import com.ankesh.myproject.persistence.dao.RecommendationDao;
import com.ankesh.myproject.persistence.dao.SimilarsDao;
import com.ankesh.myproject.persistence.dao.UserDao;
import com.ankesh.myproject.service.common.ServiceResponse;
import com.ankesh.myproject.service.dto.MovieDTO;
import com.ankesh.myproject.service.request.dto.ProcessRecommendationRequest;
import com.ankesh.myproject.service.response.dto.RecommendationServiceResponse;

@Component
public class RecommendationService {
	
	@Autowired
	RecommendationDao recommendationDao;
	
	@Autowired
	MovieDao movieDao;

	@Autowired
	SimilarsDao similarsDao;
	
	@Autowired
	UserDao userDao;

	
	public RecommendationServiceResponse getRecommendations(String userName) {
		RecommendationServiceResponse recResponse=new RecommendationServiceResponse();
		ArrayList<Long>recommendations=recommendationDao.getRecommendations(userName);
		List<MovieDTO> movies=new ArrayList<MovieDTO>();
		for(Long movieId:recommendations){
			MovieDTO movieDTO=new MovieDTO();
			movieDTO.setMovieId(movieId);
			movies.add(movieDTO);
		}
		
		recResponse.setUserName(userName);
		recResponse.setMovies(movies);
		return recResponse;
	}

	public ServiceResponse processRecommendations(
			ProcessRecommendationRequest processRequest) {
		
		ServiceResponse serviceResponse= new ServiceResponse(false,"Error in processRecommendations method");
		//get all movies which are not liked or disliked by the user
		HashSet<Long> movies = getMoviesNotRatedByUser(processRequest.getUserName());		
		
		//Delete existing recommendations as new recommendation should be inserted
		recommendationDao.deleteRecord(processRequest.getUserName());
		
		//for each movie received in last stage
			//calculate the weight and store the weight in database
		recommendationDao.addRecord(processRequest.getUserName());
		for(Long movieId:movies){
			double probIndex=calculateProbabilityIndex(processRequest.getUserName(),movieId);
			recommendationDao.updateRecord(processRequest.getUserName(), movieId, probIndex);
		}
	
		serviceResponse=new ServiceResponse(true, null);
		return serviceResponse;
	}

	private double calculateProbabilityIndex(String userName, Long movieId) {
		double probIndex=0;
		HashSet<String> users= new HashSet<String>();
		//weight/probability is calculated as per below formula
		double summationOfLikeSimilarIndexes=0;
		double summationOfDislikeSimilarIndexes=0;
		List<String> usersLikedMovie= movieDao.getUsersWhoLikedMovie(movieId);
		List<String> usersDislikedMovie= movieDao.getUsersWhoDislikedMovie(movieId);
		for(String user:usersLikedMovie){
			users.add(user);
			summationOfLikeSimilarIndexes=summationOfLikeSimilarIndexes+calculateSimilarityIndex(userName,user);
		}
		for(String user:usersDislikedMovie){
			users.add(user);
			summationOfDislikeSimilarIndexes=summationOfDislikeSimilarIndexes+calculateSimilarityIndex(userName,user);
		}
		int totalUsersCount=users.size();
		//((sum of similarity index of users who liked the movie)-(sum of similarity index of users who disliked the movie))/Total number of users who liked and disliked the movie
		probIndex=(summationOfLikeSimilarIndexes-summationOfDislikeSimilarIndexes)/(totalUsersCount);		
		return probIndex;
	}

	private double calculateSimilarityIndex(String userName, String user) {
		double index=0;
		if(similarsDao.checkSimilarityIndexExists(userName, user)){
			index=similarsDao.getSimilarityIndex(userName, user);
		}
		else if(similarsDao.checkSimilarityIndexExists(user, userName)){
			index=similarsDao.getSimilarityIndex(user, userName);
		}
		return index;
	}


	private HashSet<Long> getMoviesNotRatedByUser(String userName) {
		List<Long> totalMovies=movieDao.getAllMovies();
		List<Long> moviesLikedByUser=userDao.getMoviesLiked(userName);
		List<Long> moviesDislikedByUser=userDao.getMoviesDisliked(userName);
		TreeSet<Long> tempMovies= new TreeSet<Long>();
		tempMovies.addAll(moviesLikedByUser);
		tempMovies.addAll(moviesDislikedByUser);
		HashSet<Long> unratedMovies=new HashSet<Long>();
		Collections.sort(totalMovies);
		//Collections.sort(tempMovies);
		int count=0;
		for(Long movie:totalMovies){
			count=0;
			for(Long movieLiked:tempMovies){	
				count++;
				int y=movieLiked.compareTo(movie);
				if(y>0){
					//5 compared to 2					
					//This movie(Movie 2) is not there in the list.You can start comparing new movie from main list
					//Add this movie to unrated movie list
					//break here as you can start comparing other movies now
					unratedMovies.add(movie);
					break;
				}
				else if(y<0){
					//3 compared to 4
					//This movie(Movie 4) can be found in the list later
					if(count==tempMovies.size()){
						unratedMovies.add(movie);
					}
				}
				else if(y==0){
					//2 compared to 2
					//movie is common in lists and hence not need to be added
					//break here as you can start comparing other movies now
					break;
				}
			
			}
			
		}		
		
		return unratedMovies;
	}

}
