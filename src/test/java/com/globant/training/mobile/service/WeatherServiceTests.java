package com.globant.training.mobile.service;

import com.globant.training.mobile.client.WeatherAPIClient;
import com.globant.training.mobile.converter.WeatherModelConverter;
import com.globant.training.mobile.model.WeatherResponse;
import com.globant.training.mobile.thirdparty.model.WeatherAPIModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.when;


public class WeatherServiceTests {
    
    @Mock
    private WeatherAPIClient weatherAPIClient;
    
    @Mock
    private WeatherModelConverter weatherConverter;
    
    @InjectMocks
    private WeatherServiceImpl weatherService;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGetWeatherByCity() throws Exception {
        /* mock */
        when(weatherAPIClient.getWeatherByCity(anyLong())).thenReturn(new WeatherAPIModel());
        when(weatherConverter.weatherApiModelToResponseModel(any())).thenReturn(new WeatherResponse());
        
        /* run */
        WeatherResponse weatherResponse = weatherService.getWeatherByCity(34445);
        
        /* review */
        assertNotNull(weatherResponse);
    }
}
