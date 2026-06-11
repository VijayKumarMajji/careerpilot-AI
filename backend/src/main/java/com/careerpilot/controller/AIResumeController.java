package com.careerpilot.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerpilot.dto.AIRewriteResponse;
import com.careerpilot.dto.ResumeOptimizationRequest;
import com.careerpilot.entity.Resume;
import com.careerpilot.service.AIResumeRewriteService;
import com.careerpilot.service.JobMatchService;
import com.careerpilot.service.ResumeService;

@RestController
@RequestMapping("/api/ai")
public class AIResumeController {

    private final ResumeService resumeService;
    private final AIResumeRewriteService aiService;
    private final JobMatchService jobMatchService;

    public AIResumeController(
            ResumeService resumeService,
            AIResumeRewriteService aiService,
            JobMatchService jobMatchService) {

        this.resumeService = resumeService;
        this.aiService = aiService;
        this.jobMatchService = jobMatchService;
    }

    @PostMapping("/rewrite")
    public AIRewriteResponse rewriteResume(
            @RequestBody ResumeOptimizationRequest request) {

        Resume resume =
                resumeService.getResume(
                        request.getResumeId());

        Map<String, Object> beforeMatch =
                jobMatchService.matchResumeWithJob(
                        resume.getResumeText(),
                        request.getJobDescription());

        int originalScore =
                (Integer) beforeMatch.get(
                        "matchPercentage");

        String rewrittenResume =
                aiService.rewriteResume(
                        resume.getResumeText(),
                        request.getJobDescription());

        // Gemini failed
        if (rewrittenResume.startsWith("Gemini Error")) {

            AIRewriteResponse response =
                    new AIRewriteResponse();

            response.setOriginalScore(
                    originalScore);

            response.setImprovedScore(
                    originalScore);

            response.setImprovement(0);

            response.setMatchedSkills(
                    (java.util.List<String>)
                            beforeMatch.get(
                                    "matchedSkills"));

            response.setMissingSkills(
                    (java.util.List<String>)
                            beforeMatch.get(
                                    "missingSkills"));

            response.setRewrittenResume(
                    rewrittenResume);

            return response;
        }

        Map<String, Object> afterMatch =
                jobMatchService.matchResumeWithJob(
                        rewrittenResume,
                        request.getJobDescription());

        int improvedScore =
                (Integer) afterMatch.get(
                        "matchPercentage");

        AIRewriteResponse response =
                new AIRewriteResponse();

        response.setOriginalScore(
                originalScore);

        response.setImprovedScore(
                improvedScore);

        response.setImprovement(
                improvedScore - originalScore);

        response.setMatchedSkills(
                (java.util.List<String>)
                        afterMatch.get(
                                "matchedSkills"));

        response.setMissingSkills(
                (java.util.List<String>)
                        afterMatch.get(
                                "missingSkills"));

        response.setRewrittenResume(
                rewrittenResume);

        return response;
    }
}