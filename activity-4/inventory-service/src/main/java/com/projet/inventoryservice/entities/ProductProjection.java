package com.projet.inventoryservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Projection(name="fullProduct",types=Product.class)
public interface ProductProjection {
    public Long getId();
    public  String getName();
    public double getPrice();
    public int getQuantity();
}
