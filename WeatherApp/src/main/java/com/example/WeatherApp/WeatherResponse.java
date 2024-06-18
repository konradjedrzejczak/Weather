package com.example.WeatherApp;

import java.util.List;

public class WeatherResponse {
    private List<WeatherData> data;

    public List<WeatherData> getData() {
        return data;
    }

    public void setData(List<WeatherData> data) {
        this.data = data;
    }

    public static class WeatherData {
        private double temp;
        private double wind_spd;

        public double getTemp() {
            return temp;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getWindSpeed() {
            return wind_spd;
        }

        public void setWindSpeed(double wind_spd) {
            this.wind_spd = wind_spd;
        }
    }
}
