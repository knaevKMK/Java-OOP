package CounterStriker.models.guns;

public class Rifle extends GunImpl {
    private static final int FIRE_Rifle = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount, FIRE_Rifle);
    }


}
