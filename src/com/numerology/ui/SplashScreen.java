package com.numerology.ui;

import java.awt.BorderLayout;

import javax.swing.*;

public class SplashScreen extends JWindow {
    JProgressBar progressBar;
    Timer timer;

    public SplashScreen() {
        setSize(800, 550);
        setLocationRelativeTo(null);

        getContentPane().setLayout(new BorderLayout());

        // Logo
        ImageIcon logoIcon = new ImageIcon("images/logo.jpeg");
        JLabel logoLabel = new JLabel(logoIcon, SwingConstants.CENTER);

        // Title
        JLabel titleLabel = new JLabel("Numerology", SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(18f));

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(logoLabel, BorderLayout.CENTER);
        centerPanel.add(titleLabel, BorderLayout.SOUTH);

        getContentPane().add(centerPanel, BorderLayout.CENTER);

        // Progress Bar
        progressBar = new JProgressBar(1, 100);
        progressBar.setStringPainted(true);
        this.getContentPane().add(progressBar, BorderLayout.SOUTH);
        loadProgress();
    }

    void loadProgress() {
        timer = new Timer(30, e -> {
            int val = progressBar.getValue();
            if (val < 100) {
                progressBar.setValue(val + 1);
            } else {
                timer.stop();
                dispose();
                InputScreen inputScreen = new InputScreen();
                inputScreen.setVisible(true);
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SplashScreen splashScreen = new SplashScreen();
        splashScreen.setVisible(true);
    }
}
