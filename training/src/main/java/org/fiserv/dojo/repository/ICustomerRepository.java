package org.fiserv.dojo.repository;

import org.fiserv.dojo.domain.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {
    List<Customer> findByFirstName(String firstName);
    void add(Customer customer);
    void update(Customer customer);
    boolean delete(Long id);
    Optional<Customer> getById(Long id);
}
