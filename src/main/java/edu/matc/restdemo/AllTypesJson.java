package edu.matc.restdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Type;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/types/json")
public class AllTypesJson {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @GET
    @Produces("application/json")
    public Response getMessage() {
        ObjectMapper objectMapper = new ObjectMapper();
        GenericDao<Type> typeDao = new GenericDao<>(Type.class);
        List<Type> types = typeDao.getAll();
        String typesString = "Error making json file";

        try {
            typesString = objectMapper.writeValueAsString(types);

            logger.info(typesString);
            logger.info(Response.status(200).entity(typesString).build());

            return Response.status(200).entity(typesString).build();
        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error making json file", jsonProcessingException);
        }

        return Response.status(500).entity(typesString).build();
    }
}
