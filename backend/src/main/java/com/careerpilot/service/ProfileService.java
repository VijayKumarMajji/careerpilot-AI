package com.careerpilot.service;

import org.springframework.stereotype.Service;

import com.careerpilot.entity.Profile;
import com.careerpilot.repository.ProfileRepository;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }
    public Profile getProfile(Long id) {
    return profileRepository.findById(id)
            .orElseThrow(() ->
                    new RuntimeException("Profile not found"));
}
    public void deleteProfile(Long id) {
    profileRepository.deleteById(id);
}
}