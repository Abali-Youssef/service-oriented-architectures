package com.projet.customerservice;

import com.projet.customerservice.entities.Customer;
import com.projet.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.saveAll(List.of(
					Customer.builder()
							.nom("youssef")
							.email("youssef@youss.com")
							.build(),
					Customer.builder()
							.nom("abali")
							.email("abali@youss.com")
							.build(),
					Customer.builder()
							.nom("ali")
							.email("ali@youss.com")
							.build()
			));
		};

}
}
