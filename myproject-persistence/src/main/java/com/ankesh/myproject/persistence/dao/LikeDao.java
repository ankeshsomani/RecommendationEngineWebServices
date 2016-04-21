package com.ankesh.myproject.persistence.dao;

import com.ankesh.myproject.common.exceptions.TransactionFailureException;
import com.ankesh.myproject.persistence.entity.UserLikes;

public interface LikeDao {

	public boolean checkLikeEntryExists(UserLikes userLikes) throws TransactionFailureException;
	
	public void addLikeEntry(UserLikes userLikes) throws TransactionFailureException;

	public boolean checkDislikeEntryExists(UserLikes userLikes) throws TransactionFailureException;

	public void addDisikeEntry(UserLikes userLikes)  throws TransactionFailureException;

	public void removeDislikesEntry(UserLikes userLikes) throws TransactionFailureException;
	
	public void  removeLikesEntry(UserLikes userLikes) throws TransactionFailureException;
	
	
}
