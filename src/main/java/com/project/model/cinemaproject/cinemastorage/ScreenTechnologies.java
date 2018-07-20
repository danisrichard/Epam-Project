package com.project.model.cinemaproject.cinemastorage;

public enum  ScreenTechnologies {
    TWO_D(0),THREE_D(10),FOUR_D(15);

    private final int technologiesInPercent;

    ScreenTechnologies(int technologiesInPercent) {
        this.technologiesInPercent = technologiesInPercent;
    }

    public int getTechnologiesInPercent() {
        return technologiesInPercent;
    }
}
