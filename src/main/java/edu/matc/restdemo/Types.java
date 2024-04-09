package edu.matc.restdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Type;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * This class' purpose is to perform get and post methods to interact with the data
 */
@Path("/types")
public class Types {
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * This method's purpose is to retrieve all types
     * @return all types
     */
    @GET
    @Produces("application/json")
    public Response getTypes() {

        //reads in an object and write the json response
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

    /**
     * This method's purpose is to get the type by its id
     * @param id the type id
     * @return the type by its id
     */
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getTypeById(@PathParam("id") int id) {

        ObjectMapper objectMapper = new ObjectMapper();
        GenericDao<Type> typeDao = new GenericDao<>(Type.class);
        Type type = typeDao.getById(id);
        String typeString = "Error making json file";

        try {

            typeString = objectMapper.writeValueAsString(type);
            logger.info(typeString);
            logger.info(Response.status(200).entity(typeString).build());
            return Response.status(200).entity(typeString).build();

        } catch (JsonProcessingException jsonProcessingException) {

            logger.error("Error making json file", jsonProcessingException);
        }
        return Response.status(500).entity(typeString).build();
    }
}
