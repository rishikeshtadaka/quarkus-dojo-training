package org.fiserv.dojo.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/orders")
public class OrderController {

    @GET
    public Response GetOrders(){
        return Response.ok("Orders").build();
    }
}
