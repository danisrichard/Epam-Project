package com.project.model.openWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeather implements Serializable {

    private String api_name = "OPEN_WEATHER";
    @JsonProperty("main")
    private MainData mainData;
    @JsonProperty("wind")
    private WindData windData;
    @JsonProperty("clouds")
    private Cloud cloud;

    public Cloud getCloud() {
        return cloud;
    }

    public void setCloud(Cloud cloud) {
        this.cloud = cloud;
    }

    public MainData getMainData() {
        return mainData;
    }

    public String getApiName() {
        return api_name;
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

}