package org.fiserv.dojo.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.fiserv.dojo.dto.CustomerDto;

@Path("/customers")
@Tag(name="Customers", description = "Get all customers")
public class CustomerController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get Customer", description = "Get All Customers list")
    @APIResponse(responseCode = "200",description = "Successfully returned", content = @Content(mediaType = MediaType.APPLICATION_JSON))
    public Response GetAllCustomers(){

        return Response.ok(new CustomerDto()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response CreateCustomer(
            @RequestBody(description = "Create a customer",required = true,content = @Content(schema=@Schema(implementation = CustomerDto.class)))
            CustomerDto customerDto){
        return Response.status(Response.Status.CREATED).entity(new CustomerDto()).build();
    }
}
