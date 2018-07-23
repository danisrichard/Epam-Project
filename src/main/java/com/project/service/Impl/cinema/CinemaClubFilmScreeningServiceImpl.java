package com.project.service.Impl.cinema;

import com.project.model.cinemaproject.cinemadecorator.Cinema;
import com.project.model.cinemaproject.movie.BasicMovie;
import com.project.model.cinemaproject.movie.extendedMovie.Movie;
import com.project.model.cinemaproject.movie.extendedMovie.CinemaPriceChanceWatch;
import com.project.service.CinemaClubFilmScreeningService;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

import static com.project.model.cinemaproject.cinemastorage.ScreeningPrices.*;

@Service
public class CinemaClubFilmScreeningServiceImpl implements CinemaClubFilmScreeningService {

    // movie extendedMovie pattern erre nem jó -> 2018.07.24

    @Override
    public Movie getConcreteMovie(@Valid BasicMovie movie, Cinema cinema) {

        int filmPrice = calculateLeaseRights(movie);
        double popularityIndex = calculatePopularityIndex(movie, cinema);
        double calculateChanceToWatch = calculateChanceToWatch(movie,cinema,popularityIndex);

        return new CinemaPriceChanceWatch.Builder(movie)
                .popularityIndex(popularityIndex)
                .leaseRights(calculateLeaseRights(movie))
                .chanceToWatch(0)
                .build();
    }

    private int calculateLeaseRights(@Valid BasicMovie movie) {
        return ((movie.getIMDBPoint() + 1) * 150) * (movie.getScreenTechnologies()
                .getScreenTechnologiesInPercent()
                + movie.getLanguage()
                .getLanguageInPercent());
    }

    private double calculateChanceToWatch(@Valid BasicMovie movie, Cinema cinema, double popularityIndex) {
        return
    }

    private int calculateProfit(Movie movie) {
        return 0;
    }

    private double calculatePopularityIndex(@Valid BasicMovie movie, Cinema cinema) {
        return (movie.getIMDBPoint() * IMDB_MULTIPLIER)
                + (movie.getLanguage().getLanguageInPercent() * LANGUAGE_PRICE)
                + movie.getScreenTechnologies().getScreenTechnologiesInPercent()
                + (cinema.getPurity() * PURITY_MULTIPLIER);
    }

}
