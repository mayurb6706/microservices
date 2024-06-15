package com.cwm.user.exception;

public class UserDetailsNotFoundException  extends RuntimeException{

	public UserDetailsNotFoundException() {
		super("User does not exists!");
	}
	
	public UserDetailsNotFoundException(String message) {
		super(message);
	}
}
