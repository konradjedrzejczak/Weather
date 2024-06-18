package com.example.WeatherApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final String apiKey;
    private final WebClient webClient;

    public WeatherServiceImpl(@Value("${weather.api.key}") String apiKey, WebClient webClient) {
        this.apiKey = apiKey;
        this.webClient = webClient;
    }

    @Override
    public WeatherForecast getForecast(double latitude, double longitude, String date) {
        String url = String.format("?lat=%s&lon=%s&key=%s", latitude, longitude, apiKey);

        WeatherResponse response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();

//        if (response == null || response.getData() == null) {
//            throw new RuntimeException("No data received from Weatherbit API");
//        }

        WeatherForecast weatherForecast = new WeatherForecast();

//        response.subscribe(weatherResponse -> {
//            for (WeatherResponse.WeatherData weatherData : weatherResponse.getData()) {
//                weatherForecast.setTemp(weatherData.getTemp());
//                weatherForecast.setWindSpd(weatherData.getWindSpeed());
//            }
//        });
        assert response != null;
        for (WeatherResponse.WeatherData weatherData : response.getData()) {
            weatherForecast.setTemp(weatherData.getTemp());
            weatherForecast.setWindSpd(weatherData.getWindSpeed());
        }

        return weatherForecast;
    }
}
