package com.example.ebankservice.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.ebankservice.dto.BankAccountReqDTO;
import com.example.ebankservice.dto.BankAccountRequestDTO;
import com.example.ebankservice.dto.BankAccountResponseDTO;
import com.example.ebankservice.entities.BankAccount;
import com.example.ebankservice.mappers.AccountMapper;
import com.example.ebankservice.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
class AccountServiceImpl implements AccountService {
    private BankAccountRepository bankAccountRepository;
    private AccountMapper accountMapper ;



    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = new BankAccount();
        bankAccount = accountMapper.fromBankAccountRequestDTO(bankAccountRequestDTO);
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO =  new BankAccountResponseDTO();
        bankAccountResponseDTO= accountMapper.fromBankAccount(savedBankAccount);
        return  bankAccountResponseDTO;
    }


    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = new BankAccount();
        bankAccount = accountMapper.fromBankAccountRequestDTO(bankAccountRequestDTO);

        BankAccount updatedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO =  new BankAccountResponseDTO();
        bankAccountResponseDTO= accountMapper.fromBankAccount(updatedBankAccount);
        return  bankAccountResponseDTO;

    }


}
