package com.listapp;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.listapp.domain.Org;
import com.listapp.repositories.OrgRepo;

//@RunWith(SpringRunner.class)
public class OrgRepoTest {
    @SuppressWarnings("unused")
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private OrgRepo repo;

    @Test
    public void shouldHaveARepository() {
        assertNotNull(repo);
    }

    @Test
    public void shouldHaveNoObjectsAtStart() {
        assertEquals(0,repo.count());
    }
    @Test
    public void shouldBeAbleToPersistAnObject() {
        Org baar = new Org();
        baar.setName("Bar");
        repo.save(baar);
        System.out.println(String.valueOf(baar.getId()));
        assertEquals(1,repo.count());
    }        
    @Test
    public void shouldBeABleToQueryForObjects() {
        shouldBeAbleToPersistAnObject();
        assertNotNull(repo.findByName("Bar"));
        assertNull(repo.findByName("Baz"));
    }
}
