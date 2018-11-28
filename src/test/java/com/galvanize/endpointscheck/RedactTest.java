package com.galvanize.endpointscheck;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RedactTest {
    @Test
    public void testOneRedaction(){
        String expected = "I love big ***** and I can not lie";
        ArrayList badWords = new ArrayList();
        badWords.add("butts");
        assertEquals(expected, Redact.getRedacted("I love big butts and I can not lie", badWords));
    }

    @Test
    public void testNoRedaction(){
        String expected = "I love big butts and I can not lie";
        ArrayList badWords = new ArrayList();
        badWords.add("bottoms");
        assertEquals(expected, Redact.getRedacted("I love big butts and I can not lie", badWords));
    }

    @Test
    public void testMultipleSameRedact() {
        String expected = "* love big butts and * can not lie";
        ArrayList badWords = new ArrayList();
        badWords.add("I");
        assertEquals(expected, Redact.getRedacted("I love big butts and I can not lie", badWords));
    }

    @Test
    public void testMultipleDiffRedact(){
        String expected = "* love big ***** and * can not lie";
        ArrayList badWords = new ArrayList();
        badWords.add("I");
        badWords.add("butts");
        assertEquals(expected, Redact.getRedacted("I love big butts and I can not lie", badWords));
    }
}
