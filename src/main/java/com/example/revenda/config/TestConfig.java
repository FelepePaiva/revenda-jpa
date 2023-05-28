package com.example.revenda.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.revenda.entities.Vehicle;
import com.example.revenda.repositories.VehicleRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public void run(String... args) throws Exception {
		Vehicle v1 = new Vehicle(null, "Ônix", "Chevrolet", "Vermelho", 2020, 68000.0);
		Vehicle v2 = new Vehicle(null, "HB20", "Hyundai", "Branco", 2019, 62000.0);
		Vehicle v3 = new Vehicle(null, "Compass", "Jeep", "Azul", 2021, 160000.0);
		
		vehicleRepository.saveAll(Arrays.asList(v1, v2, v3));
		
	}

}
