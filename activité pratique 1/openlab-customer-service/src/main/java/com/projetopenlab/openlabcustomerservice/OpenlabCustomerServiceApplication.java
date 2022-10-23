package com.projetopenlab.openlabcustomerservice;

import com.projetopenlab.openlabcustomerservice.dto.CustomerRequestDTO;
import com.projetopenlab.openlabcustomerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpenlabCustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenlabCustomerServiceApplication.class, args);
    }
@Bean
    CommandLineRunner start(CustomerService customerService){
        return args -> {
            customerService.save(new CustomerRequestDTO("C3","AMAZON","amazon@amazon.com"));
            customerService.save(new CustomerRequestDTO("C1","GOOGLE","google@google.com"));
            customerService.save(new CustomerRequestDTO("C2","FACEBOOK","facebook@facebook.com"));
        };
}
}
