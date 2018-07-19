package com.project.model.cinemaproject.cinemadecorator.withcanvas;

import com.project.model.cinemaproject.cinemadecorator.BasicCinema;
import com.project.model.cinemaproject.cinemadecorator.Cinema;

public class CinemaCanvas implements Cinema {

    protected BasicCinema basicCinema;

    public CinemaCanvas(BasicCinema basicCinema) {
        this.basicCinema = basicCinema;
    }

    @Override
    public int getCurrenctMoney() {
        return 0;
    }
}
