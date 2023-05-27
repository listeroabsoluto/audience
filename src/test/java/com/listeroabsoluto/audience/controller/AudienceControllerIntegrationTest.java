package com.listeroabsoluto.audience.controller;

import com.listeroabsoluto.audience.model.Audience;
import com.listeroabsoluto.audience.service.AudienceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class AudienceControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AudienceService audienceService;

    @Test
    void shouldGetAudiences() throws Exception {
        when(audienceService.getAudiences()).thenReturn(
                List.of(
                    new Audience("1"),
                    new Audience("2"),
                    new Audience("3")
                )
        );

        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[1, 2, 3]")))
        ;

        verify(audienceService).getAudiences();
    }

}