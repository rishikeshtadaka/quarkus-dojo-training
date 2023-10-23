package org.fiserv.dojo.mappers;

import org.fiserv.dojo.domain.Customer;
import org.fiserv.dojo.dto.CustomerDto;

public class CustomerMapper {
    public static CustomerDto getDto(Customer customer){
        return new CustomerDto(customer.FirstName,customer.LastName,customer.Address);
    }
}
