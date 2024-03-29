package edu.matc.restdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Region;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/regions/json")
public class AllRegionsJson {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @GET
    @Produces("application/json")
    public Response getMessage() {
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
}
