package com.example.revenda.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.revenda.entities.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

	Optional<Vehicle> findByModel(String model);

	List<Vehicle> findByAssembler(String assembler);

	List<Vehicle> findByYearModel(Integer yearModel);

		List<Vehicle> findByPriceBetween(Double minPrice, Double maxPrice);	

}
