package edu.matc.persistence;

import edu.matc.entity.Festival;
import edu.matc.entity.Region;
import edu.matc.entity.Type;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Type dao test.
 */
class TypeDaoTest {

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
        genericDao = new GenericDao(Type.class);
        database.runSQL("cleanDB.sql");
    }

    /**
     * Gets all.
     */
    @Test
    void getAll() {
        List<Type> type = genericDao.getAll();
        assertEquals(7, type.size());
    }

    /**
     * Gets by id.
     */
    @Test
    void getById() {
        Type retrievedType = (Type)genericDao.getById(3);
        assertNotNull(retrievedType);
        assertEquals(retrievedType, genericDao.getById(3));
    }


    /**
     * Insert.
     */
    @Test
    void insert() {
        Type typeToInsert = new Type("test");

        Type insertedType = (Type)genericDao.getById(2);
        int insertedTypeID = genericDao.insert(typeToInsert);
        Type retrievedType = (Type) genericDao.getById(insertedTypeID);
        assertEquals(typeToInsert, retrievedType);

    }

    /**
     * Update.
     */
    @Test
    void update() {
        Type typeToUpdate = (Type)genericDao.getById(1);
        typeToUpdate.setType("test");
        genericDao.update(typeToUpdate);
        Type retrievedType = (Type) genericDao.getById(1);
        assertEquals(typeToUpdate, retrievedType);
    }


    /**
     * Find by property equal.
     */
    @Test
    void findByPropertyEqual() {
        List<Type> types = genericDao.findByPropertyEqual("typeID", 3);
        assertEquals(1, types.size());
        assertEquals(3, types.get(0).getTypeID());
    }


}