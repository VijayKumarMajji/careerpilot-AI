package com.careerpilot.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerpilot.dto.ResumeOptimizationRequest;
import com.careerpilot.entity.Resume;
import com.careerpilot.service.ResumeOptimizationService;
import com.careerpilot.service.ResumeService;

@RestController
@RequestMapping("/api/resumes")
public class ResumeOptimizationController {

    private final ResumeService resumeService;
    private final ResumeOptimizationService optimizationService;

    public ResumeOptimizationController(
            ResumeService resumeService,
            ResumeOptimizationService optimizationService) {

        this.resumeService = resumeService;
        this.optimizationService = optimizationService;
    }

    @PostMapping("/optimize")
    public Map<String, Object> optimizeResume(
            @RequestBody ResumeOptimizationRequest request) {

        Resume resume =
                resumeService.getResume(
                        request.getResumeId());

        return optimizationService.optimizeResume(
                resume.getResumeText(),
                request.getJobDescription());
    }
}