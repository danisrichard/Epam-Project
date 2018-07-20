package com.project.model.cinemaproject.cinemadecorator.decorator;

import com.project.model.cinemaproject.cinemadecorator.Cinema;

public class CinemaCanvas extends CinemaDecorator {

    private final static int CANVAS_FREE_PLACE = 5;

    public CinemaCanvas(Cinema cinema) {
        super(cinema);
    }

    @Override
    public int getFreePlaceInCinema() {
        return super.getFreePlaceInCinema() - CANVAS_FREE_PLACE;
    }
}
