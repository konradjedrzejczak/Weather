package com.example.WeatherApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

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

        WeatherForecast weatherForecast = new WeatherForecast();

        if (response == null) {
            return new WeatherForecast();
        } // a co jeśli będzie null> jak aplikacja się zachowa?

        for (WeatherData weatherData : response.getData()) {
            weatherForecast.setTemp(weatherData.getTemp());
            weatherForecast.setWindSpd(weatherData.getWindSpd());
        }
        return new WeatherForecast(weatherForecast.getTemp(), weatherForecast.getWindSpd());
    }
}
