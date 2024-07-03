package com.example.WeatherApp;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class WeatherResponse {
    private List<WeatherData> data;

    //klasy w oddzielnych plikach, skorzystaj z adnotacji żeby pisać zmienne camelCase a nie z "_"

}
