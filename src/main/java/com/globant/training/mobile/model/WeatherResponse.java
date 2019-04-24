package com.globant.training.mobile.model;

public class WeatherResponse {
    
    private String cityName;
    private String descWeather;
    private float tempFarenheit;
    private float tempCelcius;
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
    
    public float getTempFarenheit() {
        return tempFarenheit;
    }
    
    public void setTempFarenheit(float tempFarenheit) {
        this.tempFarenheit = tempFarenheit;
    }
    
    public float getTempCelcius() {
        return tempCelcius;
    }
    
    public void setTempCelcius(float tempCelcius) {
        this.tempCelcius = tempCelcius;
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
