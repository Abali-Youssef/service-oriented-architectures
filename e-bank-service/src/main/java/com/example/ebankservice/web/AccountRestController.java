package com.example.ebankservice.web;

import com.example.ebankservice.dto.BankAccountReqDTO;
import com.example.ebankservice.dto.BankAccountRequestDTO;
import com.example.ebankservice.dto.BankAccountResponseDTO;
import com.example.ebankservice.entities.BankAccount;
import com.example.ebankservice.repositories.BankAccountRepository;
import com.example.ebankservice.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RestController
@AllArgsConstructor
public class AccountRestController {
    private BankAccountRepository bankAccountRepository;
    private AccountService accountService ;



    @GetMapping("/bankaccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
        }
    @GetMapping("/bankaccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id).orElse(null);
    }
    @PostMapping("/bankaccounts")
    public BankAccountResponseDTO save (@RequestBody BankAccountRequestDTO bankAccountRequestDTO){
        return accountService.addAccount(bankAccountRequestDTO);
    }

    @PostMapping("/bankaccounts/{id}")
    public  BankAccountResponseDTO update (@PathVariable String id ,@RequestBody BankAccountReqDTO bankAccount){
       return  accountService.updateAccount(bankAccount);
    }
    @DeleteMapping("/bankaccounts/{id}")
    public  void delete (@PathVariable String id){
        bankAccountRepository.deleteById((id));
    }
}
