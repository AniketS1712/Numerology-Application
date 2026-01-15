package com.numerology.service;

import java.io.IOException;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.common.PDRectangle;

public class PDFGenerator {

    public static void generateNumerologyPDF(
            String name,
            String dob,
            int lifePathNumber,
            String meaning,
            String filePath
    ) throws IOException {

        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        PDPageContentStream content =
                new PDPageContentStream(document, page);

        content.beginText();
        content.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 16);
        content.setLeading(18f);
        content.newLineAtOffset(50, 750);

        content.showText("Numerology Report");
        content.newLine();
        content.newLine();

        content.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 12);

        content.showText("Name: " + name);
        content.newLine();

        content.showText("Date of Birth: " + dob);
        content.newLine();

        content.showText("Life Path Number: " + lifePathNumber);
        content.newLine();
        content.newLine();

        content.showText("Characteristics:");
        content.newLine();

        for (String line : meaning.split("\n")) {
            content.showText(line);
            content.newLine();
        }

        content.endText();
        content.close();

        document.save(filePath);
        document.close();
    }
}
