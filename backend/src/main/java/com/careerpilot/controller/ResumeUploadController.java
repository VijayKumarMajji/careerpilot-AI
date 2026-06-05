package com.careerpilot.controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.careerpilot.entity.Resume;
import com.careerpilot.service.FileStorageService;
import com.careerpilot.service.ResumeParserService;
import com.careerpilot.service.ResumeService;

@RestController
@RequestMapping("/api/resumes")
public class ResumeUploadController {

    private final FileStorageService fileStorageService;
    private final ResumeParserService resumeParserService;
    private final ResumeService resumeService;

    public ResumeUploadController(
            FileStorageService fileStorageService,
            ResumeParserService resumeParserService,
            ResumeService resumeService) {

        this.fileStorageService = fileStorageService;
        this.resumeParserService = resumeParserService;
        this.resumeService = resumeService;
    }

    @PostMapping("/upload")
    public Map<String, Object> uploadResume(
            @RequestParam("file")
            MultipartFile file)
            throws IOException {

        String filePath =
                fileStorageService.saveFile(file);

        String extractedText =
                resumeParserService.extractText(filePath);

        Resume resume = new Resume();

        resume.setFileName(
                file.getOriginalFilename());

        resume.setResumeText(
                extractedText);

        Resume savedResume =
                resumeService.saveResume(resume);

        return Map.of(
                "id", savedResume.getId(),
                "fileName", savedResume.getFileName(),
                "message",
                "Resume uploaded and saved successfully"
        );
    }
}