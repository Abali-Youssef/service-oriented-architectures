package com.projetopenlab.openlabcustomerservice.service;

import com.projetopenlab.openlabcustomerservice.dto.CustomerRequestDTO;
import com.projetopenlab.openlabcustomerservice.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    List<CustomerResponseDTO> listCustomers();



}
