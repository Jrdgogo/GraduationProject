package com.mmt.tourism.service;

import com.mmt.tourism.pojo.User;

public interface UserService {

	public User getUserByName_Pwd(User user);

	public Boolean getUserByName(String username);

	public Boolean ActivationUser(String id, String activeCode);

	public Boolean RegisterUser(User user);

}
