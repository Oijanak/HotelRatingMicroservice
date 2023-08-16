package com.microservices.rating.service;

import java.util.List;

import com.microservices.rating.Model.Rating;

public interface RatingService {
	
	Rating create(Rating rating);
	
	List<Rating> getAll();
	
	List<Rating> getRatingByUserId(String userId);
	
	List<Rating> getRatingByHotelId(String hotelId);
	

}
