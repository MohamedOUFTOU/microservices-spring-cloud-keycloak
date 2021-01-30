package com.enset.costumerservice;

import com.enset.costumerservice.entities.Costumer;
import com.enset.costumerservice.repository.CostumerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CostumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CostumerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CostumerRepository costumerRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        repositoryRestConfiguration.exposeIdsFor(Costumer.class);
        return args -> {
            costumerRepository.save(new Costumer(null,"contact@sqli.ma","SQLI"));
            costumerRepository.save(new Costumer(null,"contact@d-aim.ma","D-AIM"));
            costumerRepository.save(new Costumer(null,"contact@atos.ma","Atos"));
            costumerRepository.findAll().forEach(System.out::println);
        };
    }
}
