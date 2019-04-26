package com.globant.training.mobile.model;

public class WeatherResponse {
    
    private String cityName;
    private String descWeather;
    private float tempFahrenheit;
    private float tempCelsius;
    private String sunrise;
    private String sunset;
    private String todayDate;
    
    public String getCityName() {
        return cityName;
    }
    
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    public String getDescWeather() {
        return descWeather;
    }
    
    public void setDescWeather(String descWeather) {
        this.descWeather = descWeather;
    }
    
    public float getTempFahrenheit() {
        return tempFahrenheit;
    }
    
    public void setTempFahrenheit(float tempFahrenheit) {
        this.tempFahrenheit = tempFahrenheit;
    }
    
    public float getTempCelsius() {
        return tempCelsius;
    }
    
    public void setTempCelsius(float tempCelsius) {
        this.tempCelsius = tempCelsius;
    }
    
    public String getSunrise() {
        return sunrise;
    }
    
    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }
    
    public String getSunset() {
        return sunset;
    }
    
    public void setSunset(String sunset) {
        this.sunset = sunset;
    }
    
    public String getTodayDate() {
        return todayDate;
    }
    
    public void setTodayDate(String todayDate) {
        this.todayDate = todayDate;
    }
}
