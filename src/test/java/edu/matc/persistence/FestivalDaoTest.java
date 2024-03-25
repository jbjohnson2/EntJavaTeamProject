package edu.matc.persistence;

import edu.matc.entity.Festival;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Festival dao test.
 */
class FestivalDaoTest {

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
        genericDao = new GenericDao(Festival.class);
        database.runSQL("cleanDB.sql");
    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        List<Festival> festivals = genericDao.getAll();
        assertEquals(4, festivals.size());
    }

    /**
     * Gets by id.
     */
    @Test
    void getById() {
        Festival retrievedFestival = (Festival)genericDao.getById(3);
        assertNotNull(retrievedFestival);
        assertEquals("Free Festival", retrievedFestival.getFestivalName());
    }

    /**
     * Delete.
     */
    @Test
    void delete() {
        Festival festivalToBeDeleted = (Festival)genericDao.getById(2);
        genericDao.delete(festivalToBeDeleted);
        assertNull(genericDao.getById(2));
    }

    /**
     * Insert.
     */
    @Test
    void insert() {
        Festival festivalToInsert = new Festival("Great Festival", 3, 4, LocalDate.parse("2024-11-12"));
        int insertedFestivalID = genericDao.insert(festivalToInsert);
        assertNotEquals(0, insertedFestivalID);
        Festival insertedFestival = (Festival)genericDao.getById(insertedFestivalID);
        assertEquals("Great Festival", insertedFestival.getFestivalName());

    }

    /**
     * Update.
     */
    @Test
    void update() {
        Festival festivalToUpdate = (Festival)genericDao.getById(1);
        festivalToUpdate.setTypeID(4);
        genericDao.update(festivalToUpdate);

        //retrieve the user and check that the name change worked
        Festival actualFestival = (Festival)genericDao.getById(1);
        assertEquals(4, actualFestival.getTypeID());
    }


    /**
     * Find by property equal.
     */
    @Test
    void findByPropertyEqual() {
        List<Festival> festivals = genericDao.findByPropertyEqual("regionID", 3);
        assertEquals(1, festivals.size());
        assertEquals(4, festivals.get(0).getFestivalID());
    }

    /**
     * Test find by property equal.
     */
    @Test
    void testFindByPropertyEqual() {
        //TODO write this test
    }
}