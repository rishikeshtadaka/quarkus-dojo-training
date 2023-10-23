package org.fiserv.dojo.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.fiserv.dojo.Exception.CustomBadRequestException;
import org.fiserv.dojo.domain.Customer;
import org.fiserv.dojo.dto.CustomerDto;
import org.fiserv.dojo.repository.CustomerRepository;
import org.fiserv.dojo.repository.ICustomerRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CustomerService implements ICustomerService {
    @Inject
    ICustomerRepository customerRepository;
    public List<Customer> findByFirstName(String firstName){
        return customerRepository.findByFirstName(firstName);
    }

    public List<Customer> getAll(){
        return customerRepository.getAll();
    }

    @Override
    public Customer add(CustomerDto customerDto) {
        Customer customer=new Customer();
        customer.FirstName=customerDto.getFirstName();
        customer.LastName=customerDto.getLastName();
        customer.Address=customerDto.getAddress();
        this.customerRepository.add(customer);
        return customer;
    }

    @Override
    public Customer update(Long id, CustomerDto customerDto) {
        Optional<Customer> customer=getById(id);
        if(customer.isEmpty())
            throw new CustomBadRequestException();
        customer.get().FirstName =customerDto.getFirstName();
        customer.get().LastName=customerDto.getLastName();
        customer.get().Address=customerDto.getAddress();
        this.customerRepository.update(customer.get());
        return customer.get();
    }

    @Override
    public void delete(Long id) {
        boolean isDeleted=this.customerRepository.delete(id);
        if(!isDeleted)
            throw new CustomBadRequestException();
    }

    @Override
    public Optional<Customer> getById(Long id){
        return this.customerRepository.getById(id);
    }
}
