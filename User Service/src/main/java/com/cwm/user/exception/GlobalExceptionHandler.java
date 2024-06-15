package com.cwm.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cwm.user.model.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserDetailsNotFoundException.class)
	public ApiResponse handleUserDetailsNotFoundException(UserDetailsNotFoundException ex) {
		
		ApiResponse response = ApiResponse.builder()
				.message(ex.getLocalizedMessage())
				.exception(ex.getClass().getSimpleName())
				.status(HttpStatus.NOT_FOUND)
				.statusCode(HttpStatus.NOT_FOUND.value())
				.build();
		return response;
	}

}
