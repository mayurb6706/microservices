package com.cwm.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name="hotel_tab")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="hotel_id")
	private Long id;
	
	@Column(name="hotel_name")
	private String name;
	
	@Column(name="hotel_location")
	private String location;
	
	@Column(name="about")
	private String about;
	
	@Column(name="hotel_email")
	private String email;
	
	@Column(name="hotel_contact")
	private Long contact;
}
