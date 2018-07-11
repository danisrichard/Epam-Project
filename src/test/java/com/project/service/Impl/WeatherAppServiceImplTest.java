package com.project.service.Impl;

import com.project.model.weatherwrapper.Weather;
import com.project.service.WeatherAppService;
import com.project.utils.WeatherApiUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.MockitoAnnotations.initMocks;

@WebAppConfiguration
@RunWith(MockitoJUnitRunner.class)
class WeatherAppServiceImplTest {

    @Mock
    private WeatherApiUtil weatherApiUtil;

    @Mock
    private WeatherAppService weatherAppService;

    @BeforeClass
    void init(){
        initMocks(this);
    }

    @Test
    void getLocationByCityName(){
        try {
            weatherAppService.getLocationByCityName("dsa");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getWeatherObjectByCityName(){
        Weather weather = null;

        try {
             weather = weatherAppService.getApixuWeatherByCityName("Szeged");
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(weather);
    }
}