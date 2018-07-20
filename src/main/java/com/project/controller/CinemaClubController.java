package com.project.controller;

import com.project.model.cinemaproject.equipment.Equipment;
import com.project.service.CinemaClubEquipmentService;
import com.project.service.CinemaStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cinema")
public class CinemaClubController {

    @Autowired
    private CinemaClubEquipmentService cinemaClubService;

    @Autowired
    private CinemaStoreService cinemaStoreService;

    @GetMapping
    public String getCinemaIndexPage(){
        return "cinema-index";
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
