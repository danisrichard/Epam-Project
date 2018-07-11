package com.project.utils;

import com.project.model.weatherwrapper.Weather;
import com.project.model.apixuWeather.ApixuWeather;
import com.project.model.openWeather.OpenWeather;
import org.springframework.stereotype.Component;

@Component
public class WeatherBuilder {

    public Weather buildWeatherModelFromApixuW(ApixuWeather apixuWeather){
        return new Weather.Builder(apixuWeather.getAPI_NAME())
                                .withCloudInPercent(apixuWeather.getCurrent().getCloudInPercent())
                                .withHumidityInPercent(apixuWeather.getCurrent().getHumidty())
                                .withPressure(apixuWeather.getCurrent().getPressure())
                                .withTempInCelsius(apixuWeather.getCurrent().getTemp_c())
                                .withWind_degree(apixuWeather.getCurrent().getWind_degree())
                                .withWind_speed(apixuWeather.getCurrent().getWind_kph())
                                .build();
    }

    public Weather buildWeatherModelFromOpenW(OpenWeather openWeather){
        return new Weather.Builder(openWeather.getApiName())
                                .withCloudInPercent(openWeather.getCloud().getCloudInPercent())
                                .withHumidityInPercent(openWeather.getMainData().getHumidity())
                                .withPressure(openWeather.getMainData().getPressure())
                                .withTempInCelsius(openWeather.getMainData().getTemp())
                                .withWind_degree(openWeather.getWindData().getWindDeg())
                                .withWind_speed(openWeather.getWindData().getSpeed())
                                .build();
    }
}
