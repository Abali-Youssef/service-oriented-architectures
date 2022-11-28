package com.projet.orderservice.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
public class Product {
    private Long id;
    private String name;
    private double price;
    private int quantity;

}
