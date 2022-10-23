package com.projetopenlab.openlabcustomerservice.mappers;

import com.projetopenlab.openlabcustomerservice.dto.CustomerRequestDTO;
import com.projetopenlab.openlabcustomerservice.dto.CustomerResponseDTO;
import com.projetopenlab.openlabcustomerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
    Customer CustomerResponseDTOToCustomer(CustomerRequestDTO customerRequestDTO);

}
