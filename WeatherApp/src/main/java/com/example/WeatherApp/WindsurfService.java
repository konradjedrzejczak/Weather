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
            new WindsurfSpot("Fortaleza", -3.7171,   -38.54306000  ),
            new WindsurfSpot("Pissouri", 34.6694, 32.7013),
            new WindsurfSpot("Le Morne", -20.2364, 57.5521)
    );


    public WindsurfSpot findBestSpot(String date) {
        WindsurfSpot bestSpot = new WindsurfSpot("Jastarnia", 54.6403, 18.6709);
        double bestScore = 0.0;

        for (WindsurfSpot spot : spots) {
            try {
                WeatherForecast forecast = weatherService.getForecast(spot.getLatitude(), spot.getLongitude(), date);
                if (forecast.getWind_gust_spd() >= 5 && forecast.getWind_gust_spd() <= 18 &&
                        forecast.getTemp() >= 5 && forecast.getTemp() <= 35) {
                    double score = (forecast.getWind_gust_spd() * 3) + forecast.getTemp();
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