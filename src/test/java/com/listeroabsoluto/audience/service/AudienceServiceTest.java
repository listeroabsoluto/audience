package com.listeroabsoluto.audience.service;

import com.listeroabsoluto.audience.model.Audience;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AudienceServiceTest {

    @Test
    void getAudiences() {
        AudienceService service = new AudienceService();

        Audience e1 = new Audience("1");
        Audience e2 = new Audience("2");
        Audience e3 = new Audience("3");
        service.setAudiences(List.of(e1, e2, e3));

        assertEquals(3, service.getAudiences().size());
    }

    @Test
    void getAudiencesByUser() {
        AudienceService service = new AudienceService();

        Audience e1 = new Audience("1");
        e1.addUser("123");
        Audience e2 = new Audience("2");
        e2.addUser("123");
        Audience e3 = new Audience("3");
        service.setAudiences(List.of(e1, e2, e3));

        assertEquals(2, service.getAudiencesByUser("123").size());
    }

    @Test
    void addUserToAudiences() {
        AudienceService service = new AudienceService();

        Audience e1 = new Audience("1");
        Audience e2 = new Audience("2");
        Audience e3 = new Audience("3");
        service.setAudiences(List.of(e1, e2, e3));

        service.addUserToAudiences("456", List.of("1", "2", "3"));
        assertEquals(3, service.getAudiencesByUser("456").size());
    }
}