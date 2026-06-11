package com.careerpilot.dto;

import java.util.List;

public class ResumeAnalysisResponse {

    private Long resumeId;
    private String fileName;
    private List<String> skills;
    private int atsScore;
    private List<String> missingKeywords;
    private List<String> recommendations;

    public ResumeAnalysisResponse(
            Long resumeId,
            String fileName,
            List<String> skills,
            int atsScore,
            List<String> missingKeywords,
            List<String> recommendations) {

        this.resumeId = resumeId;
        this.fileName = fileName;
        this.skills = skills;
        this.atsScore = atsScore;
        this.missingKeywords = missingKeywords;
        this.recommendations = recommendations;
    }

    public Long getResumeId() {
        return resumeId;
    }

    public String getFileName() {
        return fileName;
    }

    public List<String> getSkills() {
        return skills;
    }

    public int getAtsScore() {
        return atsScore;
    }

    public List<String> getMissingKeywords() {
        return missingKeywords;
    }

    public List<String> getRecommendations() {
        return recommendations;
    }
}