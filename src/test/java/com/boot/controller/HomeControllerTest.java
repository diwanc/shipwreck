package com.boot.controller;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


public class HomeControllerTest {
    
	public HomeController homeController;
	
	@Before
    public void setUp() throws Exception {
		homeController = new HomeController();
    }
	
	@Test
	public void getHome(){
		Assert.assertTrue(homeController.home().equalsIgnoreCase("Das Boot, reporting for duty!"));
	}
}
