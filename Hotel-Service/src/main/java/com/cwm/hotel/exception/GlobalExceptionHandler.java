package com.cwm.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cwm.hotel.model.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(HotelNotFoundException.class)
	public ApiResponse handleHotelNotFoundException(HotelNotFoundException ex) {
		ApiResponse response = ApiResponse.builder()
				.message(ex.getLocalizedMessage())
				.exception(ex.getClass().getSimpleName())
				.status(HttpStatus.NOT_FOUND)
				.statusCode(HttpStatus.NOT_FOUND.value())
				.build();
		return response;
	}
}
