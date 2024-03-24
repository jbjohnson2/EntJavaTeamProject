package edu.matc.persistence;

import edu.matc.entity.Festival;
import edu.matc.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericDaoTest {

    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        genericDao = new GenericDao(Festival.class);
        database.runSQL("clean.sql");
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void delete() {
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void findByPropertyEqual() {
    }

    @Test
    void testFindByPropertyEqual() {
    }
}