package com.listeroabsoluto.audience.service;

import com.listeroabsoluto.audience.model.Audience;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AudienceService {

    private final List<Audience> audiences;

    public AudienceService() {
        Audience e1 = new Audience("1");
        e1.addUser("123");
        Audience e2 = new Audience("2");
        e2.addUser("123");
        Audience e3 = new Audience("3");
        e3.addUser("123");
        audiences = List.of(e1, e2, e3);
    }

    public List<Audience> getAudiences() {
        return audiences;

    }

    public List<Audience> getAudiencesByUser(String userId) {
        List<Audience> result = new ArrayList<>();
        for (Audience audience : this.audiences) {
            if (audience.containsUser(userId)) {
                result.add(audience);
            }
        }
        return result;
    }

    public void addUserToAudiences(String userId, List<Audience> audiences) {
        for (Audience audience : audiences) {
            audience.addUser(userId);
        }
    }
}
