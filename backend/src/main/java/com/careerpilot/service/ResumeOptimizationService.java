package com.careerpilot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ResumeOptimizationService {

    private final SkillExtractionService skillExtractionService;

    public ResumeOptimizationService(
            SkillExtractionService skillExtractionService) {

        this.skillExtractionService =
                skillExtractionService;
    }

    public Map<String, Object> optimizeResume(
            String resumeText,
            String jobDescription) {

        List<String> resumeSkills =
                skillExtractionService.extractSkills(
                        resumeText);

        List<String> jdSkills =
                skillExtractionService.extractSkills(
                        jobDescription);

        List<String> missingSkills =
                new ArrayList<>();

        for (String skill : jdSkills) {

            if (!resumeSkills.contains(skill)) {

                missingSkills.add(skill);
            }
        }

        List<String> suggestions =
                new ArrayList<>();

        for (String skill : missingSkills) {

            suggestions.add(
                    "Consider adding " +
                    skill +
                    " if you have relevant experience."
            );
        }

        int matchedSkills =
                jdSkills.size() -
                missingSkills.size();

        int originalScore =
                jdSkills.size() == 0
                        ? 0
                        : (int) (((double) matchedSkills
                                / jdSkills.size()) * 100);

        /*
         * No fake optimization score.
         * Until AI Rewrite happens,
         * optimizedScore should be same as originalScore.
         */
        int optimizedScore =
                originalScore;

        StringBuilder optimizedResumeText =
                new StringBuilder();

        optimizedResumeText.append(
                resumeText
        );

        optimizedResumeText.append(
                "\n\n=== ATS OPTIMIZATION SUGGESTIONS ===\n"
        );

        for (String skill : missingSkills) {

            optimizedResumeText.append(
                    "\n• "
            );

            optimizedResumeText.append(
                    skill
            );
        }

        Map<String, Object> result =
                new HashMap<>();

        result.put(
                "originalScore",
                originalScore
        );

        result.put(
                "optimizedScore",
                optimizedScore
        );

        result.put(
                "missingSkills",
                missingSkills
        );

        result.put(
                "suggestions",
                suggestions
        );

        result.put(
                "optimizedResumeText",
                optimizedResumeText.toString()
        );

        return result;
    }
}