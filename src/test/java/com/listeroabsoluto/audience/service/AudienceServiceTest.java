package com.listeroabsoluto.audience.service;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AudienceServiceTest {

    @Test
    void getAudiences() {
        AudienceService service = new AudienceService();
        assertEquals(3, service.getAudiences().size());
    }

    @Test
    void getAudiencesByUser() {
        AudienceService service = new AudienceService();
        assertEquals(3, service.getAudiencesByUser("123").size());
    }

    @Test
    void addUserToAudiences() {
        AudienceService service = new AudienceService();
        service.addUserToAudiences("456", service.getAudiences());
        assertEquals(3, service.getAudiencesByUser("456").size());
    }
}