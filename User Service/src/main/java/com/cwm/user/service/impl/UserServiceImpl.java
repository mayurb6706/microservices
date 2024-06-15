package com.cwm.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cwm.user.entity.User;
import com.cwm.user.exception.UserDetailsNotFoundException;
import com.cwm.user.repository.UserRepository;
import com.cwm.user.service.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;
	
	//Add new User
	@Override
	public User addUser(User user) {
		User newUser=this.userRepo.save(user);
		return newUser;
	}

	@Override
	public User getUserById(Long id) {
		User user=this.userRepo.findById(id).orElseThrow(()->
		new UserDetailsNotFoundException("User is not exist with given parameter!"));
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users= this.userRepo.findAll();
		return users;
	}

	@Override
	public User updateUserDetails(Long id, User newUserDetails) {
		User user= this.getUserById(id);
		user.setName(newUserDetails.getName());
		user.setEmail(newUserDetails.getEmail());
		user.setContact(newUserDetails.getContact());
		user.setAbout(newUserDetails.getAbout());
		this.userRepo.save(user);
		return user;
	}

	@Override
	public String removeUser(Long id) {
		User user=this.getUserById(id);
		this.userRepo.delete(user);
		return "User Details Removed Sucessfully!";
	}

	@Override
	public User getUserByEmail(String email) {
		User user= this.userRepo.findByEmail(email);
		return user;
	}

}
