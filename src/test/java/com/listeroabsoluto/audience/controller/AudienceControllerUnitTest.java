package com.listeroabsoluto.audience.controller;

import com.listeroabsoluto.audience.service.AudienceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class AudienceControllerUnitTest {

    @Test
    void shouldGetDefaultAudiences() {
        AudienceService audienceService = Mockito.mock(AudienceService.class);
        when(audienceService.getAudiencesByType("default")).thenReturn(List.of("1", "2", "3"));
        AudienceController audienceController = new AudienceController(audienceService);
        assertEquals("[1, 2, 3]", audienceController.getAudiences("default"));
    }

    @Test
    void shouldGetEmptyAudiences() {
        AudienceService audienceService = Mockito.mock(AudienceService.class);
        when(audienceService.getAudiencesByType("empty")).thenReturn(List.of());
        AudienceController audienceController = new AudienceController(audienceService);
        assertEquals("[]", audienceController.getAudiences("empty"));
    }
}