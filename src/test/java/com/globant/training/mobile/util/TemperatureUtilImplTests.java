package com.globant.training.mobile.util;

import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TemperatureUtilImplTests {
    
    private TemperatureUtil temperatureUtil;
    
    private DecimalFormat decimalFormat;
    
    private static final Float TEMP_EXAMPLE_KEVIN = 295F;
    private static final Double TEMP_CELSIUS = 21.85D;
    private static final Double TEMP_FAHRENHEIT = 71.33D;
    private static final String TWO_DECIMAL_FORMAT = "##.00";
    
    @Before
    public void setup() {
        temperatureUtil = new TemperatureUtilImpl();
        decimalFormat = new DecimalFormat(TWO_DECIMAL_FORMAT);
    }
    
    @Test
    public void testConvertKevinToCelsius() {
        /* run */
        Double tempCelsius = temperatureUtil.convertKevinToCelsius(TEMP_EXAMPLE_KEVIN);
        
        /* review */
        assertNotNull(tempCelsius);
        assertEquals(TEMP_CELSIUS, Double.valueOf(decimalFormat.format(tempCelsius)));
    }
    
    @Test
    public void testConvertKevinToFahrenheit() {
        /* run */
        Double tempFahrenheit = temperatureUtil.convertKevinToFahrenheit(TEMP_EXAMPLE_KEVIN);
    
        /* review */
        assertNotNull(tempFahrenheit);
        assertEquals(TEMP_FAHRENHEIT, Double.valueOf(decimalFormat.format(tempFahrenheit)));
    }
}
