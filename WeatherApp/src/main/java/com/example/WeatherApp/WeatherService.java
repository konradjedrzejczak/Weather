package com.example.WeatherApp;

import org.springframework.stereotype.Service;

@Service
public interface WeatherService {

    WeatherForecast getForecast(double latitude, double longitude, String date);

}
