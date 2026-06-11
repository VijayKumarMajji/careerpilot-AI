package com.careerpilot.service;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class PdfService {

    public byte[] generatePdf(
            String content) {

        try {

            ByteArrayOutputStream outputStream =
                    new ByteArrayOutputStream();

            Document document =
                    new Document();

            PdfWriter.getInstance(
                    document,
                    outputStream);

            document.open();

            Font titleFont =
                    new Font(
                            Font.HELVETICA,
                            18,
                            Font.BOLD
                    );

            document.add(
                    new Paragraph(
                            "CareerPilot AI Report",
                            titleFont
                    )
            );

            document.add(
                    new Paragraph(" ")
            );

            document.add(
                    new Paragraph(content)
            );

            document.close();

            return outputStream.toByteArray();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to generate PDF",
                    e
            );
        }
    }
}