package org.fiserv.dojo.controller;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/test")
public class TestController {
    @ConfigProperty(name = "greeting.morning")
    String message;

    @GET
    public Response readConfig(){
        String goodNightMessage = ConfigProvider.getConfig().getValue("greeting.night", String.class);
        return Response.ok(goodNightMessage).build();
    }
}
