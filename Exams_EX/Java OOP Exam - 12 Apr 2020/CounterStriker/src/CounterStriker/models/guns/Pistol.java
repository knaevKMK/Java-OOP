package CounterStriker.models.guns;

public class Pistol extends GunImpl {
    private static final int FIRE = 1;

    public Pistol(String name, int bulletsCount) {

        super(name, bulletsCount);

    }

    @Override
    public int fire() {
        if (super.getBulletsCount() > 0) {
            super.setBulletsCount(super.getBulletsCount() - 1);
            return 1;
        }
        return 0;
    }
}
