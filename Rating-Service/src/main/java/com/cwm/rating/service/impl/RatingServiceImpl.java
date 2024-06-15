package com.cwm.rating.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cwm.rating.entity.Rating;
import com.cwm.rating.repository.RatingRepository;
import com.cwm.rating.service.RatingService;

@Service
public class RatingServiceImpl  implements RatingService{

	@Autowired
	private RatingRepository ratingRepo;
	
	@Override
	public Rating giveRating(Rating rating) {
		Rating givenRating= this.ratingRepo.save(rating);
		return givenRating;
	}

	@Override
	public List<Rating> getAllRatingByUser(Long userId) {
		List<Rating> userRating= this.ratingRepo.findByUser(userId);
		return userRating;
	}

	@Override
	public List<Rating> getAllRatingToHotel(Long hotelId) {
		List<Rating> hotelRating= this.ratingRepo.findByHotel(hotelId);
		return hotelRating;
	}

	
}
