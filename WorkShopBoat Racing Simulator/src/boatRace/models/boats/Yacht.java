package boatRace.models.boats;

import boatRace.Validate.Validator;
import boatRace.core.Engine;

public class Yacht extends BaseBoat {
    private Engine engine;
    private int cargoWeight;

    public Yacht(String model, int weight, Engine engine, int cargoWeight) {
        super(model, weight);
        this.engine = engine;
        setCargoWeight(cargoWeight);
    }

    private void setCargoWeight(int cargoWeight) {
        Validator.validateInteger(cargoWeight, "Cargo Weight");
    }
}
