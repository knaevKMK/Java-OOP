package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerManagerTests {
    private static final String MODEL = "T14";
    private static final String MANUFACTURER = "LENOVO";
    private static final double PRICE = 2500;
    private Computer computer;
    private ComputerManager manager;

    @Before
    public void setUp() {
        this.computer = new Computer(MANUFACTURER, MODEL, PRICE);
        this.manager = new ComputerManager();
    }

    private void addComputerInMager() {
        this.manager.addComputer(computer);
        this.manager.addComputer(new Computer(MANUFACTURER, "T15", 3200));
        this.manager.addComputer(new Computer("HP", "Pavilion", 2700));
    }
    //constructor

    @Test
    public void testCreateComputerManager() {
        Assert.assertTrue(manager.getComputers().isEmpty());
    }

    // getList
    @Test
    public void testGetComputers() {
        Assert.assertTrue(manager.getComputers().isEmpty());
        addComputerInMager();
        Assert.assertFalse(manager.getComputers().isEmpty());
    }

    //getCount
    @Test
    public void testGetCount() {
        Assert.assertEquals(0, manager.getComputers().size());// empty list
        addComputerInMager();
        Assert.assertEquals(3, manager.getComputers().size());// not empty list
    }

    // addComputer
    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerInvalidParam() {
        manager.addComputer(null);
    }

    @Test
    public void testAddComputerValidParam() {
        int size = manager.getCount();
        manager.addComputer(computer);
        Assert.assertEquals(computer, manager.getComputers().get(0));
        Assert.assertEquals(size + 1, manager.getCount());
    }

    //removeComputer
    @Test
    public void testRemoveComputer() {
        addComputerInMager();
        int size = manager.getCount();
        Assert.assertEquals(computer, manager.removeComputer(MANUFACTURER, MODEL));
        Assert.assertEquals(size - 1, manager.getCount());
    }

    //getComputer

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerInvalidParam() {
        manager.getComputer(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerInvalidModel() {
        manager.getComputer(MANUFACTURER, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerInvalidManufaturer() {
        manager.getComputer(null, MODEL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerValidParamIfNotExist() {
        manager.getComputer(MANUFACTURER, MODEL);
    }

    @Test
    public void testGetComputerValidParamIfExist() {
        addComputerInMager();
        Assert.assertEquals(computer, manager.getComputer(MANUFACTURER, MODEL));
    }


    //getComputersByManufacturer by String manufacturer
    @Test
    public void testGetComputersByValidManufacturer() {
        Assert.assertTrue(manager.getComputersByManufacturer(MANUFACTURER).isEmpty());
        addComputerInMager();
        Assert.assertFalse(manager.getComputersByManufacturer(MANUFACTURER).isEmpty());
        for (Computer computer1 : manager.getComputersByManufacturer(MANUFACTURER)) {
            Assert.assertEquals(MANUFACTURER, computer1.getManufacturer());
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputersByInvalidManufacturer() {
        manager.getComputersByManufacturer(null);
    }

}