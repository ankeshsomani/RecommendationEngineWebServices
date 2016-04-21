package com.ankesh.myproject.persistence.dao;

import java.util.List;

import com.ankesh.myproject.common.exceptions.TransactionFailureException;

public interface UserDao {

	public List<String> getAllUsers() throws TransactionFailureException;
	
	public void addUser(String userName) throws TransactionFailureException;
	
	public void removeUser(String userName) throws TransactionFailureException;
	
	public boolean checkUser(String userName) throws TransactionFailureException;
	
	public List<Long> getMoviesLiked(String userName) throws TransactionFailureException;
	
	public List<Long> getMoviesDisliked(String userName) throws TransactionFailureException;
}
