package edu.matc.restdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Region;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The type Regions.
 *
 * @author jbjohnson2
 * @author JBostroem
 * @author OscarJohnson6
 */
@Path("/regions")
public class Regions {
    private final Logger logger = LogManager.getLogger(this.getClass());
    String regionsString = "Error making json file";

    /**
     * Gets regions.
     *
     * @return the regions
     */
    @GET
    @Produces("application/json")
    public Response getRegions() {
        ObjectMapper objectMapper = new ObjectMapper();
        GenericDao<Region> regionDao = new GenericDao<>(Region.class);
        List<Region> regions = regionDao.getAll();

        try {
            regionsString = objectMapper.writeValueAsString(regions);

            return Response.status(200).entity(regionsString).build();
        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error making json file", jsonProcessingException);
        }

        return Response.status(500).entity(regionsString).build();
    }

    /**
     * Gets region by id.
     *
     * @param id the id
     * @return the region by id
     */
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getRegionById(@PathParam("id") int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        GenericDao<Region> regionDao = new GenericDao<>(Region.class);
        Region region = regionDao.getById(id);

        try {
            regionsString = objectMapper.writeValueAsString(region);

            return Response.status(200).entity(regionsString).build();
        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error making json file", jsonProcessingException);
        }

        return Response.status(500).entity(regionsString).build();
    }
}
