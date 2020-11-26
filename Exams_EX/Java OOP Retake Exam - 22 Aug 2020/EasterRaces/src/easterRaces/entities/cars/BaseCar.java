package easterRaces.entities.cars;

import static easterRaces.common.ExceptionMessages.INVALID_MODEL;

public abstract class BaseCar implements Car {
    private String model;
    private int horsePower;
    private double cubicCentimeters;

    protected BaseCar(String model, int horsePower, double cubicCentimeters) {
        setModel(model);
        this.horsePower = horsePower;
        this.cubicCentimeters = cubicCentimeters;
    }

    private void setModel(String model) {
        int needLenght = 4;
        if (model == null || model.length() < needLenght) {
            throw new IllegalArgumentException(String.format(INVALID_MODEL, model, needLenght));
        }
        this.model = model;
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
        return cubicCentimeters / horsePower * laps;
    }
}
