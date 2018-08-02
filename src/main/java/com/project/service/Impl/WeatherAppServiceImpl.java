package com.project.service.Impl;

import com.project.error.WeatherServiceException;
import com.project.model.City;
import com.project.model.weatherapp.weatherwrapper.Weather;
import com.project.service.WeatherAppService;
import com.project.utils.weather.WeatherApiUtil;
import com.project.utils.weather.WeatherBuilder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.Diff;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<City> getLocationByCityName(String cityName) throws WeatherServiceException {
        return Collections.unmodifiableList(weatherApiUtil.getCityList(cityName));
    }

    @Override
    public Weather getOpenWeatherByCityName(String cityName) throws WeatherServiceException {
        openWeather = weatherBuilder.buildWeatherModelFromOpenW(weatherApiUtil.getOpenWeather(StringUtils.stripAccents(cityName)));
        return openWeather;
    }

    @Override
    public Weather getApixuWeatherByCityName(String cityName) throws WeatherServiceException {
        apuxiWeather = weatherBuilder.buildWeatherModelFromApixuW(weatherApiUtil.getApixuWeather(StringUtils.stripAccents(cityName)));
        return apuxiWeather;
    }

    @Override
    public HashMap<String, Double> getDifferencesTwoObject() {
        DiffResult diff = apuxiWeather.diff(openWeather);
        return diff.getDiffs()
                     .stream()
                     .collect(Collectors.toMap(Diff::getFieldName, d -> (Double) d.getLeft() - (Double) d.getRight(), (a, b) -> b, HashMap::new));
    }
}
