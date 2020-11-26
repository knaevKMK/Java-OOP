package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_EX = 10;
    private static final int EXPECTED_DURABILITY = AXE_ATTACK - 1;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EX);
    }

    @Test
    public void weaponAttackLosesDurability() {
        // Act
        this.axe.attack(this.dummy);
        // Assert
        Assert.assertEquals("Wrong Durability, ", EXPECTED_DURABILITY, axe.getDurabilityPoints());
    }


    @Test(expected = IllegalStateException.class)
    public void brokenWeaponCanAttack() {
        //Act
        for (int i = 0; i < 11; i++) {
            this.axe.attack(this.dummy);
        }
        // Assert
      Assert.assertEquals("Wrong Durability, ", 0, axe.getDurabilityPoints());
    }
}
