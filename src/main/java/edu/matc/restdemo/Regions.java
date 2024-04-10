package edu.matc.restdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Region;
import edu.matc.entity.Type;
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
    private String regionsString = "Error making json file";
    private ObjectMapper objectMapper;
    private GenericDao<Region> regionDao;

    public Regions() {
        //reads in an object and write the json response
        objectMapper = new ObjectMapper();
        regionDao = new GenericDao<>(Region.class);
    }
    /**
     * This method's purpose is to retrieve all regions
     * @return all regions
     */
    @GET
    @Produces("application/json")
    public Response getRegions() {

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
     * This method's purpose is to get the region by its id
     * @param id the region id
     * @return the region given its id
     */
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getRegionById(@PathParam("id") int id) {
        
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
