package com.globant.training.mobile.converter;

import com.globant.training.mobile.model.WeatherResponse;
import com.globant.training.mobile.thirdparty.model.WeatherAPIModel;
import com.globant.training.mobile.util.DateTimeUtilImpl;
import com.globant.training.mobile.util.TemperatureUtilImpl;
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
    private TemperatureUtilImpl temeratureUtil;
    
    @InjectMocks
    private WeatherModelConverterImpl weatherModelConverter;
    
    private static final String STR_DATE = "04/05/2019";
    private static final Float NEW_TEMPERATURE = 455F;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        
        /* mock */
        when(dateTimeUtil.convertDateToString(anyString(), any())).thenReturn(STR_DATE);
        when(dateTimeUtil.convertUnixDateToString(anyString(), anyLong())).thenReturn(STR_DATE);
        when(temeratureUtil.convertKevinToCelsius(anyFloat())).thenReturn(new Double(NEW_TEMPERATURE));
        when(temeratureUtil.convertKevinToFahrenheit(anyFloat())).thenReturn(new Double(NEW_TEMPERATURE));
    }
    
    @Test
    public void testWeatherApiModelToResponseModel()  {
        /* run */
        WeatherResponse responseModel = weatherModelConverter.weatherApiModelToResponseModel(new WeatherAPIModel());
        
        /* review*/
        assertNotNull(responseModel);
    }
    
    @Test
    public void testWeatherApiModelToResponseModelNull()  {
        /* run */
        WeatherResponse responseModel = weatherModelConverter.weatherApiModelToResponseModel(null);
        
        /* review*/
        assertNotNull(responseModel);
    }
}
