package org.fiserv.dojo.controller;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.fiserv.dojo.Exception.CustomBadRequestException;
import org.fiserv.dojo.domain.Customer;
import org.fiserv.dojo.dto.CustomerDto;
import org.fiserv.dojo.service.CustomerService;
import org.fiserv.dojo.service.ICustomerService;
import org.jboss.logging.Logger;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/customers")
@Tag(name="Customers", description = "Customer operations")
public class CustomerController {
    private static final Logger log = Logger.getLogger(CustomerController.class);
    @Inject
    private ICustomerService customerService;

    @Inject
    private Validator validator;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get Customer", description = "Get All Customers list")
    @APIResponse(responseCode = "200",description = "Successfully returned", content = @Content(mediaType = MediaType.APPLICATION_JSON))
    public Response GetAllCustomers(){
        List<Customer> list=this.customerService.getAll();
        return Response.ok(list).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get Customer", description = "Get customer by id")
    @APIResponse(responseCode = "200",description = "Successfully returned", content = @Content(mediaType = MediaType.APPLICATION_JSON))
    public Response GetCustomerById(@PathParam("id") Long id){
        Optional<Customer> customer=this.customerService.getById(id);
        if(customer.isEmpty())
            return Response.noContent().build();
        return Response.ok(customer).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response CreateCustomer(
            @RequestBody(description = "Create a customer",required = true,content = @Content(schema=@Schema(implementation = CustomerDto.class)))
            CustomerDto customerDto){
        log.info("Creating new Customer");
        Set<ConstraintViolation<CustomerDto>> constraintViolations =this.validator.validate(customerDto);
        if(!constraintViolations.isEmpty()){
            String messages=constraintViolations.stream().map(v->v.getMessage()).collect(Collectors.joining(", "));
            return Response.status(Response.Status.BAD_REQUEST).entity(messages).build();
        }
        Customer customer=this.customerService.add(customerDto);
        if(customer.isPersistent())
            return Response.created(URI.create("/customers"+customer.id)).build();
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response UpdateCustomer(
            @RequestBody(description = "Update a customer",required = true,content = @Content(schema=@Schema(implementation = CustomerDto.class)))
            CustomerDto customerDto,
            @PathParam("id") Long id){
        log.info("Updating new Customer");
        Customer customer=this.customerService.update(id,customerDto);
        return Response.status(Response.Status.OK).entity(customer).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response DeleteCustomer(
            @PathParam("id") Long id){
        log.info("Deleting Customer");
        this.customerService.delete(id);
        return Response.status(Response.Status.OK).build();
    }
}
