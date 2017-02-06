package com.mmt.tourism.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmt.tourism.dao.UserExtrMapper;
import com.mmt.tourism.dao.UserMapper;
import com.mmt.tourism.pojo.User;
import com.mmt.tourism.pojo.UserExample;
import com.mmt.tourism.pojo.UserExtr;
import com.mmt.tourism.service.UserService;
import com.mmt.tourism.util.GlobalUtil;
import com.mmt.tourism.util.SpringMail;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserExtrMapper userExtrMapper;
	@Autowired
	private SpringMail springMail;

	@Override
	public User getUserByName_Pwd(User user) {
		UserExample userExample=new UserExample();
		userExample.createCriteria().andUsernameEqualTo(user.getUsername()).andPasswordEqualTo(GlobalUtil.md5(user.getPassword(), user.getUsername()));
		return userMapper.selectByExample(userExample).get(0);
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

	@Override
	@Transactional
	public Boolean ActivationUser(String id, String activeCode) {
		UserExtr extr=userExtrMapper.selectByPrimaryKey(id);
		if(extr==null)
			throw new RuntimeException("激活链接已失效");
		String code=extr.getActivecode();
		if(code.equals(activeCode)){
			User record=new User();
			record.setId(id);
			record.setStatus((byte)1);
			if(userMapper.updateByPrimaryKeySelective(record)<=0)
				throw new RuntimeException("激活失败");
			userExtrMapper.deleteByPrimaryKey(id);
			return true;
		}
		return false;
	}

	@Transactional
	@Override
	public Boolean RegisterUser(User user) {
		user.setId(GlobalUtil.getUserID(user.getUsername(),user.getPassword()));
		user.setPassword(GlobalUtil.md5(user.getPassword(),user.getUsername()));
		if(userMapper.insertSelective(user)>0){
			UserExtr record=new UserExtr();
			record.setId(user.getId());
			record.setActivecode(GlobalUtil.get32bitString());
			if(userExtrMapper.insertSelective(record)<=0)
				throw new RuntimeException("激活码保存失败");
			
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("userName", user.getUsername());
			params.put("url", "/home/activationUser.action?id="+user.getId()+"&activeCode="+record.getActivecode());
			if(!springMail.doSend("遇见—江南古镇 用户激活", "activeion_User.ftl", params, user.getEmail()))
				throw new RuntimeException("邮箱发送失败");
			return true;
		}
		return false;
	}

}
