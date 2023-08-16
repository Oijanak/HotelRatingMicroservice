package com.microservices.user.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.user.Exception.ResourceNotFoundException;
import com.microservices.user.User.Hotel;
import com.microservices.user.User.Rating;
import com.microservices.user.User.User;
import com.microservices.user.external.HotelService;
import com.microservices.user.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private HotelService hotelService;
	@Override
	public User saveUser(User user) {
		String randomUserId=UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return userRepo.findAll();
	}

	@Override
	public User getUser(String userId) {
		
		User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found with Id "+userId));
		//http://localhost:8080/ratings/users/dc8b238e-428f-4c20-8c66-960cc9dde25f
		
		Rating[] userRatings=restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		List<Rating> ratings= Arrays.stream(userRatings).toList();
		List<Rating> ratingList= ratings.stream().map(rating->{
			//ResponseEntity<Hotel> entity =restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
			Hotel hotel=hotelService.getHotel(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		
		
		return user;
	}

	@Override
	public String deleteUser(String userId) {
		userRepo.deleteById(userId);
		return userId;
	}

}
