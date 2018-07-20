package com.project.model.cinemaproject.cinemadecorator.decorator;

import com.project.model.cinemaproject.cinemadecorator.Cinema;

public abstract class CinemaDecorator implements Cinema {

    protected Cinema cinema;

    CinemaDecorator(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public int getCurrentMoney() {
        return this.cinema.getCurrentMoney();
    }

    @Override
    public String getCinemaName() {
        return this.cinema.getCinemaName();
    }

    @Override
    public int getFreePlaceInCinema() {
        return this.cinema.getFreePlaceInCinema();
    }

    @Override
    public void setCinemaName(String cinemaName) {
        this.cinema.setCinemaName(cinemaName);
    }

    @Override
    public void decreaseCurrentMoney(int addMoney) {
        this.cinema.decreaseCurrentMoney(addMoney);
    }

    @Override
    public int getPurity() {
        return this.cinema.getPurity();
    }

    @Override
    public void increaseCurrentMoney(int value) {
        this.cinema.increaseCurrentMoney(value);
    }

    @Override
    public void increasePurityOne() {
        this.cinema.increasePurityOne();
    }

    @Override
    public int getSeatsNumber() {
        return this.cinema.getSeatsNumber();
    }

    @Override
    public void increaseSeatNumberOne() {
        this.cinema.increaseSeatNumberOne();
    }

    @Override
    public int getMaintained() {
        return this.cinema.getMaintained();
    }

    @Override
    public void setMaintained(int maintained) {
        this.cinema.setMaintained(maintained);
    }
}
