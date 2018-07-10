package com.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class City implements Serializable {

    private String cityKey;
    private String localizedName;

    //JUST FOR TEST
    public City(String cityKey, String localizedName) {
        this.cityKey = cityKey;
        this.localizedName = localizedName;
    }

    public String getCityKey() {
        return cityKey;
    }

    @JsonProperty("Key")
    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    @JsonProperty("LocalizedName")
    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }
}
