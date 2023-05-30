package com.example.revenda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.revenda.entities.Vehicle;
import com.example.revenda.repositories.VehicleRepository;
import com.example.revenda.services.exceptions.ResourceNotFoundException;
@Service
public class VehicleService {
	@Autowired
	private VehicleRepository repository;
	
	public List<Vehicle> findAll(){
		return repository.findAll();
	}
	//public Vehicle findById(Long id) {
		//Optional<Vehicle> obj = repository.findById(id);
		//return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	//}
	public Vehicle insert (Vehicle obj) {
		return repository.save(obj);
		
	}
	public void deleteById (Long id) {
		repository.deleteById(id);
	}
	public Vehicle findByModel (String model) {
		 return repository.findByModel(model).orElseThrow(() -> new ResourceNotFoundException(model));
	}
	public List<Vehicle> findByYearModel(Integer yearModel) {
		 List<Vehicle> list = repository.findByYearModel(yearModel);		    
		    if (list.isEmpty()) {
		        throw new ResourceNotFoundException(yearModel);
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
	public List<Vehicle> findByPriceRange(Double minPrice, Double maxPrice) {
	    return repository.findByPriceBetween(minPrice, maxPrice);
	}
}
	

