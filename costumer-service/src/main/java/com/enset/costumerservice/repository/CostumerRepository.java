package com.enset.costumerservice.repository;

import com.enset.costumerservice.entities.Costumer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CostumerRepository extends JpaRepository<Costumer,Long> {

    Page<List<Costumer>> findAllByNameContains(String name, Pageable p);
}
