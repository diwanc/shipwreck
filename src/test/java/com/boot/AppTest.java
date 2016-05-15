package com.boot;

import org.junit.Test;
import com.boot.controller.HomeController;

import static org.junit.Assert.assertEquals;

/**
 * Created by upgundecha on 02/04/16.
 */
public class AppTest {

    @Test
    public void testApp() {
        HomeController hc = new HomeController();
        String result = hc.home();
        assertEquals(result, "Das Boot, reporting for duty!");
    }
}
