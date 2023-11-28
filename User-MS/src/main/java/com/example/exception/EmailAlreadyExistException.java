package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistException extends RuntimeException {
	
	//needs 1 parameter
	private String message;

	public EmailAlreadyExistException(String message) {
		super(message);
		this.message = message;
	}
	

}
