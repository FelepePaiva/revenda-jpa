package com.example.revenda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.revenda.entities.Vehicle;
import com.example.revenda.repositories.VehicleRepository;
import com.example.revenda.services.exceptions.ResourceNotFoundException;
@Service
public class VehicleService {
	private final VehicleRepository repository;

    @Autowired
    public VehicleService(VehicleRepository repository) {
        this.repository = repository;
    }	
	public void insertVehicle(Vehicle obj) {
		repository.save(obj);
		
	}
	public void deleteById(Long id) {
	    if (!repository.existsById(id)) {
	        throw new ResourceNotFoundException(id);
	    }
	    repository.deleteById(id);
	}
	public Vehicle findByModel(String model) {
		return repository.findByModel(model).orElseThrow(() -> new ResourceNotFoundException(model));
	}
	


}
	
	

