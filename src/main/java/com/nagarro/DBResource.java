package com.nagarro;

import io.quarkus.panache.common.Sort;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/db")
public class DBResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> persons() {

        return Person.listAll(Sort.ascending("age"));
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addPerson(Person person) {

        person.persist();
        return Response.status(Response.Status.CREATED).entity(person).build();
    }
}
