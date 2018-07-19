package com.project.model.cinemaproject.maintenance;

public class SemiPro implements Maintenance {

    @Override
    public String getName() {
        return "Semi Pro";
    }

    @Override
    public int getMaintenceAfterScreening() {
        return 5;
    }

    @Override
    public double getCleanlinessRoom() {
        return 0.5;
    }

    @Override
    public int getPricePerDay() {
        return 30;
    }
}
