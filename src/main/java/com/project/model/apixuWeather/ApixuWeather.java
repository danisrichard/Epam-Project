package com.project.model.apixuWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApixuWeather implements Serializable {

    private static final String API_NAME = "APIXU_WEATHER";
    @JsonProperty("current")
    private Current current;

    public static String getApiName() {
        return API_NAME;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

}
