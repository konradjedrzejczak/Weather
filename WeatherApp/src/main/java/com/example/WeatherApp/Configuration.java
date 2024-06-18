package com.example.WeatherApp;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public WebClient webClient(){
       return WebClient.create("http://api.weatherbit.io/v2.0/forecast/daily");
    }


}
