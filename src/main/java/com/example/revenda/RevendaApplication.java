package com.example.revenda;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.revenda.entities.Vehicle;
import com.example.revenda.services.VehicleService;
import com.example.revenda.services.exceptions.ResourceNotFoundException;
@EnableWebMvc
@SpringBootApplication
@ComponentScan(basePackages = "com.example.revenda")
@Transactional
public class RevendaApplication {
	private static VehicleService service;

    @Autowired
    public RevendaApplication(VehicleService service) {
        this.service = service;
    }
		
	public static void main(String[] args) {
		SpringApplication.run(RevendaApplication.class, args);		
		Locale.setDefault(Locale.US);		
		int menu;
		Scanner sc = new Scanner(System.in);
		String model, assembler, color;
		int yearModel;
		double price;
		
		do {
			exibirMenu();
			menu = sc.nextInt();
			sc.nextLine();
			switch(menu) {
			case 1:
				System.out.println("Digite a montadora: ");
				assembler = sc.nextLine();				
				System.out.println("Cor: ");
				color = sc.nextLine();				
				System.out.println("Modelo: ");
				model = sc.nextLine();				
				System.out.println("Preço: ");
				price = sc.nextDouble();				
				System.out.println("Ano/Modelo: ");
				yearModel = sc.nextInt();
				sc.nextLine();
				Vehicle obj = new Vehicle(null, model, assembler, color, yearModel, price);	
				service.insertVehicle(obj);	
				System.out.println(obj.toString());
				break;
			case 2: 
				System.out.println("Digite o ID do veículo que será removido: ");
				Long id = sc.nextLong();
				sc.nextLine();
				service.deleteById(id);
				System.out.println("O veículo foi deletado com sucesso!");
				break;
			case 3:
				System.out.println("Digite o modelo do veículo para buscar: ");
				model = sc.nextLine();
				try {
				service.findByModel(model);
				System.out.println(service.findByModel(model));
				}
				catch (ResourceNotFoundException e) {
					System.out.println((e.getMessage()));
				}
				break;
			case 4:
				System.out.println("Digite a montadora que deseja buscar: ");
				assembler = sc.nextLine();
				try {
				service.findByAssembler(assembler);
				System.out.println(service.findByAssembler(assembler));
				}
				catch (ResourceNotFoundException e) {
					System.out.println((e.getMessage()));
				}
				break;
			case 5:
				System.out.println("Digite o ANO/MODELO que deseja buscar: ");
				yearModel = sc.nextInt();
				try {
				service.findByYearModel(yearModel);
				System.out.println(service.findByYearModel(yearModel));
				}
				catch (ResourceNotFoundException e) {
					System.out.println((e.getMessage()));
				}
				break;
			case 6:
				System.out.println("Digite a faixa de preço (minímo e máximo) que deseja buscar: ");
				System.out.println("Digite o valor mínimo: ");
				double minPrice = sc.nextDouble();
				System.out.println("Digite o valor máximo: ");
				double maxPrice = sc.nextDouble();
							
				try {
				service.findByPriceRange(minPrice, maxPrice);
				System.out.println(service.findByPriceRange(minPrice, maxPrice));
				}
				catch (ResourceNotFoundException e) {
					System.out.println((e.getMessage()));
				}	
			case 7:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("OPÇAO DE MENU INVALIDA");
				} 
			
		}while(menu != 7);
		sc.close();
	}
	static void exibirMenu() {
		System.out.println("-------- REVENDA DE VEÍCULOS --------");
		System.out.println("1 - CADASTRAR VEÍCULO");
		System.out.println("2 - REMOVER VEÍCULO");
		System.out.println("3 - BUSCAR POR MODELO");
		System.out.println("4 - BUSCAR POR MONTADORA");
		System.out.println("5 - BUSCAR POR ANO/MODELO");
		System.out.println("6 - BUSCA POR FAIXA DE PREÇO");
		System.out.println("7 - SAIR");
		System.out.println("--- ESCOLHA UMA OPÇÃO ---");
	}
		
		
		
		
		
}


