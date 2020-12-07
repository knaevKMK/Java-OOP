package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_HORSE_POWER;
import static easterRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car {
    private String model;
    private int horsePower;
    private double cubicCentimeters;
    private int minHorsePower;
    private int maxHorsePower;

    protected BaseCar(String model, int horsePower, double cubicCentimeters, int minHorsePower, int maxHorsePower) {
        setModel(model);
        this.cubicCentimeters = cubicCentimeters;
        this.minHorsePower = minHorsePower;
        this.maxHorsePower = maxHorsePower;
        setHorsePower(horsePower);
    }

    private void setModel(String model) {
        //o	If the model is null, whitespace or less than 4 symbols, throw an IllegalArgumentException
        // with message "Model {model} cannot be less than 4 symbols."
        if (model.trim().length() < 4) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, 4));
        }
        //o	All models are unique
        this.model = model;
    }

    private void setHorsePower(int horsePower) {
        //o	Every type of car has different range of valid horsepower.
        if (horsePower < this.minHorsePower || horsePower > this.maxHorsePower) {
            throw new IllegalArgumentException(String.format(INVALID_HORSE_POWER, horsePower));
        }
        // If the horsepower is not in the valid range,
        // throw an IllegalArgumentException with message "Invalid horse power: {horsepower}."

        this.horsePower = horsePower;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public double getCubicCentimeters() {
        return cubicCentimeters;
    }

    @Override
    public double calculateRacePoints(int laps) {
        //cubic centimeters / horsepower * laps
        return getCubicCentimeters() / getHorsePower() * laps;
    }
}
