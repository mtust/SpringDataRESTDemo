package com.tustanovskyy.springdatarest.customer;

import com.tustanovskyy.springdatarest.product.Product;
import lombok.Builder;
import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double budget;
    @OneToMany
    private List<Product> products;

}
