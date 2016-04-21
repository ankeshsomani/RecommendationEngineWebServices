package com.ankesh.myproject.persistence.dao.util;

import com.ankesh.myproject.common.exceptions.TransactionFailureException;
import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDBUtil {

	
	public static DB getDatabase(){
		DB db =null;
		try {

	    	/**** Connect to MongoDB ****/
	    	// Since 2.10.0, uses MongoClient
	    	MongoClient mongo = new MongoClient("localhost", 27017);

	    	/**** Get database ****/
	    	// if database doesn't exists, MongoDB will create it for you
	    	db = mongo.getDB("testdb");
	    	
		}
		catch(Exception e){
			throw new TransactionFailureException("Failed to get DB Object");
		}
		return db;
	}
}
