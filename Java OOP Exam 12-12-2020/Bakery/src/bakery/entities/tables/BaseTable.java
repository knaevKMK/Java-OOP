package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static bakery.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseTable implements Table {
    private Collection<BakedFood> foodOrders; // -  accessible only by the base class
    private Collection<Drink> drinkOrders; // accessible only by the base class

    private int tableNumber;// the table number
    private int capacity;//- int the table capacity.
    private int numberOfPeople;

    private double pricePerPerson;//– double the price per person for the table
    private boolean isReserved;// - boolean returns true if the table is reserved, otherwise false.
    private double price;//– double calculates the price for all people

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {

        this.tableNumber = tableNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;

        this.foodOrders = new ArrayList<>();        //•	foodOrders - Collection<BakedFood> accessible only by the base class
        this.drinkOrders = new ArrayList<>();   //•	drinkOrders – Collection<Drink> accessible only by the base class
        this.isReserved = false;
    }

    private void setCapacity(int capacity) {
        //•	capacity - int the table capacity.
        if (capacity <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        //o	 It can’t be less than zero. In these cases, throw an IllegalArgumentException with message "Capacity has to be greater than 0"
        this.capacity = capacity;
    }

    @Override
    public int getTableNumber() {
        return tableNumber;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        //•	price – double calculates the price for all people
        return getPricePerPerson() * getNumberOfPeople();
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        this.isReserved = true;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        //o	 cannot be less or equal to 0. In these cases, throw an IllegalArgumentException with message "Cannot place zero or less people!"
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public void orderFood(BakedFood food) {
        this.foodOrders.add(food);
//Orders the provided food (think of a way to collect all the food which is ordered).
    }

    @Override
    public void orderDrink(Drink drink) {
        drinkOrders.add(drink);
//Orders the provided drink (think of a way to collect all the drinks which are ordered).
    }

    @Override
    public double getBill() {
        //Returns the bill for all of the ordered drinks and food
        return this.drinkOrders.stream().mapToDouble(e -> e.getPrice()).sum()
                + this.foodOrders.stream().mapToDouble(f -> f.getPrice()).sum()
                + getPrice();
    }

    @Override
    public void clear() {
        this.drinkOrders = new ArrayList<>();
        this.foodOrders = new ArrayList<>();
        this.isReserved = false;
        this.numberOfPeople = 0;
        this.price = 0;
//Removes all the ordered drinks and food and finally frees the table sets the count of people and price to 0.
    }

    @Override
    public String getFreeTableInfo() {
        //Return a String with the following format:
        //"Table: {table number}"
        //"Type: {table type}"
        //"Capacity: {table capacity}"
        //"Price per Person: {price per person for the current table}"
        StringBuilder print = new StringBuilder();
        print.append("Table: ").append(getTableNumber()).append(System.lineSeparator())
                .append("Type: ").append(this.getClass().getSimpleName()).append(System.lineSeparator())
                .append("Capacity: ").append(getCapacity()).append(System.lineSeparator())
                .append(String.format("Price per Person: %.2f", getPricePerPerson()));
        return print.toString();
    }


}
