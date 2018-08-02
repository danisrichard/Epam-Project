package com.project.service.cinema;

import com.project.model.cinemaproject.cinemadecorator.Cinema;
import com.project.model.cinemaproject.movie.BasicMovie;
import com.project.model.cinemaproject.movie.extendedMovie.Movie;

import javax.validation.Valid;

public interface CinemaClubFilmScreeningService {

    Movie getConcreteMovie(@Valid BasicMovie movie, Cinema cinema);
}
