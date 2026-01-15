package com.numerology.ui;

import javax.swing.*;
import java.awt.*;

public class InputScreen extends JFrame {

    private JTextField nameField;
    private JComboBox<Integer> dayBox;
    private JComboBox<String> monthBox;
    private JComboBox<Integer> yearBox;

    public InputScreen() {
        setTitle("Numerology Input");
        setSize(420, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        // Use null layout
        getContentPane().setLayout(null);

        // Title
        JLabel titleLabel = new JLabel("Numerology Calculator", SwingConstants.CENTER);
        titleLabel.setFont(new Font("", Font.BOLD, 16));
        titleLabel.setBounds(100, 15, 220, 30);
        add(titleLabel);

        // Name label & field
        JLabel nameLabel = new JLabel("Enter Name:");
        nameLabel.setBounds(40, 60, 100, 25);
        add(nameLabel);
        
        nameField = new JTextField();
        nameField.setBounds(150, 60, 200, 25);
        add(nameField);

        // DOB label
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(40, 100, 100, 25);
        add(dobLabel);

        // Day box
        dayBox = new JComboBox<>();
        dayBox.setBounds(150, 100, 60, 25);
        populateDay();
        add(dayBox);

        // Month box
        monthBox = new JComboBox<>();
        monthBox.setBounds(220, 100, 70, 25);
        populateMonth();
        add(monthBox);

        // Year box
        yearBox = new JComboBox<>();
        yearBox.setBounds(300, 100, 70, 25);
        populateYear();
        add(yearBox);

        // Submit button
        JButton submitButton = new JButton("Generate Numerology");
        submitButton.setBounds(110, 160, 200, 30);
        submitButton.addActionListener(e -> handleSubmit());
        add(submitButton);
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

    void handleSubmit() {
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
        ResultScreen resultScreen = new ResultScreen(name, dob);
        resultScreen.setVisible(true);
    }
}
