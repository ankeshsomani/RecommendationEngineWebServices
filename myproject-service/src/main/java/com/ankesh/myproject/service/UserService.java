package com.ankesh.myproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ankesh.myproject.persistence.dao.UserDao;

@Repository
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public boolean checkUserExists(String userName) {
		boolean exists=userDao.checkUser(userName);
		return exists;
	}

	public void addUser(String userName) {
		userDao.addUser(userName);
		
	}

}
