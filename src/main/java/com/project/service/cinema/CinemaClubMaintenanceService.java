package com.project.service.cinema;

import com.project.model.cinemaproject.maintenance.Maintenance;

public interface CinemaClubMaintenanceService {

    Maintenance getMaintenanceByQuality(String maintenanceQuality);

}
