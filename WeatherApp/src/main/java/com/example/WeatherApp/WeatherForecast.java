package com.example.WeatherApp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class WeatherForecast {

    @Id
    private Long id;
    private double temp;
    private double wind_spd;


    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getWindSpd() {
        return wind_spd;
    }

    public void setWindSpd(double wind_spd) {
        this.wind_spd = wind_spd;
    }
}
