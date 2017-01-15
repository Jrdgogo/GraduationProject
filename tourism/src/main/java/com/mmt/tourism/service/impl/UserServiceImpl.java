package com.mmt.tourism.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmt.tourism.dao.UserMapper;
import com.mmt.tourism.pojo.User;
import com.mmt.tourism.pojo.UserExample;
import com.mmt.tourism.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User getUserByName_Pwd(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean getUserByName(String username) {
		UserExample userExample=new UserExample();
		userExample.createCriteria().andUsernameEqualTo(username);
		int count=userMapper.countByExample(userExample);
		if(count>0)
			return true;
		return false;
		
	}

}
