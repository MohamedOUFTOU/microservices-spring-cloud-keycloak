package com.enset.inventoryservice.repositories;

import com.enset.inventoryservice.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<List<Product>> findAllByNameContains(String name, Pageable p);
}
