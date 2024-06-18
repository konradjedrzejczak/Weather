package com.example.WeatherApp;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface WeatherService {

    WeatherForecast getForecast(double latitude, double longitude, String date);

}
