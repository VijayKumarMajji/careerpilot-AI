package com.careerpilot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.careerpilot.dto.ATSScoreResponse;
import com.careerpilot.dto.ResumeAnalysisResponse;
import com.careerpilot.entity.Resume;

@Service
public class ResumeAnalysisService {

    private final ResumeService resumeService;
    private final SkillExtractionService skillExtractionService;
    private final ATSScoreService atsScoreService;

    public ResumeAnalysisService(
            ResumeService resumeService,
            SkillExtractionService skillExtractionService,
            ATSScoreService atsScoreService) {

        this.resumeService = resumeService;
        this.skillExtractionService = skillExtractionService;
        this.atsScoreService = atsScoreService;
    }

    public ResumeAnalysisResponse analyzeResume(Long resumeId) {

        Resume resume =
                resumeService.getResume(resumeId);

        List<String> skills =
                skillExtractionService.extractSkills(
                        resume.getResumeText());

        ATSScoreResponse ats =
                atsScoreService.calculateScore(
                        resumeId);

        return new ResumeAnalysisResponse(
                resume.getId(),
                resume.getFileName(),
                skills,
                ats.getAtsScore(),
                ats.getMissingKeywords(),
                ats.getRecommendations()
        );
    }
}