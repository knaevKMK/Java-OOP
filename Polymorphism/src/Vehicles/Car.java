package Vehicles;

public class Car extends Vehicle {

    public Car(double fuel, double consumation, double tankCapacity) {
        super(fuel, consumation+0.9, tankCapacity);
        super.fuelIncrease = 0.9;
    }

    @Override
    public String drive(double km, String summer) {
        return "Car " + super.drive(km,summer);
    }
}
