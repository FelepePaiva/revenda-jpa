package com.example.revenda;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.revenda.entities.Vehicle;
import com.example.revenda.resources.VehicleResource;
import com.example.revenda.services.VehicleService;
@EnableWebMvc
@SpringBootApplication
public class RevendaApplication {
	public static void main(String[] args) {
		SpringApplication.run(RevendaApplication.class, args);		
		Locale.setDefault(Locale.US);		
		int menu;
		Scanner sc = new Scanner(System.in);
		String model, assembler, color;
		int id, yearModel;
		double price;
		
		do {
			exibirMenu();
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				System.out.println("Digite o MODELO: ");
				model = sc.nextLine();
				sc.next();
				System.out.println("Montadora: ");
				assembler = sc.nextLine();
				sc.next();
				System.out.println("Cor: ");
				color = sc.nextLine();
				sc.next();
				System.out.println("Ano/Modelo: ");
				yearModel = sc.nextInt();
				System.out.println("Preço: ");
				price = sc.nextDouble();
				Vehicle obj = new Vehicle(null, model, assembler, color, yearModel, price);		
				service.insert(obj);
				
				
				
			default:
				System.out.println("OPÇAO DE MENU INVALIDA");
			} 
			
			
		}while(menu != 7);
		sc.close();


	}
	static void exibirMenu() {
		System.out.println("-------- LIVRO LIVRARIA --------");
		System.out.println("1 - CADASTRAR VEÍCULO");
		System.out.println("2 - LISTAR");
		System.out.println("3 - EXCLUIR LIVRO");
		System.out.println("4 - PESQUISAR GÊNERO");
		System.out.println("5 - PESQUISAR POR FAIXA DE PREÇO");
		System.out.println("6 - CALCULAR O VALOR TOTAL DO ACERVO");
		System.out.println("7 - SAIR");
		System.out.println("--- ESCOLHA UMA OPÇÃO ---");
	}
		
		
		
		
		
	}


