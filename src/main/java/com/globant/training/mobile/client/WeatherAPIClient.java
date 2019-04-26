package com.globant.training.mobile.client;

import com.globant.training.mobile.thirdparty.model.WeatherAPIModel;

public interface WeatherAPIClient {
    
    WeatherAPIModel getWeatherByCity(long idCity) throws Exception;
}
