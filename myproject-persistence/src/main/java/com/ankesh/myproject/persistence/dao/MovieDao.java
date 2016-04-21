package com.ankesh.myproject.persistence.dao;

import java.util.List;

import com.ankesh.myproject.common.exceptions.TransactionFailureException;

public interface MovieDao {

	public List<String> getUsersWhoLikedMovie(Long movieId) throws TransactionFailureException;
	
	public List<String> getUsersWhoDislikedMovie(Long movieId) throws TransactionFailureException;
	
	public void addMovie(Long movieId) throws TransactionFailureException;
	
	public boolean checkMovieExists(Long movieId) throws TransactionFailureException;
	
	public List<Long> getAllMovies() throws TransactionFailureException;
}
