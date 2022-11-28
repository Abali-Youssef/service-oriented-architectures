package com.projet.inventoryservice;

import com.projet.inventoryservice.entities.Product;
import com.projet.inventoryservice.repositories.ProductRepository;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args -> {
			for (int i = 1; i <10 ; i++) {
				productRepository.saveAll(List.of(
						Product.builder().name("pdt1").price(1222+Math.random()*33).quantity(i*12).build()
				));
			}

		};
}
}
