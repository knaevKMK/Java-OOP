package easterRaces.entities.drivers;

import easterRaces.entities.cars.Car;

import static easterRaces.common.ExceptionMessages.CAR_INVALID;
import static easterRaces.common.ExceptionMessages.INVALID_NAME;

public class DriverImpl implements Driver {
    private String name;
    private Car car;
    private int numberOfWins;
    private boolean canParticipate;

    public DriverImpl(String name) {
        setName(name);
        this.canParticipate = false;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        //o	If the name is null, empty or less than 5 symbols
        // throw an IllegalArgumentException with message "Name {name} cannot be less than 5 symbols."
        //o	All names are unique
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Car getCar() {
        return car;
    }

    @Override
    public int getNumberOfWins() {
        //When the  Driver wins a Race, the number of wins should be increased.
        return numberOfWins;
    }

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException(CAR_INVALID);
        }
//This method adds a Car to the Driver. If the car is null, throw IllegalArgumentException with message "Car cannot be null.".
        //If the given Car is not null, set the current Car as the given one and after that Driver can participate to race.
        this.car = car;
        this.canParticipate = true;
    }

    @Override
    public void winRace() {
        this.numberOfWins += 1;
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }
}
