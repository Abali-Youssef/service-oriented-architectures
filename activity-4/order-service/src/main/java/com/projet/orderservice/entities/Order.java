package com.projet.orderservice.entities;

import com.projet.orderservice.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.beans.Customizer;
import java.util.Date;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Date createdAt;
    private OrderStatus status;
    private Long CustomerId;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;
    @Transient
    private Customer customer;
}
