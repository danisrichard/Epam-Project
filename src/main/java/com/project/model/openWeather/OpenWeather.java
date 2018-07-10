package com.project.model.openWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.model.MainData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeather implements Serializable {

    private static final Logger logger = LogManager.getLogger(OpenWeather.class);

    private static final String API_NAME = "OPEN_WEATHER";

    @JsonProperty("name")
    private String cityName;
    @JsonProperty("main")
    private MainData mainData;
    @JsonProperty("wind")
    private WindData windData;

    public OpenWeather() {
    }

    public MainData getMainData() {
        return mainData;
    }

    public static String getApiName() {
        return API_NAME;
    }

    public void setMainData(MainData mainData) {
        this.mainData = mainData;
    }

    public WindData getWindData() {
        return windData;
    }

    public void setWindData(WindData windData) {
        this.windData = windData;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}