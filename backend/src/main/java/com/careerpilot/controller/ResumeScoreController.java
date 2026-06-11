package com.careerpilot.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerpilot.service.ResumeService;

@RestController
@RequestMapping("/api/resumes")
public class ResumeScoreController {

    private final ResumeService resumeService;

    public ResumeScoreController(
            ResumeService resumeService) {

        this.resumeService =
                resumeService;
    }

    @GetMapping("/{id}/ats-score")
    public Map<String, Integer> getScore(
            @PathVariable Long id) {

        return Map.of(
                "atsScore",
                resumeService.getAtsScore(id)
        );
    }
}