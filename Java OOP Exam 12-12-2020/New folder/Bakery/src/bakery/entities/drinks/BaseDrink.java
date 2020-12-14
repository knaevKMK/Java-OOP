package bakery.entities.drinks;

import bakery.entities.drinks.interfaces.Drink;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseDrink implements Drink {
    private String name;
    private int portion;
    private double price;
    private String brand;

    protected BaseDrink(String name, int portion, double price, String brand) {
        setName(name);
        setPortion(portion);
        setPrice(price);
        setBrand(brand);
    }

    //Tea
//The Tea has constant value for teaPrice – 2.50
//Water
//The Water has constant value for waterPrice - 1.50
    private void validateString(String str, String exceptionMsg) {
        if (str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException(exceptionMsg);
        }

    }

    private void validateDouble(double value, String excepttionMsg) {
        if (value <= 0) {
            throw new IllegalArgumentException(excepttionMsg);
        }
    }

    private void setName(String name) {
        validateString(name, INVALID_NAME);
        this.name = name;
    }

    private void setPortion(int portion) {
        validateDouble(Double.parseDouble("" + portion), INVALID_PORTION);
        this.portion = portion;
    }

    private void setPrice(double price) {
        validateDouble(price, INVALID_PRICE);
        this.price = price;
    }

    private void setBrand(String brand) {
        validateString(brand, INVALID_BRAND);
        this.brand = brand;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getPortion() {
        return portion;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return String.format("%s %s %dml - %.2flv"
                , this.getName(), this.getBrand(), this.getPortion(), this.getPrice());
    }
    //String toString()
    //Returns a String with information about each drink. The returned String must be in the following format:
    //"{current drink name} {current brand name} - {current portion}ml - {current price - formatted to the second digit}lv"
}
