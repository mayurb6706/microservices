package com.cwm.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cwm.user.entity.User;
import com.cwm.user.exception.UserDetailsNotFoundException;
import com.cwm.user.model.RatingResponse;
import com.cwm.user.repository.UserRepository;
import com.cwm.user.service.UserService;
import com.cwm.user.service.external.RatingService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;
	
	private RatingService ratingService;
	
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
		//get the whole user details, rating + hotel details
		List<RatingResponse> ratingResponses= this.ratingService.getRatingByUser(id).getBody();
		for(RatingResponse res: ratingResponses) {
			System.out.println(res.toString());
		}
		user.setRatings(ratingResponses);
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
