package com.project.service.Impl;

import com.project.model.City;
import com.project.model.apixuWeather.ApixuWeather;
import com.project.model.openWeather.OpenWeather;
import com.project.service.WeatherAppService;
import com.project.utils.WeatherApiUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherAppServiceImpl implements WeatherAppService {

    private static final Logger logger = LogManager.getLogger(WeatherAppService.class);

    @Autowired
    private WeatherApiUtil weatherApiUtil;

    @Override
    public List<City> getLocationByCityName(String cityName) throws IOException {
        List<City> cityList = new ArrayList<>();
        cityList.add(new City("295212","Szentpétervár"));
        cityList.add(new City("224683","Szendai"));
        return cityList;
    }

    @Override
    public OpenWeather getOpenWeatherByCityName(String cityName)throws IOException{
        return weatherApiUtil.getOpenWeather(cityName);
    }

    @Override
    public ApixuWeather getApixuWeatherByCityName(String cityId) throws IOException {
        return weatherApiUtil.getApixuWeather("dsa");
    }

}
