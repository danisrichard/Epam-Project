package com.project.controller;

import com.project.error.WeatherServiceException;
import com.project.model.error.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandlerControllerAdvice {

    @ExceptionHandler(WeatherServiceException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody
    ExceptionResponse handleWeatherServiceNotFoundCityName(final WeatherServiceException wse, final HttpServletRequest httpServletRequest) {
        return new ExceptionResponse.Builder()
                .withErrorMessage(String.format("%s is not found", wse.getMessage()))
                .withRequestedURI(httpServletRequest.getRequestURI())
                .build();
    }
}
