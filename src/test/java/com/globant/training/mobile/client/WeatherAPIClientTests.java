package com.globant.training.mobile.client;

import com.globant.training.mobile.thirdparty.model.WeatherAPIModel;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;
import net.minidev.json.JSONObject;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpVersion;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.message.BasicStatusLine;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.spy;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Unirest.class, Gson.class})
public class WeatherAPIClientTests {
    
    @Mock
    private Gson gson;
    
    @Mock
    private Unirest unirest;
    
    @InjectMocks
    private WeatherAPIClientImpl weatherAPIClient;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testGetWeatherByCity() throws Exception {
        GetRequest request = mock(GetRequest.class);
        HttpRequest httpRequest = mock(HttpRequest.class);
        HttpResponse<JsonNode> mockResponse = mock(HttpResponse.class);
        JsonNode mockNode = mock(JsonNode.class);
        
        /* mock */
        PowerMockito.mockStatic(Unirest.class);
        when(Unirest.get(anyString())).thenReturn(request);
        when(request.queryString(anyString(), anyLong())).thenReturn(httpRequest);
        when(httpRequest.queryString(anyString(), anyString())).thenReturn(httpRequest);
        when(httpRequest.asJson()).thenReturn(mockResponse);
        when(mockResponse.getStatus()).thenReturn(HttpStatus.OK.value());
        when(mockResponse.getBody()).thenReturn(mockNode);
        
        when(gson.fromJson(anyString(), Matchers.<Class<WeatherAPIModel>>any())).thenReturn(new WeatherAPIModel());
        /* run */
        WeatherAPIModel apiModel = weatherAPIClient.getWeatherByCity(new Long(1445));
        
        /* review */
        assertNotNull(apiModel);
    }
    
}
