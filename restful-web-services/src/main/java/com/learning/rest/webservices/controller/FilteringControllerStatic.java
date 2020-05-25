package com.learning.rest.webservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.rest.webservices.bean.SomeFilteringBean;

@RestController
public class FilteringControllerStatic {
	
	@GetMapping("/static-filtering")
	public SomeFilteringBean retrieveBean() {
		return new SomeFilteringBean("Value1","Value2","Value3");
	}

}
