package com.example.ebankservice.web;

import com.example.ebankservice.dto.BankAccountRequestDTO;
import com.example.ebankservice.dto.BankAccountResponseDTO;
import com.example.ebankservice.entities.BankAccount;
import com.example.ebankservice.entities.Customer;
import com.example.ebankservice.repositories.BankAccountRepository;
import com.example.ebankservice.repositories.CustomerRepository;
import com.example.ebankservice.service.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQLController {
    private BankAccountRepository bankAccountRepository ;
    private AccountService accountService ;
    private CustomerRepository customerRepository;

    public BankAccountGraphQLController(BankAccountRepository bankAccountRepository, AccountService accountService, CustomerRepository customerRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.customerRepository = customerRepository;
    }
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }

    @QueryMapping
    public List<Customer> customers(){
        return customerRepository.findAll();
    }

    @QueryMapping
    public BankAccount getBankAccount(@Argument String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("account %s not found",id)));
    }

    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccountRequestDTO){
            return  accountService.addAccount(bankAccountRequestDTO);
    }
    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,  @Argument BankAccountRequestDTO bankAccountRequestDTO){
        return  accountService.updateAccount(id,bankAccountRequestDTO);
    }

    @MutationMapping
    public boolean deleteAccount(@Argument String id){
         bankAccountRepository.deleteById(id);
         return true;
    }
}


/*le type record existe dans les version le plus recentes a partir de java 14
record BankAccountDTO(Double balance, String type,String currency){

}*/
