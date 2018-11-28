package com.galvanize.endpointscheck;

import java.util.ArrayList;
import java.util.Arrays;

public class Camelize {
    public static String getCamelCase(String original, boolean initialCap){
        String camelized = "";
        ArrayList indivWords = new ArrayList(Arrays.asList(original.split("_")));
        if(!initialCap){
            camelized += indivWords.get(0);
            indivWords.remove(0);
        }
            for (int i = 0; i < indivWords.size(); i++) {
                String word = String.valueOf(indivWords.get(i));
                StringBuilder wordSB = new StringBuilder(word);
                wordSB.replace(0, 1, String.valueOf(Character.toUpperCase(word.charAt(0))));
                camelized += wordSB;
            }
        return camelized;
    }
}
