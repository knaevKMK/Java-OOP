package Vehicles;

import Vehicles.Validation.Validate;

public class Truck extends Vehicle {


    protected Truck(double fuel, double consumption, double tankCapacity) {
        super(fuel, consumption+1.6, tankCapacity);
        super.fuelIncrease = 1.6;
    }

    @Override
    public void refuel(double fuel) {
        Validate.isTankFuelValid(super.getFuel(), fuel, super.getTankCapacity());
        super.setFuel(super.getFuel() + fuel * 0.95);
    }

    @Override
    public String drive(double km, String summer) {
        return "Truck " + super.drive(km , summer);
    }
}
