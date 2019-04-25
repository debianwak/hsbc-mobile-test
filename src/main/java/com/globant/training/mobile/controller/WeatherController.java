package com.globant.training.mobile.controller;

import com.globant.training.mobile.client.WeatherServiceClient;
import com.globant.training.mobile.converter.WeatherConverter;
import com.globant.training.mobile.model.WeatherResponse;
import com.globant.training.mobile.thirdparty.model.WeatherAPIModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class WeatherController {
    
    @Inject
    private WeatherServiceClient weatherServiceClient;
    
    @Inject
    private WeatherConverter weatherConverter;
    
    private static long DEFAULT_CITY = 2643743;
    
    @RequestMapping("/")
    public String getWeatherView(Model model) {
        model.addAttribute("showResult", false);
        model.addAttribute("selectedOption", DEFAULT_CITY);
        return "weatherView";
    }
    
    @PostMapping("/weatherCityInfo")
    public String addUser(@RequestParam("idCity") long idCity, Model model, HttpSession session, HttpServletRequest request) throws Exception {
    
        WeatherAPIModel apiResponse = weatherServiceClient.getWeatherByCity(idCity);
        WeatherResponse responseModel = weatherConverter.weatherApiModelToResponseModel(apiResponse);
        
        model.addAttribute("date", responseModel.getTodayDate());
        model.addAttribute("cityName", responseModel.getCityName());
        model.addAttribute("weather", responseModel.getDescWeather());
        model.addAttribute("tempFarenheit", responseModel.getTempFarenheit());
        model.addAttribute("tempCelcius", responseModel.getTempCelcius());
        model.addAttribute("sunrise", responseModel.getSunrise());
        model.addAttribute("sunset", responseModel.getSunset());
    
        model.addAttribute("selectedOption", idCity);
        model.addAttribute("showResult", true);
        
        return "weatherView";
    }
}
