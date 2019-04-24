package com.globant.training.mobile.client;

import com.globant.training.mobile.thirdparty.model.WeatherAPIModel;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.springframework.stereotype.Component;

@Component
public class WeatherServiceClient {

    
    
    public WeatherAPIModel getWeatherByCity(long idCity) throws Exception {
        Gson gson = new Gson();
        HttpResponse<JsonNode> response = Unirest.get("http://api.openweathermap.org/data/2.5/weather")
                .queryString("id", idCity)
                .queryString("APPID", "1633a179e789e7fbae1d6dca78a5da9f")
                .asJson();
        return gson.fromJson(response.getBody().toString(), WeatherAPIModel.class);
    }
    
}
