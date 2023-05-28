package com.listeroabsoluto.audience.service;

import com.listeroabsoluto.audience.model.Audience;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AudienceService {

    private final AudienceRepository audienceRepository;

    public AudienceService(AudienceRepository audienceRepository) {
        this.audienceRepository = audienceRepository;
    }

    public List<Audience> getAudiences() {
        List<Audience> audienceList = new ArrayList<>();
        audienceRepository.findAll().forEach(audienceList::add);

        return audienceList;
    }

    public void saveOrUpdate(Audience audience) {
        audienceRepository.save(audience);
    }

    public void delete(String name) {
        audienceRepository.findById(name).ifPresent(audienceRepository::delete);
    }

    public Audience getOneByName(String name) {
        return audienceRepository.findById(name).orElseThrow(RuntimeException::new);
    }

    public List<Audience> getAudiencesByUser(String userId) {
        List<Audience> result = new ArrayList<>();
        for (Audience audience : this.getAudiences()) {
            if (audience.containsUser(userId)) {
                result.add(audience);
            }
        }
        return result;
    }

    public void addUserToAudiences(String userId, List<String> audiences) {
        for (Audience audience : this.getAudiences()) {
            if (audiences.contains(audience.getName())) {
                audience.addUser(userId);
                audienceRepository.save(audience);
            }
        }
    }

    public void removeUserFromAudiences(String userId, List<String> audiences) {
        for (Audience audience : this.getAudiences()) {
            if (audiences.contains(audience.getName())) {
                audience.removeUser(userId);
                audienceRepository.save(audience);
            }
        }
    }
}
