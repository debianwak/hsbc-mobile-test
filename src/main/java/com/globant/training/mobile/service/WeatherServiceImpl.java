package com.globant.training.mobile.service;

import com.globant.training.mobile.client.WeatherAPIClient;
import com.globant.training.mobile.converter.WeatherModelConverter;
import com.globant.training.mobile.exception.WeatherException;
import com.globant.training.mobile.model.WeatherResponse;
import com.globant.training.mobile.thirdparty.model.WeatherAPIModel;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class WeatherServiceImpl implements WeatherService {
    
    @Inject
    private WeatherAPIClient weatherAPIClient;
    
    @Inject
    private WeatherModelConverter weatherConverter;
    
    @Override
    public WeatherResponse getWeatherByCity(long idCity) throws WeatherException {
        WeatherAPIModel apiResponse = weatherAPIClient.getWeatherByCity(idCity);
        WeatherResponse responseModel = weatherConverter.weatherApiModelToResponseModel(apiResponse);
        
        return responseModel;
    }
}
