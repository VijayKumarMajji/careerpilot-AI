package com.careerpilot.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerpilot.dto.ProfileRequest;
import com.careerpilot.entity.Profile;
import com.careerpilot.service.ProfileService;


@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }
    @GetMapping("/{id}")
    public Profile getProfile(@PathVariable Long id) {
    return profileService.getProfile(id);
}
@DeleteMapping("/{id}")
public String deleteProfile(
        @PathVariable Long id) {

    profileService.deleteProfile(id);

    return "Profile deleted successfully";
}

    @PostMapping
    public Profile createProfile(
            @RequestBody ProfileRequest request) {

        Profile profile = new Profile();

        profile.setFullName(request.getFullName());
        profile.setPhone(request.getPhone());
        profile.setLocation(request.getLocation());
        profile.setLinkedinUrl(request.getLinkedinUrl());
        profile.setGithubUrl(request.getGithubUrl());
        profile.setSummary(request.getSummary());
        profile.setTargetRole(request.getTargetRole());
        profile.setYearsOfExperience(
                request.getYearsOfExperience());

        return profileService.saveProfile(profile);
    }
}