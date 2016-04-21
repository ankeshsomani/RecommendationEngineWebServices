package com.ankesh.myproject.persistence.dao;

import com.ankesh.myproject.common.exceptions.TransactionFailureException;

public interface SimilarsDao {

	public void addSimilarityIndex(String userName1, String userName2, double similarityIndex) throws TransactionFailureException;
	
	public void updateSimilarityIndex(String userName1, String userName2,double similarityIndex) throws TransactionFailureException;
	
	public void deleteSimilarityIndex(String userName1, String userName2) throws TransactionFailureException;
	
	public boolean checkSimilarityIndexExists(String userName1, String userName2) throws TransactionFailureException;
	public double getSimilarityIndex(String userName1, String userName2) throws TransactionFailureException ;
}
