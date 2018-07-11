package com.project.utils;

import com.project.model.City;
import com.project.model.apixuWeather.ApixuWeather;
import com.project.model.openWeather.OpenWeather;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.io.IOException;
import java.net.*;
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
    private final String autoCompleteWithCityKey= "http://dataservice.accuweather.com/locations/v1/cities/autocomplete?apikey={API_KEY}&q={CITY_NAME}&language=en-us";
    private final String currentLocationWeatherAccuWeather= "http://api.apixu.com/v1/current.json?key=0c00e7a0ab794d1c9c5141506181007&q=Szeged";

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

    public ApixuWeather getApixuWeather(String location) throws IOException{
        URI uri = new UriTemplate(currentLocationWeatherAccuWeather).expand(location,OW_API_KEY);
        logger.info("apixuweather: {}", uri);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri.toString(),ApixuWeather.class);
    }

    /*
    public AccuWeather getAccuWeather(String locationKey) throws IOException {
        URI uri = new UriTemplate(currentLocationWeatherAccuWeather).expand(locationKey, AW_API_KEY);
        logger.info(uri);
        RestTemplate restTemplate = new RestTemplate();
        Gson gson = new Gson();

        URL url = new URL(uri.toString());
        URLConnection request = url.openConnection();
        request.connect();
        String json = getJson(request);


        try {

            restTemplate.getForObject(json,AccuWeather[].class);

        }catch (Exception e){
            logger.info(e.getMessage());
        }

        return null;
    }

    private String getJson(URLConnection request) throws IOException {
        JsonParser jp = new JsonParser ();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        return root.getAsJsonArray().getAsJsonArray().toString();
    }
    */
}
