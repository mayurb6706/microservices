package com.cwm.user.service.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cwm.user.model.RatingResponse;


@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	
	@GetMapping("/userid")
	public ResponseEntity<List<RatingResponse>> getRatingByUser(@RequestParam("id") Long userId);
}
