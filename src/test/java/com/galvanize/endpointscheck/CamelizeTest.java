package com.galvanize.endpointscheck;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CamelizeTest {

    @Test
    public void testAllCamel(){
        String expected = "ThisIsCamelized";
        assertEquals(expected, Camelize.getCamelCase("this_is_camelized", true));
    }

    @Test
    public void testNoFirstCamel(){
        String expected = "thisIsCamelized";
        assertEquals(expected, Camelize.getCamelCase("this_is_camelized", false));
    }
}
