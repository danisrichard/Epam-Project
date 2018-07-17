package com.project.service;

import com.project.error.WeatherServiceException;
import com.project.model.City;
import com.project.model.weatherwrapper.Weather;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface WeatherAppService {

    Weather getApixuWeatherByCityName(String cityName) throws WeatherServiceException;

    Weather getOpenWeatherByCityName(String cityName) throws WeatherServiceException;

    List<City> getLocationByCityName(String cityName) throws WeatherServiceException;

    HashMap<String, Double> getDifferencesTwoObject();
}
