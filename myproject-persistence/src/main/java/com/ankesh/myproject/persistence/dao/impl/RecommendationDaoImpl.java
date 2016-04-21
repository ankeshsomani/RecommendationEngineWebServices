package com.ankesh.myproject.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ankesh.myproject.common.exceptions.TransactionFailureException;
import com.ankesh.myproject.persistence.dao.RecommendationDao;
import com.ankesh.myproject.persistence.dao.util.MongoDBUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Repository
public class RecommendationDaoImpl implements RecommendationDao{

	@Override
	public void addRecord(String userName)
			throws TransactionFailureException {
		try{
		DB mongoDB=MongoDBUtil.getDatabase();
		
		DBCollection table = mongoDB.getCollection("recommendations");
		BasicDBObject document = new BasicDBObject();
		//BasicDocumentDetail docDetail=new D
    	document.put("userName", userName);      	
    	table.insert(document);
		}
		catch(Exception e){
			e.printStackTrace();
			throw new TransactionFailureException("Problems in addSimilarityIndex");
		}

	}

	@Override
	public void updateRecord(String userName, long movieId,double probabilityIndex) throws TransactionFailureException {
		try{
			DB mongoDB=MongoDBUtil.getDatabase();				
		    DBCollection table = mongoDB.getCollection("recommendations");	
			BasicDBObject query = new BasicDBObject();
			query.put("userName", userName);			
	
			BasicDBObject documentDetail = new BasicDBObject();
			documentDetail.put("movieId", movieId);
			documentDetail.put("weight", probabilityIndex);
				
			DBObject listItem = new BasicDBObject("movies",documentDetail);
			DBObject updateQuery = new BasicDBObject("$push", listItem);
			table.update(query, updateQuery);			
			
		}
		catch(Exception e){
			e.printStackTrace();
			throw new TransactionFailureException("Problems in updateRecord in RecommendationDaoImpl");
		}
		
	}

	@Override
	public boolean checkRecord(String userName, long movieId)
			throws TransactionFailureException {
		boolean exists=false;
		DB mongoDB=MongoDBUtil.getDatabase();
	
		try{
		DBCollection table = mongoDB.getCollection("recommendations");
		BasicDBObject searchQuery = new BasicDBObject();
    	searchQuery.put("userName", userName);
    	 BasicDBObject fields = new BasicDBObject();
    	 //fields.put("_id", 0);
    	 fields.put("suggestions", 0);    	
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
	public void deleteRecord(String userName)
			throws TransactionFailureException {		
		DB mongoDB=MongoDBUtil.getDatabase();	
		try{
		DBCollection table = mongoDB.getCollection("recommendations");
		BasicDBObject searchQuery = new BasicDBObject();
    	searchQuery.put("userName", userName);    	    	
    	table.remove(searchQuery);	
		}
		catch(Exception e){
			e.printStackTrace();
			throw new TransactionFailureException("Problems while deleteRecord");
		}		
	}

	@Override
	public ArrayList<Long> getRecommendations(String userName)
			throws TransactionFailureException {
		ArrayList<Long> movieRecommendations=new ArrayList<Long>();
		DB mongoDB=MongoDBUtil.getDatabase();
		
		try{			 
			    DBCollection table = mongoDB.getCollection("recommendations");
				BasicDBObject searchQuery = new BasicDBObject();
		    	searchQuery.put("userName",userName);
		    	DBObject object=null;
		    	BasicDBObject fields = new BasicDBObject("movies",true).append("_id",false); 	
		    	DBCursor cursor = table.find(searchQuery,fields);
		    	while (cursor.hasNext()) {
		    		object=cursor.next();		    		
		    	}
		    	List<DBObject> obj2=(List<DBObject>)object.get("movies");
		    	for(DBObject obj3:obj2){ 	
		    		if((Double)obj3.get("weight") > 0){
		    			movieRecommendations.add((Long)obj3.get("movieId"));
		    		}
		   
		    	}
		}
		catch(Exception e){
			e.printStackTrace();
			throw new TransactionFailureException("Problems while checking for a record");
		}
		return movieRecommendations;
	}

	
}
