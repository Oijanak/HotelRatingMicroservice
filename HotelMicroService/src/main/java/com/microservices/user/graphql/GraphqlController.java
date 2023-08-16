package com.microservices.user.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.microservices.user.Model.Hotel;
import com.microservices.user.Model.HotelInput;
import com.microservices.user.service.HotelService;

@Controller
public class GraphqlController {
	@Autowired
	private HotelService hs;
	@QueryMapping("allHotels")
	public List<Hotel> getHotels(){
		return hs.gteAll();
	}
	@QueryMapping("getHotel")
	public Hotel getHotel(@Argument String hotelId) {
		return hs.get(hotelId);
	}
	
	@MutationMapping("createHotel")
	public Hotel create(@Argument HotelInput hotel ) {
		Hotel h=new Hotel();
		h.setAbout(hotel.getAbout());
		h.setContact(hotel.getContact());
		h.setLocation(hotel.getLocation());
		h.setName(hotel.getName());
		return hs.create(h);
	}
}

