package com.example.ebankservice.dto;

import com.example.ebankservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountReqDTO {
    private String id;
    private Date createdAt ;
    private Double balance ;
    private String currency ;
    private AccountType type;
}
