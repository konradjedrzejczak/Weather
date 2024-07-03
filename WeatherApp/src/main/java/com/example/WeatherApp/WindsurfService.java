package com.example.WeatherApp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WindsurfService {

    private final WeatherService weatherService;
    private final List<WindsurfSpot> spots = WindsurfSpot.getSpots();

    public WindsurfSpot findBestSpot(String date) {

        Optional<WindsurfSpot> bestSpot = spots.stream()
                .map(spot -> {
                    try {
                        WeatherForecast forecast = weatherService.getForecast(spot.getLatitude(), spot.getLongitude(), date);


                        boolean isWeatherSuitable =
                                forecast.getWindSpd() >= 5 && forecast.getWindSpd() <= 18 &&
                                        forecast.getTemp() >= 5 && forecast.getTemp() <= 35;

                        if (isWeatherSuitable) {
                            double score = (forecast.getWindSpd() * 3) + forecast.getTemp();
                            spot.setScore(score);

                            return spot;
                        }
                    } catch (Exception e) {
                        System.err.println("Error with forecast");
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(WindsurfSpot::getScore));


        return bestSpot.orElseThrow(() -> new RuntimeException("No good weather for surfing "));
    }
}