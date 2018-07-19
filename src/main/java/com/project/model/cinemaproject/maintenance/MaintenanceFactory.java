package com.project.model.cinemaproject.maintenance;

public class MaintenanceFactory {

    public Maintenance getMainTance(String maintanceName) {

        maintanceName = maintanceName.toLowerCase().replace("\\s+", "");

        switch (maintanceName) {
            case "entrant":
                return new Entrant();
            case "pro":
                return new Pro();
            case "semipro":
                return new SemiPro();
            default:
                return null;
        }
    }
}
