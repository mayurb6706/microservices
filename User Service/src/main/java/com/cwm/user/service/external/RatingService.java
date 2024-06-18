package com.cwm.user.service.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cwm.user.model.RatingResponse;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
	@GetMapping("/api/rating/userid")
	public ResponseEntity<List<RatingResponse>> getRatingByUser(@RequestParam("id") Long userId);
	
}
