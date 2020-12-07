package easterRaces.repositories.interfaces;

import easterRaces.entities.cars.Car;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static easterRaces.common.ExceptionMessages.CAR_EXISTS;
import static easterRaces.common.ExceptionMessages.CAR_NOT_FOUND;

public class CarRepository<E> implements Repository<Car>{
    private Collection<Car> cars;

    public CarRepository() {
        this.cars = new ArrayList<>();
    }


    @Override
    public Collection<Car> getAll() {
        return Collections.unmodifiableCollection(cars);
    }

    @Override
    public void add(Car car) {
        if (isExist(car)) {
            throw new IllegalArgumentException(String.format(CAR_EXISTS, car.getModel()));
        }
//Adds an entity in the collection.
        cars.add(car);
    }

    private boolean isExist(Car car) {
        for (Car car1 : cars) {
            if (car.getModel().equals(car1.getModel())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Car car) {
        //Removes an entity from the collection.
        return this.cars.remove(car);
    }

    @Override
    public Car getByName(String name) {
        Car car = this.cars.stream()
                .filter(e -> e.getModel().equals(name))
                .findFirst().orElse(null);
        if (car == null) {
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND, name));
        }
        return car;
    }


}
