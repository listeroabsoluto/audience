package com.listeroabsoluto.audience.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AudienceController {

    @GetMapping
    public String getAudiences(@RequestParam(defaultValue = "default") String type)
    {
        return "1,2,3";
    }
}
