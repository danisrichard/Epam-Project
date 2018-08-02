package com.project.service.Impl.cinema;

import com.project.error.NotEnoughFreePlaceException;
import com.project.error.NotEnoughMoneyException;
import com.project.model.cinemaproject.cinemadecorator.Cinema;
import com.project.model.cinemaproject.cinemadecorator.decorator.CinemaCanvas;
import com.project.model.cinemaproject.cinemadecorator.decorator.ThreeDProjectorCinema;
import com.project.model.cinemaproject.cinemadecorator.decorator.TwoDProjectorCinema;
import com.project.model.cinemaproject.equipment.Equipment;
import com.project.repository.EquipmentRepository;
import com.project.service.cinema.CinemaClubEquipmentService;
import com.project.utils.CinemaInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.model.cinemaproject.cinemastorage.CinemaPrices.*;
import static com.project.model.cinemaproject.cinemastorage.CinemaRequiredFreePlaces.*;

@Service
public class CinemaClubEquipmentServiceImpl implements CinemaClubEquipmentService {

    @Autowired
    private CinemaInputValidator cinemaInputValidator;

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }

    @Override
    public Equipment addNewEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    @Override
    public Cinema buyTwoDProjector(Cinema cinema) throws NotEnoughMoneyException, NotEnoughFreePlaceException {
        if (cinemaInputValidator.checkEnoughCurrency(cinema, TWO_D_PROJECTOR_PRICE) && cinemaInputValidator.cinemaFreePlacesChecker(cinema, TWO_D_PROJECTOR_FREE_PLACE)) {
            cinema.decreaseCurrentMoney(TWO_D_PROJECTOR_PRICE);
        }
        return new TwoDProjectorCinema(cinema);
    }

    @Override
    public Cinema buyThreeDProjector(Cinema cinema) throws NotEnoughMoneyException, NotEnoughFreePlaceException {
        if (cinemaInputValidator.checkEnoughCurrency(cinema, THREE_D_PROJECTOR_PRICE) && cinemaInputValidator.cinemaFreePlacesChecker(cinema, THREE_D_PROJECTOR_FREE_PLACE)) {
            cinema.decreaseCurrentMoney(THREE_D_PROJECTOR_PRICE);
        }

        return new ThreeDProjectorCinema(cinema);
    }

    @Override
    public Cinema buyCanvas(Cinema cinema) throws NotEnoughMoneyException, NotEnoughFreePlaceException {
        if (cinemaInputValidator.checkEnoughCurrency(cinema, CANVAS_PRICE) && cinemaInputValidator.cinemaFreePlacesChecker(cinema, CANVAS_FREE_PLACE)) {
            cinema.decreaseCurrentMoney(CANVAS_PRICE);
        }
        return new CinemaCanvas(cinema);
    }

    @Override
    public Cinema buyOneSeatsToCinema(Cinema cinema) throws NotEnoughMoneyException, NotEnoughFreePlaceException {
        if (cinemaInputValidator.checkEnoughCurrency(cinema, ONE_SEAT_PRICE) && cinemaInputValidator.cinemaFreePlacesChecker(cinema, SEAT_FREE_PLACE)) {
            cinema.increaseSeatNumberOne();
            cinema.decreaseCurrentMoney(ONE_SEAT_PRICE);
        }
        return cinema;
    }

    @Override
    public Cinema buyOneFloorAreaToCinema(Cinema cinema) throws NotEnoughMoneyException {
        if (cinemaInputValidator.checkEnoughCurrency(cinema, ONE_FLOOR_AREA)) {
            cinema.increaseFloorAreaOne();
            cinema.decreaseCurrentMoney(ONE_FLOOR_AREA);
        }
        return cinema;
    }

}
