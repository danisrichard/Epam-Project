package com.project.error;

public class WeatherServiceException extends Exception {

    public WeatherServiceException(){
        super();
    }

    public WeatherServiceException(final String cityName){
        super(cityName);
    }
}
