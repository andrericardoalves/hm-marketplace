package com.alvesinc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alvesinc.hmuser.entities.User;
import com.alvesinc.hmuser.repository.UserRepository;
import com.alvesinc.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserRepository repository;
	
	public User create(User user) {
		
		if(verifyUserEmailExist(user.getEmail())) {
			 throw new RuntimeException("There is already the email " + user.getEmail());	
		}
		
		if(verifyUserNameExist(user.getName())) {
			 throw new RuntimeException("There is already the name " + user.getName());	
		}
		
		
		return repository.save(user);
	}
	
	private boolean verifyUserNameExist(String name){
		User user = this.findUserByName(name);
		return user != null && user.getName().equalsIgnoreCase(name) ? true : false; 
	}
	
	private boolean verifyUserEmailExist(String email){
		User user = this.findUserByEmail(email);
		return user != null && user.getEmail().equalsIgnoreCase(email) ? true : false; 
	}
	
	public User findUserByEmail(String email) {
	  return repository.findUserByEmail(email);
	}
	public User findUserByName(String name) {
	   return repository.findUserByName(name);
	}
}
