package com.listeroabsoluto.audience.controller;

import com.listeroabsoluto.audience.model.Audience;
import com.listeroabsoluto.audience.service.AudienceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AudienceControllerUnitTest {

    @Test
    void shouldGetDefaultAudiences() {
        AudienceService audienceService = Mockito.mock(AudienceService.class);
        List<Audience> audienceList = List.of(new Audience("1"), new Audience("2"), new Audience("3"));
        when(audienceService.getAudiences()).thenReturn(audienceList);
        AudienceController audienceController = new AudienceController(audienceService);
        assertEquals(audienceList, audienceController.getAudiences());
    }

}