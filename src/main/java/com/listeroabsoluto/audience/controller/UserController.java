package com.listeroabsoluto.audience.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.listeroabsoluto.audience.model.Audience;
import com.listeroabsoluto.audience.service.AudienceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final AudienceService audienceService;

    public UserController(AudienceService audienceService) {
        this.audienceService = audienceService;
    }

    @GetMapping(path = "/user/{id}")
    @JsonView(Audience.View.Public.class)
    public List<Audience> getAudiencesByUser(@PathVariable(name = "id") String userId) {
        return audienceService.getAudiencesByUser(userId);
    }

    @PostMapping(path = "/user/{id}")
    @JsonView(Audience.View.Public.class)
    public List<Audience> addUserToAudiences(@PathVariable(name = "id") String userId, @RequestBody List<String> audiences) {
        audienceService.addUserToAudiences(userId, audiences);

        return audienceService.getAudiencesByUser(userId);
    }

    @DeleteMapping(path = "/user/{id}")
    @JsonView(Audience.View.Public.class)
    public List<Audience> removeUserFromAudiences(@PathVariable(name = "id") String userId, @RequestBody List<String> audiences) {
        audienceService.removeUserFromAudiences(userId, audiences);

        return audienceService.getAudiencesByUser(userId);
    }

}
