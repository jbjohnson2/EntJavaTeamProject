package edu.matc.restdemo;

import edu.matc.entity.Festival;
import edu.matc.entity.Region;
import edu.matc.entity.Type;
import edu.matc.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDate;
import java.util.List;

/**
 * This class' purpose is to return festivals
 */
@Path("/festivals")
public class Festivals {
    // The Java method will process HTTP GET requests
    private GenericDao genericDao;
    private final Logger logger = LogManager.getLogger(this.getClass());
    private String output;

    /**
     * Instantiates a new Festival.
     */
    public Festivals() {

        genericDao = new GenericDao<>(Festival.class);
    }

    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")

    /**
     * This method's purpose is to return all festivals
     */
    public Response getFestivals() {
        // Return a simple message
        output = "Here's all the festivals: " + genericDao.getAll();
        return Response.status(200).entity(output).build();
    }

    @GET

    @Path("/{param}")
    
    @Produces("text/plain")

    /**
     * This method's purpose is to get the festival by id
     */
    public Response getFestivalById(@PathParam("param") int id) {

        // Return the festival specified by the id
        if (genericDao.getById(id) == null) {

            output = "No festivals could be found";

        } else {

            output = "Here's the festival: " + genericDao.getById(id);
        }

        return Response.status(200).entity(output).build();
    }

    // The Java method will process HTTP GET requests
    @GET

    @Path("/json")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response getMessage() {
        ObjectMapper objectMapper = new ObjectMapper();
        GenericDao<Festival> festivalDao = new GenericDao<>(Festival.class);
        List<Festival> festivals = festivalDao.getAll();
        String festivalsJsonString = "Error making json file";

        try {
            festivalsJsonString = objectMapper.writeValueAsString(festivals);
            logger.info(festivalsJsonString);
            logger.info(Response.status(200).entity(festivalsJsonString).build());
            return Response.status(200).entity(festivalsJsonString).build();
        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error processing json file", jsonProcessingException);
        }

        return Response.status(500).entity(festivalsJsonString).build();
    }

    @POST
    @Path("/{name}/{regionID}/{typeID}/{date}")
    /**
     * This method's purpose is to return all festivals
     */
    public Response postFestivals(@PathParam("name") String name,
                                  @PathParam("regionID") int regionID,
                                  @PathParam("typeID") int typeID,
                                  @PathParam("date") String date) {
        genericDao = new GenericDao<>(Festival.class);
        GenericDao regionDao = new GenericDao(Region.class);
        GenericDao typeDao = new GenericDao(Type.class);
        Festival festival = new Festival();
        LocalDate localDate = LocalDate.parse(date);


        festival.setFestivalName(name);
        festival.setRegion((Region)regionDao.getById(regionID));
        festival.setType((Type)typeDao.getById(typeID));
        festival.setFestivalStartDate(localDate);

        int id = genericDao.insert(festival);

        String output = "You've successfully added a festival with an Id of " + id;
        return Response.status(200).entity(output).build();
    }
}