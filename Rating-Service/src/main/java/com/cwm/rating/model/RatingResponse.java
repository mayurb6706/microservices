package com.cwm.rating.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RatingResponse {

	
	private int rating;
	private Long hotel;
	private UserRespose user;
	private String feedback;
}
