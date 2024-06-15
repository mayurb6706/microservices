package com.cwm.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cwm.hotel.entity.Hotel;
import com.cwm.hotel.service.impl.HotelServiceImpl;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

	@Autowired
	private HotelServiceImpl hotelService;
	
	//add new Hotel
	@PostMapping("/add")
	public ResponseEntity<Hotel> addNewHotel(@RequestBody Hotel hotel){
		Hotel newHotel= this.hotelService.addNewHotel(hotel);
		return new ResponseEntity<Hotel>(newHotel, HttpStatus.CREATED);
	}
	
	//Get all hotels
	@GetMapping("/all-hotels")
	public ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> hotels = this.hotelService.getAllHotels();
		return ResponseEntity.ok(hotels);
	}
	
	//Get hotel details by hotel id
	@GetMapping("/hotel")
	public ResponseEntity<Hotel> getHotelById(@RequestParam("id") Long id){
		Hotel hotel= this.hotelService.getHotelById(id);
		return ResponseEntity.ok(hotel);
	}
}
