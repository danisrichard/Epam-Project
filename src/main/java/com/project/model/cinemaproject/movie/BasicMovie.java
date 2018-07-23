package com.project.model.cinemaproject.movie;

import com.project.model.cinemaproject.cinemastorage.Language;
import com.project.model.cinemaproject.cinemastorage.ScreenTechnologies;

public class BasicMovie{

    private String movieName;
    private int IMDBPoint;
    private Language language;
    private ScreenTechnologies screenTechnologies;
    private int ticketPrice;

    public String getMovieName() {
        return movieName;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public int getIMDBPoint() {
        return IMDBPoint;
    }

    public Language getLanguage() {
        return language;
    }

    public ScreenTechnologies getScreenTechnologies() {
        return screenTechnologies;
    }

    private BasicMovie(Builder builder) {
        movieName = builder.movieName;
        IMDBPoint = builder.IMDBPoint;
        language = builder.language;
        screenTechnologies = builder.screenTechnologies;
    }

    public static final class Builder {
        private String movieName;
        private int IMDBPoint;
        private Language language;
        private ScreenTechnologies screenTechnologies;
        private int ticketPrice;

        public Builder() {
        }

        public Builder movieName(String val) {
            movieName = val;
            return this;
        }

        public Builder ticketPrice(int val){
            ticketPrice = val;
            return this;
        }

        public Builder IMDBPoint(int val) {
            IMDBPoint = val;
            return this;
        }

        public Builder cinemaPrices(Language val) {
            language = val;
            return this;
        }

        public Builder screenTechnologies(ScreenTechnologies val) {
            screenTechnologies = val;
            return this;
        }

        public BasicMovie build() {
            return new BasicMovie(this);
        }
    }
}
