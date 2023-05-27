package com.listeroabsoluto.audience.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudienceControllerUnitTest {

    @Test
    void shouldGetAudiences() {
        AudienceController audienceController = new AudienceController();
        assertEquals("1,2,3", audienceController.getAudiences("default"));
    }
}