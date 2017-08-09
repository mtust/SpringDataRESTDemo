package com.tustanovskyy.springdatarest.customer.service;


import com.tustanovskyy.springdatarest.customer.Customer;

import java.util.List;

public interface CustomerService {
    Customer addProducts(Long id, List<Long> productIds);
}
