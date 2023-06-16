package com.example.revenda.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@GetMapping(value = "/model/{model}")
	@Transactional
	public ResponseEntity<List<Vehicle>> findByModel(@PathVariable String model) {
		List<Vehicle> obj = service.findByModel(model);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping(value = "/assembler/{assembler}")
	@Transactional
	public ResponseEntity<List<Vehicle>> findByAssembler(@PathVariable String assembler) {
		List<Vehicle> obj = service.findByAssembler(assembler);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping(value = "/yearModel/{yearModel}")
	@Transactional
	public ResponseEntity<List<Vehicle>> findByYearModel(@PathVariable Integer yearModel) {
		List<Vehicle> obj = service.findByYearModel(yearModel);
		return ResponseEntity.ok().body(obj);
	}
	@GetMapping(value = "/price/")
	public ResponseEntity<List<Vehicle>> findByPriceRange (@RequestParam("minPrice") Double minPrice, 
			@RequestParam("maxPrice") Double maxPrice){
		List<Vehicle> list = service.findByPriceRange(minPrice, maxPrice);
		return ResponseEntity.ok().body(list);
	}
	
}
