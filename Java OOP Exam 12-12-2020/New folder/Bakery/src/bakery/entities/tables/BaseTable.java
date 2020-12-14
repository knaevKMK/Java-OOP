package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static bakery.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseTable implements Table {

    private Collection<BakedFood> foodOrders;  //•	foodOrders - Collection<BakedFood> accessible only by the base class
    private Collection<Drink> drinkOrders;   //•	drinkOrders – Collection<Drink> accessible only by the base class
    private int tableNumber;// – int the table number
    private int capacity;// - int the table capacity.
    private int numberOfPeople;// - int the count of people who want a table.
    private double pricePerPerson;// – double the price per person for the table
    private boolean isReserved;// - boolean returns true if the table is reserved, otherwise false.
    private double price;// – double calculates the price for all people

    //InsideTable
    //The InsideTable has constant value for pricePerPerson – 2.50
    //OutsideTable
    //The OutsideTable has constant value for pricePerPerson - 3.50

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        this.tableNumber = tableNumber;
        setCapacity(capacity);
        setPricePerPerson(pricePerPerson);
        setReserved(false);
    }

    public void setNumberOfPeople(int numberOfPeople) {
        validateInteger(numberOfPeople, INVALID_NUMBER_OF_PEOPLE);
        if (numberOfPeople <= this.getCapacity()) {
            this.numberOfPeople = numberOfPeople;
        }
    }

    private void validateInteger(int val, String exceptionMsg) {
        if (val <= 0) {
            throw new IllegalArgumentException(exceptionMsg);
        }
    }

    private void setCapacity(int capacity) {
        validateInteger(capacity, INVALID_TABLE_CAPACITY);
        this.capacity = capacity;
    }

    private void setPricePerPerson(double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    private void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    private void setPrice(double price) {
        this.price = price;
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
        return price;
    }

    @Override
    public void reserve(int numberOfPeople) {
        if (!this.isReserved) {
            setReserved(true);
            setNumberOfPeople(numberOfPeople);
            setPrice(numberOfPeople * pricePerPerson);
        }
    }

    @Override
    public void orderFood(BakedFood food) {
//Orders the provided food (think of a way to collect all the food which is ordered).
        this.foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        this.drinkOrders.add(drink);
//Orders the provided drink (think of a way to collect all the drinks which are ordered).
    }

    @Override
    public double getBill() {
        //Returns the bill for all of the ordered drinks and food.
        return this.foodOrders.stream().mapToDouble(BakedFood::getPrice).sum()
                + this.drinkOrders.stream().mapToDouble(Drink::getPrice).sum()
                + numberOfPeople * pricePerPerson;
    }

    @Override
    public void clear() {
//Removes all the ordered drinks and food
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
// and finally frees the table
        this.setReserved(false);
// sets the count of people
        this.numberOfPeople = 0;
// and price to 0.
        this.price = 0;
    }

    @Override
    public String getFreeTableInfo() {
        StringBuilder print = new StringBuilder();
        print.append("Table: ").append(this.getTableNumber()).append(System.lineSeparator())
                .append("Type: ").append(this.getClass().getSimpleName()).append(System.lineSeparator())
                .append("Capacity: ").append(this.getCapacity()).append(System.lineSeparator())
                .append(String.format("Price per Person: %.2f", this.getPricePerPerson()));
        return print.toString();
    }
}
