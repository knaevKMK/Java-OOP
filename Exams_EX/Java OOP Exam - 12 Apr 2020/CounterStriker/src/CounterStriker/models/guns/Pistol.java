package CounterStriker.models.guns;

public class Pistol extends GunImpl {
    private static final int FIRE = 1;

    public Pistol(String name, int bulletsCount) {

        super(name, bulletsCount);
        super.setFire(FIRE);
    }
}
