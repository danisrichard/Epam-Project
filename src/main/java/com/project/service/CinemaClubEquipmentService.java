package com.project.service;

import com.project.error.NotEnoughFreePlaceException;
import com.project.error.NotEnoughMoneyException;
import com.project.model.cinemaproject.cinemadecorator.Cinema;
import com.project.model.cinemaproject.equipment.Equipment;

import java.util.List;

public interface CinemaClubEquipmentService {

    List<Equipment> getAllEquipment();

    Cinema buyTwoDProjector(Cinema cinema) throws NotEnoughMoneyException, NotEnoughFreePlaceException;

    Cinema buyThreeDProjector(Cinema cinema) throws NotEnoughMoneyException, NotEnoughFreePlaceException;

    Cinema buyCanvas(Cinema cinema) throws NotEnoughMoneyException, NotEnoughFreePlaceException;

    Cinema buyOneSeatsToCinema(Cinema cinema) throws NotEnoughMoneyException, NotEnoughFreePlaceException;

    Cinema buyOneFloorAreaToCinema(Cinema cinema) throws NotEnoughMoneyException;

    Equipment addNewEquipment(Equipment equipment);
}
