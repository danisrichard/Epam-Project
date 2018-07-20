package com.project.model.weatherapp.weatherwrapper;

import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Weather implements Diffable<Weather> {

    private String API_NAME;
    private double cloudInPercent;
    private double tempInCelsius;
    private double humidityInPercent;
    private double pressure;
    private double wind_speed;
    private double wind_degree;

    private Weather(Builder builder) {
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
                .append("Cloud in Percent:",this.cloudInPercent,weather.cloudInPercent)
                .append("Temperature:",this.tempInCelsius,weather.tempInCelsius)
                .append("Humidity:",this.humidityInPercent,weather.humidityInPercent)
                .append("Pressure:",this.pressure,weather.pressure)
                .append("Wind speed:",this.wind_speed, weather.wind_speed)
                .append("Wind degree:",this.wind_degree, weather.wind_degree)
                .build();
    }

    public static class Builder {

        private String API_NAME;
        private int cloudInPercent;
        private int tempInCelsius;
        private double humidityInPercent;
        private double pressure;
        private double wind_speed;
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

        public Builder withWind_speed(double wind_speed) {
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

    public double getCloudInPercent() {
        return cloudInPercent;
    }

    public double getTempInCelsius() {
        return tempInCelsius;
    }

    public double getHumidityInPercent() {
        return humidityInPercent;
    }

    public double getPressure() {
        return pressure;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public double getWind_degree() {
        return wind_degree;
    }
}
