package com.microservices.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.user.User.User;

public interface UserRepository extends JpaRepository<User, String> {

}
