package com.listeroabsoluto.audience.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AudienceControllerAcceptanceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetAudiences() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")))
        ;
    }

    @Test
    void shouldGetUserAudiences() throws Exception {
        mockMvc.perform(get("/user/123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")))
        ;
    }

    @Test
    void shouldAddUserToAudiences() throws Exception {
        mockMvc.perform(
                        post("/user/789")
                                .content("[\"1\",\"2\"]")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")))
        ;
    }
}