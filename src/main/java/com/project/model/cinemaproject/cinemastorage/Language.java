package com.project.model.cinemaproject.cinemastorage;

public enum Language {
    ENGLISH(0),HUNGARY_SUB(5),HUNGARY_SYNC(10);

    private final int languageInPercent;

    Language(int languageInPercent) {
        this.languageInPercent = languageInPercent;
    }

    public int getLanguageInPercent() {
        return languageInPercent;
    }
}
