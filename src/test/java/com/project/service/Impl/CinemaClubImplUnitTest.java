package com.project.service.Impl;

import com.project.error.NotEnoughFreePlaceException;
import com.project.error.NotEnoughMoneyException;
import com.project.model.cinemaproject.cinemadecorator.BasicCinema;
import com.project.model.cinemaproject.cinemadecorator.Cinema;
import com.project.model.cinemaproject.cinemadecorator.decorator.CinemaCanvas;
import com.project.model.cinemaproject.cinemadecorator.decorator.ThreeDProjectorCinema;
import com.project.model.cinemaproject.cinemadecorator.decorator.TwoDProjectorCinema;
import com.project.model.cinemaproject.equipment.Equipment;
import com.project.model.cinemaproject.maintenance.MaintenanceFactory;
import com.project.repository.EquipmentRepository;
import com.project.service.Impl.cinema.CinemaClubEquipmentServiceImpl;
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

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CinemaClubImplUnitTest {

    private final static int CANVAS_PRICE = 5000;
    private final static int ONE_SEAT_PRICE = 50;
    private final static int ONE_FLOOR_AREA = 200;
    private final static int TWO_D_PROJECTOR_PRICE = 5000;
    private final static int THREE_D_PROJECTOR_PRICE = 9000;

    @InjectMocks
    CinemaClubEquipmentServiceImpl cinemaClubService;

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

        List<Equipment> equipmentBasicList = new ArrayList<>(Arrays.asList(equipmentOne, equipmentTwo, equipmentThree));

        when(equipmentRepository.findAll()).thenReturn(Arrays.asList(equipmentOne, equipmentTwo, equipmentThree));
        List<Equipment> equipmentServiceList = cinemaClubService.getAllEquipment();

        assertNotNull(equipmentServiceList);
        assertEquals(equipmentBasicList, equipmentServiceList);
    }

    @Test
    public void addNewEquipmentWhenAddNewEntityShouldReturnThatEntity() {
        when(equipmentRepository.save(any(Equipment.class))).thenReturn(new Equipment());
        Equipment equipment1 = new Equipment();

        assertNotEquals(cinemaClubService.addNewEquipment(equipment1), equipment1);
    }

    @Test
    public void buyTwoDProjectorWhenHaveGotEnoughMoneyShouldReturnTwoDProjectDecoratorEntity() throws NotEnoughMoneyException, NotEnoughFreePlaceException {
        Cinema cinema = new BasicCinema();
        cinema.increaseCurrentMoney(TWO_D_PROJECTOR_PRICE);

        Cinema returnCinema = cinemaClubService.buyTwoDProjector(cinema);

        Cinema cinema1 = new TwoDProjectorCinema(new BasicCinema());

        assertNotEquals(cinema1, returnCinema);
    }

    @Test
    public void buyTwoDProjectorWhenHaveGotEnoughMoneyShouldReturnTwoDProjectDecoratorEntityMinusFiveThousand() throws NotEnoughMoneyException, NotEnoughFreePlaceException {
        Cinema cinema = new BasicCinema();
        cinema.increaseCurrentMoney(TWO_D_PROJECTOR_PRICE);

        int returnMoney = cinemaClubService.buyTwoDProjector(cinema).getCurrentMoney();

        assertEquals(0, returnMoney);
    }

    @Test
    public void buyThreeDProjectorWhenHaveGotEnoughMoneyShouldReturnThreeDProjectDecoratorEntity() throws NotEnoughMoneyException, NotEnoughFreePlaceException {
        Cinema cinema = new BasicCinema();
        cinema.increaseCurrentMoney(THREE_D_PROJECTOR_PRICE);

        Cinema returnCinema = cinemaClubService.buyThreeDProjector(cinema);

        assertTrue(returnCinema instanceof ThreeDProjectorCinema);
    }

    @Test
    public void buyCanvasWhenHaveGotEnoughMoneyShouldReturnCinemaCanvasDecoratorEntity() throws NotEnoughMoneyException, NotEnoughFreePlaceException {
        Cinema cinema = new BasicCinema();
        cinema.increaseCurrentMoney(CANVAS_PRICE);

        Cinema responseCinema = cinemaClubService.buyCanvas(cinema);

        assertTrue(responseCinema instanceof CinemaCanvas);
    }

    @Test
    public void buyOneFloorAreaToCinemaWhenHaveGotEnoughMoneyShouldReturnIncreasedFloorAreInCinemaObject() throws NotEnoughMoneyException {
        Cinema cinema = new BasicCinema();
        cinema.increaseCurrentMoney(ONE_FLOOR_AREA);
        int baseFloorArea = cinema.getPurity();

        baseFloorArea += 1;

        int returnFloor = cinemaClubService.buyOneFloorAreaToCinema(cinema).getPurity();

        assertEquals(baseFloorArea, returnFloor);
    }

    @Test
    public void buyOneSeatsToCinemaWhenHaveGotEnoughMoneyShouldReturnIncreasedSeatInCinemaObject() throws NotEnoughMoneyException, NotEnoughFreePlaceException {
        Cinema cinema = new BasicCinema();
        cinema.increaseCurrentMoney(ONE_SEAT_PRICE);

        int seatsNumber = cinema.getSeatsNumber() + 1;

        int returnSeatNumber = cinemaClubService.buyOneSeatsToCinema(cinema).getSeatsNumber();

        assertEquals(seatsNumber, returnSeatNumber);
    }
}