package com.project.model.cinemaproject.cinemadecorator;

public interface Cinema {

    int getCurrentMoney();

    String getCinemaName();

    void setCinemaName(String cinemaName);

    void decreaseCurrentMoney(int value);

    void increaseCurrentMoney(int value);

    int getPurity();

    void increasePurityOne();

    int getSeatsNumber();

    void increaseSeatNumberOne();

    int getMaintained();

    void setMaintained(int maintained);

    int getFreePlaceInCinema();

}
