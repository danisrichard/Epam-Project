package com.project.controller;

import com.project.model.cinemaproject.cinemadecorator.BasicCinema;
import com.project.model.cinemaproject.cinemadecorator.Cinema;
import com.project.model.cinemaproject.equipment.Equipment;
import com.project.service.CinemaClubEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("request")
@RequestMapping("/cinema")
public class CinemaClubController {

    Cinema cinema = new BasicCinema();

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
        model.addAttribute("cinema",cinema);
        return "cinema/management/cinema-management-index";
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
