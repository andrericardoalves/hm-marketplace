package com.alvesinc.service;

import com.alvesinc.hmuser.entities.User;

public interface IUserService {

	public User create(User user);
	public User findUserByEmail(String email);
	public User findUserByName(String name);
	
}
