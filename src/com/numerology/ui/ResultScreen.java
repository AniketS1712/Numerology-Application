package com.numerology.ui;

import javax.swing.*;
import java.awt.*;

import com.numerology.dao.Numerology;
import com.numerology.service.*;

public class ResultScreen extends JFrame {

    public ResultScreen(String name, String dob) {

        setTitle("Numerology Result");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(10, 10));

        // TITLE
        JLabel titleLabel = new JLabel("Numerology & Zodiac Report", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        // LOGIC
        NumerologyCalculator calculator = new NumerologyCalculator();
        NumerologyMeaning meaningService = new NumerologyMeaning();

        int lifePathNumber = calculator.calculateLifePathNumber(dob);

        String career = meaningService.career(lifePathNumber);
        String relationship = meaningService.relationships(lifePathNumber);
        String health = meaningService.health(lifePathNumber);
        String money = meaningService.money(lifePathNumber);
        String characteristics = meaningService.characteristics(lifePathNumber);
        
        ZodiacCalculator zodiacCalculator = new ZodiacCalculator();
        ZodiacInfo zodiac = zodiacCalculator.getZodiac(dob);

        // CENTER PANEL (RESULTS)
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        resultPanel.add(createSection("Personal Details",
                "Name: " + name,
                "Date of Birth: " + dob));

        resultPanel.add(createSection("Numerology",
                "Life Path Number: " + lifePathNumber,
                "Career: " + career,
                "Relationships: " + relationship,
                "Health: " + health,
                "Money: " + money,
                "Characteristics: " + characteristics));

        resultPanel.add(createSection("Zodiac Details",
                "Zodiac Sign: " + zodiac.getZodiacSign(),
                "Element: " + zodiac.getElement(),
                "Ruling Planet: " + zodiac.getZodiacPlanet(),
                "Vedic Rashi: " + zodiac.getVedicName(),
                "Vedic Planet: " + zodiac.getVedicPlanet()));

        JScrollPane scrollPane = new JScrollPane(resultPanel);
        add(scrollPane, BorderLayout.CENTER);

        // BUTTONS
        JButton pdfButton = new JButton("Generate PDF");
        pdfButton.addActionListener(e -> {
            try {
                String filePath = "Numerology_Report.pdf";

                PDFGenerator.generateNumerologyPDF(
                        name, dob, lifePathNumber,
                        career, relationship, health, money, characteristics,
                        filePath
                );

                Numerology.saveResult(
                        name, dob, lifePathNumber,
                        career, relationship, health, money, characteristics
                );

                JOptionPane.showMessageDialog(this,
                        "PDF generated successfully");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Error generating PDF",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            dispose();
            new InputScreen().setVisible(true);
        });

        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.add(pdfButton);
        bottomPanel.add(backButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    // SIMPLE SECTION METHOD
    private JPanel createSection(String title, String... lines) {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createTitledBorder(title));

        for (String line : lines) {
            panel.add(new JLabel(line));
        }

        panel.add(Box.createVerticalStrut(10));
        return panel;
    }
}
