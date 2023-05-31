package com.example.revenda.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String model) {
		super("Resource not found. Model: " + model);
	}

	public ResourceNotFoundException(Integer yearModel) {
		super("Resource not found. Yearmodel: " + yearModel);
	}

	public ResourceNotFoundException(Double minPrice, Double maxPrice) {
		super("Resource not found. Price range: " + minPrice + " and " + maxPrice);
	}

	public ResourceNotFoundException(Long id) {
		super("Resource not found. ID: " + id);
	}
}