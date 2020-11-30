package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ComputerTest {
    private static final Part part = new Part("TEST", 25);
    private static final String COMPUTER_NAME = "Pesho";
    private Computer computer;

    @Before
    public void setUp() {
        this.computer = new Computer(COMPUTER_NAME);
    }

    // get Nmae
    @Test
    public void testGetName() {
        Assert.assertEquals("Pesho", computer.getName());
    }

    // getPrice

    @Test
    public void setGetTotalPriceEmptyList() {
        Assert.assertEquals(0, computer.getTotalPrice(), 0.0);
    }

    @Test
    public void setGetTotalPriceNotEmptyList() {
        computer.addPart(part);
        computer.addPart(new Part("TEST_2", 21));
        Assert.assertEquals(46, computer.getTotalPrice(), 0.0);
    }

    // remove
    @Test
    public void testRemovePartExpectExist() {
        computer.addPart(part);
        Assert.assertTrue(computer.removePart(part));
        Assert.assertFalse(computer.getParts().contains(part));
    }

    @Test
    public void testRemovePartExpectNotExist() {
        Assert.assertFalse(computer.removePart(part));
        Assert.assertFalse(computer.getParts().contains(part));
    }

    //get|Part
    @Test
    public void getPartExpectedExistPart() {
        computer.addPart(part);
        Assert.assertNull(computer.getPart("Test"));
    }

    @Test
    public void getPartExpectedNotExistPart() {
        Assert.assertNull(computer.getPart("Test"));
    }

    // add
    @Test(expected = IllegalArgumentException.class)
    public void testAddPartNullWithException() {
        computer.addPart(null);
    }

    @Test
    public void testAddPartValidPart() {
        computer.addPart(part);
        Assert.assertEquals(part, computer.getParts().get(0));
    }

    //construnctor
    @Test
    public void testCreatComputerValidName() {
        Computer computer = new Computer(COMPUTER_NAME);
        Assert.assertEquals(COMPUTER_NAME, computer.getName());
        Assert.assertTrue(computer.getParts().isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateComputerInvalidName() {
        Computer computer = new Computer(null);
    }

    //getParts
    @Test
    public void testGetPartsEmptyList() {
        Assert.assertTrue(computer.getParts().isEmpty());
    }

    @Test
    public void testGetPartsNotEmptyList() {
        computer.addPart(part);
        Assert.assertFalse(computer.getParts().isEmpty());
    }


}