package com.project.model.accuWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccuWeather implements Serializable {
    private Temperature temperature;
    private Imperial imperial;
    private String weatherText;
}
