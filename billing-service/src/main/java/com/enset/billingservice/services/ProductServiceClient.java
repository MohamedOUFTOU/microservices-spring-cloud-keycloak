package com.enset.billingservice.services;


import com.enset.billingservice.entities.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductServiceClient {
    @GetMapping("/products/{id}")
    Product findProductById(@RequestHeader(value = "Authorization") String jwtToken,@PathVariable("id") Long id);
    @GetMapping("/products")
    PagedModel<Product> findAll(@RequestHeader(value = "Authorization") String jwtToken);
}
