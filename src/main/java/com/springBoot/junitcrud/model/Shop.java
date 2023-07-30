package com.springBoot.junitcrud.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "shop")

public class Shop {
    @Id
    private Long id;

    @Column(name = "prod_name")
    private String name;

    @Column(name = "prod_price")
    private Double price;
}
