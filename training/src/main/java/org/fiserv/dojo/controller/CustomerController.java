package org.fiserv.dojo.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fiserv.dojo.dto.CustomerDto;

@Path("/customers")
public class CustomerController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response GetAllCustomers(){

        return Response.ok(new CustomerDto()).build();
    }
}
