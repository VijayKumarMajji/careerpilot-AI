package com.careerpilot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerpilot.entity.Resume;

public interface ResumeRepository
        extends JpaRepository<Resume, Long> {
}