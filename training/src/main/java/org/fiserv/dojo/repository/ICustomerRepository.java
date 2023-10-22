package org.fiserv.dojo.repository;

import org.fiserv.dojo.domain.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findByFirstName(String firstName);
}
