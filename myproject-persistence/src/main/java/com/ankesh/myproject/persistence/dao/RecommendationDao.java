package com.ankesh.myproject.persistence.dao;

import java.util.ArrayList;

import com.ankesh.myproject.common.exceptions.TransactionFailureException;

public interface RecommendationDao {

	public void addRecord(String userName) throws TransactionFailureException;
	
	public void updateRecord(String userName, long movieId, double probabilityIndex) throws TransactionFailureException;

	public boolean checkRecord(String userName, long movieId) throws TransactionFailureException;
	
	public void deleteRecord(String userName) throws TransactionFailureException;
	
	public ArrayList<Long> getRecommendations(String userName) throws TransactionFailureException;
	
}
