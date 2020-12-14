package bakery.entities.bakedFoods;

import bakery.entities.bakedFoods.interfaces.BakedFood;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseFood implements BakedFood {
    private String name;
    private double portion;
    private double price;
    //Bread
    //The Bread has constant value for InitialBreadPortion - 200
    //Cake
    //The Cake has constant value for InitialBreadPortion - 245

    protected BaseFood(String name, double portion, double price) {
      setName(name);
      setPortion(portion);
      setPrice(price);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    private void setPortion(double portion) {
        validateDouble(portion, INVALID_PORTION);
        this.portion = portion;
    }

    private void validateDouble(double value, String excepttionMsg) {
        if (value <= 0) {
            throw new IllegalArgumentException(excepttionMsg);
        }
    }

    private void setPrice(double price) {
        validateDouble(price, INVALID_PRICE);
        this.price = price;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPortion() {
        return portion;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2fg - %.2f"
                , this.getName(), this.getPortion(), this.getPrice());
    }

    //Returns a String with information about each food. The returned String must be in the following format:
    //"{currentBakedFoodName}: {currentPortion - formatted to the second digit}g - {currentPrice - formatted to the second digit}"
}
