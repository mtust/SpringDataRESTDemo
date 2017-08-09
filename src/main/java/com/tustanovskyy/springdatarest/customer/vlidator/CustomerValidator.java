package com.tustanovskyy.springdatarest.customer.vlidator;

import com.tustanovskyy.springdatarest.customer.Customer;
import com.tustanovskyy.springdatarest.product.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        final Customer customer = (Customer) target;
        final Double budget = customer.getBudget();
        List<Product> productList = customer.getProducts();
        if (productList.stream().mapToDouble(Product::getPrice).sum() > customer.getBudget()) {
            errors.rejectValue("budget", "400", customer.getName() + " haven't enough money");
        }
    }
}
