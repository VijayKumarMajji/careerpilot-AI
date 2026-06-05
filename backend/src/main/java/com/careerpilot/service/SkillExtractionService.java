package com.careerpilot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SkillExtractionService {

    private static final List<String> SKILLS = List.of(
            "Java",
            "Spring Boot",
            "Spring",
            "Hibernate",
            "PostgreSQL",
            "MySQL",
            "SQL",
            "AWS",
            "Docker",
            "Kubernetes",
            "React",
            "Angular",
            "JavaScript",
            "TypeScript",
            "Git",
            "GitHub",
            "REST API",
            "Microservices",
            "Maven",
            "JUnit"
    );

    public List<String> extractSkills(String resumeText) {

        List<String> detectedSkills = new ArrayList<>();

        for (String skill : SKILLS) {

            if (resumeText.toLowerCase()
                    .contains(skill.toLowerCase())) {

                detectedSkills.add(skill);
            }
        }

        return detectedSkills;
    }
}