package com.tustanovskyy.springdatarest.customer.controller;

import com.tustanovskyy.springdatarest.customer.Customer;
import com.tustanovskyy.springdatarest.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RepositoryRestController
@ExposesResourceFor(Customer.class)
@RequiredArgsConstructor
public class CustomRestController {

    private final RepositoryEntityLinks entityLinks;
    private final CustomerService customerService;

    @ResponseBody
    @PostMapping(path = "customers/{id}/products")
    public ResponseEntity addProducts(@PathVariable Long id, @RequestBody List<Long> productIds){
        Customer customer = customerService.addProducts(id, productIds);
        Resource<Customer> resource = new Resource<>(customer);
        resource.add(entityLinks.linkToSingleResource(Customer.class, id));
        return ResponseEntity.ok(resource);
    }

}
