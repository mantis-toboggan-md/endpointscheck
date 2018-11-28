package com.galvanize.endpointscheck;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@RunWith(SpringRunner.class)
@WebMvcTest(Controllers.class)
public class ControllersTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testAllCamelQuery() throws Exception {
        this.mvc.perform(get("/camelize?original=this_is_camelized&initialCap=true").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("ThisIsCamelized"));
    }

    @Test
    public void testNotFirstCamelQuery() throws Exception {
        this.mvc.perform(get("/camelize?original=this_is_camelized&initialCap=false").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("thisIsCamelized"));
        this.mvc.perform(get("/camelize?original=this_is_camelized").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("thisIsCamelized"));
    }

    @Test
    public void testOneWordRedact() throws Exception {
        this.mvc.perform(get("/redact?original=I love big butts and I can not lie&badWord=butts").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("I love big ***** and I can not lie"));
    }

    @Test
    public void testMultiWordRedact() throws Exception{
        this.mvc.perform(get("/redact?original=I love big butts and I can not lie&badWord=butts&badWord=I").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("* love big ***** and * can not lie"));
    }

    @Test
    public void testEncodeQuery() throws Exception {
        this.mvc.perform(post("/encode?&message=a little of this and a little of that&key=mcxrstunopqabyzdefghijklvw").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("m aohhas zt hnog myr m aohhas zt hnmh"));
    }


    @Test
    public void testSedQuery()throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/sed/{find}/{replacement}", "little", "lot")
                .contentType(MediaType.TEXT_PLAIN)
                .content("a little of this and a little of that");
        mvc.perform(builder)
                .andExpect(status().isOk())
                .andExpect(content().string("a lot of this and a lot of that"));
    }


}
