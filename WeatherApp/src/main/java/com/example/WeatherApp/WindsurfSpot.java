package com.example.WeatherApp;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class WindsurfSpot {

    //zastąp kod (gettery settery) lombokiem.
    private String name;
    private double latitude;
    private double longitude;
    private double score;
    public WindsurfSpot(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Getter
    private static final List<WindsurfSpot> spots = Arrays.asList( // zrób klasę która będzie miała stałą zawierającą lokalizacje.
            new WindsurfSpot("Jastarnia", 54.6403, 18.6709),
            new WindsurfSpot("Bridgetown", 13.1033, -59.6122),
            new WindsurfSpot("Fortaleza", -3.7171, -38.54306000),
            new WindsurfSpot("Pissouri", 34.6694, 32.7013),
            new WindsurfSpot("Le Morne", -20.2364, 57.5521)
    );

}
