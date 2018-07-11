package com.project.service.Impl;

import com.project.model.City;
import com.project.model.openWeather.OpenWeather;
import com.project.model.weatherwrapper.Weather;
import com.project.service.WeatherAppService;
import com.project.utils.WeatherApiUtil;
import com.project.utils.WeatherBuilder;
import javafx.util.Pair;
import org.apache.commons.lang3.builder.Diff;
import org.apache.commons.lang3.builder.DiffResult;
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

    @Autowired
    private WeatherBuilder weatherBuilder;

    private Weather apuxiWeather;
    private Weather openWeather;

    @Override
    public List<City> getLocationByCityName(String cityName) throws IOException {
        List<City> cityList = new ArrayList<>();
        cityList.add(new City("295212", "Szentpétervár"));
        cityList.add(new City("224683", "Szendai"));
        return cityList;
    }

    @Override
    public Weather getOpenWeatherByCityName(String cityName) throws IOException {
        openWeather = weatherBuilder.buildWeatherModelFromOpenW(weatherApiUtil.getOpenWeather(cityName));
        return openWeather;
    }

    @Override
    public Weather getApixuWeatherByCityName(String cityName) throws IOException {
        apuxiWeather = weatherBuilder.buildWeatherModelFromApixuW(weatherApiUtil.getApixuWeather(cityName));
        return apuxiWeather;
    }

    @Override
    public Diff getDifferencesTwoObject() {

        DiffResult diff = apuxiWeather.diff(openWeather);

        diff.getDiffs().stream().map(d -> "Left: " + d.getLeft() + " - Right:" + d.getRight()).forEach(System.out::println);

        return null;
    }
}