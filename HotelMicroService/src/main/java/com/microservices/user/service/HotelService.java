package com.microservices.user.service;

import java.util.List;

import com.microservices.user.Model.Hotel;

public interface HotelService {
	
	Hotel create(Hotel hotel);
	List<Hotel> gteAll();
	Hotel get(String id);
}
