package com.numerology.service;

public class NumerologyCalculator {

    public int calculateLifePathNumber(String dob) {
        int sum = 0;
        for (char c : dob.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        while (sum > 9) {
            int temp = 0;
            while (sum > 0) {
                temp += sum % 10;
                sum /= 10;
            }
            sum = temp;
        }
        return sum;
    }
}
