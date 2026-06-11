package com.careerpilot.controller;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerpilot.dto.ResumeOptimizationRequest;
import com.careerpilot.entity.Resume;
import com.careerpilot.service.PdfService;
import com.careerpilot.service.ResumeOptimizationService;
import com.careerpilot.service.ResumeService;

@RestController
@RequestMapping("/api/pdf")
public class PdfController {

    private final ResumeService resumeService;
    private final ResumeOptimizationService optimizationService;
    private final PdfService pdfService;

    public PdfController(
            ResumeService resumeService,
            ResumeOptimizationService optimizationService,
            PdfService pdfService) {

        this.resumeService =
                resumeService;

        this.optimizationService =
                optimizationService;

        this.pdfService =
                pdfService;
    }

    @PostMapping("/download")
    public ResponseEntity<byte[]> downloadPdf(
            @RequestBody ResumeOptimizationRequest request) {

        Resume resume =
                resumeService.getResume(
                        request.getResumeId());

        Map<String, Object> result =
                optimizationService.optimizeResume(
                        resume.getResumeText(),
                        request.getJobDescription());

        String optimizedResumeText =
                (String) result.get(
                        "optimizedResumeText");

        byte[] pdf =
                pdfService.generatePdf(
                        optimizedResumeText);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=OptimizedResume.pdf")
                .contentType(
                        MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}