package com.ankesh.myproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ankesh.myproject.persistence.dao.MovieDao;

@Repository
public class MovieService {
	
	@Autowired
	MovieDao movieDao;
	
	public void addMovie(Long movieId){
		movieDao.addMovie(movieId);
	}
	
	public boolean checkMovieExists(Long movieId){
		return movieDao.checkMovieExists(movieId);
	}

}
