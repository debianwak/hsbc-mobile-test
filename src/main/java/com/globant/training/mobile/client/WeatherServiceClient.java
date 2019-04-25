package com.globant.training.mobile.client;

import com.globant.training.mobile.thirdparty.model.WeatherAPIModel;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component
public class WeatherServiceClient {
    
    @Inject
    private Gson gson;
    
    @Value( "${thirdpaty.weather.key}" )
    private String apiKey;
    
    @Value( "${thirdpaty.weather.endpoint}" )
    private String weatherEndpoint;
    
    private static final String WEATHER_PARAM_ID = "id";
    
    private static final String WEATHER_PARAM_APP_ID = "APPID";
    
    
    public WeatherAPIModel getWeatherByCity(long idCity) throws Exception {
        
        HttpResponse<JsonNode> response = Unirest.get(weatherEndpoint)
                .queryString(WEATHER_PARAM_ID, idCity)
                .queryString(WEATHER_PARAM_APP_ID, apiKey)
                .asJson();
        return gson.fromJson(response.getBody().toString(), WeatherAPIModel.class);
    }
    
}
