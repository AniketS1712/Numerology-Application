package com.numerology.service;

public class NumerologyMeaning {

    public String career(int num) {
        switch (num) {
            case 1:
                return "Leadership-oriented career. Suitable for entrepreneurship, management roles, and positions where independence and decision-making are required.";
            case 2:
                return "Works best in team-based environments. Careers involving diplomacy, coordination, and human relations are ideal.";
            case 3:
                return "Highly creative. Excels in communication, media, writing, arts, and public speaking roles.";
            case 4:
                return "Disciplined and systematic. Suitable for engineering, administration, and structured professional fields.";
            case 5:
                return "Dynamic and adaptable. Best suited for sales, marketing, travel, and roles involving movement and change.";
            case 6:
                return "Service-oriented. Teaching, healthcare, counseling, and social service fields are favorable.";
            case 7:
                return "Analytical and thoughtful. Performs well in research, IT, academics, and spiritual studies.";
            case 8:
                return "Authority-driven. Business, finance, leadership, and executive roles bring success.";
            case 9:
                return "Humanitarian mindset. Works well in social service, arts, and public welfare fields.";
            default:
                return "No career data available.";
        }
    }

    public String relationships(int num) {
        switch (num) {
            case 1:
                return "Strong-willed and independent in relationships. Needs a supportive and understanding partner.";
            case 2:
                return "Emotionally sensitive and loyal. Values harmony and emotional bonding.";
            case 3:
                return "Expressive and romantic. Brings joy and enthusiasm into relationships.";
            case 4:
                return "Reliable and practical. Believes in long-term commitment and stability.";
            case 5:
                return "Freedom-loving and adventurous. Needs space and excitement in relationships.";
            case 6:
                return "Caring and family-oriented. Deeply committed to loved ones.";
            case 7:
                return "Reserved by nature. Requires emotional space and understanding.";
            case 8:
                return "Protective and dominant. Seeks control and security.";
            case 9:
                return "Compassionate and idealistic. Values emotional depth and sincerity.";
            default:
                return "No relationship data available.";
        }
    }

    public String health(int num) {
        switch (num) {
            case 1:
                return "Good physical vitality but should manage stress and overwork.";
            case 2:
                return "Emotionally sensitive. Mental peace is important for good health.";
            case 3:
                return "Generally energetic. Avoid excesses and irregular habits.";
            case 4:
                return "Strong endurance. Maintain flexibility and avoid rigidity.";
            case 5:
                return "Active lifestyle. Needs balance to avoid restlessness.";
            case 6:
                return "Stable health. Avoid taking excessive responsibilities.";
            case 7:
                return "Mental health plays a key role. Meditation and calmness help.";
            case 8:
                return "Strong constitution but pressure and stress must be controlled.";
            case 9:
                return "Emotional health directly impacts physical well-being.";
            default:
                return "No health data available.";
        }
    }

    public String money(int num) {
        switch (num) {
            case 1:
                return "Financial growth through self-effort and leadership.";
            case 2:
                return "Steady but slow financial progress. Savings are important.";
            case 3:
                return "Earnings through creativity and communication skills.";
            case 4:
                return "Stable income through discipline and hard work.";
            case 5:
                return "Fluctuating income. Requires financial planning.";
            case 6:
                return "Generally good financial stability.";
            case 7:
                return "Income through knowledge, learning, and expertise.";
            case 8:
                return "Strong wealth-building potential if handled wisely.";
            case 9:
                return "Earns well but tends to spend generously.";
            default:
                return "No financial data available.";
        }
    }

    public String characteristics(int num) {
        switch (num) {
            case 1:
                return "Confident, ambitious, and self-reliant personality.";
            case 2:
                return "Calm, cooperative, and emotionally sensitive nature.";
            case 3:
                return "Optimistic, creative, and expressive individual.";
            case 4:
                return "Hardworking, reliable, and disciplined personality.";
            case 5:
                return "Energetic, adaptable, and adventurous nature.";
            case 6:
                return "Responsible, nurturing, and protective personality.";
            case 7:
                return "Analytical, introspective, and spiritually inclined.";
            case 8:
                return "Goal-oriented, authoritative, and determined.";
            case 9:
                return "Compassionate, generous, and idealistic personality.";
            default:
                return "No personality data available.";
        }
    }
}
