package org.fiserv.dojo.Exception;

import io.quarkus.logging.Log;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GenericErrorHandling implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        Log.error(e.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity("Generic:Something went wrong").build();
    }
}


