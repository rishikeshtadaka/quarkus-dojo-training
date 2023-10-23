package org.fiserv.dojo.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.fiserv.dojo.domain.Customer;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer>, ICustomerRepository {
    public List<Customer> findByFirstName(String firstName){
        return this.list("firstName",firstName);
    }

    @Override
    public void add(Customer customer) {
        this.persist(customer);
    }

    @Override
    public void update(Customer customer) {
        this.persist(customer);
    }

    @Override
    public boolean delete(Long id) {
        return this.deleteById(id);
    }

    @Override
    public Optional<Customer> getById(Long id){
        return findByIdOptional(id);
    }

    @Override
    public List<Customer> getAll(){
        return listAll();
    }


}
