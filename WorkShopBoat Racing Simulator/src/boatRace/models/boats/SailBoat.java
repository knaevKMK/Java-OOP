package boatRace.models.boats;

import boatRace.Validate.Validator;

public class SailBoat extends BaseBoat {
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) {
        super(model, weight);
        setSailEfficiency(sailEfficiency);
    }

    private void setSailEfficiency(int sailEfficiency) {
        Validator.validateInteger(sailEfficiency, "Sail efficiency");
        this.sailEfficiency = sailEfficiency;
    }
}
