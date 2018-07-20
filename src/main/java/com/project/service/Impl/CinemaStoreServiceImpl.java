package com.project.service.Impl;

import com.project.model.cinemaproject.cinemadecorator.Cinema;
import com.project.service.CinemaStoreService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class CinemaStoreServiceImpl implements CinemaStoreService {

    private Cinema cinema;

    public Cinema getCinema(){
        return cinema;
    }

    public void createNewCinema(Cinema cinema){
        this.cinema = cinema;
    }

}
