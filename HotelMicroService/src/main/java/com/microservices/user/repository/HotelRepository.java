package com.microservices.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.user.Model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {
 
}
