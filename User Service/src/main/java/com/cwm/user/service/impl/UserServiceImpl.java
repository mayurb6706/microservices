package com.cwm.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cwm.user.entity.User;
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
		User user=this.userRepo.findById(id).orElseThrow();
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users= this.userRepo.findAll();
		return users;
	}

	@Override
	public User updateUserDetails(Long id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
