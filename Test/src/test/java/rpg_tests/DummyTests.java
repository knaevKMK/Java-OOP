package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_EX = 10;
    private static final int EXPECTED_HEALTH = DUMMY_HEALTH - AXE_ATTACK;
    private static final int EXPECTED_EX=DUMMY_EX;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EX);
    }

    //Dummy loses health if attacked
    @Test
    public void dummyLosesHealtAfterAttacked() {
        dummy.takeAttack(AXE_ATTACK);
        Assert.assertEquals(EXPECTED_HEALTH, dummy.getHealth());
    }

    // Dead Dummy throws exception if attacked
    @Test(expected = IllegalStateException.class)
    public void deadDummyCanAttacked() {
        for (int i = 0; i < 3; i++) {
            dummy.takeAttack(AXE_ATTACK);
        }

        Assert.assertEquals(0, dummy.getHealth());
    }

    // Dead Dummy can give XP
    @Test
    public void deadDummyCanGiveXP() {
        for (int i = 0; i < 2; i++) {
            dummy.takeAttack(AXE_ATTACK);
        }
        dummy.giveExperience();
        Assert.assertEquals(EXPECTED_EX, dummy.giveExperience());
    }

    // Alive Dummy can&#39;t give XP
    @Test(expected = IllegalStateException.class)
    public void aliveDummyCanNOtGiveXP() {
        dummy.takeAttack(axe.getAttackPoints());
        dummy.giveExperience();
        Assert.assertEquals(EXPECTED_EX, dummy.giveExperience());
    }
}
