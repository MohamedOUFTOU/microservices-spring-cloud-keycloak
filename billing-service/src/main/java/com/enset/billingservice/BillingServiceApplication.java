package com.enset.billingservice;

import com.enset.billingservice.entities.Bill;
import com.enset.billingservice.entities.ProductItem;
import com.enset.billingservice.repositories.BillRepository;
import com.enset.billingservice.repositories.ProductItemRepository;
import com.enset.billingservice.services.CostumerServiceClient;
import com.enset.billingservice.services.ProductServiceClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Bill.class,ProductItem.class);
        };
    }
}
