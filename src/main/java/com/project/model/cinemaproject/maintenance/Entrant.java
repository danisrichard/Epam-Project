package com.project.model.cinemaproject.maintenance;

public class Entrant implements Maintenance {

    @Override
    public String getName() {
        return "Entrant";
    }

    @Override
    public int getMaintenceAfterScreening() {
        return 13;
    }

    @Override
    public double getCleanlinessRoom() {
        return 0.8;
    }

    @Override
    public int getPricePerDay() {
        return 20;
    }
}
