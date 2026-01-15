package com.numerology.ui;

import javax.swing.*;
import java.awt.*;

import com.numerology.dao.Numerology;
import com.numerology.service.NumerologyCalculator;
import com.numerology.service.PDFGenerator;

public class ResultScreen extends JFrame {

    public ResultScreen(String name, String dob) {
        setTitle("Numerology Result");
        setSize(420, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        getContentPane().setLayout(new BorderLayout(10, 10));

        // ---------- TITLE ----------
        JLabel titleLabel = new JLabel("Numerology Result", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        getContentPane().add(titleLabel, BorderLayout.NORTH);

        // ---------- NUMEROLOGY LOGIC ----------
        NumerologyCalculator calculator = new NumerologyCalculator();
        int lifePathNumber = calculator.calculateLifePathNumber(dob);
        String career = calculator.getCareerMeaning(lifePathNumber);
        String relationship = calculator.getRelationshipMeaning(lifePathNumber);
        String health = calculator.getHealthMeaning(lifePathNumber);
        String money = calculator.getMoneyMeaning(lifePathNumber);
        String characteristics = calculator.getCharacteristics(lifePathNumber);

        // ---------- RESULT TEXT ----------
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);

        resultArea.setText(
                "Name: " + name +
                        "\nDate of Birth: " + dob +
                        "\n\nLife Path Number: " + lifePathNumber +
                        "\n\nCareer:\n" + career +
                        "\n\nRelationships:\n" + relationship +
                        "\n\nHealth:\n" + health +
                        "\n\nMoney:\n" + money +
                        "\n\nCharacteristics:\n" + characteristics);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // ---------- BUTTONS ----------
        JButton pdfButton = new JButton("Generate PDF");
        pdfButton.addActionListener(e -> {
            try {
                String filePath = "Numerology_Report.pdf";

                PDFGenerator.generateNumerologyPDF(
                        name, dob, lifePathNumber, career, relationship, health, money, characteristics, filePath);

                JOptionPane.showMessageDialog(
                        this,
                        "PDF generated successfully:\n" + filePath);

                Numerology.saveResult(name, dob, lifePathNumber,
                        career, relationship, health, money, characteristics);

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this,
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

        // ---------- BOTTOM PANEL ----------
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        bottomPanel.add(pdfButton);
        bottomPanel.add(backButton);

        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
    }
}
