package com.project.controller;

import com.project.model.cinemaproject.cinemadecorator.BasicCinema;
import com.project.model.cinemaproject.cinemadecorator.Cinema;
import com.project.model.cinemaproject.movie.BasicMovie;
import com.project.model.cinemaproject.movie.extendedMovie.Movie;
import com.project.service.cinema.CinemaClubEquipmentService;
import com.project.service.cinema.CinemaClubFilmScreeningService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

import javax.validation.Valid;

@Controller
@SessionScope
@RequestMapping("/cinema")
public class CinemaClubController {

    private static final Logger logger = LogManager.getLogger(CinemaClubController.class);

    private Cinema cinema = new BasicCinema();

    private Movie movie;

    @Autowired
    private CinemaClubFilmScreeningService cinemaClubFilmScreeningService;

    @Autowired
    private CinemaClubEquipmentService cinemaClubService;

    @GetMapping
    public String getCinemaIndexPage() {
        return "cinema/cinema-index";
    }

    @RequestMapping(value = "/create-cinema", method = RequestMethod.GET)
    public String createCinema(@RequestParam(required = false, value = "cinemaName") String value) {
        cinema.setCinemaName(value);
        return "cinema/tutorial/tutorial";
    }

    @GetMapping("/cinema-management")
    public String manageCinema(Model model) {
        model.addAttribute("cinema", cinema);
        model.addAttribute("movie", new BasicMovie());
        model.addAttribute("equipment", cinemaClubService.getAllEquipment());
        return "cinema/management/cinema-management-index";
    }

    @PostMapping("/movie")
    public String checkMovieInfos(@Valid BasicMovie basicMovie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.info("error");
        }
        movie = cinemaClubFilmScreeningService.getConcreteMovie(basicMovie, cinema);
        return "redirect:/cinema/management/cinema-management-index";
    }

    @RequestMapping(value = "/equipment/{id}", method = RequestMethod.GET)
    public String equipmentPage(Model model, @PathVariable String id) {
        logger.info(id);
        return "redirect:/cinema/cinema-management";
    }

    @GetMapping("/maintain")
    public String maintainCinema() {
        return "redirect:/cinema/cinema-management";
    }

    @GetMapping("/nextday")
    public String nextDay() {
        return "redirect:/cinema/cinema-management";
    }

}
