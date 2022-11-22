package com.projet.comptemulticonnecteurs;

import com.projet.comptemulticonnecteurs.dto.CompteRequestDTO;
import com.projet.comptemulticonnecteurs.service.CompteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

@SpringBootApplication
public class CompteMultiConnecteursApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompteMultiConnecteursApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CompteService compteService){
		return args -> {
			compteService.save(new CompteRequestDTO(100));
			compteService.save(new CompteRequestDTO(200));
			compteService.save(new CompteRequestDTO(300));
		};
	}
	@Bean
	SimpleJaxWsServiceExporter serviceExporter() {
		SimpleJaxWsServiceExporter simpleJaxWsServiceExporter = new SimpleJaxWsServiceExporter();

		simpleJaxWsServiceExporter.setBaseAddress("http://localhost:8088/");

		System.out.println("server started");
		return simpleJaxWsServiceExporter;
	}
}
