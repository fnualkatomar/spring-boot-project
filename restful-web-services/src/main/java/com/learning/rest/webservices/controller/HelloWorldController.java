package com.learning.rest.webservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.learning.rest.webservices.bean.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path = "/hello-world/path/{pathAttribute}")
	public HelloWorldBean helloWorldPathAttribute(@PathVariable String pathAttribute) {
		return new HelloWorldBean(String.format("Hello World,%s", pathAttribute));
	}

}
