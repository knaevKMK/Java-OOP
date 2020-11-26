package Vehicles.Validation;

public class Validate {
    private Validate() {
    }

    public static void isTankFuelValid(double fuelInTank, double topUp, double tankCapacity) {
        if (topUp <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (topUp+ fuelInTank > tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
    }
}
