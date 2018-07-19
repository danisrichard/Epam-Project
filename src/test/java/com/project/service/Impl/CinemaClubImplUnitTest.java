package com.project.service.Impl;

import com.project.model.cinemaproject.equipment.Equipment;
import com.project.model.cinemaproject.maintenance.MaintenanceFactory;
import com.project.repository.EquipmentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CinemaClubImplUnitTest {

    @InjectMocks
    CinemaClubImpl cinemaClubService;

    @Mock
    EquipmentRepository equipmentRepository;

    @Mock
    MaintenanceFactory maintenanceFactory;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllEquipmentWhenQueryAllEquipmentShouldReturnListWithEquipmentsEntity() {
        Equipment equipmentOne = new Equipment();
        Equipment equipmentTwo = new Equipment();
        Equipment equipmentThree = new Equipment();

        List<Equipment> equipmentBasicList = new ArrayList<>(Arrays.asList(equipmentOne,equipmentTwo,equipmentThree));

        when(equipmentRepository.findAll()).thenReturn(Arrays.asList(equipmentOne, equipmentTwo, equipmentThree));
        List<Equipment> equipmentServiceList = cinemaClubService.getAllEquipment();

        assertNotNull(equipmentServiceList);
        assertEquals(equipmentBasicList,equipmentServiceList);
    }

    @Test
    public void addNewEquipmentWhenAddNewEntityShouldReturnThatEntity() {
        when(equipmentRepository.save(any(Equipment.class))).thenReturn(new Equipment());
        Equipment equipment1 = new Equipment();

        assertNotEquals(cinemaClubService.addNewEquipment(equipment1), equipment1);
    }

    @Test
    public void buyEquipment() {
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