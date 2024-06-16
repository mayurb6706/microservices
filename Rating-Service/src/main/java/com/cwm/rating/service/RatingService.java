package com.cwm.rating.service;

import java.util.List;

import com.cwm.rating.entity.Rating;
import com.cwm.rating.model.RatingResponse;

public interface RatingService {

	Rating giveRating(Rating rating);
	
	List<RatingResponse> getAllRatingByUser(Long userId);
	
	List<RatingResponse> getAllRatingToHotel(Long hotelId);
	
}
