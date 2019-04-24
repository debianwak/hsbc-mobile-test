package com.globant.hsbc.training.mobile.converter;

import com.globant.hsbc.training.mobile.builder.GenericBuilder;
import com.globant.hsbc.training.mobile.model.WeatherResponse;
import com.globant.hsbc.training.mobile.thirdparty.model.WeatherAPIModel;
import org.springframework.stereotype.Component;

@Component
public class WeatherConverter {
    
    
    public WeatherResponse weatherApiModelToResponseModel(WeatherAPIModel apiModel) throws Exception {
    
        return GenericBuilder.of(WeatherResponse::new)
                .with(WeatherResponse::setCityName, apiModel.getName())
                .with(WeatherResponse::setTodayDate, new java.text.SimpleDateFormat("MM/dd/yyyy").format(new java.util.Date()))
                .with(WeatherResponse::setDescWeather, apiModel.getWeather().get(0).getDescription())
                .with(WeatherResponse::setTempCelcius, apiModel.getMain().getTemp() - 273.15F)
                .with(WeatherResponse::setTempFarenheit, (((apiModel.getMain().getTemp() - 273) * 9/5) + 32))
                .with(WeatherResponse::setSunrise,
                        new java.text.SimpleDateFormat("hh:mm a").format(new java.util.Date (apiModel.getSys().getSunrise() * 1000)))
                .with(WeatherResponse::setSunset,
                        new java.text.SimpleDateFormat("hh:mm a").format(new java.util.Date (apiModel.getSys().getSunset() * 1000)))
                .build();
    }
    
}
