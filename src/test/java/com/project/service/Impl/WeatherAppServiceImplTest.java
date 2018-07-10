package com.project.service.Impl;

import com.project.utils.WeatherApiUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WeatherAppServiceImplTest {

    @Autowired
    private WeatherApiUtil weatherApiUtil;

    @Autowired
    private WeatherAppServiceImpl weatherAppService;

    @Test
    void getLocationByCityName(){
        try {
            weatherAppService.getLocationByCityName("dsa");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}