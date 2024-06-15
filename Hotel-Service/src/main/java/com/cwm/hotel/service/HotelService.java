package com.cwm.hotel.service;

import java.util.List;

import com.cwm.hotel.entity.Hotel;

public interface HotelService {

	Hotel addNewHotel(Hotel hotel);
	
	List<Hotel> getAllHotels();
	
	Hotel getHotelById(Long id);
}
