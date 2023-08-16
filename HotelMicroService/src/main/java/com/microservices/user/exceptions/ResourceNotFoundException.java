package com.microservices.user.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	public ResourceNotFoundException(String  msg) {
		super(msg);
	}
	public ResourceNotFoundException() {
		super("Resource Not Found");
	}
}
