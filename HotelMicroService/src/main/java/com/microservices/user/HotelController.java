package com.microservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.user.Model.Hotel;
import com.microservices.user.service.HotelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
	private HotelService hotelserv;
	@PostMapping
	public ResponseEntity<Hotel> create(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelserv.create(hotel));
	}
	
	@GetMapping("/{hotelId}")
	@Operation(
			tags = {"Get Hotel By Id"},
			description = "get hotel data by its id",
			summary = "get value"
			)
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		return ResponseEntity.ok(hotelserv.get(hotelId));
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel(){
		return ResponseEntity.ok(hotelserv.gteAll());
	}
	
}
