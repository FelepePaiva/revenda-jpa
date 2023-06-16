package com.example.revenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.revenda.entities.Vehicle;
import com.example.revenda.repositories.VehicleRepository;
import com.example.revenda.services.exceptions.ResourceNotFoundException;
@Service
public class VehicleService {
	private VehicleRepository repository;

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
	public List<Vehicle> findByModel(String model) {
		List<Vehicle> list = repository.findByModel(model);
		if (list.isEmpty()) {
			throw new ResourceNotFoundException(model);
		}
		return list;
	}
	public List<Vehicle> findByAssembler(String assembler) {
		List<Vehicle> list = repository.findByAssembler(assembler);		    
	    if (list.isEmpty()) {
	        throw new ResourceNotFoundException(assembler);
	    }		    
	    return list;
	}
	public List<Vehicle> findByYearModel(Integer yearModel) {
		List<Vehicle> list = repository.findByYearModel(yearModel);
		if (list.isEmpty()) {
			throw new ResourceNotFoundException(yearModel);
		}
		return list;
	}
	public List<Vehicle> findByPriceRange(Double minPrice, Double maxPrice) {
		List<Vehicle> list = repository.findByPriceBetween(minPrice, maxPrice);
		if (list.isEmpty()) {
			throw new ResourceNotFoundException(minPrice, maxPrice);
		}
	    return list;
	}
	


}
	
	

