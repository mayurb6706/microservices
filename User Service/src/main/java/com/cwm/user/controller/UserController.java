package com.cwm.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cwm.user.entity.User;
import com.cwm.user.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired 
	private UserServiceImpl userService;
	
	//add new User
	@PostMapping("/create")
	public ResponseEntity<User> addNewUser(@RequestBody User user){
		
		User newUser=this.userService.addUser(user);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
	
	//Get the user by user id
	@GetMapping("/id/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		User user=this.userService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	//Get all Users
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users= this.userService.getAllUsers();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
}
