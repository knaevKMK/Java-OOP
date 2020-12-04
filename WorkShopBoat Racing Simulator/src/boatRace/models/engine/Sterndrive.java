package boatRace.models.engine;

public class Sterndrive extends BoatEngineImpl {
    private static final int MULTIPLYER = 7;
    public Sterndrive(String model, int horsePower, int displacement) {
        super(model, horsePower, displacement);
    }
    @Override
    public int output() {
        return getHorsePower() * MULTIPLYER + getDisplacement();
    }
}
