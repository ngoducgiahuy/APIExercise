package com.giahuy.APIExercise.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 385255518286489693L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}
	
	
}
