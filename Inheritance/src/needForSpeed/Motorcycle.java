package needForSpeed;

public class Motorcycle extends Vehicle {
    private static final double DEFAULT_FUEL_CONSUMPTION = 8;

    public Motorcycle(double fuel, int horsePower) {
        super(fuel, horsePower);
        super.setFuelConsumption(DEFAULT_FUEL_CONSUMPTION);
    }
}
