package org.fiserv.dojo.service;

import org.fiserv.dojo.domain.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findByFirstName(String firstName);
    List<Customer> getAll();
}
