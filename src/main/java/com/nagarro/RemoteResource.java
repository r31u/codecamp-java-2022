package com.nagarro;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/remote")
public class RemoteResource {

    @RestClient
    RemoteService service;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Fallback(fallbackMethod = "fallBack")
    public String getHello() {

        return service.getRemoteHello();
    }

    private String fallBack() {

        return "Fallback return !!";
    }
}
