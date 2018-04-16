package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceCallController { 
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping(path="/callaggregate")
	public String concatResponse(){
		ResponseEntity<String> service1 = restTemplate.getForEntity("http://localhost:8088/service/printname", String.class);
		ResponseEntity<String> service2 = restTemplate.getForEntity("http://localhost:9000/service/add", String.class);
		
		return service1.getBody().concat(" | ").concat(service2.getBody());
	}

}
