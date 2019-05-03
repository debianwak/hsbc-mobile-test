package com.globant.training.mobile.util;

import org.springframework.stereotype.Component;

@Component
public class TemeratureUtilImpl implements TemeratureUtil {
    
    @Override
    public Double convertKevinToCelsius(float tempKevin) {
        return Double.valueOf(tempKevin - 273.15F);
    }
    
    @Override
    public Double convertKevinToFahrenheit(float tempKevin) {
        return Double.valueOf(((( tempKevin - 273) * 9/5) + 32));
    }
}
