package com.microservices.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.rating.Model.Rating;
import com.microservices.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	@Autowired
	private RatingService ratingServ;
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingServ.create(rating));
	}
	@GetMapping
	public ResponseEntity<List<Rating>> getRatings(){
		return ResponseEntity.ok(ratingServ.getAll());
		
	}
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		return ResponseEntity.ok(ratingServ.getRatingByUserId(userId));
	}
	@GetMapping("hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(ratingServ.getRatingByHotelId(hotelId));
	}
}
