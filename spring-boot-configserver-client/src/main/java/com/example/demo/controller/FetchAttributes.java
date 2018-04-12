package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ApplicationAttributes;
@RestController
@RefreshScope
public class FetchAttributes {

	@Value("${defaultapp}")
	private String defaultapp;
	@Value("${globalmessage}")
	private String globalmessage;
	@Value("${valuetooverride}")
	private String valuetooverride;
	@Value("${environment}")
	private String environment;
	@Value("${displaymessage}")
	private String displaymessage;
	@Value("${secured}")
	private String secured;
	
	@Autowired
	ApplicationAttributes a;
	
	@RequestMapping(path="/getAttributes", method=RequestMethod.POST)
	public ApplicationAttributes getAttributes(){
		a.setEnvironment(environment);
		a.setDefaultapp(defaultapp);
		a.setDisplaymessage(displaymessage);
		a.setGlobalmessage(globalmessage);
		a.setValuetooverride(valuetooverride);
		a.setSecured(secured);
		return a;
	}
}
