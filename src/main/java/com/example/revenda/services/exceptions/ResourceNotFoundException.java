package com.example.revenda.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String model) {
		super("Resource not found. Model: " + model);
	}

	public ResourceNotFoundException(Integer yearModel) {
		super("Resource not found. Yearmodel: " + yearModel);
	}
	

}
