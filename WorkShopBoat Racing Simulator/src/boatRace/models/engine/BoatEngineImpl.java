package boatRace.models.engine;

import boatRace.Validate.Validator;
import boatRace.core.Engine;
import boatRace.models.engine.interfaces.BoatEngine;

public abstract class BoatEngineImpl implements BoatEngine {
    private String model;
    private int horsePower;
    private int displacement;

    protected BoatEngineImpl(String model, int horsePower, int displacement) {
        setModel(model);
        setHorsePower(horsePower);
        setDisplacement(displacement);
    }

    public int getHorsePower() {
        return horsePower;
    }

    public int getDisplacement() {
        return displacement;
    }

    private void setDisplacement(int displacement) {
        Validator.validateInteger(displacement, "Displacement");
        this.displacement = displacement;
    }

    private void setHorsePower(int horsePower) {
        Validator.validateInteger(horsePower, "Horse Power");
        this.horsePower = horsePower;
    }

    private void setModel(String model) {
        Validator.validateEngineModel(model);
        this.model = model;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int output() {
        return horsePower + displacement;
    }
}
