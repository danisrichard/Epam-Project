package com.project.service;

import com.project.model.City;
import com.project.model.weatherwrapper.Weather;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface WeatherAppService {

    Weather getApixuWeatherByCityName(String cityName) throws IOException;

    Weather getOpenWeatherByCityName(String cityName) throws IOException;

    List<City> getLocationByCityName(String cityName) throws IOException;

    HashMap<String, Double> getDifferencesTwoObject();
}
