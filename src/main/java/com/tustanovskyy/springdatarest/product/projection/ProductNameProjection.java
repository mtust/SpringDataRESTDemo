package com.tustanovskyy.springdatarest.product.projection;

import com.tustanovskyy.springdatarest.product.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Product.class, name = "name")
public interface ProductNameProjection {

    String getName();

}
