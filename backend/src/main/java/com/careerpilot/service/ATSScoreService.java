package com.careerpilot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ATSScoreService {

    private final SkillExtractionService skillExtractionService;

    public ATSScoreService(
            SkillExtractionService skillExtractionService) {

        this.skillExtractionService =
                skillExtractionService;
    }

    public Map<String, Object> calculateScore(
            String resumeText) {

        List<String> skills =
                skillExtractionService
                        .extractSkills(resumeText);

        int score = 40;

        score += Math.min(skills.size() * 5, 50);

        List<String> suggestions =
                new ArrayList<>();

        if (!skills.contains("java")) {
            suggestions.add("Add Java");
        }

        if (!skills.contains("spring boot")) {
            suggestions.add("Add Spring Boot");
        }

        if (!skills.contains("docker")) {
            suggestions.add("Add Docker");
        }

        if (!skills.contains("aws")) {
            suggestions.add("Add AWS");
        }

        if (!skills.contains("postgresql")) {
            suggestions.add("Add PostgreSQL");
        }

        return Map.of(
                "atsScore", score,
                "detectedSkills", skills,
                "suggestions", suggestions
        );
    }
}