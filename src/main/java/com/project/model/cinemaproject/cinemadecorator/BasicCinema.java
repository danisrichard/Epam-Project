package com.project.model.cinemaproject.cinemadecorator;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class BasicCinema implements Cinema {

    protected String cinemaName;
    protected int currentMoney;
    @Max(100)
    @Min(0)
    protected int purity;
    protected int seats;
    @Max(100)
    @Min(0)
    protected int maintained;
    protected int floorArea;

    public BasicCinema() {
        this.purity = 100;
        this.seats = 0;
        this.maintained = 100;
        this.floorArea = 20;
    }

    @Override
    public int getFreePlaceInCinema() {
        return floorArea - seats;
    }

    @Override
    public int getCurrentMoney() {
        return currentMoney;
    }

    @Override
    public String getCinemaName() {
        return cinemaName;
    }

    @Override
    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    @Override
    public void decreaseCurrentMoney(int value) {
        this.currentMoney -= value;
    }

    @Override
    public void increaseCurrentMoney(int value) {
        this.currentMoney += value;
    }

    @Override
    public int getPurity() {
        return purity;
    }

    @Override
    public void increaseFloorAreaOne() {
        this.floorArea += 1;
    }

    @Override
    public int getSeatsNumber() {
        return seats;
    }

    @Override
    public void increaseSeatNumberOne() {
        this.seats++;
    }

    @Override
    public int getMaintained() {
        return maintained;
    }

    @Override
    public void setMaintained(int maintained) {
        this.maintained = maintained;
    }

}
