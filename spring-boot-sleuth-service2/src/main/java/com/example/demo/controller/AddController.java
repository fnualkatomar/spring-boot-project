package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddController {
	@RequestMapping(path="/add")
	public String printString() throws InterruptedException{ 
		int c = 1000+5001;
		return String.valueOf(c);
	}

}
