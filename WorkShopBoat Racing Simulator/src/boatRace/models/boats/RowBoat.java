package boatRace.models.boats;

import boatRace.Validate.Validator;
import boatRace.models.boats.BaseBoat;

public class RowBoat extends BaseBoat {
    private int oars;

    public RowBoat(String model, int weight, int oars) {
        super(model, weight);
        setOars(oars);
    }

    private void setOars(int oars) {
        Validator.validateInteger(oars, "Oars");
        this.oars = oars;
    }

    public int getOars() {
        return oars;
    }
}
