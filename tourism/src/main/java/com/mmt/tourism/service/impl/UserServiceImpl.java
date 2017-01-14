package com.mmt.tourism.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmt.tourism.dao.UserDao;
import com.mmt.tourism.pojo.User;
import com.mmt.tourism.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public User getUserByName_Pwd(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getUserByName(String username) {
		
		User u=userDao.getUserByName(username);
		if(u!=null)
			return true;
		return false;
		
	}

}
