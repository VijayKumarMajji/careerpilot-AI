package com.careerpilot.service;

import org.springframework.stereotype.Service;

@Service
public class AIResumeRewriteService {

    private final GeminiService geminiService;

    public AIResumeRewriteService(
            GeminiService geminiService) {

        this.geminiService = geminiService;
    }

    public String rewriteResume(
            String resumeText,
            String jobDescription) {

        String prompt =
                """
                You are a professional ATS Resume Optimizer.

                TASK:

                1. Analyze the job description.
                2. Identify important ATS keywords.
                3. Rewrite the resume to improve ATS compatibility.
                4. Include missing keywords ONLY if they are reasonably related to the candidate's experience.
                5. Do NOT invent fake companies, fake projects, fake certifications, or fake years of experience.
                6. Improve Professional Summary.
                7. Improve Technical Skills section.
                8. Improve Project descriptions.
                9. Keep ATS-friendly formatting.
                10. Return ONLY the final optimized resume.

                RESUME:

                """
                + resumeText +
                """

                JOB DESCRIPTION:

                """
                + jobDescription;

        return geminiService.generateContent(prompt);
    }
}