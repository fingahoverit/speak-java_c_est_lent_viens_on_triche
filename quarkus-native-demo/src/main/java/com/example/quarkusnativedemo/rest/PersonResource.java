package com.example.quarkusnativedemo.rest;

import com.example.quarkusnativedemo.model.Person;
import com.example.quarkusnativedemo.service.PersonService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    @Inject
    PersonService service;

    @GET
    public List<Person> list() {
        return service.listAll();
    }
}
