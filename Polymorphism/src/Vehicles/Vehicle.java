package Vehicles;

import Vehicles.Interface.IVehcle;
import Vehicles.Validation.Validate;

public abstract class Vehicle implements IVehcle {
    private double fuel;
    private double consumption;
    private double tankCapacity;
    protected double fuelIncrease;

    protected Vehicle(double fuel, double consumption, double tankCapacity) {
        this.fuel = fuel;
        this.consumption = consumption;
        this.tankCapacity = tankCapacity;
    }

    protected double getFuel() {
        return fuel;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    protected void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getConsumption() {
        return consumption;
    }

    @Override
    public String drive(double km, String summer) {
        double needFuel = this.consumption * km;
        if (summer.equalsIgnoreCase("summer")) {
            needFuel = (this.consumption + fuelIncrease) * km;
        }
        if (needFuel <= this.fuel) {
            setFuel(this.fuel - needFuel);
            return String.format("travelled %s km", DecFormat.format(km));
        }
        return "needs refueling";

    }

    @Override
    public void refuel(double fuel) {
        Validate.isTankFuelValid(this.fuel, fuel, this.tankCapacity);
        setFuel(this.fuel + fuel);
    }
}
