package com.cwm.rating.service;

import java.util.List;

import com.cwm.rating.entity.Rating;

public interface RatingService {

	Rating giveRating(Rating rating);
	
	List<Rating> getAllRatingByUser(Long userId);
	
	List<Rating> getAllRatingToHotel(Long hotelId);
	
}
