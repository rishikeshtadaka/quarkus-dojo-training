package org.fiserv.dojo.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.fiserv.dojo.domain.Customer;
import org.fiserv.dojo.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CustomerService implements ICustomerService {
    @Inject
    CustomerRepository customerRepository;
    public List<Customer> findByFirstName(String firstName){
        return customerRepository.findByFirstName(firstName);
    }

    public List<Customer> getAll(){
        return customerRepository.listAll();
    }

    @Override
    public void add(Customer customer) {
        this.customerRepository.add(customer);
    }

    @Override
    public void update(Customer customer) {
        this.customerRepository.update(customer);
    }

    @Override
    public boolean delete(Long id) {
        return this.customerRepository.delete(id);
    }

    @Override
    public Optional<Customer> getById(Long id){
        return this.customerRepository.findByIdOptional(id);
    }
}
