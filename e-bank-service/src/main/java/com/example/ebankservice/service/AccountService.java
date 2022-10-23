package com.example.ebankservice.service;

import com.example.ebankservice.dto.BankAccountReqDTO;
import com.example.ebankservice.dto.BankAccountRequestDTO;
import com.example.ebankservice.dto.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);
    public BankAccountResponseDTO updateAccount(BankAccountReqDTO bankAccountReqDTO);
}
