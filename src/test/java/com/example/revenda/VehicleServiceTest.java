package com.example.revenda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.revenda.entities.Vehicle;
import com.example.revenda.repositories.VehicleRepository;
import com.example.revenda.services.VehicleService;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {
	@InjectMocks
	VehicleService service;	
	@Mock
	VehicleRepository repository;	 
	Vehicle vehicle;
	@BeforeEach
	public void setup() {
		vehicle = new Vehicle(1L, "Compass", "Jeep", "Preto", 2023, 195000.0);
	}
	@Test
	void deveBuscarVeiculoPorModelo() {
		String model = "Compass";
		when(repository.findByModel(model)).thenReturn(Collections.singletonList(vehicle));
		List<Vehicle> vehicles = service.findByModel(model);
		assertEquals(Collections.singletonList(vehicle), vehicles);
		verify(repository).findByModel(model);
		verifyNoMoreInteractions(repository);
	}
	@Test
	void deveBuscarVeiculoPorAno() {
		int yearModel = 2023;
		List<Vehicle> expectedVehicles = Collections.singletonList(vehicle);
		when(repository.findByYearModel(yearModel)).thenReturn(expectedVehicles);
		List<Vehicle> vehicles = service.findByYearModel(yearModel);
		assertEquals(Collections.singletonList(vehicle), vehicles);
		verify(repository).findByYearModel(yearModel);
		verifyNoMoreInteractions(repository);
	}
	@Test
	void deveInserirVeiculo () {
		service.insertVehicle(vehicle);		
        verify(repository).save(vehicle);
        verifyNoMoreInteractions(repository);    
        
        
	}
}

