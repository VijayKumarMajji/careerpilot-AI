package com.careerpilot.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerpilot.entity.Resume;
import com.careerpilot.service.ResumeService;

@RestController
@RequestMapping("/api/resumes")
public class ResumeAnalysisController {

    private final ResumeService resumeService;

    public ResumeAnalysisController(
            ResumeService resumeService) {

        this.resumeService =
                resumeService;
    }

    @GetMapping("/{id}/analysis")
    public Map<String, Object> getAnalysis(
            @PathVariable Long id) {

        Resume resume =
                resumeService.getResume(id);

        return Map.of(
                "fileName",
                resume.getFileName(),

                "skills",
                Arrays.asList(
                        resume.getSkills()
                                .split(","))
        );
    }
}