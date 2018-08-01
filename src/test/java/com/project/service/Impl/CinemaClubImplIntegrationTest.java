package com.project.service.Impl;

import com.project.model.cinemaproject.equipment.Equipment;
import com.project.model.cinemaproject.maintenance.Maintenance;
import com.project.model.cinemaproject.maintenance.MaintenanceFactory;
import com.project.service.CinemaClubEquipmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CinemaClubImplIntegrationTest {

    @Autowired
    private CinemaClubEquipmentService cinemaClubService;

    @Test
    public void getAllEquipment() {

    }

    @Test
    public void addNewEquipmentWhenAddToDatabaseShouldReturnSameEntity() {
        Equipment equipment = new Equipment();
        equipment.setEquipmentDesc("Kamu adat");
        equipment.setName("First");
        equipment.setPrice(2000);

        cinemaClubService.addNewEquipment(equipment);

        assertEquals(cinemaClubService.addNewEquipment(equipment), equipment);
    }

    @Test
    public void buyEquipmentWhenUseValidMaintenanceInputShouldReturnProObject() {
    }

    @Test
    public void buyMaintenance() {
    }

    @Test
    public void endOfTheDay() {
    }

    @Test
    public void screeningInCinema() {
    }
}