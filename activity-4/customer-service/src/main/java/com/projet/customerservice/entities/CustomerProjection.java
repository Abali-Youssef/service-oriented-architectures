package com.projet.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name="fullProduct",types=Customer.class)
public interface CustomerProjection {
    Long getId();
    String getNom();
    String getEmail();

}
