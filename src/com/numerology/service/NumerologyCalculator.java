package com.numerology.service;

public class NumerologyCalculator {

    public int calculateLifePathNumber(String dob) {
        int sum = 0;

        for (char ch : dob.toCharArray()) {
            if (Character.isDigit(ch)) {
                sum += Character.getNumericValue(ch);
            }
        }

        return reduceToSingleDigit(sum);
    }

    private int reduceToSingleDigit(int num) {
        while (num > 9) {
            int s = 0;
            while (num != 0) {
                s += num % 10;
                num /= 10;
            }
            num = s;
        }
        return num;
    }

    public String getBasicMeaning(int number) {
        switch (number) {
            case 1:
                return "Leader, independent, confident";
            case 2:
                return "Peace-loving, emotional, cooperative";
            case 3:
                return "Creative, expressive, joyful";
            case 4:
                return "Hardworking, disciplined, practical";
            case 5:
                return "Adventurous, energetic, freedom-lover";
            case 6:
                return "Caring, responsible, family-oriented";
            case 7:
                return "Spiritual, thinker, analytical";
            case 8:
                return "Ambitious, powerful, success-driven";
            case 9:
                return "Humanitarian, kind, generous";
            default:
                return "Unknown";
        }
    }
}
