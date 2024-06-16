package com.cwm.rating.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cwm.rating.entity.Rating;
import com.cwm.rating.model.HotelResponse;
import com.cwm.rating.model.RatingResponse;
import com.cwm.rating.model.UserRespose;
import com.cwm.rating.repository.RatingRepository;
import com.cwm.rating.service.RatingService;

@Service
public class RatingServiceImpl  implements RatingService{

	@Autowired
	private RatingRepository ratingRepo;
	
	@Autowired
	private RestTemplate template;
	
	@Override
	public Rating giveRating(Rating rating) {
		Rating givenRating= this.ratingRepo.save(rating);
		
		return givenRating;
	}

	@Override
	public List<RatingResponse> getAllRatingByUser(Long userId) {
		List<Rating> userRating= this.ratingRepo.findByUser(userId);
		List<RatingResponse> responses= new ArrayList<>();
		responses = userRating.stream().map(rating->{
			HotelResponse hotel=this.template.getForObject("http://HOTEL-SERVICE/api/hotel/hotel?id="+rating.getHotel(),HotelResponse.class);
				RatingResponse response=RatingResponse.builder()
						.feedback(rating.getFeedback())
						.hotel(hotel)
						.rating(rating.getRating())
						.build();
				return response;
		}).collect(Collectors.toList());
		return responses;
	}

	@Override
	public List<RatingResponse> getAllRatingToHotel(Long hotelId) {
		List<Rating> hotelRating= this.ratingRepo.findByHotel(hotelId);
		List<RatingResponse> responses= new ArrayList<>();
		responses=hotelRating.stream().map(rating->{
			UserRespose user= this.template.getForObject("http://USER-SERVICE/api/user/id/"+rating.getUser(), UserRespose.class);
			RatingResponse response= RatingResponse.builder()
					.feedback(rating.getFeedback())
					.rating(rating.getRating())
					.user(user)
					.build();
			return response;
		}).collect(Collectors.toList());
		return responses;
	}

	
}
