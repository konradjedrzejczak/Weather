package com.example.WeatherApp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class WeatherForecast {

    @Id
    private Long id;
    private double temp;
    private double wind_gust_spd;

    public WeatherForecast() {
    }

    public WeatherForecast(double temp, double wind_gust_spd) {
        this.temp = temp;
        this.wind_gust_spd = wind_gust_spd;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getWind_gust_spd() {
        return wind_gust_spd;
    }

    public void setWind_gust_spd(double wind_gust_spd) {
        this.wind_gust_spd = wind_gust_spd;
    }
}