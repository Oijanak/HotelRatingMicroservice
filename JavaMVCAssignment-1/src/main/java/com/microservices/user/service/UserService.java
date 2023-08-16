package com.microservices.user.service;

import java.util.List;

import com.microservices.user.User.User;

public interface UserService {
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUser(String userId);
	
	String deleteUser(String userId);
	

}
