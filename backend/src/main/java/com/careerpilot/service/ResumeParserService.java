package com.careerpilot.service;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;


@Service
public class ResumeParserService {

    public String extractText(String filePath)
            throws IOException {

        File file = new File(filePath);

        PDDocument document = Loader.loadPDF(file);

        PDFTextStripper stripper =
                new PDFTextStripper();

        String text =
                stripper.getText(document);

        document.close();

        return text;
    }
}