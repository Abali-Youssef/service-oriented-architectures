package com.example.ebankservice.repositories;

import com.example.ebankservice.entities.BankAccount;
import com.example.ebankservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
