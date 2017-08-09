package com.tustanovskyy.springdatarest.config;

import com.tustanovskyy.springdatarest.customer.vlidator.CustomerValidator;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class CustomerRepositoryRestConfigurer extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureValidatingRepositoryEventListener(final ValidatingRepositoryEventListener validatingListener) {
        final CustomerValidator customerValidator = new CustomerValidator();
        validatingListener.addValidator("beforeCreate", customerValidator);
        validatingListener.addValidator("beforeSave", customerValidator);
    }

}
