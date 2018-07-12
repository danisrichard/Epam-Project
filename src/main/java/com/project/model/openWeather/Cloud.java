package com.project.model.openWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cloud {

    @JsonProperty("all")
    private int cloudInPercent;

    public int getCloudInPercent() {
        return cloudInPercent;
    }

    public void setCloudInPercent(int cloudInPercent) {
        this.cloudInPercent = cloudInPercent;
    }
}
