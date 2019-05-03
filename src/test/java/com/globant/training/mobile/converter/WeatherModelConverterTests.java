package com.globant.training.mobile.converter;

import com.globant.training.mobile.model.WeatherResponse;
import com.globant.training.mobile.thirdparty.model.WeatherAPIModel;
import com.globant.training.mobile.util.DateTimeUtilImpl;
import com.globant.training.mobile.util.TemeratureUtilImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyFloat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class WeatherModelConverterTests {
    
    @Mock
    private DateTimeUtilImpl dateTimeUtil;
    
    @Mock
    private TemeratureUtilImpl temeratureUtil;
    
    @InjectMocks
    private WeatherModelConverterImpl weatherModelConverter;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        
        /* mock */
        when(dateTimeUtil.convertDateToString(anyString(), any())).thenReturn(new String());
        when(dateTimeUtil.convertUnixDateToString(anyString(), anyLong())).thenReturn(new String());
        when(temeratureUtil.convertKevinToCelsius(anyFloat())).thenReturn(new Double(455f));
        when(temeratureUtil.convertKevinToFahrenheit(anyFloat())).thenReturn(new Double(455f));
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
