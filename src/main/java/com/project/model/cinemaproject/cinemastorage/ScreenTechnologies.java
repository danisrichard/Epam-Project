package com.project.model.cinemaproject.cinemastorage;

public enum ScreenTechnologies {
    TWO_D(0),THREE_D(10);

    private final int screenTechnologiesInPercent;

    ScreenTechnologies(int screenTechnologiesInPercent) {
        this.screenTechnologiesInPercent = screenTechnologiesInPercent;
    }

    public int getScreenTechnologiesInPercent() {
        return screenTechnologiesInPercent;
    }
}
