package com.projetopenlab.openlabcustomerservice.web;

import com.projetopenlab.openlabcustomerservice.dto.CustomerRequestDTO;
import com.projetopenlab.openlabcustomerservice.dto.CustomerResponseDTO;
import com.projetopenlab.openlabcustomerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestAPI {
    private CustomerService customerService;


    public CustomerRestAPI(CustomerService customerService) {
        this.customerService = customerService;
    }
    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> allCustomers(){
        return customerService.listCustomers();
    }
    @PostMapping (path = "/customers")
    public CustomerResponseDTO save(@RequestBody  CustomerRequestDTO customerRequestDTO){
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDTO);
    }
    @GetMapping(path = "/customer/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable  String id){
        return customerService.getCustomer(id);
    }
}
