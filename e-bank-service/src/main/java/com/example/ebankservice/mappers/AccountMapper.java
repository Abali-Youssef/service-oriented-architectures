package com.example.ebankservice.mappers;

import com.example.ebankservice.dto.BankAccountReqDTO;
import com.example.ebankservice.dto.BankAccountRequestDTO;
import com.example.ebankservice.dto.BankAccountResponseDTO;
import com.example.ebankservice.entities.BankAccount;
import graphql.parser.UnicodeUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromBankAccount (BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return  bankAccountResponseDTO ;
    }
    public BankAccount fromBankAccountRequestDTO (BankAccountRequestDTO bankAccountRequestDTO){
      BankAccount bankAccount = new BankAccount();
      BeanUtils.copyProperties(bankAccountRequestDTO,bankAccount);
      bankAccount.setId(UUID.randomUUID().toString());
      bankAccount.setCreatedAt(new Date());
      return bankAccount;
    }
    public BankAccount fromBankAccountReqDTO (BankAccountReqDTO bankAccountReqDTO){
        BankAccount bankAccount = new BankAccount();
        BeanUtils.copyProperties(bankAccountReqDTO,bankAccount);
        return bankAccount;
    }
}
