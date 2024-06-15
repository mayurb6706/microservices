package com.cwm.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cwm.hotel.entity.Hotel;
import com.cwm.hotel.exception.HotelNotFoundException;
import com.cwm.hotel.repository.HotelRepository;
import com.cwm.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public Hotel addNewHotel(Hotel hotel) {
		Hotel newHotel = this.hotelRepo.save(hotel);
		return newHotel;
	}

	@Override
	public List<Hotel> getAllHotels() {
		List<Hotel> hotels = this.hotelRepo.findAll();
		return hotels;
	}

	@Override
	public Hotel getHotelById(Long id) {
		Hotel hotel = this.hotelRepo.findById(id)
				.orElseThrow(() -> new HotelNotFoundException("Hotel does not found with entered parameter."));
		return hotel;
	}

}
