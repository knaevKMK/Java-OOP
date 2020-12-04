package boatRace.models.engine;

import boatRace.models.engine.interfaces.BoatEngine;

public class Jet extends BoatEngineImpl {
    private static final int MULTIPLYER = 5;

    public Jet(String model, int horsePower, int displacement) {
        super(model, horsePower, displacement);
    }

    @Override
    public int output() {
        return getHorsePower() * MULTIPLYER + getDisplacement();
    }
}
