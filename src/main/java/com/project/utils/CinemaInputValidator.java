package com.project.utils;

import com.project.error.NotEnoughFreePlaceException;
import com.project.error.NotEnoughMoneyException;
import com.project.model.cinemaproject.cinemadecorator.Cinema;
import org.springframework.stereotype.Component;

@Component
public class CinemaInputValidator {

    public boolean cinemaFreePlacesChecker(Cinema cinema, int requiredFreePlace) throws NotEnoughFreePlaceException {
        if (cinema.getFreePlaceInCinema() >= requiredFreePlace) {
            return true;
        }
        throw new NotEnoughFreePlaceException("Not enough place");
    }

    public boolean checkEnoughCurrency(Cinema cinema, int itemPrice) throws NotEnoughMoneyException {
        if (itemPrice <= cinema.getCurrentMoney()) {
            return true;
        }
        throw new NotEnoughMoneyException("Not enough money");
    }
}