package com.example.ebankservice.repositories;

import com.example.ebankservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface BankAccountRepository extends JpaRepository<BankAccount,String> {

}
