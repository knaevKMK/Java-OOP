package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class PlayerTests {
    private Player player;
    private Gun gun;
    private static String PLAYER_NAME = "Niko";
    private static int PLAYER_HEALTH = 50;
    private static int DAMAGE = 5;


    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Player
    @Before
    public void setUp() {
        this.gun = new Gun("Makarov", 12);
        this.player = new Player(PLAYER_NAME, PLAYER_HEALTH);
    }

//getGun
    @Test
    public void testGetGunByValidName(){
        player.addGun(gun);
        Assert.assertNotNull(player.getGun("Makarov"));
        Assert.assertEquals(gun,player.getGun("Makarov"));
    }

    @Test
    public void testGetGunByInValidName() {
        player.addGun(gun);
        Assert.assertNull(player.getGun("Test"));
    }
    //removeGun
    @Test
    public void testRemoveGunIfExist() {
        player.addGun(gun);
        Assert.assertTrue(player.removeGun(gun));
    }

    @Test
    public void testRemoveGunIfNotExist() {
        Assert.assertFalse(player.removeGun(gun));
    }

    //addGun
    @Test(expected = NullPointerException.class)
    public void testAddGunEqualNull() {
        player.addGun(null);

    }

    @Test
    public void testAddGunValid() {
        player.addGun(gun);
        Assert.assertFalse(player.getGuns().isEmpty());
    }

    //takeDamage
    @Test
    public void testTakeDamageHealthLowerThanDamageShouldReturnZero() {
        player.takeDamage(55);
        Assert.assertEquals(0, player.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageZeroHealth() {
        Player player = new Player(PLAYER_NAME, 0);
        player.takeDamage(DAMAGE);
    }

    //getUsername()
    @Test
    public void testGetUsername() {
        Assert.assertEquals(PLAYER_NAME, player.getUsername());
    }

    // getGuns
    @Test
    public void testGetGunsNotEmptiList() {
        player.addGun(gun);
        Assert.assertFalse(player.getGuns().isEmpty());
        Assert.assertEquals(gun, player.getGuns().get(0));
    }

    @Test
    public void testGetGunsEmptiList() {
        Assert.assertTrue(player.getGuns().isEmpty());
    }

    // constructor+setters
    @Test
    public void testConstructorValidArguments() {
        Assert.assertEquals(PLAYER_NAME, player.getUsername());
        Assert.assertEquals(PLAYER_HEALTH, player.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorInvalidName() {
        Player player = new Player("", PLAYER_HEALTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorInvalidHealth() {
        Player player = new Player(PLAYER_NAME, -1);
    }

}
