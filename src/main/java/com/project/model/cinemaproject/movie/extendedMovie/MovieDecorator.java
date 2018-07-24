package com.project.model.cinemaproject.movie.extendedMovie;

import com.project.model.cinemaproject.cinemastorage.Language;
import com.project.model.cinemaproject.cinemastorage.ScreenTechnologies;
import com.project.model.cinemaproject.movie.BasicMovie;

import java.text.DecimalFormat;

public abstract class MovieDecorator implements Movie{

    protected int leaseRights;

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
    public double getChanceToWatch() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return Double.parseDouble(decimalFormat.format(chanceToWatch));
    }

    @Override
    public int getLeaseRights() {
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
