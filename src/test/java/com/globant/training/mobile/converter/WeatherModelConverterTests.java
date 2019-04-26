package com.globant.training.mobile.converter;

import com.globant.training.mobile.model.WeatherResponse;
import com.globant.training.mobile.thirdparty.model.WeatherAPIModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;

public class WeatherModelConverterTests {
    
    @InjectMocks
    private WeatherModelConverterImpl weatherModelConverter;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testWeatherApiModelToResponseModel() throws Exception {
        /* run */
        WeatherResponse responseModel = weatherModelConverter.weatherApiModelToResponseModel(new WeatherAPIModel());
        
        /* review*/
        assertNotNull(responseModel);
    }
    
    @Test
    public void testWeatherApiModelToResponseModelNull() throws Exception {
        /* run */
        WeatherResponse responseModel = weatherModelConverter.weatherApiModelToResponseModel(null);
        
        /* review*/
        assertNotNull(responseModel);
    }
}
