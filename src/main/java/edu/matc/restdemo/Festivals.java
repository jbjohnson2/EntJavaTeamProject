package edu.matc.restdemo;

import edu.matc.entity.Festival;
import edu.matc.entity.Region;
import edu.matc.entity.Type;
import edu.matc.persistence.GenericDao;
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

    ObjectMapper objectMapper;



    /**
     * Instantiates a new Festival.
     */
    public Festivals() {

        genericDao = new GenericDao<>(Festival.class);
    }


    @GET

    @Produces("application/json")
    public Response getFestivals() {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        List<Festival> festivals = genericDao.getAll();
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


    /**
     * Gets all festivals in plain text.
     *
     * @return the festivals in plain text
     */
    @GET
    @Path("/pt")
    @Produces("text/plain")


    public Response getFestivalsPT() {
        // Return a simple message
        output = "Here's all the festivals: " + genericDao.getAll();
        return Response.status(200).entity(output).build();
    }

    /**
     * get festival by id
     * @param id festival to be retrieved id
     * @return festival
     */

    @GET
    @Path("/{param}")
    @Produces("application/json")
    public Response getFestivalById(@PathParam("param") int id) {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        Festival festival = (Festival)genericDao.getById(id);

        String festivalString = "Error making json file";

        try {
            festivalString = objectMapper.writeValueAsString(festival);

            logger.info(festivalString);
            logger.info(Response.status(200).entity(festivalString).build());
            return Response.status(200).entity(festivalString).build();

        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error making json file", jsonProcessingException);
        }

        return Response.status(500).entity(festivalString).build();
    }

    /**
     * This method's purpose is to get the festival by id
     */

    @GET

    @Path("/{param}/pt")
    
    @Produces("text/plain")


    public Response getFestivalByIdPT(@PathParam("param") int id) {

        // Return the festival specified by the id
        if (genericDao.getById(id) == null) {

            output = "No festivals could be found";

        } else {

            output = "Here's the festival: " + genericDao.getById(id);
        }

        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/types/{param}")
    @Produces("application/json")
    public Response getFestivalsByTypeId(@PathParam("param") int typeId) {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();


        List festivals = genericDao.findByPropertyEqual("typeID", typeId);

        String festivalString = "Error making json file";

        try {
            festivalString = objectMapper.writeValueAsString(festivals);

            logger.info(festivalString);
            logger.info(Response.status(200).entity(festivalString).build());
            return Response.status(200).entity(festivalString).build();

        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error making json file", jsonProcessingException);
        }

        return Response.status(500).entity(festivalString).build();
    }

    /**
     * Gets festival by type id.
     *
     * @param typeID the type id
     * @return the festival by type id
     */
    @GET

    @Path("/types/{param}/pt")

    @Produces("text/plain")

    public Response getFestivalByTypeIdPT(@PathParam("param") int typeID) {

        // Return the festival specified by the id
        if (genericDao.findByPropertyEqual("typeID", typeID) == null) {

            output = "No festivals could be found";

        } else {

            output = "Here's the festival: " + genericDao.findByPropertyEqual("typeID", typeID);
        }

        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/regions/{param}")
    @Produces("application/json")
    public Response getFestivalsByRegionId(@PathParam("param") int regionId) {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();


        List festivals = genericDao.findByPropertyEqual("regionID", regionId);

        String festivalString = "Error making json file";

        try {
            festivalString = objectMapper.writeValueAsString(festivals);

            logger.info(festivalString);
            logger.info(Response.status(200).entity(festivalString).build());
            return Response.status(200).entity(festivalString).build();

        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error making json file", jsonProcessingException);
        }

        return Response.status(500).entity(festivalString).build();
    }

    /**
     * Gets festival by region id.
     *
     * @param regionID the region id
     * @return the festival by region id
     */
    @GET

    @Path("/regions/{param}/pt")

    @Produces("text/plain")

    public Response getFestivalByRegionIdPT(@PathParam("param") int regionID) {

        // Return the festival specified by the id
        if (genericDao.findByPropertyEqual("regionID", regionID) == null) {

            output = "No festivals could be found";

        } else {

            output = "Here's the festival: " + genericDao.findByPropertyEqual("regionID", regionID);
        }

        return Response.status(200).entity(output).build();
    }



    /**
     * This method's purpose is to add a  festival
     */
    @POST

    @Path("/{name}/{regionId}/{typeId}/{date}")


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