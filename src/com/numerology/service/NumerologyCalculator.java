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

    public String getCareerMeaning(int num) {
        switch (num) {
            case 1: return "Leadership roles, entrepreneurship, independence.";
            case 2: return "Teamwork, diplomacy, human relations.";
            case 3: return "Creative fields, communication, media.";
            case 4: return "Engineering, management, disciplined work.";
            case 5: return "Sales, travel, marketing, dynamic roles.";
            case 6: return "Teaching, healthcare, social service.";
            case 7: return "Research, IT, spirituality.";
            case 8: return "Business, finance, authority positions.";
            case 9: return "Public service, arts, humanitarian work.";
            default: return "";
        }
    }

    public String getRelationshipMeaning(int num) {
        switch (num) {
            case 1: return "Strong personality, needs understanding partner.";
            case 2: return "Loyal, emotional, values harmony.";
            case 3: return "Expressive, romantic, joyful.";
            case 4: return "Stable, loyal, practical.";
            case 5: return "Freedom loving, adventurous.";
            case 6: return "Caring, family-oriented.";
            case 7: return "Reserved, needs emotional space.";
            case 8: return "Dominant, protective.";
            case 9: return "Compassionate, idealistic.";
            default: return "";
        }
    }

    public String getHealthMeaning(int num) {
        switch (num) {
            case 1: return "Good vitality, manage stress.";
            case 2: return "Sensitive, needs emotional balance.";
            case 3: return "Generally energetic, avoid excess.";
            case 4: return "Strong endurance, avoid rigidity.";
            case 5: return "Active but prone to restlessness.";
            case 6: return "Stable health, avoid overworking.";
            case 7: return "Needs mental peace.";
            case 8: return "Strong but prone to pressure.";
            case 9: return "Emotional health important.";
            default: return "";
        }
    }

    public String getMoneyMeaning(int num) {
        switch (num) {
            case 1: return "Earns through self-effort.";
            case 2: return "Stable but slow financial growth.";
            case 3: return "Money through creativity.";
            case 4: return "Steady income through discipline.";
            case 5: return "Fluctuating income.";
            case 6: return "Good financial stability.";
            case 7: return "Money through knowledge.";
            case 8: return "Strong wealth potential.";
            case 9: return "Gains but spends generously.";
            default: return "";
        }
    }

    public String getCharacteristics(int num) {
        switch (num) {
            case 1: return "Confident, independent, ambitious.";
            case 2: return "Calm, cooperative, sensitive.";
            case 3: return "Creative, expressive, optimistic.";
            case 4: return "Hardworking, disciplined, reliable.";
            case 5: return "Adventurous, energetic, adaptable.";
            case 6: return "Responsible, caring, protective.";
            case 7: return "Analytical, spiritual, introspective.";
            case 8: return "Authoritative, goal-oriented.";
            case 9: return "Compassionate, generous, idealistic.";
            default: return "";
        }
    }
}
