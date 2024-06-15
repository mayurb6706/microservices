package com.cwm.rating.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="rating_tab")
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rating_id")
	private Long id;
	
	@Column(name="rating")
	private int rating;
	
	@Column(name="hotel_id")
	private Long hotel;
	
	@Column(name="user_id")
	private Long user;
	
	@Column(name="feedback")
	private String feedback;
	
}
