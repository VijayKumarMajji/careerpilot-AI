package com.careerpilot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class JobMatchService {

    private final SkillExtractionService skillExtractionService;

    public JobMatchService(
            SkillExtractionService skillExtractionService) {

        this.skillExtractionService =
                skillExtractionService;
    }

    public Map<String, Object> matchResumeWithJob(
            String resumeText,
            String jobDescription) {

        List<String> resumeSkills =
                skillExtractionService
                        .extractSkills(resumeText);

        List<String> jdSkills =
                skillExtractionService
                        .extractSkills(jobDescription);

        List<String> matchedSkills =
                new ArrayList<>();

        List<String> missingSkills =
                new ArrayList<>();

        for (String skill : jdSkills) {

            if (resumeSkills.contains(skill)) {
                matchedSkills.add(skill);
            } else {
                missingSkills.add(skill);
            }
        }

        int matchPercentage = 0;

        if (!jdSkills.isEmpty()) {
            matchPercentage =
                    (matchedSkills.size() * 100)
                            / jdSkills.size();
        }

        return Map.of(
                "matchPercentage",
                matchPercentage,
                "matchedSkills",
                matchedSkills,
                "missingSkills",
                missingSkills
        );
    }
}