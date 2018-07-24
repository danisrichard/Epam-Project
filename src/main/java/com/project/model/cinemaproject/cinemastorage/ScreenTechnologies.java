package com.project.model.cinemaproject.cinemastorage;

public enum ScreenTechnologies {
    TWO_D(0),THREE_D(0.1);

    private final double screenTechnologiesInPercent;

    ScreenTechnologies(double screenTechnologiesInPercent) {
        this.screenTechnologiesInPercent = screenTechnologiesInPercent;
    }

    public double getScreenTechnologiesInPercent() {
        return screenTechnologiesInPercent;
    }
}
