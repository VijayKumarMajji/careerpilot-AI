package com.careerpilot.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate =
            new RestTemplate();

    public String generateContent(
            String prompt) {
                System.out.println("Gemini Key Loaded = " + apiKey);

        try {

            String url =
                    "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent?key="
                            + apiKey;

            Map<String, Object> body =
                    Map.of(
                            "contents",
                            List.of(
                                    Map.of(
                                            "parts",
                                            List.of(
                                                    Map.of(
                                                            "text",
                                                            prompt
                                                    )
                                            )
                                    )
                            )
                    );

            HttpHeaders headers =
                    new HttpHeaders();

            headers.setContentType(
                    MediaType.APPLICATION_JSON
            );

            HttpEntity<Map<String, Object>>
                    entity =
                    new HttpEntity<>(
                            body,
                            headers
                    );

            ResponseEntity<Map> response =
                    restTemplate.postForEntity(
                            url,
                            entity,
                            Map.class
                    );

            List candidates =
                    (List) response.getBody()
                            .get("candidates");

            Map candidate =
                    (Map) candidates.get(0);

            Map content =
                    (Map) candidate.get("content");

            List parts =
                    (List) content.get("parts");

            Map firstPart =
                    (Map) parts.get(0);

            return firstPart
                    .get("text")
                    .toString();

        } catch (Exception e) {

            return "Gemini Error: "
                    + e.getMessage();
        }
    }
}