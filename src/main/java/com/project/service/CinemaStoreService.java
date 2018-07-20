package com.project.service;

import com.project.model.cinemaproject.cinemadecorator.Cinema;

public interface CinemaStoreService {

    public Cinema getCinema();

    public void createNewCinema(Cinema cinema);
}
