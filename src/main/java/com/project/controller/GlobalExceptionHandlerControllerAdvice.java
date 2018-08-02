package com.project.controller;

import com.project.error.NotEnoughFreePlaceException;
import com.project.error.NotEnoughMoneyException;
import com.project.error.NotFoundThisMobileException;
import com.project.error.WeatherServiceException;
import com.project.model.error.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
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

    @ExceptionHandler(NotEnoughFreePlaceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ExceptionResponse handleCinemaHasntGotEnoughFreePlace(final NotEnoughFreePlaceException wse, final HttpServletRequest httpServletRequest) {
        return new ExceptionResponse.Builder()
                .withErrorMessage(wse.getMessage())
                .withRequestedURI(httpServletRequest.getRequestURI())
                .build();
    }

    @ExceptionHandler(NotEnoughMoneyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody
    ExceptionResponse handleCinemaHasntGotEnoughMoney(final NotEnoughMoneyException wse, final HttpServletRequest httpServletRequest) {
        return new ExceptionResponse.Builder()
                .withErrorMessage(wse.getMessage())
                .withRequestedURI(httpServletRequest.getRequestURI())
                .build();
    }

    @ExceptionHandler(NotFoundThisMobileException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundMobileInRepository(final NotFoundThisMobileException wse, final HttpServletRequest httpServletRequest, Model model) {
        model.addAttribute("exception", new ExceptionResponse.Builder().build());
        return "mobile-section/mobile-index";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundPage() {
        return "404";
    }
}
