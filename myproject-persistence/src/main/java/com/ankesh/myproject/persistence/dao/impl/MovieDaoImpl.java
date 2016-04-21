package com.ankesh.myproject.persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ankesh.myproject.common.exceptions.TransactionFailureException;
import com.ankesh.myproject.persistence.dao.MovieDao;
import com.ankesh.myproject.persistence.dao.util.MongoDBUtil;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

@Repository
public class MovieDaoImpl implements MovieDao{

	/* (non-Javadoc)
	 * @see com.ankesh.myproject.persistence.dao.MovieDao#getUsersWhoLikedMovie(java.lang.String)
	 */
	@Override
	public List<String> getUsersWhoLikedMovie(Long movieId)
			throws TransactionFailureException {

		List<String> users= new ArrayList<String>();
		DB mongoDB=MongoDBUtil.getDatabase();
		
		try{

    	 
        DBCollection collection = mongoDB.getCollection("userlikes");
	    DBObject match = new BasicDBObject("$match", new BasicDBObject("movieid", movieId));
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
			throw new TransactionFailureException("Problems in getUsersWhoLikedMovie ");
		}
		finally{
			
		}
		return users;
	
	}

	@Override
	public List<String> getUsersWhoDislikedMovie(Long movieId)
			throws TransactionFailureException {

		List<String> users= new ArrayList<String>();
		DB mongoDB=MongoDBUtil.getDatabase();
		
		try{
		    DBCollection collection = mongoDB.getCollection("userdislikes");
		    DBObject match = new BasicDBObject("$match", new BasicDBObject("movieid", movieId));
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
			throw new TransactionFailureException("Problems in getUsersWhoDislikedMovie ");
		}
		finally{
			
		}
		return users;
	
	}

	@Override
	public void addMovie(Long movieId) throws TransactionFailureException {

		try{
		DB mongoDB=MongoDBUtil.getDatabase();
		
		DBCollection table = mongoDB.getCollection("movies");
		BasicDBObject document = new BasicDBObject();
    	document.put("movieId", movieId); 	
    	table.insert(document);
		}
		catch(Exception e){
			throw new TransactionFailureException("Problems while adding a record in movies table");
		}

	}

	@Override
	public boolean checkMovieExists(Long movieId)
			throws TransactionFailureException {
		boolean exists=false;
		DB mongoDB=MongoDBUtil.getDatabase();
		
		try{
		DBCollection table = mongoDB.getCollection("movies");
		BasicDBObject searchQuery = new BasicDBObject();
    	searchQuery.put("movieId", movieId);
    	    	
    	DBCursor cursor = table.find(searchQuery);
    	while (cursor.hasNext()) {
    		cursor.next();
    		exists=true;
    	}
		}
		catch(Exception e){
			throw new TransactionFailureException("Problems while checkMovieExists");
		}
		return exists;
	}

	@Override
	public List<Long> getAllMovies() throws TransactionFailureException {
		long count =0;
		List<Long> movies=new ArrayList<Long> ();
		DB mongoDB=MongoDBUtil.getDatabase();		
		try{
		    DBCollection collection = mongoDB.getCollection("movies");
		    DBObject match = new BasicDBObject("$match", new BasicDBObject());
		    DBObject groupFields = new BasicDBObject("_id", "$movieId");
		    groupFields.put("movies", new BasicDBObject("$addToSet", "$movieId"));
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
			throw new TransactionFailureException("Problems in getAllMovies ");
		}
		return movies;
	}

}
