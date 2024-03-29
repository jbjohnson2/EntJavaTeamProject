package edu.matc.restdemo;

import edu.matc.entity.Region;
import edu.matc.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/region")
public class RegionById {

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getMessage(@PathParam("id") int id) {
        GenericDao<Region> regionDao = new GenericDao<>(Region.class);
        Region region = regionDao.getById(id);

        return Response.status(500).entity(region.getRegionName()).build();
    }
}
