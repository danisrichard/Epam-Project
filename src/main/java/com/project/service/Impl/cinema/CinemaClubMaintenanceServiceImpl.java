package com.project.service.Impl.cinema;

import com.project.error.NotEnoughMoneyException;
import com.project.model.cinemaproject.cinemadecorator.Cinema;
import com.project.model.cinemaproject.maintenance.Maintenance;
import com.project.service.CinemaClubMaintenanceService;
import com.project.utils.CinemaInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
public class CinemaClubMaintenanceServiceImpl implements CinemaClubMaintenanceService {

    @Autowired
    CinemaInputValidator cinemaInputValidator;

    @Override
    public Maintenance getMaintenanceByQuality(String maintenanceQuality) {
        return null;
    }

    public Cinema maintenanceInCinema(@NotNull Cinema cinema) throws NotEnoughMoneyException {
        if(cinemaInputValidator.checkEnoughCurrency(cinema,cinema.getFreePlaceInCinema()*15)){
            cinema.decreaseCurrentMoney(cinema.getFreePlaceInCinema()*15);
            cinema.setMaintained(100);
        }
        return cinema;
    }

}
