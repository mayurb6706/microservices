package com.cwm.hotel.exception;

public class HotelNotFoundException extends RuntimeException {

	public HotelNotFoundException(){
		super("Hotel does not found!");
	}
	
	public HotelNotFoundException(String message) {
		super(message);
	}
}
