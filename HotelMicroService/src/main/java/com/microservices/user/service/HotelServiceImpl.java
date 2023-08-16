package com.microservices.user.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.user.Model.Hotel;
import com.microservices.user.exceptions.ResourceNotFoundException;
import com.microservices.user.repository.HotelRepository;
@Service
public class HotelServiceImpl implements HotelService {
	@Autowired
	private HotelRepository hotelRepo;
	@Override
	public Hotel create(Hotel hotel) {
		String id=UUID.randomUUID().toString();
		hotel.setId(id);
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> gteAll() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel get(String id) {
		
		return hotelRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel with given Id not found"));
	}

}
