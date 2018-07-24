package com.project.model.cinemaproject.cinemastorage;

public enum Language {
    ENGLISH(0),HUNGARY_SUB(0.5),HUNGARY_SYNC(0.1);

    private final double languageInPercent;

    Language(double languageInPercent) {
        this.languageInPercent = languageInPercent;
    }

    public double getLanguageInPercent() {
        return languageInPercent;
    }
}
