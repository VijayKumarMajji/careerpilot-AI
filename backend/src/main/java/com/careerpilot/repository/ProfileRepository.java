package com.careerpilot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerpilot.entity.Profile;

public interface ProfileRepository
        extends JpaRepository<Profile, Long> {
}