package com.project.model.cinemaproject.movie.extendedMovie;

import com.project.model.cinemaproject.cinemastorage.Language;
import com.project.model.cinemaproject.cinemastorage.ScreenTechnologies;
import com.project.model.cinemaproject.movie.BasicMovie;

public abstract class MovieDecorator implements Movie{

    protected double leaseRights;

    protected double popularityIndex;

    protected double chanceToWatch;

    protected int filmPrice;

    protected BasicMovie movie;

    protected MovieDecorator() {
    }

    @Override
    public int getTicketPrice() {
        return movie.getTicketPrice();
    }

    @Override
    public double getPopularityIndex() {
        return popularityIndex;
    }

    @Override
    public int getFilmPrice() {
        return filmPrice;
    }

    @Override
    public double getChanceToWatch() {
        return chanceToWatch;
    }

    @Override
    public double getLeaseRights() {
        return leaseRights;
    }

    @Override
    public String getMovieName() {
        return movie.getMovieName();
    }

    @Override
    public int getIMDBPoint() {
        return movie.getIMDBPoint();
    }

    @Override
    public Language getLanguage() {
        return movie.getLanguage();
    }

    @Override
    public ScreenTechnologies getScreenTechnologies() {
        return movie.getScreenTechnologies();
    }
}
