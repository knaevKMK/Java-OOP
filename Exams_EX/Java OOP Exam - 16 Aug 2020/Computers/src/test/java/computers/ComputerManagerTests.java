package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {
    // TODO: Test ComputerManager
    private ComputerManager computerManager;
    private Computer computer;

    @Before
    public void setUp() {
        this.computer = new Computer("manufacturer", "model", 20);
        this.computerManager = new ComputerManager();
    }

    @Test
    public void testGetComputersByManufacturerReturnNotEmptyList() {
        computerManager.addComputer(computer);
        Assert.assertFalse(computerManager.getComputersByManufacturer("manufacturer").isEmpty());
    }

    @Test
    public void testGetComputersByManufacturerReturnEmptyList() {
        Assert.assertTrue(computerManager.getComputersByManufacturer("manufacturer").isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputersByManufacturerNotValidManufactor() {
        List<Computer> temp = computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void testGetComputerIfExist() {
        computerManager.addComputer(computer);
        Assert.assertEquals(computer, computerManager.getComputer("manufacturer", "model"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerEmtyManufactor() {
        computerManager.getComputer("", "model");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerEmtyModel() {
        computerManager.getComputer("manufacturer", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerEmty() {
        Assert.assertNull(computerManager.getComputer("manufactorer", "model"));
    }

    @Test
    public void testRemoveComputerIfExist() {
        computerManager.addComputer(computer);
        Assert.assertEquals(computer, computerManager.removeComputer("manufacturer", "model"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveComputerEmtyManufactor() {
        computerManager.removeComputer("", "model");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveComputerEmtyModel() {
        computerManager.removeComputer("manufacturer", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveComputerEmty() {
        Assert.assertNull(computerManager.removeComputer("manufactorer", "model"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerSameTwoTimes() {
        this.computerManager.addComputer(computer);
        this.computerManager.addComputer(computer);
    }

    @Test
    public void testAddComputerValid() {
        this.computerManager.addComputer(computer);
        Assert.assertFalse(computerManager.getComputers().isEmpty());
        Assert.assertEquals(computer, computerManager.getComputers().get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerNull() {
        this.computerManager.addComputer(null);
    }

    @Test
    public void testGetComputersEmptyList() {
        Assert.assertTrue(computerManager.getComputers().isEmpty());
    }

    public void testGetComputersNotEmptyList() {
        computerManager.addComputer(computer);
        Assert.assertFalse(computerManager.getComputers().isEmpty());
    }

    @Test
    public void testGetCountEmptyList() {
        Assert.assertEquals(0, computerManager.getCount());
    }

    @Test
    public void testGetCountNotEmptyList() {
        computerManager.addComputer(computer);
        Assert.assertEquals(1, computerManager.getCount());
    }

}