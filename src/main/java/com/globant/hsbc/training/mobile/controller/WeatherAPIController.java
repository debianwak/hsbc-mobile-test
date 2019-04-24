package com.globant.hsbc.training.mobile.controller;

import com.globant.hsbc.training.mobile.converter.WeatherConverter;
import com.globant.hsbc.training.mobile.client.WeatherServiceClient;
import com.globant.hsbc.training.mobile.model.WeatherResponse;
import com.globant.hsbc.training.mobile.thirdparty.model.WeatherAPIModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping("/api/weather/info")
public class WeatherAPIController {
    
    @Inject
    private WeatherServiceClient weatherServiceClient;
    
    @Inject
    private WeatherConverter weatherConverter;
    
    @RequestMapping(value = "/city/{city}",  produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<WeatherResponse> getWeatherInfo(@PathVariable("city") long idCity) throws Exception {
        
        WeatherAPIModel apiResponse = weatherServiceClient.getWeatherByCity(idCity);
        
        return new ResponseEntity<>(weatherConverter.weatherApiModelToResponseModel(apiResponse), HttpStatus.OK);
    }
    
}
