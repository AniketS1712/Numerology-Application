package com.numerology.service;

public class ZodiacInfo {

    private String zodiacSign;
    private String element;
    private String zodiacPlanet;
    private String vedicName;
    private String vedicPlanet;

    public ZodiacInfo(String zodiacSign, String element, String planet, String vedicName, String vedicPlanet) {
        this.zodiacSign = zodiacSign;
        this.element = element;
        this.zodiacPlanet = planet;
        this.vedicName = vedicName;
        this.vedicPlanet = vedicPlanet;
    }

    public String getZodiacSign() {
        return zodiacSign;
    }

    public String getElement() {
        return element;
    }

    public String getZodiacPlanet() {
        return zodiacPlanet;
    }

    public String getVedicName() {
        return vedicName;
    }

    public String getVedicPlanet() {
        return vedicPlanet;
    }
}