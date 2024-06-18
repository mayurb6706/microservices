package com.cwm.user.model;

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
@ToString
@Builder
public class HotelResponse {

	private String name;
	
	private String location;
	
	private String about;
	
	private String email;
	
	private Long contact;
}

