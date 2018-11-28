package com.galvanize.endpointscheck;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EncodeTest {
    @Test
    public void testEncode(){
        String key = "mcxrstunopqabyzdefghijklvw";
        String message = "a little of this and a little of that";
        String expected = "m aohhas zt hnog myr m aohhas zt hnmh";
        assertEquals(expected, Encode.getEncoded(message, key));
    }

    @Test
    public void testNoEncode(){
        String key = "abcdefghijklmnopqrstuvwxyz";
        String message = "a little of this and a little of that";
        assertEquals(message, Encode.getEncoded(message, key));
    }
}
