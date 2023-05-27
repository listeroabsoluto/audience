package com.listeroabsoluto.audience.controller;

import com.listeroabsoluto.audience.service.AudienceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AudienceController {

    private final AudienceService audienceService;

    public AudienceController(AudienceService audienceService) {
        this.audienceService = audienceService;
    }

    @GetMapping(path = "/")
    public String getAudiences() {
        return audienceService.getAudiences().toString();
    }

    @GetMapping(path = "/user/{id}")
    public String getAudiencesByUser(@PathVariable(name = "id") String userId) {
        return audienceService.getAudiencesByUser(userId).toString();
    }

    @PostMapping(path = "/user/{id}")
    public String addUserToAudiences(@PathVariable(name = "id") String userId, @RequestBody RBody body) {
        audienceService.addUserToAudiences(userId, body.audiences);

        return audienceService.getAudiencesByUser(userId).toString();
    }

    static class RBody {
        public List<String> audiences;
    }
}
