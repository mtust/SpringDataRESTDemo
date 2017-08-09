package com.tustanovskyy.springdatarest.product;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;
}
