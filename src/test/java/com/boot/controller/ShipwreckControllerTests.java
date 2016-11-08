package com.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.boot.App;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

/*@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@ContextConfiguration(classes = MockServletContext.class)
@WebAppConfiguration */
@RunWith(MockitoJUnitRunner.class)
//@SpringApplicationConfiguration(classes = App.class)
public class ShipwreckControllerTests {
	public Shipwreck wreck1;
	public Shipwreck wreck2;
	public Shipwreck wreck3;
	
	private ShipwreckRepository shipwreckRepository = Mockito.mock(ShipwreckRepository.class);
	private List<Shipwreck> wreckAll = new ArrayList<Shipwreck>();
	@InjectMocks
	public ShipwreckController shipwreckController = new ShipwreckController();
	
    @Before
    public void initMocks(){
        
        wreck1 = new Shipwreck(123456789L,"U870","A very deep Indian UBoat","FAIR",100,146.5,150.0,2016);
        wreckAll.add(wreck1);
        wreck2 = new Shipwreck(123456788L,"U871","A very deep china UBoat","BAD",100,150.0,146.5,2016);
        wreck3 = new Shipwreck(123456787L,"U872","A very deep England UBoat","GOOD",140,155.0,125.0,2013);
        wreckAll.add(wreck2);
    }
    
    @Test
    public void testListAllShipwrecks() {
    	List<Shipwreck> zeroWrecks = new ArrayList<Shipwreck>();
        Mockito.when(this.shipwreckRepository.findAll()).thenReturn(zeroWrecks);


        List<Shipwreck> listAllWrecks= shipwreckController.list();


        Mockito.verify(this.shipwreckRepository, Mockito.times(1)).findAll();

        Assert.assertTrue(listAllWrecks.size() == 0);


    }
    
    @Test
    public void getShipwrecksList(){
        Mockito.when(this.shipwreckRepository.findAll()).thenReturn(wreckAll);


        List<Shipwreck> listAllWrecks= shipwreckController.list();


        Mockito.verify(this.shipwreckRepository, Mockito.times(1)).findAll();

        Assert.assertTrue(listAllWrecks.size() == 2);
        System.out.println("ID from the Mock - "+listAllWrecks.get(0).getId());
        Assert.assertTrue(listAllWrecks.get(0).getId().equals(123456789L));
    }
    
    @Test
    public void getShipwrecksFindOne(){
        Mockito.when(this.shipwreckRepository.findOne(Mockito.anyLong())).thenReturn(wreck1);


        Shipwreck oneWreck= shipwreckController.get(123456L);


        Mockito.verify(this.shipwreckRepository, Mockito.times(1)).findOne(123456L);
        System.out.println("ID from the Mock - "+oneWreck.getId());
        Assert.assertTrue(oneWreck.getId().equals(123456789L));
    }
    
/*    @Test
    public void createShipwreck(){
        Mockito.when(this.shipwreckRepository.saveAndFlush(Mockito.any())).thenReturn(wreck3);


        Shipwreck newWreck= shipwreckController.create(wreck3);


        Mockito.verify(this.shipwreckRepository, Mockito.times(1)).saveAndFlush(newWreck);
        System.out.println("ID from the Mock - "+wreck3.getId());
        Assert.assertTrue(newWreck.getId().equals(123456787L));
    }
*/    
 /*   @Test
    public void updateShipwreck(){
        Mockito.when(this.shipwreckRepository.findOne(Mockito.anyLong())).thenReturn(wreck3);

    	Mockito.when(this.shipwreckRepository.saveAndFlush(Mockito.any())).thenReturn(wreck3);

        Shipwreck updateWreck= shipwreckController.update(123456L,wreck3);
        updateWreck.setId(123456786L);


        Mockito.verify(this.shipwreckRepository, Mockito.times(1)).saveAndFlush(updateWreck);
        Mockito.verify(this.shipwreckRepository, Mockito.times(1)).findOne(123456L);

        System.out.println("ID from the Mock - "+updateWreck.getId());
        Assert.assertTrue(updateWreck.getId().equals(123456786L));
    }*/
}

