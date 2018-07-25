package com.project.service.Impl.cinema;

import com.project.model.cinemaproject.cinemadecorator.Cinema;
import com.project.model.cinemaproject.movie.BasicMovie;
import com.project.model.cinemaproject.movie.extendedMovie.Movie;
import com.project.model.cinemaproject.movie.extendedMovie.CinemaPriceChanceWatch;
import com.project.service.CinemaClubFilmScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

import static com.project.model.cinemaproject.cinemastorage.ScreeningPrices.*;

@Service
public class CinemaClubFilmScreeningServiceImpl implements CinemaClubFilmScreeningService {

    @Override
    public Movie getConcreteMovie(@Valid BasicMovie movie, Cinema cinema) {

        int leaseRights = calculateLeaseRights(movie);
        double popularityIndex = calculatePopularityIndex(movie, cinema);
        double calculateChanceToWatch = calculateChanceToWatch(movie, cinema, popularityIndex, leaseRights);

        return new CinemaPriceChanceWatch.Builder(movie)
                .popularityIndex(popularityIndex)
                .leaseRights(leaseRights)
                .chanceToWatch(calculateChanceToWatch)
                .build();
    }

    private int calculateLeaseRights(BasicMovie movie) {
        return (int) (((movie.getIMDBPoint() + 1) * 150) * ( 1 + (movie.getScreenTechnologies().getScreenTechnologiesInPercent()
                        + movie.getLanguage().getLanguageInPercent())));
    }

    private double calculatePopularityIndex(BasicMovie movie, Cinema cinema) {
        return (movie.getIMDBPoint() * IMDB_MULTIPLIER)
                + (movie.getLanguage().ordinal() * LANGUAGE_MULTIPLIER)
                + movie.getScreenTechnologies().ordinal()
                + (cinema.getPurity() * PURITY_MULTIPLIER);
    }

    private double calculateChanceToWatch(BasicMovie movie, Cinema cinema, double popularityIndex, int leaseRights) {
        return (leaseRights / (Math.log(cinema.getSeatsNumber()) * SEAT_NUMBER_MULTIPLIER))
                * (((popularityIndex / 10) + POPULARITY_INDEX_MULTIPLIER) / movie.getTicketPrice()) * 100;
    }

}
