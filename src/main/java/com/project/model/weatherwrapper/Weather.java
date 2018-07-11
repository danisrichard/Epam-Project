package com.project.model.weatherwrapper;

import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Weather implements Diffable<Weather> {

    private String API_NAME;
    private int cloudInPercent;
    private int tempInCelsius;
    private double humidityInPercent;
    private double pressure;
    private int wind_speed;
    private double wind_degree;

    public Weather(Builder builder) {
        this.API_NAME = builder.API_NAME;
        this.cloudInPercent = builder.cloudInPercent;
        this.tempInCelsius = builder.tempInCelsius;
        this.humidityInPercent = builder.humidityInPercent;
        this.pressure = builder.pressure;
        this.wind_speed = builder.wind_speed;
        this.wind_degree = builder.wind_degree;
    }

    @Override
    public DiffResult diff(Weather weather) {
        return new DiffBuilder(this,weather,ToStringStyle.DEFAULT_STYLE)
                .append("cloudInPercent",this.cloudInPercent,weather.cloudInPercent)
                .append("tempInCelsius",this.tempInCelsius,weather.tempInCelsius)
                .append("humidityInPercent",this.humidityInPercent,weather.humidityInPercent)
                .append("pressure",this.pressure,weather.pressure)
                .append("wind_speed",this.wind_speed, weather.wind_speed)
                .append("wind_degree",this.wind_degree, weather.wind_degree)
                .build();
    }

    public static class Builder {

        private String API_NAME;
        private int cloudInPercent;
        private int tempInCelsius;
        private double humidityInPercent;
        private double pressure;
        private int wind_speed;
        private double wind_degree;

        public Builder(String api_name) {
            this.API_NAME = api_name;
        }

        public Builder withCloudInPercent(int cloudInPercent) {
            this.cloudInPercent = cloudInPercent;
            return this;
        }

        public Builder withTempInCelsius(int tempInCelsius) {
            this.tempInCelsius = tempInCelsius;
            return this;
        }

        public Builder withHumidityInPercent(double humidityInPercent) {
            this.humidityInPercent = humidityInPercent;
            return this;
        }

        public Builder withPressure(double pressure) {
            this.pressure = pressure;
            return this;
        }

        public Builder withWind_speed(int wind_speed) {
            this.wind_speed = wind_speed;
            return this;
        }

        public Builder withWind_degree(double wind_degree) {
            this.wind_degree = wind_degree;
            return this;
        }

        public Weather build() {
            return new Weather(this);
        }
    }

    public String getAPI_NAME() {
        return API_NAME;
    }

    public int getCloudInPercent() {
        return cloudInPercent;
    }

    public int getTempInCelsius() {
        return tempInCelsius;
    }

    public double getHumidityInPercent() {
        return humidityInPercent;
    }

    public double getPressure() {
        return pressure;
    }

    public int getWind_speed() {
        return wind_speed;
    }

    public double getWind_degree() {
        return wind_degree;
    }

    @Override
    public String toString() {
        return "weatherwrapper{" +
                "API_NAME='" + API_NAME + '\'' +
                ", cloudInPercent=" + cloudInPercent +
                ", tempInCelsius=" + tempInCelsius +
                ", humidityInPercent=" + humidityInPercent +
                ", pressure=" + pressure +
                ", wind_speed=" + wind_speed +
                ", wind_degree=" + wind_degree +
                '}';
    }
}
