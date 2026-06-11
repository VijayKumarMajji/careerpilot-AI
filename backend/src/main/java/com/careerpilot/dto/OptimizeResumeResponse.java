package com.careerpilot.dto;

import java.util.List;

public class OptimizeResumeResponse {

    private int originalScore;
    private int optimizedScore;
    private List<String> missingSkills;
    private List<String> suggestions;

    public OptimizeResumeResponse(
            int originalScore,
            int optimizedScore,
            List<String> missingSkills,
            List<String> suggestions) {

        this.originalScore = originalScore;
        this.optimizedScore = optimizedScore;
        this.missingSkills = missingSkills;
        this.suggestions = suggestions;
    }

    public int getOriginalScore() {
        return originalScore;
    }

    public int getOptimizedScore() {
        return optimizedScore;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }
}