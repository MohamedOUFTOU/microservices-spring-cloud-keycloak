package com.enset.billingservice.services;

import com.enset.billingservice.entities.Costumer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "COSTUMER-SERVICE")
public interface CostumerServiceClient {

    @GetMapping("/costumers/{id}")
    Costumer findCostumerById(@RequestHeader(value = "Authorization") String jwtToken, @PathVariable("id") Long id);
}
