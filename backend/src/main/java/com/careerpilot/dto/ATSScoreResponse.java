package com.careerpilot.dto;

import java.util.List;

public class ATSScoreResponse {

    private int atsScore;
    private List<String> strengths;
    private List<String> missingKeywords;
    private List<String> recommendations;

    public ATSScoreResponse(
            int atsScore,
            List<String> strengths,
            List<String> missingKeywords,
            List<String> recommendations) {

        this.atsScore = atsScore;
        this.strengths = strengths;
        this.missingKeywords = missingKeywords;
        this.recommendations = recommendations;
    }

    public int getAtsScore() {
        return atsScore;
    }

    public List<String> getStrengths() {
        return strengths;
    }

    public List<String> getMissingKeywords() {
        return missingKeywords;
    }

    public List<String> getRecommendations() {
        return recommendations;
    }
}