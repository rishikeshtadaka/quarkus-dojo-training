package org.fiserv.dojo.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.fiserv.dojo.domain.Customer;
import org.fiserv.dojo.repository.CustomerRepository;

import java.util.List;

@ApplicationScoped
public class CustomerService {
    @Inject
    CustomerRepository customerRepository;
    public List<Customer> findByFirstName(String firstName){
        return customerRepository.findByFirstName(firstName);
    }

    public List<Customer> getAll(){
        return customerRepository.listAll();
    }
}
