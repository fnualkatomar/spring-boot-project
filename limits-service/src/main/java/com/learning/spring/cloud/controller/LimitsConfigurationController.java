package com.learning.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.spring.cloud.LimitsConfigurationViaApplicationProps;
import com.learning.spring.cloud.beans.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {
	@Autowired
	LimitsConfigurationViaApplicationProps configuration;
	
	@GetMapping("/limits-service")
	public LimitsConfiguration retrieveConfigurations() {
		
		return new LimitsConfiguration(configuration.getMinimum(),configuration.getMaximum());
	}

}
