package com.cwm.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cwm.rating.entity.Rating;
import com.cwm.rating.model.RatingResponse;
import com.cwm.rating.service.impl.RatingServiceImpl;

@RestController
@RequestMapping("/api/rating")
public class RatingController {

	@Autowired
	private RatingServiceImpl ratingService;
	
	//Give a rating to the hotel
	@PostMapping("/give-rating")
	public ResponseEntity<Rating> giveRatingToHotel(@RequestBody Rating rating){
		Rating givenRating= this.ratingService.giveRating(rating);
		return new ResponseEntity<Rating>(givenRating, HttpStatus.CREATED);
	}
	
	//Get all rating by user id
	@GetMapping("/userid")
	public ResponseEntity<List<RatingResponse>> getRatingByUser(@RequestParam("id") Long userId){
		List<RatingResponse> userRating= this.ratingService.getAllRatingByUser(userId);
		return ResponseEntity.ok(userRating);
	}
	
	//Get all ratings given to hotel
	@GetMapping("/hotelid")
	public ResponseEntity<List<RatingResponse>> getAllRatingToHotel(@RequestParam Long hotelId){
		List<RatingResponse> hotelRatings= this.ratingService.getAllRatingToHotel(hotelId);
		return new ResponseEntity<List<RatingResponse>>(hotelRatings, HttpStatus.ACCEPTED);
	}
}
