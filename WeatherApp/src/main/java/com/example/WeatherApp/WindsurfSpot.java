package com.example.WeatherApp;

public class WindsurfSpot {

    private String name;
    private double latitude;
    private double longitude;

    public WindsurfSpot(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Gettery i settery
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
