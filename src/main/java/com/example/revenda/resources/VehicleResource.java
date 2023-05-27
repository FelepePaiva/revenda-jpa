package com.example.revenda.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.revenda.entities.Vehicle;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleResource {
	@GetMapping
	public ResponseEntity<Vehicle> findAll() {
		Vehicle v1 = new Vehicle(1L, "Compass", "Jeep", "Preto", 2022, 145000.0);
		return ResponseEntity.ok().body(v1);
	}

}
