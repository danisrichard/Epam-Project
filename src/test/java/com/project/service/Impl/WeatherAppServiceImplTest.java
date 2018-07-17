package com.project.service.Impl;

import com.project.error.WeatherServiceException;
import com.project.model.City;
import com.project.model.weatherwrapper.Weather;
import com.project.utils.WeatherApiUtil;
import com.project.utils.WeatherBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class WeatherAppServiceImplTest {

    @Mock
    private WeatherApiUtil weatherApiUtil;

    @Mock
    private WeatherBuilder weatherBuilder;

    @InjectMocks
    private WeatherAppServiceImpl weatherAppService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getLocationByValidCityNameAndReturnOneListSize() throws WeatherServiceException {
        List<City> oneElementList = weatherAppService.getLocationByCityName("Szeged");
        assertEquals(1,oneElementList.size());
    }

    @Test
    void getOpenWeatherByCityName() {
    }

    @Test
    void getWeatherShouldNotNullWhenUsingValidCityName() throws WeatherServiceException {
        Weather we = weatherAppService.getOpenWeatherByCityName("Szeged");
        assertNotNull(we);
    }

    @Test
    void getDifferencesTwoObject() {
    }
}