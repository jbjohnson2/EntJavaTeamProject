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

    /**
     * Gets festival by type id.
     *
     * @param typeID the id
     * @return the festival by type id
     */
    @GET

    @Path("/types/{param}")

    @Produces("text/plain")

    public Response getFestivalByTypeId(@PathParam("param") int typeID) {

        // Return the festival specified by the id
        if (genericDao.findByPropertyEqual("typeID", typeID) == null) {

            output = "No festivals could be found";

        } else {

            output = "Here's the festival: " + genericDao.findByPropertyEqual("typeID", typeID);
        }

        return Response.status(200).entity(output).build();
    }


    /**
     * Gets festival by region id.
     *
     * @param regionID the region id
     * @return the festival by region id
     */
    @GET

    @Path("/regions/{param}")

    @Produces("text/plain")

    public Response getFestivalByRegionId(@PathParam("param") int regionID) {

        // Return the festival specified by the id
        if (genericDao.findByPropertyEqual("regionID", regionID) == null) {

            output = "No festivals could be found";

        } else {

            output = "Here's the festival: " + genericDao.findByPropertyEqual("regionID", regionID);
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

    @Path("/{name}/{regionId}/{typeId}/{date}")

    /**
     * This method's purpose is to return all festivals
     */
    public Response postFestivals(@PathParam("name") String name,
                                  @PathParam("regionId") int regionId,
                                  @PathParam("typeId") int typeId,
                                  @PathParam("date") String date) {

        GenericDao regionDao = new GenericDao(Region.class);
        GenericDao typeDao = new GenericDao(Type.class);
        LocalDate localDate = LocalDate.parse(date);

        if (typeDao.getById(typeId) == null) {
            output = "Please enter a valid type id";
        } else if (regionDao.getById(regionId) == null) {
            output = "Please enter a valid region ID";
        } else {
            Festival festival = new Festival(name, regionId, typeId, date);
            int id = genericDao.insert(festival);
            output = "You've successfully added a festival with an Id of " + id;
        }
        return Response.status(200).entity(output).build();
    }
}