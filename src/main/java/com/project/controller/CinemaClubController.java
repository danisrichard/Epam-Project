package com.project.controller;

import com.project.model.cinemaproject.cinemadecorator.BasicCinema;
import com.project.model.cinemaproject.cinemadecorator.Cinema;
import com.project.model.cinemaproject.equipment.Equipment;
import com.project.model.cinemaproject.movie.BasicMovie;
import com.project.model.cinemaproject.movie.extendedMovie.Movie;
import com.project.service.CinemaClubEquipmentService;
import com.project.service.CinemaClubFilmScreeningService;
import com.project.utils.RequestResponseLogging;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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

    Cinema cinema = new BasicCinema();

    Movie movie;

    @Autowired
    private CinemaClubFilmScreeningService cinemaClubFilmScreeningService;

    @Autowired
    private CinemaClubEquipmentService cinemaClubService;

    @GetMapping
    public String getCinemaIndexPage(){
        return "cinema/cinema-index";
    }

    @RequestMapping(value = "/create-cinema", method = RequestMethod.GET)
    public String createCinema(@RequestParam(required = false,value = "cinemaName") String value){
        cinema.setCinemaName(value);
        return "cinema/tutorial/tutorial";
    }

    @GetMapping("/cinema-management")
    public String manageCinema(Model model){
        model.addAttribute("movie",movie);
        model.addAttribute("cinema",cinema);
        model.addAttribute("movie", new BasicMovie());
        return "cinema/management/cinema-management-index";
    }

    @PostMapping("/movie")
    public String checkMovieInfos(@Valid BasicMovie basicMovie,BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            logger.info("error");
        }

        System.out.println(basicMovie.toString());
        movie = cinemaClubFilmScreeningService.getConcreteMovie(basicMovie,cinema);
        return "redirect: /cinema/management/cinema-management-index";
    }

    @GetMapping("/equipment")
    public String equipmentPage(Model model){
        return "cinema-equipment-section";
    }

    @PutMapping("/equipment/add-new-equipment")
    public String addNewEquipment(BindingResult bindingResult, Equipment equipment){

        return "";
    }



}
