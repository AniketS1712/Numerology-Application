package com.numerology.ui;

import javax.swing.*;
import java.awt.*;

public class InputScreen extends JFrame {

    private JTextField nameField;
    private JComboBox<Integer> dayBox;
    private JComboBox<String> monthBox;
    private JComboBox<Integer> yearBox;

    public InputScreen() {
        setTitle("Numerology Calculator");
        setSize(500, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel main = new JPanel(new BorderLayout());
        main.add(createHeader(), BorderLayout.NORTH);
        main.add(createAboutNumerology(), BorderLayout.CENTER);
        main.add(createForm(), BorderLayout.SOUTH);
        add(main);
    }

    private JPanel createHeader() {

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBackground(Color.WHITE);
        header.setBorder(BorderFactory.createEmptyBorder(15, 10, 10, 10));

        JLabel title = new JLabel("Numerology Calculator", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel(
                "Enter your details to generate your Numerology and Zodiac report",
                SwingConstants.CENTER);
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 12));
        subtitle.setForeground(Color.DARK_GRAY);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        header.add(title);
        header.add(Box.createVerticalStrut(5));
        header.add(subtitle);

        return header;
    }

    private JPanel createAboutNumerology() {

        JPanel aboutPanel = new JPanel(new BorderLayout());
        aboutPanel.setBackground(Color.WHITE);
        aboutPanel.setBorder(BorderFactory.createTitledBorder("Numerology"));

        JTextArea aboutText = new JTextArea(
                "Numerology is a belief system that studies the relationship between numbers " +
                        "and human life. It is commonly used to analyze personality traits, career paths, " +
                        "relationships, and life patterns based on a person’s date of birth.\n\n" +
                        "This application uses the Life Path Number, calculated from the date of birth, " +
                        "to generate numerology and zodiac-based insights.");

        aboutText.setLineWrap(true);
        aboutText.setWrapStyleWord(true);
        aboutText.setEditable(false);
        aboutText.setFont(new Font("SansSerif", Font.PLAIN, 12));
        aboutText.setBackground(Color.WHITE);
        aboutText.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        aboutPanel.add(aboutText, BorderLayout.CENTER);

        return aboutPanel;
    }

    private JPanel createForm() {
        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setBackground(Color.WHITE);
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Name row
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.setBackground(Color.WHITE);

        JLabel nameLabel = new JLabel("Full Name:");
        nameField = new JTextField(15);

        namePanel.add(nameLabel);
        namePanel.add(nameField);

        // DOB row
        JPanel dobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dobPanel.setBackground(Color.WHITE);

        JLabel dobLabel = new JLabel("Date of Birth:");

        dayBox = new JComboBox<>();
        populateDay();

        monthBox = new JComboBox<>();
        populateMonth();

        yearBox = new JComboBox<>();
        populateYear();

        dobPanel.add(dobLabel);
        dobPanel.add(dayBox);
        dobPanel.add(monthBox);
        dobPanel.add(yearBox);

        // Button row
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);

        JButton submitButton = new JButton("Generate Numerology");
        submitButton.addActionListener(e -> handleSubmit());

        buttonPanel.add(submitButton);

        // Add all rows to form
        form.add(namePanel);
        form.add(Box.createVerticalStrut(15));
        form.add(dobPanel);
        form.add(Box.createVerticalStrut(20));
        form.add(buttonPanel);

        return form;
    }

    private void populateDay() {
        dayBox.addItem(0);
        for (int i = 1; i <= 31; i++) {
            dayBox.addItem(i);
        }
    }

    private void populateMonth() {
        monthBox.addItem("MM");
        for (int i = 1; i <= 12; i++) {
            monthBox.addItem(String.format("%02d", i));
        }
    }

    private void populateYear() {
        yearBox.addItem(0);
        for (int y = 2025; y >= 1925; y--) {
            yearBox.addItem(y);
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private boolean isValidDate(int day, String month, int year) {
        if (month.equals("04") || month.equals("06") ||
                month.equals("09") || month.equals("11")) {
            return day <= 30;
        }

        if (month.equals("02")) {
            return isLeapYear(year) ? day <= 29 : day <= 28;
        }
        return true;
    }

    private void handleSubmit() {
        String name = nameField.getText().trim();
        int day = (int) dayBox.getSelectedItem();
        String month = (String) monthBox.getSelectedItem();
        int year = (int) yearBox.getSelectedItem();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name cannot be empty");
            return;
        }

        if (day == 0 || year == 0 || month.equals("MM")) {
            JOptionPane.showMessageDialog(this, "Please select complete date");
            return;
        }

        if (!isValidDate(day, month, year)) {
            JOptionPane.showMessageDialog(this, "Invalid date selected");
            return;
        }

        String dob = String.format("%02d-%s-%d", day, month, year);
        dispose();
        new ResultScreen(name, dob).setVisible(true);
    }
}
