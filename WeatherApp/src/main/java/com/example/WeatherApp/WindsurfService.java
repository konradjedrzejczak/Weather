package com.example.WeatherApp;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WindsurfService {

    private final WeatherService weatherService;

    public WindsurfService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    private final List<WindsurfSpot> spots = Arrays.asList(
            new WindsurfSpot("Jastarnia", 54.6403, 18.6709),
            new WindsurfSpot("Bridgetown", 13.1033, -59.6122),
            new WindsurfSpot("Fortaleza", -3.7171, -38.4444),
            new WindsurfSpot("Pissouri", 34.8963, 32.9917),
            new WindsurfSpot("Le Morne", -20.2364, 57.3272)
    );


    public WindsurfSpot findBestSpot(String date) {
        WindsurfSpot bestSpot = new WindsurfSpot("Jastarnia", 54.6403, 18.6709);
        double bestScore = 0.0;

        for (WindsurfSpot spot : spots) {
            try {
                WeatherForecast forecast = weatherService.getForecast(spot.getLatitude(), spot.getLongitude(), date);
                if (//forecast.getWindSpd() >= 5 && forecast.getWindSpd() <= 18 &&
                        forecast.getTemp() >= 5 && forecast.getTemp() <= 35) {
                    double score = Math.pow(forecast.getWindSpd(), 3) + forecast.getTemp();
                    if (score > bestScore) {
                        bestScore = score;
                        bestSpot = spot;
                    }
                }
            } catch (RuntimeException e) {

            }
        }

        return bestSpot;
    }
}