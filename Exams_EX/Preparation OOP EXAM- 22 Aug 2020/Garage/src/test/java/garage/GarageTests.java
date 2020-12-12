package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GarageTests {
    private static final String MODEL_CAR = "Mercedes";
    private static final int MAX_SPEED_CAR = 320;
    private static final double PRICE_CAR = 320000.20;
    private Car car;
    private Garage garage;

    @Before
    public void setUp() {
        this.car = new Car(MODEL_CAR, MAX_SPEED_CAR, PRICE_CAR);
        this.garage = new Garage();
    }

    private void addCarInGarage() {
        garage.addCar(car);
        garage.addCar(new Car("Dacia", 190, 23000));
        garage.addCar(new Car("Opel", 180, 19000));
    }

    //constructor
    @Test
    public void testCreateGarage() {
        Assert.assertTrue(garage.getCars().isEmpty());
    }

    //getCollection
    @Test
    public void testGetCollection() {
        Assert.assertTrue(garage.getCars().isEmpty());
        addCarInGarage();
        Assert.assertFalse(garage.getCars().isEmpty());
    }

    //getCount
    @Test
    public void testGetCountReturnZeroForEmptyList() {
        Assert.assertEquals(0, garage.getCount());

    }

    @Test
    public void testGetCountNonEmptyList() {
        addCarInGarage();
        Assert.assertEquals(3, garage.getCount());
    }

    //findAllCarsWithMaxSpeedAbove
    @Test
    public void findAllCarsWithMaxSpeedAboveIfNotFoundReturnEmptyList() {
        int speed = 260;
        Assert.assertTrue(garage.findAllCarsWithMaxSpeedAbove(speed).isEmpty());
    }

    @Test
    public void findAllCarsWithMaxSpeedAboveIfFoundReturnNonEmptyList() {
        int speed = 260;
        addCarInGarage();
        Assert.assertFalse(garage.findAllCarsWithMaxSpeedAbove(speed).isEmpty());
        Assert.assertEquals(car, garage.getCars().get(0));
    }


    //add car
    @Test(expected = IllegalArgumentException.class)
    public void testAddCarInvalidParam() {
        garage.addCar(null);
    }

    @Test
    public void testAddCarValidParam() {
        int count = garage.getCount();
        addCarInGarage();
        Assert.assertEquals(count + 3, garage.getCount());
        Assert.assertTrue(garage.getCars().contains(car));
    }

    // getTheMostExpensiveCar
    @Test
    public void testGetTheMostExpensiveCarIfExist() {
        addCarInGarage();
        Assert.assertNotNull(garage.getTheMostExpensiveCar());
        Assert.assertEquals(car, garage.getTheMostExpensiveCar());
    }

    @Test
    public void testGetTheMostExpensiveCarIfNotExistReturnNull() {
        Assert.assertNull(garage.getTheMostExpensiveCar());
    }

    //findAllCarsByBrand
    @Test
    public void testFindAllCarsByBrandIfExist() {
        addCarInGarage();
        Assert.assertFalse(garage.findAllCarsByBrand(MODEL_CAR).isEmpty());
        Assert.assertEquals(car, garage.getCars().get(0));
    }
@Test
    public void testFindAllCarsByBrandIfNotExist() {
        Assert.assertTrue(garage.findAllCarsByBrand(MODEL_CAR).isEmpty());
    }

}