package org.fiserv.dojo.Exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class CustomBadRequestErrorHandling implements ExceptionMapper<CustomBadRequestException> {

    @Override
    public Response toResponse(CustomBadRequestException e) {
        return Response.status(Response.Status.BAD_REQUEST).entity("Custom Bad Request").build();
    }
}

