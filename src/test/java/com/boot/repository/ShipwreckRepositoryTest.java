package com.boot.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.boot.model.Shipwreck;


@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EmbeddedDbJavaConfig.class})
// @ContextConfiguration("/embedded-db-application-context.xml")
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ShipwreckRepositoryTest {

    @PersistenceContext
    EntityManager entityManager;


    @Autowired
    ShipwreckRepository shipwreckRepository;


    @Test
    public void shouldGetShipwreckById() {
        Shipwreck wreck = shipwreckRepository.findOne(1L);

        assertThat(wreck.getId(), is(1L));
    }


    @Test
    public void shouldAutoGenerateTheId() {
    	Shipwreck wreck = shipwreckRepository.save(new Shipwreck());

        entityManager.flush();

        assertThat(wreck.getId(), is(5L));
    }


    @Test
    public void canDeleteWreck()  {
    	shipwreckRepository.delete(3L);

        entityManager.flush();

        assertThat(shipwreckRepository.findOne(3L), nullValue());
    }
    
    @Test
    public void canfindAllShipwrecks()  {
    	List<Shipwreck> wrecks = shipwreckRepository.findAll();

        entityManager.flush();

        Assert.assertEquals(wrecks.size(), 4);
    }
    
    @Test
    public void canUpdateShipwreck()  {
    	Shipwreck wreck = shipwreckRepository.findOne(1L);
    	wreck.setDescription("New Description");
    	wreck = shipwreckRepository.saveAndFlush(wreck);
        entityManager.flush();

        Assert.assertEquals(wreck.getDescription(), "New Description");
    }
}
