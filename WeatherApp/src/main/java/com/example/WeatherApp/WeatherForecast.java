package com.example.WeatherApp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WeatherForecast {

    @Id
    private Long id;

    private double temp;

    private double windSpd;

    public WeatherForecast() {
    }

    public WeatherForecast(double temp, double windSpd) {
        this.temp = temp;
        this.windSpd = windSpd;
    }


}