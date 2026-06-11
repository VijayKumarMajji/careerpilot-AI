package com.careerpilot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.careerpilot.dto.ATSScoreResponse;
import com.careerpilot.entity.Resume;

@Service
public class ATSScoreService {

    private final ResumeService resumeService;
    private final SkillExtractionService skillExtractionService;

    public ATSScoreService(
            ResumeService resumeService,
            SkillExtractionService skillExtractionService) {

        this.resumeService = resumeService;
        this.skillExtractionService = skillExtractionService;
    }

    public ATSScoreResponse calculateScore(Long resumeId) {

        Resume resume =
                resumeService.getResume(resumeId);

        List<String> skills =
                skillExtractionService.extractSkills(
                        resume.getResumeText());

        int score = 50;

        score += Math.min(skills.size() * 3, 40);

        List<String> missingKeywords =
                new ArrayList<>();

        List<String> recommendations =
                new ArrayList<>();

        List<String> importantSkills = List.of(
                "AWS",
                "Docker",
                "Microservices",
                "Spring Boot",
                "REST API",
                "Kubernetes"
        );

        for (String skill : importantSkills) {

            if (!skills.contains(skill)) {

                missingKeywords.add(skill);

                recommendations.add(
                        "Add experience with " + skill);
            }
        }

        score = Math.min(score, 100);

        return new ATSScoreResponse(
                score,
                skills,
                missingKeywords,
                recommendations
        );
    }
}