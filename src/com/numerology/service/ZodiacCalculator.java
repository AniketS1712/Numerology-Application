package com.numerology.service;

public class ZodiacCalculator {

    public ZodiacInfo getZodiac(String dob) {

        String[] parts = dob.split("-");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);

        if ((month == 3 && day >= 21) || (month == 4 && day <= 19))
            return new ZodiacInfo("Aries", "Fire", "Mars", "Mesh", "Mangal");

        if ((month == 4 && day >= 20) || (month == 5 && day <= 20))
            return new ZodiacInfo("Taurus", "Earth", "Venus", "Vrishabh", "Shukra");

        if ((month == 5 && day >= 21) || (month == 6 && day <= 20))
            return new ZodiacInfo("Gemini", "Air", "Mercury", "Mithun", "Budh");

        if ((month == 6 && day >= 21) || (month == 7 && day <= 22))
            return new ZodiacInfo("Cancer", "Water", "Moon", "Karka", "Chandra");

        if ((month == 7 && day >= 23) || (month == 8 && day <= 22))
            return new ZodiacInfo("Leo", "Fire", "Sun", "Simha", "Surya");

        if ((month == 8 && day >= 23) || (month == 9 && day <= 22))
            return new ZodiacInfo("Virgo", "Earth", "Mercury", "Kanya", "Budha");

        if ((month == 9 && day >= 23) || (month == 10 && day <= 22))
            return new ZodiacInfo("Libra", "Air", "Venus", "Tula", "Shukra");

        if ((month == 10 && day >= 23) || (month == 11 && day <= 21))
            return new ZodiacInfo("Scorpio", "Water", "Mars", "Vrischik", "Mangal");

        if ((month == 11 && day >= 22) || (month == 12 && day <= 21))
            return new ZodiacInfo("Sagittarius", "Fire", "Jupiter", "Dhanu", "Guru");

        if ((month == 12 && day >= 22) || (month == 1 && day <= 19))
            return new ZodiacInfo("Capricorn", "Earth", "Saturn", "Makar", "Shani");

        if ((month == 1 && day >= 20) || (month == 2 && day <= 18))
            return new ZodiacInfo("Aquarius", "Air", "Saturn", "Kumbh", "Shani");

        return new ZodiacInfo("Pisces", "Water", "Jupiter", "Meen", "Guru");
    }
}
