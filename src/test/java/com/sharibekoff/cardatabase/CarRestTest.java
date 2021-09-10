package com.sharibekoff.cardatabase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CarRestTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAuthentication() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/login").
                content("{\"username\":\"admin\", \"password\": \"admin\"}")).
                andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.post("/login").
                content("{\"username\":\"admin\", \"password\": \"wrongpwd\"}")).
                andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
