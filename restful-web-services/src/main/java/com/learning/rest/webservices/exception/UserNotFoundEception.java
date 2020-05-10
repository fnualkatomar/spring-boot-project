package com.learning.rest.webservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND )
public class UserNotFoundEception extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundEception() {
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundEception(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
