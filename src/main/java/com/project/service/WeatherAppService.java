package com.project.service;

import com.project.model.City;
import com.project.model.apixuWeather.ApixuWeather;
import com.project.model.openWeather.OpenWeather;

import java.io.IOException;
import java.util.List;

public interface WeatherAppService {

    ApixuWeather getApixuWeatherByCityName(String cityName) throws IOException;

    OpenWeather getOpenWeatherByCityName(String cityName) throws IOException;

    List<City> getLocationByCityName(String cityName) throws IOException;
}
