package com.galvanize.endpointscheck;

import java.util.HashMap;

public class Encode {
    public static String getEncoded(String message, String key){
        String alphabet = "abcdefghijklmnopqrstuvqxyz";
        HashMap cipher = new HashMap<Character, Character>();
        StringBuilder encodedMessage = new StringBuilder();
        for(int i = 0; i < alphabet.length(); i++){
            cipher.put(alphabet.charAt(i), key.charAt(i));
        }
        for(int i = 0; i < message.length(); i++){
            if(message.charAt(i) != ' '){
                encodedMessage.append(cipher.get(message.charAt(i)));
            }
            else{
                encodedMessage.append(message.charAt(i));
            }
        }
        return encodedMessage.toString();
    }
}
