package com.microservice.client2;

import org.springframework.stereotype.Component;

@Component
public class Object {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
