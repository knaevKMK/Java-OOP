package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import rpg_lab.Hero;
import rpg_lab.Interfaces.Target;
import rpg_lab.Interfaces.Weapon;

public class HerroTest {

    private static final String HERO_NAME = "Hero";
    private static final int TARGET_XP = 10;

    @Test
    public void attackGainsExperienceIfTargetIsDead() {
        Target fakeTarget = Mockito.mock(Target.class);
        Weapon fakeWeapon = Mockito.mock(Weapon.class);
        Mockito.when(fakeTarget.isDead()).thenReturn(true);
        Mockito.when(fakeTarget.giveExperience()).thenReturn(TARGET_XP);
        Hero hero = new Hero(HERO_NAME, fakeWeapon);

        hero.attack(fakeTarget);

        Assert.assertEquals("Wrong experience", TARGET_XP, hero.getExperience());
    }

}
