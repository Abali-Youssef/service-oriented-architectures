package com.projetopenlab.openlabcustomerservice.repositories;

import com.projetopenlab.openlabcustomerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
