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
 * The type Types.
 *
 * @author jbjohnson2
 * @author JBostroem
 * @author OscarJohnson6
 */
@Path("/types")
public class Types {
    private final Logger logger = LogManager.getLogger(this.getClass());
    String typeString = "Error making json file";

    /**
     * Gets types.
     *
     * @return the types
     */
    @GET
    @Produces("application/json")
    public Response getTypes() {
        ObjectMapper objectMapper = new ObjectMapper();
        GenericDao<Type> typeDao = new GenericDao<>(Type.class);
        List<Type> types = typeDao.getAll();

        try {
            typeString = objectMapper.writeValueAsString(types);

            return Response.status(200).entity(typeString).build();
        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error making json file", jsonProcessingException);
        }

        return Response.status(500).entity(typeString).build();
    }

    /**
     * Gets type by id.
     *
     * @param id the id
     * @return the type by id
     */
    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getTypeById(@PathParam("id") int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        GenericDao<Type> typeDao = new GenericDao<>(Type.class);
        Type type = typeDao.getById(id);

        try {
            typeString = objectMapper.writeValueAsString(type);

            return Response.status(200).entity(typeString).build();
        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error making json file", jsonProcessingException);
        }

        return Response.status(500).entity(typeString).build();
    }
}
