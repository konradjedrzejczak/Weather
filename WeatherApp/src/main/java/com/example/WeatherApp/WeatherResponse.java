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
        private double wind_gust_spd;

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
}
