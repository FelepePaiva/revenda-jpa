package com.example.revenda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.revenda.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

	List<Vehicle> findByModel(String model);
	

}
