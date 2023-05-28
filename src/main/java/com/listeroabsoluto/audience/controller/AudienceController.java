package com.listeroabsoluto.audience.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.listeroabsoluto.audience.model.Audience;
import com.listeroabsoluto.audience.service.AudienceService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AudienceController {

    private final AudienceService audienceService;

    public AudienceController(AudienceService audienceService) {
        this.audienceService = audienceService;
    }

    @GetMapping(path = "/")
    @JsonView(Audience.View.ExtendedPublic.class)
    public List<Audience> getAudiences() {
        return audienceService.getAudiences();
    }

    @GetMapping(path = "/{name}")
    @JsonView(Audience.View.Internal.class)
    public Audience getAudienceByName(@PathVariable String name) {
        return audienceService.getOneByName(name);
    }

    @PostMapping(path = "/{name}")
    @JsonView(Audience.View.Public.class)
    public Audience createAudience(@PathVariable String name) {
        audienceService.saveOrUpdate(new Audience(name));

        return audienceService.getOneByName(name);
    }

    @DeleteMapping(path = "/{name}")
    @JsonView(Audience.View.Public.class)
    public void deleteAudience(@PathVariable String name) {
        audienceService.delete(name);
    }
}
