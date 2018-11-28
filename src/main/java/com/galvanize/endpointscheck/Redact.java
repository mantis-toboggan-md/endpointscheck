package com.galvanize.endpointscheck;

import java.util.ArrayList;
import java.util.Arrays;

public class Redact {
    public static String getRedacted(String original, ArrayList badWords){
        ArrayList indivWords = new ArrayList(Arrays.asList(original.split(" ")));
        StringBuilder censoredSentence = new StringBuilder();
            for(int i = 0; i < indivWords.size(); i++){
                String word = String.valueOf(indivWords.get(i));
                for(int j = 0; j < badWords.size(); j++) {
                    String badWord = String.valueOf(badWords.get(j));
                    String censor = "";
                    for (int k = 0; k < badWord.length(); k++) {
                        censor += "*";
                    }
                    if(badWord.equalsIgnoreCase(word)){
                        word = censor;
                    }
                }
                censoredSentence.append(word);
                censoredSentence.append(" ");
            }
        return censoredSentence.toString().trim();
    }
}
