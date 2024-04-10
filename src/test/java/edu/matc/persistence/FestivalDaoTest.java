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
        assertEquals(retrievedFestival, genericDao.getById(3));
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
        Festival retrievedFestival = (Festival) genericDao.getById(insertedFestivalID);
        assertEquals(festivalToInsert, retrievedFestival);

    }


    /**
     * Update.
     */
    @Test
    void update() {

        Festival festivalToUpdate = (Festival)genericDao.getById(1);
        festivalToUpdate.setFestivalName("test");
        genericDao.update(festivalToUpdate);
        Festival retrievedFestival = (Festival) genericDao.getById(1);
        assertEquals(festivalToUpdate, retrievedFestival);
    }


    /**
     * Find by property equal.
     */
    @Test
    void findByPropertyEqual() {
        List<Festival> festivals = genericDao.findByPropertyEqual("festivalName", "Free Festival");
        assertEquals(1, festivals.size());
        assertEquals(3, festivals.get(0).getFestivalID());
    }

}