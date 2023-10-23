package org.fiserv.dojo.service;

import org.fiserv.dojo.domain.Customer;
import org.fiserv.dojo.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findByFirstName(String firstName);
    List<Customer> getAll();
    Optional<Customer> getById(Long id);
    Customer add(CustomerDto customer);
    Customer update(Long id,CustomerDto customer);
    void delete(Long id);
}
