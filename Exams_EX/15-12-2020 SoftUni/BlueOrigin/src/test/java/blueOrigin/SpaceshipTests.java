package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.security.PublicKey;
import java.util.ArrayList;

public class SpaceshipTests {
    private Spaceship ship;
    private Astronaut astronaut;
    private static final String name_Astro = "Ivan";
    private static final double oxygenInPercentage_Astro = 55;
    private static final String SHIP_NAME = "Apolo";
    private static final int CAPACITY = 2;

    @Before
    public void setUp() {
        this.astronaut = new Astronaut(name_Astro, oxygenInPercentage_Astro);
        this.ship = new Spaceship(SHIP_NAME, CAPACITY);
    }

    // contructor
    @Test
    public void testCreateShipValidParam() {
        Spaceship spaceship = new Spaceship(SHIP_NAME, CAPACITY);
        Assert.assertEquals(SHIP_NAME, spaceship.getName());
        Assert.assertEquals(CAPACITY, spaceship.getCapacity());
        Assert.assertEquals(0, spaceship.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateShipInValidNmae() {
        Spaceship spaceship = new Spaceship(null, CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateShipInValidCapacity() {
        Spaceship spaceship = new Spaceship(SHIP_NAME, -2);
    }

    //get count -> empty and Not Empty
    @Test
    public void testGetCount() {
        Assert.assertEquals(0, this.ship.getCount());
        this.ship.add(astronaut);
        Assert.assertEquals(1, this.ship.getCount());
    }


    // getName
    @Test
    public void testGetName() {
        Assert.assertEquals(SHIP_NAME, this.ship.getName());
    }

    //getCapacity
    public void getCapacity() {
        Assert.assertEquals(CAPACITY, this.ship.getCapacity());
    }


    // add:
    @Test(expected = IllegalArgumentException.class)
    public void testAddMoreAstroOverCapacity() {
        add();
        this.ship.add(new Astronaut("Gosho", 30));
    }

    private void add() {
        this.ship.add(astronaut);
        this.ship.add(new Astronaut("Pesho", 20));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddExistAstro() {
        this.ship.add(astronaut);
        this.ship.add(astronaut);
    }


    @Test
    public void testAddValidAstroUnderCapacity() {
        Assert.assertEquals(0, this.ship.getCount());
        this.ship.add(astronaut);
        Assert.assertEquals(1, this.ship.getCount());
    }


    //
    @Test
    public void testRemoveExistAstro() {
        add();
        Assert.assertTrue(this.ship.remove(this.astronaut.getName()));
    }

    @Test
    public void testRemoveNotExistAstro() {
        Assert.assertFalse(this.ship.remove(this.astronaut.getName()));
    }
}
