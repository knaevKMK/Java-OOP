package CounterStriker.models.guns;

public class Pistol extends GunImpl {
    private static final int FIRE_BULLETS_AT_ONCE = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount, FIRE_BULLETS_AT_ONCE);
    }


}
