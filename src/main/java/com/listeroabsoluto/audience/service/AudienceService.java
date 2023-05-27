package com.listeroabsoluto.audience.service;

import com.listeroabsoluto.audience.model.Audience;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AudienceService {

    private List<Audience> audiences;

    public AudienceService() {
        audiences = List.of();
    }

    public void setAudiences(List<Audience> audiences) {
        this.audiences = audiences;
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

    public void addUserToAudiences(String userId, List<String> audiences) {
        for (Audience audience : this.audiences) {
            if (audiences.contains(audience.getName())) {
                audience.addUser(userId);
            }
        }
    }
}
