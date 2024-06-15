package com.cwm.user.service;

import java.util.List;

import com.cwm.user.entity.User;

public interface UserService {

	User addUser(User user);
	
	User getUserById(Long id);
	
	List<User> getAllUsers();
	
	User updateUserDetails(Long id, User newUserDetails);
	
	String removeUser(Long id);
	
	User getUserByEmail(String email);
	
}  
