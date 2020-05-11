package com.learning.rest.webservices.bean;

import java.util.Date;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All Details about User")
public class User {
	
	private Integer id;
	@Size(min = 2, message = "Name should be greater than 2")
	@ApiModelProperty(notes = "Name should be greater than or equal to 2 Character")
	private String name;
	@ApiModelProperty(notes = "Birth Date can't be of future date")
	private Date birthDate;
	
	public User() {}
	
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	

}
