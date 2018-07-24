package com.project.model.cinemaproject.movie.extendedMovie;

import com.project.model.cinemaproject.cinemastorage.Language;
import com.project.model.cinemaproject.cinemastorage.ScreenTechnologies;

public interface Movie {
    String getMovieName();
    int getIMDBPoint();
    Language getLanguage();
    ScreenTechnologies getScreenTechnologies();
    double getPopularityIndex();
    double getChanceToWatch();
    int getLeaseRights();
    int getTicketPrice();
}
