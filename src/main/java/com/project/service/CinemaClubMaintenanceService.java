package com.project.service;

import com.project.model.cinemaproject.maintenance.Maintenance;

public interface CinemaClubMaintenanceService {

    Maintenance getMaintenanceByQuality(String maintenanceQuality);

}
