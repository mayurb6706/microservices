package com.cwm.rating.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cwm.rating.model.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RatingNotFoundException.class)
	public ApiResponse handleHotelNotFoundException(RatingNotFoundException ex) {
		ApiResponse response = ApiResponse.builder()
				.message(ex.getLocalizedMessage())
				.exception(ex.getClass().getSimpleName())
				.status(HttpStatus.NOT_FOUND)
				.statusCode(HttpStatus.NOT_FOUND.value())
				.build();
		return response;
	}
}
