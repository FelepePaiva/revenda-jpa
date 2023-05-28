package com.example.revenda.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.revenda.entities.Vehicle;
import com.example.revenda.repositories.VehicleRepository;
@Service
public class VehicleService {
	@Autowired
	private VehicleRepository repository;
	
	public List<Vehicle> findAll(){
		return repository.findAll();
	}
	public Vehicle findById(Long id) {
		Optional<Vehicle> obj = repository.findById(id);
		return obj.get();
	}
	public Vehicle insert (Vehicle obj) {
		return repository.save(obj);
		
	}

}
