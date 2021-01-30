package com.enset.costumerservice.entities;

import org.springframework.data.rest.core.config.Projection;


@Projection(name = "fullCostumer",types = Costumer.class)
public interface CostumerProjection extends Projection {
    public Long getId();
    public String getEmail();
    public String getName();
}
