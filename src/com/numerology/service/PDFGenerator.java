package com.numerology.service;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class PDFGenerator {

    public static void generateNumerologyPDF(
            String name,
            String dob,
            int lifePathNumber,
            String career,
            String relationship,
            String health,
            String money,
            String characteristics,
            String filePath
    ) throws IOException {

        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        PDPageContentStream content =
                new PDPageContentStream(document, page);

        content.beginText();
        content.setLeading(18f);
        content.newLineAtOffset(50, 750);

        // Title
        content.setFont(
                new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD),
                16
        );
        content.showText("Numerology Report");
        content.newLine();
        content.newLine();

        // Body font
        content.setFont(
                new PDType1Font(Standard14Fonts.FontName.HELVETICA),
                12
        );

        // Basic Info
        content.showText("Name: " + name);
        content.newLine();

        content.showText("Date of Birth: " + dob);
        content.newLine();

        content.showText("Life Path Number: " + lifePathNumber);
        content.newLine();
        content.newLine();

        // Career
        content.showText("Career:");
        content.newLine();
        writeMultilineText(content, career);
        content.newLine();

        // Relationships
        content.showText("Relationships:");
        content.newLine();
        writeMultilineText(content, relationship);
        content.newLine();

        // Health
        content.showText("Health:");
        content.newLine();
        writeMultilineText(content, health);
        content.newLine();

        // Money
        content.showText("Money:");
        content.newLine();
        writeMultilineText(content, money);
        content.newLine();

        // Characteristics
        content.showText("Characteristics:");
        content.newLine();
        writeMultilineText(content, characteristics);

        content.endText();
        content.close();

        document.save(filePath);
        document.close();
    }

    // Helper method for multiline text
    private static void writeMultilineText(
            PDPageContentStream content,
            String text
    ) throws IOException {

        String[] lines = text.split("\\n");
        for (String line : lines) {
            content.showText(line);
            content.newLine();
        }
    }
}
