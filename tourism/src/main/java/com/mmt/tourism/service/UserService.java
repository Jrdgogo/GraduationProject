package com.mmt.tourism.service;

import java.util.List;

import com.mmt.tourism.pojo.po.User;
import com.mmt.tourism.pojo.po.UserAccount;
import com.mmt.tourism.pojo.po.Visitors;

public interface UserService {

	public User getUserByName_Pwd(User user);

	public Boolean getUserByName(String username);

	public Boolean ActivationUser(String id, String activeCode);

	public Boolean RegisterUser(User user);
	
	public List<String> addVisitors(List<Visitors> visitors);
	public List<UserAccount> getAccounts(String userId);
	public Boolean addAccount(UserAccount account);

}
