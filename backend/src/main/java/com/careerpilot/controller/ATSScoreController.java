package com.careerpilot.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerpilot.dto.ATSScoreRequest;
import com.careerpilot.entity.Resume;
import com.careerpilot.service.ATSScoreService;
import com.careerpilot.service.ResumeService;

@RestController
@RequestMapping("/api/ats")
public class ATSScoreController {

    private final ResumeService resumeService;
    private final ATSScoreService atsScoreService;

    public ATSScoreController(
            ResumeService resumeService,
            ATSScoreService atsScoreService) {

        this.resumeService = resumeService;
        this.atsScoreService = atsScoreService;
    }

    @PostMapping("/score")
    public Map<String, Object> getScore(
            @RequestBody ATSScoreRequest request) {

        Resume resume =
                resumeService.getResume(
                        request.getResumeId());

        return atsScoreService.calculateScore(
                resume.getResumeText());
    }
}