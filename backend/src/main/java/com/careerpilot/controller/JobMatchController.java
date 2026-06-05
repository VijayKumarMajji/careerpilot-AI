package com.careerpilot.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerpilot.dto.JobMatchRequest;
import com.careerpilot.entity.Resume;
import com.careerpilot.service.JobMatchService;
import com.careerpilot.service.ResumeService;

@RestController
@RequestMapping("/api/jobs")
public class JobMatchController {

    private final ResumeService resumeService;
    private final JobMatchService jobMatchService;

    public JobMatchController(
            ResumeService resumeService,
            JobMatchService jobMatchService) {

        this.resumeService = resumeService;
        this.jobMatchService = jobMatchService;
    }

    @PostMapping("/match")
    public Map<String, Object> matchJob(
            @RequestBody JobMatchRequest request) {

        Resume resume =
                resumeService.getResume(
                        request.getResumeId());

        return jobMatchService.matchResumeWithJob(
                resume.getResumeText(),
                request.getJobDescription());
    }
}