package com.microservices.user.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.user.User.User;
import com.microservices.user.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userServ;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User usr=userServ.saveUser(user);
		System.out.println("Is it working?");
		return ResponseEntity.status(HttpStatus.CREATED).body(usr);
	}

	@GetMapping("/{userId}")
	@CircuitBreaker(name="ratingAndHotelBreaker",fallbackMethod = "ratingHotelFallBack")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		User usr=userServ.getUser(userId);
		return ResponseEntity.ok(usr);
	}
	
	
	//creating fallback method for breaker
	public ResponseEntity<User> ratingHotelFallBack(String userId,Exception ex){
		User user= User.builder()
						.email("dummy@gmail.com")
						.name("dummy")
						.about("This is dummy user")
						.userId("123")
						.build();
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	
	
	
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> ulist=userServ.getAllUser();
		return ResponseEntity.ok(ulist);
	}
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId){
		String user=userServ.deleteUser(userId);
		return ResponseEntity.ok(user);
	}
}
