package com.project.model.cinemaproject.cinemadecorator.withcanvas.withprojector;

import com.project.model.cinemaproject.cinemadecorator.Cinema;
import com.project.model.cinemaproject.cinemadecorator.withcanvas.CinemaCanvas;

public class TwoDProjectorCinema implements Cinema {

    protected CinemaCanvas cinemaCanvas;

    public TwoDProjectorCinema(CinemaCanvas cinemaCanvas) {
        this.cinemaCanvas = cinemaCanvas;
    }

    @Override
    public int getCurrenctMoney() {
        return 0;
    }
}
