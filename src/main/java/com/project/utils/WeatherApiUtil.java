package com.project.utils;

import com.project.error.WeatherServiceException;
import com.project.model.City;
import com.project.model.weatherapp.apixuWeather.ApixuWeather;
import com.project.model.weatherapp.openWeather.OpenWeather;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.*;
import java.util.*;

@Component
public class WeatherApiUtil {

    private static final Logger logger = LogManager.getLogger(WeatherApiUtil.class);

    @Value("${api.apuxiweather.key}")
    private String APUXI_API_KEY;

    @Value("${api.openweather.key}")
    private String OW_API_KEY;

    @Value("${api.accuweather.key}")
    private String AW_API_KEY;

    //Accuweather
    private final String autoCompleteWithCityKey= "http://dataservice.accuweather.com/locations/v1/cities/autocomplete?apikey={API_KEY}&q={CITY_NAME}&language=en-us";

    // ApuxiWeather section
    private final String currentLocationWeatherApuxiWeather = "http://api.apixu.com/v1/current.json?key={API_KEY}&q={CITY_NAME}";

    //openWeather section
    private final String currentLocationWeatherOpenWeather = "https://api.openweathermap.org/data/2.5/weather?q={CITY_NAME}&appid={ID}&units=metric";


    public List<City> getCityList(String location) throws WeatherServiceException {
        URI uri = new UriTemplate(autoCompleteWithCityKey).expand(AW_API_KEY,location);
        logger.info("citylist uri: {}",uri);
        RestTemplate restTemplate = new RestTemplate();
        return Arrays.asList(Objects.requireNonNull(restTemplate.getForObject(uri, City[].class)));
    }

    public ApixuWeather getApixuWeather(String location) throws WeatherServiceException {
        URI uri = new UriTemplate(currentLocationWeatherApuxiWeather).expand(APUXI_API_KEY, location);
        logger.info("apixuweather: {}", uri);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri.toString(), ApixuWeather.class);
    }

    public OpenWeather getOpenWeather(String location) throws WeatherServiceException {
        URI uri = new UriTemplate(currentLocationWeatherOpenWeather).expand(location, OW_API_KEY);
        logger.info("openweatherlink: {}", uri);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri.toString(), OpenWeather.class);
    }
}
