package com.project.service;

import com.project.model.City;
import com.project.model.openWeather.OpenWeather;

import java.io.IOException;
import java.util.List;

public interface WeatherAppService {

    //AccuWeather getAccuWeatherByCityId(String cityId);

    OpenWeather getOpenWeatherByCityName(String cityName) throws IOException;

    List<City> getLocationByCityName(String cityName) throws IOException;
}
