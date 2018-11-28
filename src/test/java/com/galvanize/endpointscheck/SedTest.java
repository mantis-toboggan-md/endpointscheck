package com.galvanize.endpointscheck;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SedTest {
    @Test
    public void testSed(){
        String find = "little";
        String replacement = "lot";
        String body = "a little of this and a little of that";
        assertEquals("a lot of this and a lot of that", Sed.getSedded(find, replacement, body));
    }

    @Test
    public void testSedNoReplace(){
        String find = "lot";
        String replacement = "little";
        String body = "a little of this and a little of that";
        assertEquals("a little of this and a little of that", Sed.getSedded(find, replacement, body));
    }
}
