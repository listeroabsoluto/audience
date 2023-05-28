package com.listeroabsoluto.audience.service;

import com.listeroabsoluto.audience.model.Audience;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AudienceServiceTest {

    @Test
    void getAudiences() {
        Audience e1 = new Audience("1");
        Audience e2 = new Audience("2");
        Audience e3 = new Audience("3");

        AudienceRepository repository = Mockito.mock(AudienceRepository.class);
        when(repository.findAll()).thenReturn(List.of(e1, e2, e3));
        AudienceService service = new AudienceService(repository);

        assertEquals(3, service.getAudiences().size());
    }

    @Test
    void getAudiencesByUser() {
        Audience e1 = new Audience("1");
        e1.addUser("123");
        Audience e2 = new Audience("2");
        e2.addUser("123");
        Audience e3 = new Audience("3");

        AudienceRepository repository = Mockito.mock(AudienceRepository.class);
        when(repository.findAll()).thenReturn(List.of(e1, e2, e3));
        AudienceService service = new AudienceService(repository);

        assertEquals(2, service.getAudiencesByUser("123").size());
    }

    @Test
    void addUserToAudiences() {
        Audience e1 = new Audience("1");
        Audience e2 = new Audience("2");
        Audience e3 = new Audience("3");

        AudienceRepository repository = Mockito.mock(AudienceRepository.class);
        when(repository.findAll()).thenReturn(List.of(e1, e2, e3));
        AudienceService service = new AudienceService(repository);

        service.addUserToAudiences("456", List.of("1", "2", "3"));
        assertEquals(3, service.getAudiencesByUser("456").size());
    }
}