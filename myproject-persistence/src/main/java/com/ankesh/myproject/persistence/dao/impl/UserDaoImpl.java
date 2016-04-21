package com.ankesh.myproject.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ankesh.myproject.common.exceptions.TransactionFailureException;
import com.ankesh.myproject.persistence.dao.UserDao;
import com.ankesh.myproject.persistence.dao.util.MongoDBUtil;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public List<String> getAllUsers() throws TransactionFailureException {

		List<String> users= new ArrayList<String>();
		DB mongoDB=MongoDBUtil.getDatabase();
		
		try{
		    DBCollection collection = mongoDB.getCollection("users");

			   
		    DBObject match = new BasicDBObject("$match", new BasicDBObject());
		    DBObject groupFields = new BasicDBObject("_id", "$username");
		    groupFields.put("users", new BasicDBObject("$addToSet", "$username"));
		    DBObject group = new BasicDBObject("$group", groupFields);

		    AggregationOutput output = collection.aggregate(match, group);

		    Iterable<DBObject> itResult = output.results();

		    for (DBObject dbo : itResult) {
		        List<String> items = (List<String>) dbo.get("users");
		        for(String item : items){
		            users.add(item);
		        }

		    }
		}
		catch(Exception e){
			throw new TransactionFailureException("Problems while checking for a record");
		}
		return users;
		
	}
	@Override
	public void addUser(String userName) throws TransactionFailureException{

		try{
		DB mongoDB=MongoDBUtil.getDatabase();
		
		DBCollection table = mongoDB.getCollection("users");
		BasicDBObject document = new BasicDBObject();
    	document.put("username", userName);   	
    	table.insert(document);
		}
		catch(Exception e){
			throw new TransactionFailureException("Problems while adding a record in users table");
		}
		
	
	}
	
	@Override
	public void removeUser(String userName) throws TransactionFailureException{

		try{
		DB mongoDB=MongoDBUtil.getDatabase();
		
		DBCollection table = mongoDB.getCollection("users");
		BasicDBObject document = new BasicDBObject();
    	document.put("username", userName);   	
    	table.remove(document);
		}
		catch(Exception e){
			throw new TransactionFailureException("Problems while removing a record from users table");
		}
		
	
	}
	@Override
	public boolean checkUser(String userName) throws TransactionFailureException {


		boolean exists=false;
		DB mongoDB=MongoDBUtil.getDatabase();
		
		try{
		DBCollection table = mongoDB.getCollection("users");
		BasicDBObject searchQuery = new BasicDBObject();
    	searchQuery.put("username", userName);
    	    	
    	DBCursor cursor = table.find(searchQuery);
    	while (cursor.hasNext()) {
    		cursor.next();
    		exists=true;
    	}
		}
		catch(Exception e){
			throw new TransactionFailureException("Problems while checking for a record in checkUser ");
		}
		return exists;
	
		
	}
	@Override
	public List<Long> getMoviesLiked(String userName)
			throws TransactionFailureException {
		List<Long> movies= new ArrayList<Long>();
		DB mongoDB=MongoDBUtil.getDatabase();
		
		try{
		    DBCollection collection = mongoDB.getCollection("userlikes");
		    DBObject match = new BasicDBObject("$match", new BasicDBObject("username", userName));
		    DBObject groupFields = new BasicDBObject("_id", "$movieid");
		    groupFields.put("movies", new BasicDBObject("$addToSet", "$movieid"));
		    DBObject group = new BasicDBObject("$group", groupFields);

		    AggregationOutput output = collection.aggregate(match, group);

		    Iterable<DBObject> itResult = output.results();

		    for (DBObject dbo : itResult) {
		        List<Long> items = (List<Long>) dbo.get("movies");
		        for(Long item : items){
		        	movies.add(item);
		        }

		    }
		}
		catch(Exception e){
			e.printStackTrace();
			throw new TransactionFailureException("Problems in getMoviesLiked ");
		}
		return movies;
	}
	@Override
	public List<Long> getMoviesDisliked(String userName)
			throws TransactionFailureException {
		List<Long> movies= new ArrayList<Long>();
		DB mongoDB=MongoDBUtil.getDatabase();
		
		try{
		    DBCollection collection = mongoDB.getCollection("userdislikes");
		    DBObject match = new BasicDBObject("$match", new BasicDBObject("username",userName));
		    DBObject groupFields = new BasicDBObject("_id", "$movieid");
		    groupFields.put("movies", new BasicDBObject("$addToSet", "$movieid"));
		    DBObject group = new BasicDBObject("$group", groupFields);

		    AggregationOutput output = collection.aggregate(match, group);

		    Iterable<DBObject> itResult = output.results();

		    for (DBObject dbo : itResult) {
		    	  List<Long> items = (List<Long>) dbo.get("movies");
			        for(Long item : items){
			        	movies.add(item);
			        }

		    }
		}
		catch(Exception e){
			throw new TransactionFailureException("Problems in getMoviesDisliked ");
		}
		finally{
			
		}
		return movies;
	}

	
	
}
