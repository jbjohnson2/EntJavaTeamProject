package edu.matc.restdemo;

import edu.matc.entity.Region;
import edu.matc.entity.Type;
import edu.matc.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/type")
public class TypeById {

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getMessage(@PathParam("id") int id) {
        GenericDao<Type> typeDao = new GenericDao<>(Type.class);
        Type type = typeDao.getById(id);

        return Response.status(500).entity(type.getType()).build();
    }
}
