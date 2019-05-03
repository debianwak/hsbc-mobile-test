package com.globant.training.mobile.util;

import org.springframework.stereotype.Component;

@Component
public class TemperatureUtilImpl implements TemperatureUtil {
    
    @Override
    public Double convertKevinToCelsius(float tempKevin) {
        return (double) (tempKevin - 273.15F);
    }
    
    @Override
    public Double convertKevinToFahrenheit(float tempKevin) {
        return ((tempKevin - 273.15) * 9D / 5) + 32;
    }
}
