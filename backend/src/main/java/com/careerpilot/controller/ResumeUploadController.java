package com.careerpilot.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.careerpilot.entity.Resume;
import com.careerpilot.service.FileStorageService;
import com.careerpilot.service.ResumeParserService;
import com.careerpilot.service.ResumeScoreService;
import com.careerpilot.service.ResumeService;
import com.careerpilot.service.SkillExtractionService;

@RestController
@RequestMapping("/api/resumes")
public class ResumeUploadController {

    private final FileStorageService fileStorageService;
    private final ResumeParserService resumeParserService;
    private final ResumeService resumeService;
    private final SkillExtractionService skillExtractionService;
    private final ResumeScoreService resumeScoreService;

    public ResumeUploadController(
            FileStorageService fileStorageService,
            ResumeParserService resumeParserService,
            ResumeService resumeService,
            SkillExtractionService skillExtractionService,
            ResumeScoreService resumeScoreService) {

        this.fileStorageService = fileStorageService;
        this.resumeParserService = resumeParserService;
        this.resumeService = resumeService;
        this.skillExtractionService = skillExtractionService;
        this.resumeScoreService = resumeScoreService;
    }

    @PostMapping("/upload")
    public Map<String, Object> uploadResume(
            @RequestParam("file") MultipartFile file)
            throws IOException {

        String filePath =
                fileStorageService.saveFile(file);

        String extractedText =
                resumeParserService.extractText(filePath);

        List<String> skills =
                skillExtractionService.extractSkills(
                        extractedText);

        int score =
                resumeScoreService.calculateScore(
                        extractedText,
                        skills);

        Resume resume = new Resume();

        resume.setFileName(
                file.getOriginalFilename());

        resume.setResumeText(
                extractedText);

        resume.setAtsScore(
                score);

        resume.setSkills(
                String.join(",", skills));

        Resume savedResume =
                resumeService.saveResume(
                        resume);

        return Map.of(
                "id", savedResume.getId(),
                "fileName", savedResume.getFileName(),
                "skills", skills,
                "score", score,
                "message",
                "Resume uploaded and analyzed successfully"
        );
    }
}