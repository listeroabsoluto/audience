package com.listeroabsoluto.audience.controller;

import com.listeroabsoluto.audience.service.AudienceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AudienceController {

    private final AudienceService audienceService;

    public AudienceController(AudienceService audienceService) {
        this.audienceService = audienceService;
    }

    @GetMapping(path = "/")
    public String getAudiences(@RequestParam(defaultValue = "default") String type)
    {
        return audienceService.getAudiencesByType(type).toString();
    }
}
