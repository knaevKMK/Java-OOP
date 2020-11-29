package CounterStriker.models.guns;

public class Rifle extends GunImpl {
    private static final int FIRE = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
        super.setFire(FIRE);
    }
}
