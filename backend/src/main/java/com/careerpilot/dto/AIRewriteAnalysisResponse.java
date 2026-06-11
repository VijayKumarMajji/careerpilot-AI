package com.careerpilot.dto;

public class AIRewriteAnalysisResponse {

    private int originalScore;
    private int improvedScore;
    private int improvement;
    private String rewrittenResume;

    public AIRewriteAnalysisResponse(
            int originalScore,
            int improvedScore,
            int improvement,
            String rewrittenResume) {

        this.originalScore = originalScore;
        this.improvedScore = improvedScore;
        this.improvement = improvement;
        this.rewrittenResume = rewrittenResume;
    }

    public int getOriginalScore() {
        return originalScore;
    }

    public int getImprovedScore() {
        return improvedScore;
    }

    public int getImprovement() {
        return improvement;
    }

    public String getRewrittenResume() {
        return rewrittenResume;
    }
}