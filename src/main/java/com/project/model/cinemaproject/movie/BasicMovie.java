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

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setIMDBPoint(int IMDBPoint) {
        this.IMDBPoint = IMDBPoint;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setScreenTechnologies(ScreenTechnologies screenTechnologies) {
        this.screenTechnologies = screenTechnologies;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "BasicMovie{" +
                "movieName='" + movieName + '\'' +
                ", IMDBPoint=" + IMDBPoint +
                ", language=" + language +
                ", screenTechnologies=" + screenTechnologies +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
