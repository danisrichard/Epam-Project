package com.project.utils;

import com.project.model.City;
import com.project.model.openWeather.OpenWeather;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Component
public class WeatherApiUtil {

    private static final Logger logger = LogManager.getLogger(WeatherApiUtil.class);

    @Value("${api.accuweather.key}")
    private String AW_API_KEY;

    @Value("${api.openweather.key}")
    private String OW_API_KEY;

    // AccuWeather section
    private String autoCompleteWithCityKey= "http://dataservice.accuweather.com/locations/v1/cities/autocomplete?apikey={API_KEY}&q={CITY_NAME}&language=hu-HU";
    private final String currentLocationWeatherAccuWeather= "http://dataservice.accuweather.com/currentconditions/v1/187706?apikey=q26cLadqdhGBKDsFqeiGwEYVNhJGKHyW&language=hu-HU";

    //openWeather section
    private final String currentLocationWeatherOpenWeather = "https://api.openweathermap.org/data/2.5/weather?q={CITY_NAME}&appid={ID}";

    public List<City> getCityList(String location) throws IOException {
        URI uri = new UriTemplate(autoCompleteWithCityKey).expand(AW_API_KEY,location);
        logger.info("citylist uri: {}",uri);

        RestTemplate restTemplate = new RestTemplate();
        return Arrays.asList(restTemplate.getForObject(uri,City[].class));
    }

    public OpenWeather getOpenWeather(String location) throws IOException{
        URI uri = new UriTemplate(currentLocationWeatherOpenWeather).expand(location,OW_API_KEY);
        logger.info("openweatherlink: {}", uri);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri.toString(),OpenWeather.class);
    }

    /*
    public Object getAccuWeather(String locationKey) throws IOException {
        URI uri = new UriTemplate(currentLocationWeatherAccuWeather).expand(AW_API_KEY, locationKey);
        logger.info("accuweatherlink: {}", uri);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, OpenWeather.class);
    }
    */
}
