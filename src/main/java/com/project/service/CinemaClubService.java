package com.project.service;

import com.project.model.cinemaproject.equipment.Equipment;
import com.project.model.cinemaproject.maintenance.Maintenance;

import java.util.List;

public interface CinemaClubService {

    List<Equipment> getAllEquipment();

    void buyEquipment(Equipment equipment);

    Maintenance buyMaintenance(String maintenanceName);

    void endOfTheDay();

    void screeningInCinema();

    Equipment addNewEquipment(Equipment equipment);
}
