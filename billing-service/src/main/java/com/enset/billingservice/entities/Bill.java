package com.enset.billingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private long costumerID;

    @OneToMany(mappedBy = "bill", cascade = CascadeType.REMOVE)
    private Collection<ProductItem> productItems = new ArrayList<>();

    @Transient
    private Costumer costumer;
}
