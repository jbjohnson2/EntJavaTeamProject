package edu.matc.restdemo;

import edu.matc.entity.Festival;
import edu.matc.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * This class' purpose is to return all festivals
 */
@Path("/festivals")
public class Festivals {
    // The Java method will process HTTP GET requests
    private GenericDao genericDao;

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
    public Response getMessage() {
        // Return a simple message
        String output = "Here's all the festivals: " + genericDao.getAll();
        return Response.status(200).entity(output).build();
    }
}