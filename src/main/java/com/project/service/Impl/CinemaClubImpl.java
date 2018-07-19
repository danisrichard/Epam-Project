package com.project.service.Impl;

import com.project.model.cinemaproject.equipment.Equipment;
import com.project.model.cinemaproject.maintenance.Maintenance;
import com.project.model.cinemaproject.maintenance.MaintenanceFactory;
import com.project.repository.CinemaClubRepository;
import com.project.repository.EquipmentRepository;
import com.project.service.CinemaClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaClubImpl implements CinemaClubService {

    @Autowired
    private CinemaClubRepository cinemaClubRepository;

    @Autowired
    private EquipmentRepository equipmentRepository;

    //private Maintenance maintenance;

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    @Override
    public Equipment addNewEquipment(Equipment equipment) {
       return equipmentRepository.save(equipment);
    }

    @Override
    public void buyEquipment(Equipment equipment) {

    }

    @Override
    public Maintenance buyMaintenance(String maintenanceName) {
        return new MaintenanceFactory().getMainTance(maintenanceName);
    }

    @Override
    public void endOfTheDay() {

    }

    @Override
    public void screeningInCinema() {

    }
}
