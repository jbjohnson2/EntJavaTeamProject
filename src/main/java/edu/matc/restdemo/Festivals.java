package edu.matc.restdemo;

import edu.matc.entity.Festival;
import edu.matc.persistence.GenericDao;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * This class' purpose is to return festivals
 */
@Path("/festivals")
public class Festivals {
    // The Java method will process HTTP GET requests
    private GenericDao genericDao;
    private String output;

    /**
     * Instantiates a new Festival.
     */
    public Festivals() {

        genericDao = new GenericDao<>(Festival.class);
    }

    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")

    /**
     * This method's purpose is to return all festivals
     */
    public Response getFestivals() {
        // Return a simple message
        output = "Here's all the festivals: " + genericDao.getAll();
        return Response.status(200).entity(output).build();
    }

    @GET

    @Path("/{param}")
    
    @Produces("text/plain")

    /**
     * This method's purpose is to get the festival by id
     */
    public Response getFestivalById(@PathParam("param") int id) {

        // Return the festival specified by the id
        if (genericDao.getById(id) == null) {

            output = "No festivals could be found";

        } else {

            output = "Here's the festival: " + genericDao.getById(id);
        }

        return Response.status(200).entity(output).build();
    }
}