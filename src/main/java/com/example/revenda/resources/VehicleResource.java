package com.example.revenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.revenda.entities.Vehicle;
import com.example.revenda.services.VehicleService;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleResource {
	@Autowired
	private VehicleService service;
	@GetMapping
	public ResponseEntity<List<Vehicle>> findAll() {
		List<Vehicle> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Vehicle> findById(@PathVariable Long id) {
		Vehicle obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}
