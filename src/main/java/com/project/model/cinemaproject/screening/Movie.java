package com.project.model.cinemaproject.screening;

import com.project.model.cinemaproject.cinemastorage.CinemaPrices;
import com.project.model.cinemaproject.cinemastorage.ScreenTechnologies;

public class Movie {

    private String movieName;
    private int IMDBPoint;
    private CinemaPrices cinemaPrices;
    private ScreenTechnologies screenTechnologies;

    private Movie(Builder builder) {
        movieName = builder.movieName;
        IMDBPoint = builder.IMDBPoint;
        cinemaPrices = builder.cinemaPrices;
        screenTechnologies = builder.screenTechnologies;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getIMDBPoint() {
        return IMDBPoint;
    }

    public CinemaPrices getCinemaPrices() {
        return cinemaPrices;
    }

    public ScreenTechnologies getScreenTechnologies() {
        return screenTechnologies;
    }

    public static final class Builder {
        private String movieName;
        private int IMDBPoint;
        private CinemaPrices cinemaPrices;
        private ScreenTechnologies screenTechnologies;

        public Builder() {
        }

        public Builder movieName(String val) {
            movieName = val;
            return this;
        }

        public Builder IMDBPoint(int val) {
            IMDBPoint = val;
            return this;
        }

        public Builder cinemaPrices(CinemaPrices val) {
            cinemaPrices = val;
            return this;
        }

        public Builder screenTechnologies(ScreenTechnologies val) {
            screenTechnologies = val;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
