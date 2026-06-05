package com.careerpilot.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ResumeScoreService {

    public int calculateScore(
            String resumeText,
            List<String> skills) {

        int score = 0;

        score += Math.min(skills.size() * 5, 40);

        if (resumeText.toLowerCase().contains("education")) {
            score += 20;
        }

        if (resumeText.toLowerCase().contains("experience")) {
            score += 20;
        }

        if (resumeText.toLowerCase().contains("project")) {
            score += 10;
        }

        if (resumeText.toLowerCase().contains("skill")) {
            score += 10;
        }

        return Math.min(score, 100);
    }
}