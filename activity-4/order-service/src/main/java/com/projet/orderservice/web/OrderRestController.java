package com.projet.orderservice.web;

import com.projet.orderservice.entities.Order;
import com.projet.orderservice.model.Customer;
import com.projet.orderservice.model.Product;
import com.projet.orderservice.repositories.OrderRepository;
import com.projet.orderservice.repositories.ProductItemRepository;
import com.projet.orderservice.service.CustomerRestClientService;
import com.projet.orderservice.service.InventoryRestClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderRestController {
    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;


@GetMapping("/fullorder/{id}")
    public Order getOrder(@PathVariable  Long id){
        Order order =orderRepository.findById(id).get();
    Customer customer=customerRestClientService.customerById(order.getCustomerId());
    order.setCustomer(customer);
    order.getProductItems().forEach(pi -> {
        Product product = inventoryRestClientService.ProductById(pi.getProductId());
        pi.setProduct(product);
            }

    );
    return  order;
    }
}
