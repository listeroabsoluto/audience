package com.listeroabsoluto.audience.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AudienceService {
    public List getAudiencesByType(String type) {
        if (type.equals("empty")) {
            return List.of();
        }

        return List.of("1", "2", "3");
    }
}
