package com.microservices.rating.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.rating.Model.Rating;
import com.microservices.rating.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {
	@Autowired
	private RatingRepository ratingRepo;
	@Override
	public Rating create(Rating rating) {
		String id=UUID.randomUUID().toString();
		rating.setRatingId(id);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAll() {
		
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		
		return ratingRepo.findByHotelId(hotelId);
	}

}
