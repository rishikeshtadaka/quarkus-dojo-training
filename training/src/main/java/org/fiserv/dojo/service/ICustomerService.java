package org.fiserv.dojo.service;

import org.fiserv.dojo.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findByFirstName(String firstName);
    List<Customer> getAll();
    Optional<Customer> getById(Long id);
    void add(Customer customer);
    void update(Customer customer);
    boolean delete(Long id);
}
