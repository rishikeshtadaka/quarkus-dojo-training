package org.fiserv.dojo.service;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.fiserv.dojo.domain.Customer;
import org.fiserv.dojo.dto.CustomerDto;
import org.fiserv.dojo.repository.ICustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import static io.restassured.RestAssured.when;
import static org.mockito.Mockito.verify;


@QuarkusTest
public class TestCustomerService {
    @Inject
    ICustomerService customerService;

    @InjectMock
    ICustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        Customer customer1=mock(Customer.class);
        List<Customer> list=new ArrayList<>();
        list.add(customer1);
        Mockito.when(customerRepository.getAll())
                .thenReturn(list);
    }

    @Test
    public void getAll(){
        List<CustomerDto> listOutput=this.customerService.getAll();
        assertEquals(1, listOutput.size());
    }

}
