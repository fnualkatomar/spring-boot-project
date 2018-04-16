package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrintController {
	@RequestMapping(path="/printname")
	public String printString() throws InterruptedException{
		Thread.sleep(2000);
		return "Shiv Ratan Singh";
	}

}
