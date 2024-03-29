package edu.matc.persistence;

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
        assertEquals(4, region.size());
    }

    /**
     * Gets by id.
     */
    @Test
    void getById() {
        Region retrievedRegion = (Region)genericDao.getById(3);
        assertNotNull(retrievedRegion);
        assertEquals("Free Region", retrievedRegion.getRegionName());
    }

    /**
     * Delete.
     */
    @Test
    void delete() {
        Region regionToBeDeleted = (Region)genericDao.getById(2);
        genericDao.delete(regionToBeDeleted);
        assertNull(genericDao.getById(2));
    }

    /**
     * Insert.
     */
    @Test
    void insert() {
        Region regionToInsert = new Region("Great Region", 1);
        int insertedRegionID = genericDao.insert(regionToInsert);
        assertNotEquals(0, insertedRegionID);
        Region insertedRegion = (Region)genericDao.getById(insertedRegionID);
        assertEquals("Great Region", insertedRegion.getRegionName());

    }

    /**
     * Update.
     */
    @Test
    void update() {
        Region regionToUpdate = (Region)genericDao.getById(1);
        regionToUpdate.setTypeID(4);
        genericDao.update(regionToUpdate);

        //retrieve the user and check that the name change worked
        Region actualRegion = (Region)genericDao.getById(1);
        assertEquals(4, actualRegion.getTypeID());
    }


    /**
     * Find by property equal.
     */
    @Test
    void findByPropertyEqual() {
        List<Region> regions = genericDao.findByPropertyEqual("regionID", 3);
        assertEquals(1, regions.size());
        assertEquals(4, regions.get(0).getRegionID());
    }

    /**
     * Test find by property equal.
     */
    @Test
    void testFindByPropertyEqual() {
        //TODO write this test
    }
}