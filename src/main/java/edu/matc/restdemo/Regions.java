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
 * This class' purpose is to perform get and post methods to interact with the data
 */
@Path("/regions")
public class Regions {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * This method's purpose is to retrieve all regions
     * @return all regions
     */
    @GET
    @Produces("application/json")
    public Response getRegions() {

        ObjectMapper objectMapper = new ObjectMapper();
        GenericDao<Region> regionDao = new GenericDao<>(Region.class);
        List<Region> regions = regionDao.getAll();
        String regionsString = "Error making json file";

        try {
            regionsString = objectMapper.writeValueAsString(regions);

            logger.info(regionsString);
            logger.info(Response.status(200).entity(regionsString).build());
            return Response.status(200).entity(regionsString).build();

        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error making json file", jsonProcessingException);
        }
        return Response.status(500).entity(regionsString).build();
    }

    /**
     * This method's purpose is to get the region by its id
     * @param id the region id
     * @return the region given its id
     */
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getRegionById(@PathParam("id") int id) {

        ObjectMapper objectMapper = new ObjectMapper();
        GenericDao<Region> regionDao = new GenericDao<>(Region.class);
        Region region = regionDao.getById(id);

        String regionString = "Error making json file";

        try {
            regionString = objectMapper.writeValueAsString(region);

            logger.info(regionString);
            logger.info(Response.status(200).entity(regionString).build());
            return Response.status(200).entity(regionString).build();

        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error making json file", jsonProcessingException);
        }

        return Response.status(500).entity(regionString).build();
    }
}
