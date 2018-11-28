package com.galvanize.endpointscheck;

import java.util.ArrayList;
import java.util.Arrays;

public class Sed {
    public static String getSedded(String find, String replacement, String body){
        ArrayList indivWords = new ArrayList(Arrays.asList(body.split(" ")));
        StringBuilder seddedMessage = new StringBuilder();
        for(int i = 0; i < indivWords.size(); i++){
            if(indivWords.get(i).equals(find)){
                seddedMessage.append(replacement);
            }
            else{
                seddedMessage.append(indivWords.get(i));
            }
            seddedMessage.append(" ");
        }
        return seddedMessage.toString().trim();
    }
}
