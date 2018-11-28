package com.galvanize.endpointscheck;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controllers {


    @GetMapping("/camelize")
    public String parseCamelQuery(@RequestParam String original, @RequestParam(value = "initialCap", required=false)boolean initialCap){
        return Camelize.getCamelCase(original, initialCap);
    }
//
    @GetMapping("/redact")
    public String parseRedactQuery(@RequestParam String original, @RequestParam(value = "badWord") ArrayList<String>badWords){
        System.out.println("badwords: " + badWords);
        return Redact.getRedacted(original, badWords);
    }
//
    @PostMapping("/encode")
    public String parseEncodeQuery(@RequestParam String message, @RequestParam String key){
        return Encode.getEncoded(message, key);
    }
//
    @PostMapping("/sed/{find}/{replacement}")
    public String parseSedQuery(@PathVariable String find, @PathVariable String replacement, @RequestBody String body){
        return Sed.getSedded(find, replacement,body);
    }
}