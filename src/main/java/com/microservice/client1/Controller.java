package com.microservice.client1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	Object object;
	@GetMapping("/demo")
	public Object helloWorld() {
		object.setMessage("say hello to microservices");
		return object;
		
	}
}
