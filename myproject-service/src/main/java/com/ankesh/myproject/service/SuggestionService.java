package com.ankesh.myproject.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ankesh.myproject.persistence.dao.SimilarsDao;
import com.ankesh.myproject.persistence.dao.UserDao;

@Component
public class SuggestionService {
	
	@Autowired
	UserDao userDao;
	

	@Autowired
	SimilarsDao similarsDao;
	
	public void updateSuggestions(String userName){
		List<String> users= userDao.getAllUsers();
		for(String user:users){
			if(!user.equals(userName)){
				double similarityIndex=calculateSimilarityIndex(userName,user);
				boolean exists=similarsDao.checkSimilarityIndexExists(userName, user);
				
				if(exists){
					//Go and udpate
					similarsDao.updateSimilarityIndex(userName, user, similarityIndex);
				}
				else{
					exists=similarsDao.checkSimilarityIndexExists(user, userName);
					if(exists){
						similarsDao.updateSimilarityIndex(user, userName, similarityIndex);
					}
					else{
						similarsDao.addSimilarityIndex(user, userName, similarityIndex);
					}
				}
			}
		}
	}

	private double calculateSimilarityIndex(String userName, String user) {
		Map<String,Integer> values= new HashMap<String,Integer>();
		long commonMoviesLiked=commonMoviesLikedByUsers(userName,user,values);
		long commonMoviesDisliked=commonMoviesDisikedByUsers(userName,user,values);
		long moviesLikedBy1andDislikedBy2=moviesLikedBy1andDislikedBy2(userName,user);
		long moviesDislikedby1andLikedBy2=moviesDislikedby1andLikedBy2(userName,user);
		//double totalMoviesAnalyzed=values.get("moviesDisikedBy1")+values.get("moviesDisikedBy2")+values.get("moviesLikedBy1")+values.get("moviesLikedBy2")-commonMoviesLiked-commonMoviesDisliked-moviesLikedBy1andDislikedBy2-moviesDislikedby1andLikedBy2;
		//Below changed as per recommendation of Ravi and Mayur
		double totalMoviesAnalyzed=commonMoviesLiked+commonMoviesDisliked+moviesLikedBy1andDislikedBy2+moviesDislikedby1andLikedBy2;
		System.out.println("commonMoviesLiked "+commonMoviesLiked);
		System.out.println("commonMoviesdisLiked "+commonMoviesDisliked);
		System.out.println("moviesLikedBy1andDislikedBy2 "+moviesLikedBy1andDislikedBy2);
		System.out.println("moviesLikedBy2andDislikedBy1 "+moviesDislikedby1andLikedBy2);
		System.out.println("totalMoviesAnalyzed "+totalMoviesAnalyzed);
		double similarityIndex=(commonMoviesLiked+commonMoviesDisliked-moviesLikedBy1andDislikedBy2-moviesDislikedby1andLikedBy2)/(totalMoviesAnalyzed);
		return similarityIndex;
		
	}



	private long commonMoviesDisikedByUsers(String userName, String user, Map<String, Integer> values) {
		long count=0;
		List<Long> moviesDislikedByUser1=userDao.getMoviesDisliked(userName);
		List<Long> moviesDislikedByUser2=userDao.getMoviesDisliked(user);
		Collections.sort(moviesDislikedByUser1);
		Collections.sort(moviesDislikedByUser2);
		values.put("moviesDisikedBy1", moviesDislikedByUser1.size());
		values.put("moviesDisikedBy2", moviesDislikedByUser2.size());
		int x=0;
		for(Long movie:moviesDislikedByUser1){
			for(Long movie2:moviesDislikedByUser2){
				int y=movie2.compareTo(movie);
				if(y==0){
					System.out.println("MOvies DisLiked "+movie);
					moviesDislikedByUser2.remove(movie2);
					
					count++;
					break;
				}
				else if (y >1){
					x=1;
					break;
				}
			}
			if(x==1){
				break;
			}
		}
		
		return count;
	}

	private long moviesDislikedby1andLikedBy2(String userName, String user) {
		long count=0;
		List<Long> moviesLikedByUser1=userDao.getMoviesDisliked(userName);
		List<Long> moviesLikedbyUser2=userDao.getMoviesLiked(user);
		Collections.sort(moviesLikedByUser1);
		Collections.sort(moviesLikedbyUser2);
		int x=0;
		for(Long movie:moviesLikedByUser1){
			for(Long movie2:moviesLikedbyUser2){
				int y=movie2.compareTo(movie);
				if(y==0){
					System.out.println("MOvies Disliked by 1 and liked by 2 "+movie);
					moviesLikedbyUser2.remove(movie2);
					
					count++;
					break;
				}
				else if (y >1){
					x=1;
					break;
				}
			}
			if(x==1){
				break;
			}
		}
		
		return count;
	}

	private long moviesLikedBy1andDislikedBy2(String userName, String user) {
		long count=0;
		List<Long> moviesLikedByUser1=userDao.getMoviesLiked(userName);
		List<Long> moviesDislikedByUser2=userDao.getMoviesDisliked(user);
		Collections.sort(moviesLikedByUser1);
		Collections.sort(moviesDislikedByUser2);
		int x=0;
		for(Long movie:moviesLikedByUser1){
			for(Long movie2:moviesDislikedByUser2){
				int y=movie2.compareTo(movie);
				if(y==0){
					System.out.println("MOvies liked by 1 and disliked by 2 "+movie);
					moviesDislikedByUser2.remove(movie2);
					
					count++;
					break;
				}
				else if (y >1){
					x=1;
					break;
				}
			}
			if(x==1){
				break;
			}
		}
		
		return count;
	}

	public long commonMoviesLikedByUsers(String userName1, String userName2, Map<String, Integer> values){
		long count=0;
		List<Long> moviesLikedByUser1=userDao.getMoviesLiked(userName1);
		List<Long> moviesLikedByUser2=userDao.getMoviesLiked(userName2);
		Collections.sort(moviesLikedByUser1);
		Collections.sort(moviesLikedByUser2);
		values.put("moviesLikedBy1", moviesLikedByUser1.size());
		values.put("moviesLikedBy2", moviesLikedByUser2.size());
		int x=0;
		for(Long movie:moviesLikedByUser1){
			for(Long movie2:moviesLikedByUser2){
				int y=movie2.compareTo(movie);
				if(y==0){
					System.out.println("MOvies Liked "+movie);
					moviesLikedByUser2.remove(movie2);
					count++;
					break;
				}
				else if (y >1){
					x=1;
					break;
				}
			}
			if(x==1){
				break;
			}
		}
		
		return count;
	}

	private List<String> getMoviesLikedByUser(String userName1) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
