package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class ApplicationAttributes {
private String environment;
private String defaultapp;
private String globalmessage;
private String valuetooverride;
private String displaymessage;
private String secured;

public String getEnvironment() {
	return environment;
}

public void setEnvironment(String environment) {
	this.environment = environment;
}

public String getDefaultapp() {
	return defaultapp;
}

public void setDefaultapp(String defaultapp) {
	this.defaultapp = defaultapp;
}

public String getGlobalmessage() {
	return globalmessage;
}

public void setGlobalmessage(String globalmessage) {
	this.globalmessage = globalmessage;
}

public String getValuetooverride() {
	return valuetooverride;
}

public void setValuetooverride(String valuetooverride) {
	this.valuetooverride = valuetooverride;
}

public String getDisplaymessage() {
	return displaymessage;
}

public void setDisplaymessage(String displaymessage) {
	this.displaymessage = displaymessage;
}

public String getSecured() {
	return secured;
}

public void setSecured(String secured) {
	this.secured = secured;
}



 
 
}
