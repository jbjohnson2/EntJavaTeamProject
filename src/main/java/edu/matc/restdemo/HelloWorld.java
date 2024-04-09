package edu.matc.restdemo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/greetings")
public class HelloWorld {

    @GET
    @Produces("text/plain")
    public Response getMessage() {

        String output = "Hello World";
        return Response.status(200).entity(output).build();
    }
}