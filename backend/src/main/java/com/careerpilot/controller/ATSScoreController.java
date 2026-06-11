package com.careerpilot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerpilot.dto.ATSScoreResponse;
import com.careerpilot.service.ATSScoreService;

@RestController
@RequestMapping("/api/resumes")
public class ATSScoreController {

    private final ATSScoreService atsScoreService;

    public ATSScoreController(
            ATSScoreService atsScoreService) {

        this.atsScoreService = atsScoreService;
    }

    @GetMapping("/{resumeId}/ats-score")
    public ATSScoreResponse getScore(
            @PathVariable Long resumeId) {

        return atsScoreService.calculateScore(
                resumeId);
    }
}