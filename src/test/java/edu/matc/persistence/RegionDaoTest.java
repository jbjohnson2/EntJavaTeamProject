package edu.matc.persistence;

import edu.matc.entity.Festival;
import edu.matc.entity.Region;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Region dao test.
 */
class RegionDaoTest {

    /**
     * The Generic dao.
     */
    GenericDao genericDao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        genericDao = new GenericDao(Region.class);
        database.runSQL("cleanDB.sql");
    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        List<Region> region = genericDao.getAll();
        assertEquals(7, region.size());
    }

    /**
     * Gets by id.
     */
    @Test
    void getById() {
        Region retrievedRegion = (Region) genericDao.getById(3);
        assertNotNull(retrievedRegion);
        assertEquals(retrievedRegion, genericDao.getById(3));
    }

    /**
     * Insert.
     */
    @Test
    void insert() {
        Region regionToInsert = new Region("test");

        Region insertedRegion = (Region)genericDao.getById(2);
        int insertedRegionID = genericDao.insert(regionToInsert);
        Region retrievedRegion = (Region) genericDao.getById(insertedRegionID);
        assertEquals(regionToInsert, retrievedRegion);
    }

    /**
     * Update.
     */
    @Test
    void update() {

        Region regionToUpdate = (Region)genericDao.getById(1);
        regionToUpdate.setRegionName("test");
        genericDao.update(regionToUpdate);
        Region retrievedRegion = (Region) genericDao.getById(1);
        assertEquals(regionToUpdate, retrievedRegion);
    }


    /**
     * Find by property equal.
     */
    @Test
    void findByPropertyEqual() {
        List<Region> regions = genericDao.findByPropertyEqual("regionID", 3);
        assertEquals(1, regions.size());
        assertEquals(3, regions.get(0).getRegionID());
    }


}