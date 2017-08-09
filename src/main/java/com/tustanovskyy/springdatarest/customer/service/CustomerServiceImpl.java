package com.tustanovskyy.springdatarest.customer.service;

import com.tustanovskyy.springdatarest.customer.Customer;
import com.tustanovskyy.springdatarest.customer.repositories.CustomerRepository;
import com.tustanovskyy.springdatarest.product.Product;
import com.tustanovskyy.springdatarest.product.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private  ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public Customer addProducts(Long id, List<Long> productIds) {
        Customer customer = customerRepository.findOne(id);
        List<Product> products = customer.getProducts();
        products.addAll((List) productRepository.findAll(productIds));
        customer.setProducts(products);
        return customer;
    }
}
