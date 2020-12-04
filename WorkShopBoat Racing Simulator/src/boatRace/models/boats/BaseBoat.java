package boatRace.models.boats;

import boatRace.Validate.Validator;
import boatRace.models.boats.interfaces.Boat;

public abstract class BaseBoat implements Boat {
    private String model;
    private int weight;

    protected BaseBoat(String model, int weight) {
        setModel(model);
        setWeight(weight);
    }

    private void setWeight(int weight) {
        Validator.validateInteger(weight,"Weight");

        this.weight = weight;
    }

    private void setModel(String model) {
        Validator.validateModelBoat(model);
        this.model = model;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getWeight() {
        return weight;
    }
}
