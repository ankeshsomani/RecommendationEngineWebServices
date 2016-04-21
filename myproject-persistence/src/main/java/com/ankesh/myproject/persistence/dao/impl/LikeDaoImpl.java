package com.ankesh.myproject.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.ankesh.myproject.common.exceptions.TransactionFailureException;
import com.ankesh.myproject.persistence.dao.LikeDao;
import com.ankesh.myproject.persistence.dao.util.MongoDBUtil;
import com.ankesh.myproject.persistence.entity.UserLikes;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

@Repository
public class LikeDaoImpl implements LikeDao{

	@Override
	public boolean checkLikeEntryExists(UserLikes userLikes)
			throws TransactionFailureException {

		boolean exists=false;
		DB mongoDB=MongoDBUtil.getDatabase();
		String userName=userLikes.getUserName();
		long movieId=userLikes.getMovieId();
		try{
		DBCollection table = mongoDB.getCollection("userlikes");
		BasicDBObject searchQuery = new BasicDBObject();
    	searchQuery.put("username", userName);
    	searchQuery.put("movieid", movieId);    	
    	DBCursor cursor = table.find(searchQuery);
    	while (cursor.hasNext()) {
    		cursor.next();
    		exists=true;
    	}
		}
		catch(Exception e){
			throw new TransactionFailureException("Problems while checking for a record");
		}
		return exists;
	}

	@Override
	public void addLikeEntry(UserLikes userLikes)
			throws TransactionFailureException {
		try{
		DB mongoDB=MongoDBUtil.getDatabase();
		String userName=userLikes.getUserName();
		long movieId=userLikes.getMovieId();
		DBCollection table = mongoDB.getCollection("userlikes");
		BasicDBObject document = new BasicDBObject();
    	document.put("username", userName);
    	document.put("movieid", movieId);
    	
    	table.insert(document);
		}
		catch(Exception e){
			throw new TransactionFailureException("Problems while adding a record");
		}
		
	}

	@Override
	public boolean checkDislikeEntryExists(UserLikes userLikes)
			throws TransactionFailureException {
		
		boolean exists=false;
		DB mongoDB=MongoDBUtil.getDatabase();
		String userName=userLikes.getUserName();
		long movieId=userLikes.getMovieId();
		try{
		DBCollection table = mongoDB.getCollection("userdislikes");
		BasicDBObject searchQuery = new BasicDBObject();
    	searchQuery.put("username", userName);
    	searchQuery.put("movieid", movieId);    	
    	DBCursor cursor = table.find(searchQuery);
    	while (cursor.hasNext()) {
    		cursor.next();
    		exists=true;
    	}
		}
		catch(Exception e){
			throw new TransactionFailureException("Problems while checking for a record in userdislikes");
		}
		return exists;
	}

	@Override
	public void addDisikeEntry(UserLikes userLikes)
			throws TransactionFailureException {
		try{
		DB mongoDB=MongoDBUtil.getDatabase();
		String userName=userLikes.getUserName();
		long movieId=userLikes.getMovieId();
		DBCollection table = mongoDB.getCollection("userdislikes");
		BasicDBObject document = new BasicDBObject();
    	document.put("username", userName);
    	document.put("movieid", movieId);
    	
    	table.insert(document);
		}
		catch(Exception e){
			throw new TransactionFailureException("Problems while adding a record in userdislikes");
		}
		
		
	}

	@Override
	public void removeDislikesEntry(UserLikes userLikes)
			throws TransactionFailureException {
		try{
			DB mongoDB=MongoDBUtil.getDatabase();
			String userName=userLikes.getUserName();
			long movieId=userLikes.getMovieId();
			DBCollection table = mongoDB.getCollection("userdislikes");
			BasicDBObject document = new BasicDBObject();
	    	document.put("username", userName);
	    	document.put("movieid", movieId);
	    	
	    	table.remove(document);
			}
			catch(Exception e){
				throw new TransactionFailureException("Problems while removing a record in userdislikes");
			}
		
	}

	
	@Override
	public void removeLikesEntry(UserLikes userLikes)
			throws TransactionFailureException {
		try{
			DB mongoDB=MongoDBUtil.getDatabase();
			String userName=userLikes.getUserName();
			long movieId=userLikes.getMovieId();
			DBCollection table = mongoDB.getCollection("userlikes");
			BasicDBObject document = new BasicDBObject();
	    	document.put("username", userName);
	    	document.put("movieid", movieId);
	    	
	    	table.remove(document);
			}
			catch(Exception e){
				throw new TransactionFailureException("Problems while removing a record in userdislikes");
			}
		
	}
}
