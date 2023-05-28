package com.example.revenda.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	@PostMapping
	public ResponseEntity<Vehicle> insertVehicle (@RequestBody Vehicle obj) {
		obj = service.insert(obj);
		//Comando para que o retorno seja especificado para retornar o código 201 
		//que o responsável por indicar que algo foi criado
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}

}
