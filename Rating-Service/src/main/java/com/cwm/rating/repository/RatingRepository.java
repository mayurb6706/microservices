package com.cwm.rating.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cwm.rating.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

	List<Rating> findByUser(Long userId);

	List<Rating> findByHotel(Long hotelId);
}
