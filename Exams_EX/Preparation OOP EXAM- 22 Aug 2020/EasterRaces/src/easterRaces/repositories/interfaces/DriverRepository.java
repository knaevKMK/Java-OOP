package easterRaces.repositories.interfaces;

import easterRaces.entities.drivers.Driver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static easterRaces.common.ExceptionMessages.DRIVER_EXISTS;
import static easterRaces.common.ExceptionMessages.DRIVER_NOT_FOUND;

public class DriverRepository<E> implements Repository<Driver> {
    private Collection<Driver> drivers;

    public DriverRepository() {
        this.drivers = new ArrayList<>();
    }

    @Override
    public Driver getByName(String name) {
       Driver driver= this.drivers.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst().orElse(null);
       if (driver==null){
           throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND,name));
       }
       return driver;
    }

    @Override
    public Collection<Driver> getAll() {
        return Collections.unmodifiableCollection(drivers);
    }

    @Override
    public void add(Driver driver) {
        if (driverExist(driver)) {
            throw new IllegalArgumentException(String.format(DRIVER_EXISTS, driver.getName()));
        }
        this.drivers.add(driver);
    }

    private boolean driverExist(Driver driver) {
        for (Driver driver1 : drivers) {
            if (driver.getName().equals(driver1.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Driver driver) {
        return this.drivers.remove(driver);
    }
}
