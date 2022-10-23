package com.projet.ensetbillingservice;

import com.projet.ensetbillingservice.dto.InvoiceRequestDTO;
import com.projet.ensetbillingservice.service.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class EnsetBillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnsetBillingServiceApplication.class, args);
    }
@Bean
    CommandLineRunner start(InvoiceService invoiceService){
        return args -> {
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(1233),"C1"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(33),"C3"));
            invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(3443),"C2"));
        };
}
}
