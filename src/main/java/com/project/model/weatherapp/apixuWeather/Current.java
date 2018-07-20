package com.project.model.weatherapp.apixuWeather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Current implements Serializable {

    @JsonProperty("temp_c")
    private int temp_c;
    @JsonProperty("wind_kph")
    private int wind_kph;
    @JsonProperty("wind_degree")
    private double wind_degree;
    @JsonProperty("humidity")
    private int humidty;
    @JsonProperty("cloud")
    private int cloudInPercent;
    @JsonProperty("pressure_mb")
    private double pressure;

    public int getHumidty() {
        return humidty;
    }

    public void setHumidty(int humidty) {
        this.humidty = humidty;
    }

    public int getCloudInPercent() {
        return cloudInPercent;
    }

    public void setCloudInPercent(int cloudInPercent) {
        this.cloudInPercent = cloudInPercent;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public int getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(int temp_c) {
        this.temp_c = temp_c;
    }

    public int getWind_kph() {
        return wind_kph;
    }

    public void setWind_kph(int wind_kph) {
        this.wind_kph = wind_kph;
    }

    public double getWind_degree() {
        return wind_degree;
    }

    public void setWind_degree(double wind_degree) {
        this.wind_degree = wind_degree;
    }
}
