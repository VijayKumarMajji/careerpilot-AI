package com.careerpilot.dto;

import java.util.List;

public class AIRewriteResponse {

    private int originalScore;
    private int improvedScore;
    private int improvement;

    private List<String> matchedSkills;
    private List<String> missingSkills;

    private String rewrittenResume;

    public int getOriginalScore() {
        return originalScore;
    }

    public void setOriginalScore(int originalScore) {
        this.originalScore = originalScore;
    }

    public int getImprovedScore() {
        return improvedScore;
    }

    public void setImprovedScore(int improvedScore) {
        this.improvedScore = improvedScore;
    }

    public int getImprovement() {
        return improvement;
    }

    public void setImprovement(int improvement) {
        this.improvement = improvement;
    }

    public List<String> getMatchedSkills() {
        return matchedSkills;
    }

    public void setMatchedSkills(List<String> matchedSkills) {
        this.matchedSkills = matchedSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(List<String> missingSkills) {
        this.missingSkills = missingSkills;
    }

    public String getRewrittenResume() {
        return rewrittenResume;
    }

    public void setRewrittenResume(String rewrittenResume) {
        this.rewrittenResume = rewrittenResume;
    }
}