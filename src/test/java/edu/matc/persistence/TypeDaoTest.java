package edu.matc.persistence;

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
        assertEquals("food", retrievedType.getType());
    }


    /**
     * Insert.
     */
    @Test
    void insert() {
        Type typeToInsert = new Type("Great Type");
        int insertedTypeID = genericDao.insert(typeToInsert);
        assertNotEquals(0, insertedTypeID);
        Type insertedType = (Type)genericDao.getById(insertedTypeID);
        assertEquals("Great Type", insertedType.getType());

    }

    /**
     * Update.
     */
    @Test
    void update() {
        Type typeToUpdate = (Type) genericDao.getById(1);
        typeToUpdate.setTypeID(4);
        genericDao.update(typeToUpdate);

        //retrieve the user and check that the name change worked
        Type actualType = (Type)genericDao.getById(4);
        assertEquals("music", actualType.getType());
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