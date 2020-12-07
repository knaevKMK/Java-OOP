package easterRaces.entities.cars;

public class SportsCar extends BaseCar {
    private static final double CUBIC_SM = 3000;
    private static final int minHP = 250;
    private static final int maxHP = 450;

    //The cubic centimeters for this type of car are 3000. Minimum horsepower is 250 and maximum horsepower is 450.
    public SportsCar(String model, int horsePower) {
        super(model, horsePower, CUBIC_SM, minHP, maxHP);
    }
}
