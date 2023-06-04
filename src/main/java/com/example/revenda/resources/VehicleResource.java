package com.example.revenda.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.revenda.entities.Vehicle;
import com.example.revenda.services.VehicleService;
@RestController
@RequestMapping(value = "/vehicles")
public class VehicleResource {
	@Autowired
	private VehicleService service;	
	@PostMapping
	@Transactional
	public void inserVehicle(@RequestBody Vehicle obj) {
		service.insertVehicle(obj);
	}
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<String> deleteVehicle(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.ok("Veículo excluído com sucesso!");
	}

}
