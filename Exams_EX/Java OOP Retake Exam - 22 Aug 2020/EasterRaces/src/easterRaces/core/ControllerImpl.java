package easterRaces.core;

import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.DriverRepository;
import easterRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static easterRaces.common.ExceptionMessages.RACE_INVALID;
import static easterRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> riderRepository;
    private Repository<Car> motorcycleRepository;
    private Repository<Race> raceRepository;


    public ControllerImpl(Repository<Driver> riderRepository, Repository<Car> motorcycleRepository, Repository<Race> raceRepository) {
        this.riderRepository = riderRepository;
        this.motorcycleRepository = motorcycleRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        riderRepository.add(new DriverImpl(driver));
        return String.format(DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        switch (type) {
            case "Muscle":
                type="MuscleCar";
                motorcycleRepository.add(new MuscleCar(model, horsePower));
                break;
            case "Sports":
                type="SportsCar";
                motorcycleRepository.add(new SportsCar(model, horsePower));
                break;
        }
        return String.format(CAR_CREATED, type, model);
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = riderRepository.getByName(driverName);
        Car car = this.motorcycleRepository.getByName(carModel);
        driver.addCar(car);
        return String.format(CAR_ADDED, driverName, carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Race race = raceRepository.getByName(raceName);
        Driver driver = riderRepository.getByName(driverName);
        race.addDriver(driver);
        return String.format(DRIVER_ADDED, driverName, raceName);
    }

    @Override
    public String createRace(String name, int laps) {
        raceRepository.add(new RaceImpl(name, laps));
        return String.format(RACE_CREATED, name);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);
        return startRace(race);
    }

    public String startRace(Race race) {
        raceHaveEnoghDriver(race);

        int laps = race.getLaps();
        List<Driver> winners = race.getDrivers().stream()
                .filter(Driver::getCanParticipate)
                .sorted((dr1, dr2) -> Double.compare(dr2.getCar().calculateRacePoints(laps), dr1.getCar().calculateRacePoints(laps)))
                .limit(3).collect(Collectors.toList());
        Driver first = winners.get(0);
        first.winRace();
        Driver second = winners.get(1);
        Driver tirth = winners.get(2);
        raceRepository.remove(race);
        return new StringBuilder()
                .append(String.format(DRIVER_FIRST_POSITION, first.getName(), race.getName())).append(System.lineSeparator())
                .append(String.format(DRIVER_SECOND_POSITION, second.getName(), race.getName())).append(System.lineSeparator())
                .append(String.format(DRIVER_THIRD_POSITION, tirth.getName(), race.getName()))
                .toString();
    }

    private void raceHaveEnoghDriver(Race race) {
        int count = 0;
        for (Driver driver : race.getDrivers()) {
            if (driver.getCanParticipate()) {
                count++;
            }
        }
        if (count < 3) {
            throw new IllegalArgumentException(String.format(RACE_INVALID, race.getName(), 3));
        }
    }
}
