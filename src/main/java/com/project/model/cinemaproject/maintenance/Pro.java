package com.project.model.cinemaproject.maintenance;

public class Pro implements Maintenance {

    @Override
    public String getName() {
        return "Pro";
    }

    @Override
    public int getMaintenceAfterScreening() {
        return 2;
    }

    @Override
    public double getCleanlinessRoom() {
        return 0.3;
    }

    @Override
    public int getPricePerDay() {
        return 45;
    }
}
