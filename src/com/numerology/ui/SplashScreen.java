package com.numerology.ui;

import java.awt.BorderLayout;

import javax.swing.*;

public class SplashScreen extends JWindow {
    JProgressBar progressBar;
    Timer timer;

    public SplashScreen() {
        setSize(400, 250);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Numerology Application", SwingConstants.CENTER);
        label.setFont(label.getFont().deriveFont(18f));

        add(label);

        progressBar = new JProgressBar(1, 100);
        progressBar.setStringPainted(true);
        this.getContentPane().add(progressBar, BorderLayout.SOUTH);
        loadProgress();
    }

    void loadProgress() {
        timer = new Timer(30, e-> {
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
