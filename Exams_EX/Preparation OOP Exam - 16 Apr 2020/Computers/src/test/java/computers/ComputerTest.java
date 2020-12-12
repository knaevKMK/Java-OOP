package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PrimitiveIterator;

import static org.junit.Assert.*;

public class ComputerTest {
    private static final String COMPUTER_NAME = "Lenovo";
    private static final String PART_NAME = "SolidStateDrive";
    private static final double PRICE_PART = 20.5;
    private Computer computer;
    private Part part;


    @Before
    public void setUp() {
        part = new Part(PART_NAME, PRICE_PART);
        computer = new Computer(COMPUTER_NAME);
    }

    private void addParts() {
        computer.addPart(part);
        computer.addPart(new Part("RamChip", 10));
        computer.addPart(new Part("HardDiskDrive", 100));
    }

    // construntor 2x name+ list IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testCreateComputerInvalidName() {
        Computer computer = new Computer(null);
    }

    @Test
    public void testCreateComputerValidName() {
      //  Computer computer = new Computer(COMPUTER_NAME);
        Assert.assertEquals(COMPUTER_NAME, computer.getName());
        Assert.assertTrue(this.computer.getParts().isEmpty());
    }

    // getName
    @Test
    public void testGetName() {
        Assert.assertEquals(COMPUTER_NAME, this.computer.getName());
    }

    // getList
    @Test
    public void testGetParts() {
        Assert.assertTrue(this.computer.getParts().isEmpty());
        addParts();
        Assert.assertFalse(this.computer.getParts().isEmpty());
    }


    //getTotalPrice - 2
    @Test
    public void testGetTotalPrice() {
        Assert.assertEquals(0, this.computer.getTotalPrice(), 0.0);
        addParts();
        Assert.assertEquals(130.5, this.computer.getTotalPrice(), 0.0);
    }


    // add
    @Test(expected = IllegalArgumentException.class)
    public void testAddPartNull() {
        this.computer.addPart(null);
    }

    @Test
    public void testAddPart() {
        Assert.assertTrue(this.computer.getParts().isEmpty());
        addParts();
        Assert.assertEquals(this.part, this.computer.getParts().get(0));
        Assert.assertFalse(this.computer.getParts().isEmpty());
    }

    // remove
    @Test
    public void testRemovePartIfNotExist() {
        int temp = this.computer.getParts().size();
        Assert.assertFalse(this.computer.removePart(part));
        Assert.assertEquals(temp, this.computer.getParts().size());
    }

    @Test
    public void testRemovePartIfExist() {
        addParts();
        int temp = this.computer.getParts().size();
        Assert.assertTrue(this.computer.removePart(part));
        Assert.assertEquals(temp - 1, this.computer.getParts().size());
    }

    //getPartByName
    @Test
    public void testGetPartByNameIfNotXist() {
        addParts();
        Assert.assertNull(this.computer.getPart("Ivan"));
    }

    @Test
    public void testGetPartByNameIfExist() {
        addParts();
        Assert.assertNotNull(this.computer.getPart(PART_NAME));
    }

}