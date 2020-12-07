package easterRaces.entities.cars;

public class MuscleCar extends BaseCar {
    private static final double CUBIC_SM = 5000;
    private static final int minHP = 400;
    private static final int maxHP = 600;

    //The cubic centimeters for this type of car are 5000. Minimum horsepower is 400 and maximum horsepower is 600.
    public MuscleCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_SM, minHP, maxHP);
    }

}
