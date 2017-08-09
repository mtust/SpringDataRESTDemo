package com.tustanovskyy.springdatarest.customer.repositories;

import com.tustanovskyy.springdatarest.customer.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer, Long>{

    List<Customer> findByName(@Param("name") String name);

    @RestResource(path = "product")
    List<Customer> findByProductsPrice(@Param("price") Double price);

    @Query(value = "select sum(p.price) from Customer as c " +
            "join c.products as p where c.id = :#{#id}")
    Double totalPrice(@Param("id") Long id);
}
