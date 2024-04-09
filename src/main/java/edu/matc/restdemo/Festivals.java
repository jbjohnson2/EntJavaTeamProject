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

import java.util.List;

/**
 * This class' purpose is to return festivals
 *
 * @author jbjohnson2
 * @author JBostroem
 * @author OscarJohnson6
 *
 */
@Path("/festivals")
public class Festivals {
    // The Java method will process HTTP GET requests
    private GenericDao genericDao;
    private final Logger logger = LogManager.getLogger(this.getClass());
    private String output;
    private ObjectMapper objectMapper;
    String festivalsString = "Error making json file";

    /**
     * Instantiates a new Festival.
     */
    public Festivals() {
        genericDao = new GenericDao<>(Festival.class);
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    /**
     * Gets festivals.
     *
     * @return the festivals
     */
    @GET

    @Produces("application/json")
    public Response getFestivals() {
        List<Festival> festivals = genericDao.getAll();

        try {
            festivalsString = objectMapper.writeValueAsString(festivals);

            return Response.status(200).entity(festivalsString).build();
        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error processing json file", jsonProcessingException);
        }

        return Response.status(500).entity(festivalsString).build();
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
        output = "Here's all the festivals: " + genericDao.getAll();
        return Response.status(200).entity(output).build();
    }

    /**
     * get festival by id
     *
     * @param id festival to be retrieved id
     * @return festivals by id
     */
    @GET
    @Path("/{param}")
    @Produces("application/json")
    public Response getFestivalById(@PathParam("param") int id) {
        Festival festival = (Festival)genericDao.getById(id);

        try {
            festivalsString = objectMapper.writeValueAsString(festival);

            return Response.status(200).entity(festivalsString).build();
        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error making json file", jsonProcessingException);
        }

        return Response.status(500).entity(festivalsString).build();
    }

    /**
     * This method's purpose is to get the festival by id
     *
     * @param id the id
     * @return the festival by id pt
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

    /**
     * Gets festivals by type id.
     *
     * @param typeId the type id
     * @return the festivals by type id
     */
    @GET
    @Path("/types/{param}")
    @Produces("application/json")
    public Response getFestivalsByTypeId(@PathParam("param") int typeId) {
        List festivals = genericDao.findByPropertyEqual("typeID", typeId);

        try {
            festivalsString = objectMapper.writeValueAsString(festivals);

            return Response.status(200).entity(festivalsString).build();
        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error making json file", jsonProcessingException);
        }

        return Response.status(500).entity(festivalsString).build();
    }

    /**
     * Return the festivals specified by the id
     *
     * @param typeID the type id for the festivals
     * @return the festivals by that have matching type id
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

    /**
     * Gets festivals by region id.
     *
     * @param regionId the region id
     * @return the festivals by region id
     */
    @GET
    @Path("/regions/{param}")
    @Produces("application/json")
    public Response getFestivalsByRegionId(@PathParam("param") int regionId) {
        List festivals = genericDao.findByPropertyEqual("regionID", regionId);
        String festivalString = "Error making json file";

        try {
            festivalString = objectMapper.writeValueAsString(festivals);

            return Response.status(200).entity(festivalString).build();
        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error processing json file", jsonProcessingException);
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
     *
     * @param name     the name
     * @param regionId the region id
     * @param typeId   the type id
     * @param date     the date
     * @return the response
     */
    @POST
    @Path("/{name}/{regionId}/{typeId}/{date}")
    @Produces ("application/json")
    public Response postFestivals(@PathParam("name") String name,
                                  @PathParam("regionId") int regionId,
                                  @PathParam("typeId") int typeId,
                                  @PathParam("date") String date) {

        GenericDao regionDao = new GenericDao(Region.class);
        GenericDao typeDao = new GenericDao(Type.class);

        if (typeDao.getById(typeId) == null) {
            output = "Please enter a valid type id";
        } else if (regionDao.getById(regionId) == null) {
            output = "Please enter a valid region ID";
        } else {
            Festival festival = new Festival(name, regionId, typeId, date);
            int id = genericDao.insert(festival);
            Festival insertedFestival = (Festival)genericDao.getById(id);

            try {
                output = objectMapper.writeValueAsString(insertedFestival);

                return Response.status(200).entity(output).build();
            } catch (JsonProcessingException jsonProcessingException) {
                logger.error("Error making json file", jsonProcessingException);
                output = "Error processing json response";

                return Response.status(500).entity(output).build();
            }
        }
        return Response.status(400).entity(output).build();
    }
}