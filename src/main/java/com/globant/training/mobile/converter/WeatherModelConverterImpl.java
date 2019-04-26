package com.globant.training.mobile.converter;

import com.globant.training.mobile.builder.GenericBuilder;
import com.globant.training.mobile.model.WeatherResponse;
import com.globant.training.mobile.thirdparty.model.WeatherAPIModel;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class WeatherModelConverterImpl implements WeatherModelConverter {
    
    
    public WeatherResponse weatherApiModelToResponseModel(WeatherAPIModel apiModel) {
        if (apiModel == null) {
            return new WeatherResponse();
        }
        
        return GenericBuilder.of(WeatherResponse::new)
                .with(WeatherResponse::setCityName, apiModel.getName())
                .with(WeatherResponse::setTodayDate, new java.text.SimpleDateFormat("MM/dd/yyyy").format(new java.util.Date()))
                .with(WeatherResponse::setDescWeather, Optional.ofNullable(apiModel.getWeather()).map(w -> w.get(0).getDescription()).orElseGet(() -> ""))
                .with(WeatherResponse::setTempCelsius, Optional.ofNullable(apiModel.getMain()).map( m-> m.getTemp() - 273.15F).orElseGet(() -> 0f))
                .with(WeatherResponse::setTempFahrenheit, apiModel.getMain() != null ? ((( apiModel.getMain().getTemp() - 273) * 9/5) + 32): 0)
                .with(WeatherResponse::setSunrise, apiModel.getSys() != null?
                        new java.text.SimpleDateFormat("hh:mm a").format(new java.util.Date (apiModel.getSys().getSunrise() * 1000)): null)
                .with(WeatherResponse::setSunset, apiModel.getSys() != null?
                        new java.text.SimpleDateFormat("hh:mm a").format(new java.util.Date (apiModel.getSys().getSunset() * 1000)): null)
                .build();
    }
    
}
