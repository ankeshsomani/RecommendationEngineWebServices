package com.ankesh.myproject.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;

import com.ankesh.myproject.common.exceptions.TransactionFailureException;
import com.ankesh.myproject.persistence.dao.SimilarsDao;
import com.ankesh.myproject.persistence.dao.util.MongoDBUtil;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;


@Repository
public class SimilarsDaoImpl implements SimilarsDao{

	@Override
	public boolean checkSimilarityIndexExists(String userName1, String userName2) throws TransactionFailureException {


		boolean exists=false;
		DB mongoDB=MongoDBUtil.getDatabase();
	
		try{
		DBCollection table = mongoDB.getCollection("similarity");
		BasicDBObject searchQuery = new BasicDBObject();
    	searchQuery.put("users", userName1+":"+userName2);
    	    	
    	DBCursor cursor = table.find(searchQuery);
    	while (cursor.hasNext()) {
    		cursor.next();
    		exists=true;
    	}
	
		}
		catch(Exception e){
			e.printStackTrace();
			throw new TransactionFailureException("Problems while checking for a record");
		}
		return exists;
	
		
	}
	
	@Override
	public double getSimilarityIndex(String userName1, String userName2)
			throws TransactionFailureException {
		double similarityIndex=0;
		 DBObject objReturned= null;
		DB mongoDB=MongoDBUtil.getDatabase();
		
		try{
		DBCollection table = mongoDB.getCollection("similarity");
		BasicDBObject searchQuery = new BasicDBObject();
    	searchQuery.put("users", userName1+":"+userName2);
    	BasicDBObject fields = new BasicDBObject("similarityIndex",true).append("_id",false);   	
    	DBCursor cursor = table.find(searchQuery,fields);
    	while (cursor.hasNext()) {
    		objReturned=cursor.next();
    		
    	}
	
    	similarityIndex=new Double(objReturned.get("similarityIndex").toString());
		}
		catch(Exception e){
			e.printStackTrace();
			throw new TransactionFailureException("Problems while checking for a record");
		}
		finally{
			
		}
		return similarityIndex;
		
	}

	@Override
	public void addSimilarityIndex(String userName1, String userName2,
			double similarityIndex) throws TransactionFailureException {


		try{
		DB mongoDB=MongoDBUtil.getDatabase();
		
		DBCollection table = mongoDB.getCollection("similarity");
		BasicDBObject document = new BasicDBObject();
    	document.put("users", userName1+":"+userName2);  
    	document.put("similarityIndex", similarityIndex);
    	table.insert(document);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new TransactionFailureException("Problems in addSimilarityIndex");
		}
		
	
	
		
	}

	@Override
	public void updateSimilarityIndex(String userName1, String userName2,
			double similarityIndex) throws TransactionFailureException {
		try{
			DB mongoDB=MongoDBUtil.getDatabase();
			
			
			BasicDBObject query = new BasicDBObject();
	    	query.put("users", userName1+":"+userName2);

			DBCollection table = mongoDB.getCollection("similarity");
			BasicDBObject newDocument = new BasicDBObject();
	    	newDocument.put("similarityIndex", similarityIndex);

	    	BasicDBObject updateObj = new BasicDBObject();
	    	updateObj.put("$set", newDocument);

	    	table.update(query, updateObj);

	    
			}
			catch(Exception e){
				e.printStackTrace();
				throw new TransactionFailureException("Problems in updateSimilarityIndex");
			}
			
		
		
	}

	@Override
	public void deleteSimilarityIndex(String userName1, String userName2)
			throws TransactionFailureException {
		// TODO Auto-generated method stub
		
	}

}
