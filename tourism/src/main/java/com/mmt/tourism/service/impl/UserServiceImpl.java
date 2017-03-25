package com.mmt.tourism.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mmt.tourism.config.mail.SpringMail;
import com.mmt.tourism.dao.UserAccountMapper;
import com.mmt.tourism.dao.UserExtrMapper;
import com.mmt.tourism.dao.UserMapper;
import com.mmt.tourism.dao.VisitorsMapper;
import com.mmt.tourism.pojo.po.User;
import com.mmt.tourism.pojo.po.UserAccount;
import com.mmt.tourism.pojo.po.UserAccountExample;
import com.mmt.tourism.pojo.po.UserExample;
import com.mmt.tourism.pojo.po.UserExtr;
import com.mmt.tourism.pojo.po.Visitors;
import com.mmt.tourism.service.UserService;
import com.mmt.tourism.util.GlobalUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserExtrMapper userExtrMapper;
	@Autowired
	private VisitorsMapper visitorsMapper;
	@Autowired
	private UserAccountMapper userAccountMapper;
	@Autowired
	private SpringMail springMail;

	@Override
	public User getUserByName_Pwd(User user) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(user.getUsername())
				.andPasswordEqualTo(GlobalUtil.md5(user.getPassword(), user.getUsername()));
		List<User> users = userMapper.selectByExample(userExample);
		if (users != null && !users.isEmpty())
			return users.get(0);
		return null;
	}

	@Override
	public Boolean getUserByName(String username) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(username);
		int count = userMapper.countByExample(userExample);
		if (count > 0)
			return true;
		return false;

	}

	@Override
	@Transactional
	public Boolean ActivationUser(String id, String activeCode) {
		UserExtr extr = userExtrMapper.selectByPrimaryKey(id);
		if (extr == null)
			throw new RuntimeException("激活链接已失效");
		String code = extr.getActivecode();
		if (code.equals(activeCode)) {
			User record = new User();
			record.setId(id);
			record.setStatus((byte) 1);
			if (userMapper.updateByPrimaryKeySelective(record) <= 0)
				throw new RuntimeException("激活失败");
			userExtrMapper.deleteByPrimaryKey(id);
			
			UserAccount account=getAccounts(id).get(0);
			account.setStatus(true);
			userAccountMapper.updateByPrimaryKey(account);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public Boolean RegisterUser(User user) {
		UserAccount account=new UserAccount();
		account.setStatus(false);
		account.setPassword(user.getPassword());
		
		user.setId(GlobalUtil.getUserID(user.getUsername(), user.getPassword()));
		account.setUserid(user.getId());
		
		user.setPassword(GlobalUtil.md5(user.getPassword(), user.getUsername()));
		if (userMapper.insertSelective(user) > 0) {
			UserExtr record = new UserExtr();
			record.setId(user.getId());
			record.setActivecode(GlobalUtil.get32bitString());
			if (userExtrMapper.insertSelective(record) <= 0)
				throw new RuntimeException("激活码保存失败");

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userName", user.getUsername());
			params.put("url",
					"/home/activationUser.action?id=" + user.getId() + "&activeCode=" + record.getActivecode());
			if (!springMail.doSend("遇见—江南古镇 用户激活", "activeion_User.ftl", params, user.getEmail()))
				throw new RuntimeException("邮箱发送失败");
			addAccount(account);
			return true;
		}
		return false;
	}

	@Override
	public List<String> addVisitors(List<Visitors> visitors) {

		List<String> list = new ArrayList<String>();
		for (Visitors visitor : visitors) {
			visitor.setId(GlobalUtil.getModelID(Visitors.class));
			if (visitorsMapper.insertSelective(visitor) <= 0)
				throw new RuntimeException("出行人员纪录失败！");
			list.add(visitor.getId());
		}
		return list;
	}

	@Override
	public List<UserAccount> getAccounts(String userId) {
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andUseridEqualTo(userId);
		return userAccountMapper.selectByExample(example);
	}

	@Override
	public Boolean addAccount(UserAccount account) {
		String password=account.getPassword();
		UserAccountExample example = new UserAccountExample();
		example.createCriteria().andUseridEqualTo(account.getId());
		List<UserAccount> accounts = userAccountMapper.selectByExample(example);
		if (accounts == null || accounts.isEmpty()) {
			account.setId(GlobalUtil.getModelID(UserAccount.class));
			account.setPassword(GlobalUtil.md5(password, account.getId()));
			return userAccountMapper.insertSelective(account) > 0;
		}else{
			account=accounts.get(0);
			account.setPassword(GlobalUtil.md5(password, account.getId()));
			return userAccountMapper.updateByPrimaryKeySelective(account)>0;
		}
	}

}
