package easterRaces.entities.racers;

import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static easterRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race {
    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
        this.drivers = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, 5));
        }
        //o	If the name is null, empty or less than 5 symbols throw an IllegalArgumentException with message "Name {name} cannot be less than 5 symbols."
        //o	All names are unique
        this.name = name;
    }

    public void setLaps(int laps) {
        if (laps < 1) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS, 1));
        }
        //o	Throws IllegalArgumentException with message "Laps cannot be less than 1.", if the laps are less than 1.
        this.laps = laps;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLaps() {
        return laps;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return Collections.unmodifiableCollection(drivers);
    }

    @Override
    public void addDriver(Driver driver) {
//•	If a Driver is null throw an IllegalArgumentException with message "Driver cannot be null."
        if (driver == null) {
            throw new IllegalArgumentException(DRIVER_INVALID);
        }
//•	If a Driver cannot participate in the Race (the Driver doesn't own a Car)
// throw an IllegalArgumentException with message "Driver {driver name} could not participate in race."
        if (!driver.getCanParticipate()){
            throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE,driver.getName()));
        }
//•	If the Driver already exists in the Race throw an IllegalArgumentException with message:
//"Driver {driver name} is already added in {race name} race."
        if (this.drivers.contains(driver)){
            throw new IllegalArgumentException(String.format(DRIVER_ALREADY_ADDED,driver.getName(),this.getName()));
        }
        this.drivers.add(driver);
    }
}
