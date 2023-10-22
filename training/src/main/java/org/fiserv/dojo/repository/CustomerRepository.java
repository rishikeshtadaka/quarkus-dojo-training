package org.fiserv.dojo.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.fiserv.dojo.domain.Customer;

import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer>, ICustomerRepository {
    public List<Customer> findByFirstName(String firstName){
        return this.list("firstName",firstName);
    }

}
