package easterRaces.entities.racers;

import easterRaces.entities.drivers.Driver;


import java.util.ArrayList;
import java.util.Collection;

import static easterRaces.common.ExceptionMessages.*;

public class RaceImpl implements Race {

    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps) {
        setName(name);
        setLaps(laps);
        drivers = new ArrayList<>();
    }

    private void setLaps(int laps) {
        int minLaps = 1;
        if (laps < minLaps) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_LAPS, minLaps));
        }
    }

    private void setName(String name) {
        int needLenght = 5;
        if (name == null || name.length() < 5) {
            throw new IllegalArgumentException(String.format(INVALID_NAME, name, needLenght));
        }
        this.name = name;
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
        return drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        if (driver == null) {
            throw new IllegalArgumentException(DRIVER_INVALID);
        }
        if (!driver.getCanParticipate()) {
            throw new IllegalArgumentException(String.format(DRIVER_NOT_PARTICIPATE, driver.getName()));
        }
        containsDriver(driver);

        drivers.add(driver);
    }

    private void containsDriver(Driver driver) {
        for (Driver driver1 : drivers) {
            if (driver1.getName().equals(driver.getName())) {
                throw new IllegalArgumentException(String.format(DRIVER_ALREADY_ADDED,driver.getName(),getName()));
            }
        }
    }
}
