package com.project.service.Impl.cinema;

import com.project.model.cinemaproject.cinemadecorator.BasicCinema;
import com.project.model.cinemaproject.cinemadecorator.Cinema;
import com.project.model.cinemaproject.cinemadecorator.decorator.CinemaCanvas;
import com.project.model.cinemaproject.cinemadecorator.decorator.ThreeDProjectorCinema;
import com.project.model.cinemaproject.cinemastorage.Language;
import com.project.model.cinemaproject.cinemastorage.ScreenTechnologies;
import com.project.model.cinemaproject.movie.BasicMovie;
import com.project.model.cinemaproject.movie.extendedMovie.Movie;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CinemaClubFilmScreeningServiceImplUnitTest {

    @Autowired
    private CinemaClubFilmScreeningServiceImpl cinemaClubFilmScreeningService;

    private Cinema cinema;

    private BasicMovie basicMovie;

    private final int LEASE_RIGHT_PRICE = 720;
    private final double POPULARITY_INDEX = 6.4;
    private final double CHANCE_TO_WATCH = 100.33;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        cinema = new BasicCinema();
        cinema.setCinemaName("dsa");
        cinema.increaseCurrentMoney(5000);


        /*
        basicMovie = new BasicMovie.Builder()
                .movieName("dsa")
                .cinemaPrices(Language.HUNGARY_SYNC)
                .IMDBPoint(3)
                .screenTechnologies(ScreenTechnologies.THREE_D)
                .ticketPrice(80)
                .build();
                */
    }

    @Test
    public void testgetConcreteMovieWhenShouldReturnPopularityIndex() {
        Movie movie = cinemaClubFilmScreeningService.getConcreteMovie(basicMovie, cinema);

        double popularityIndex = movie.getPopularityIndex();

        assertEquals(popularityIndex,POPULARITY_INDEX);
    }

    @Test
    public void testgetConcreteMovieWhenValidInputShouldReturnValidLeaseRights() {
        Movie movie = cinemaClubFilmScreeningService.getConcreteMovie(basicMovie, cinema);

        int leaseRights = movie.getLeaseRights();

        assertEquals(leaseRights,LEASE_RIGHT_PRICE);
    }

    @Test
    public void testgetConcreteMovieWhenValidInputShouldReturnValidChanceToWatch() {
        Movie movie = cinemaClubFilmScreeningService.getConcreteMovie(basicMovie, cinema);

        double popularityIndex = movie.getChanceToWatch();

        assertEquals(popularityIndex,CHANCE_TO_WATCH);
    }

    @Test
    public void testshit(){

        Cinema cinema1 = new ThreeDProjectorCinema(new BasicCinema());

        cinema1.setCinemaName("dsadsa");
        cinema1.increaseCurrentMoney(200000);
        cinema1.increaseFloorAreaOne();

        Cinema dsa = new CinemaCanvas(new ThreeDProjectorCinema(new BasicCinema()));



        System.out.println(cinema1.getCinemaName());
        System.out.println(cinema1.getCurrentMoney());

        System.out.println(dsa.getCinemaName() + " " + cinema1.getCinemaName());

    }


}