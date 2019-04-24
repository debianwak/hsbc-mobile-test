package com.globant.training.mobile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WeatherController {
    
    
    @RequestMapping("/")
    public String getWeatherView() {
        
        return "weatherView";
    }
}
