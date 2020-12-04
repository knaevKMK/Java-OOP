package boatRace.models.boats;

import boatRace.core.Engine;

public class PowerBoat extends BaseBoat {
    private Engine engineOne;
    private Engine engineTwo;


    public PowerBoat(String model, int weight, Engine engineOne, Engine engineTwo) {
        super(model, weight);
        this.engineOne = engineOne;
        this.engineTwo = engineTwo;
    }
}
