package Vehicles;

public class Bus extends Vehicle {


    protected Bus(double fuel, double consumption, double tankCapacity) {
        super(fuel, consumption, tankCapacity);
        super.fuelIncrease = 1.4;
    }


    @Override
    public String drive(double km, String summer) {
        return "Bus " + super.drive(km, summer);
    }
}
