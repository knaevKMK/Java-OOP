package bakery.entities.table;

import bakery.entities.interfaces.BakedFood;
import bakery.entities.interfaces.Drink;
import bakery.entities.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static bakery.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public class BaseTable implements Table {
    private Collection<BakedFood> foodOrders;
    private Collection<Drink> drinkOrders;
    private int tableNumber;
    private int capacity;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReserved;
    private double price;

    public BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.foodOrders = new ArrayList<>();
        this.drinkOrders = new ArrayList<>();
        setTableNumber(tableNumber);
        setCapacity(capacity);
        setPricePerPerson(pricePerPerson);
        setReserved(false);
    }

    private void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    private void setCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
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
//•	foodOrders - Collection<BakedFood> accessible only by the base class
    //•	drinkOrders – Collection<Drink> accessible only by the base class
    //•	tableNumber – int the table number
    //•	capacity - int the table capacity.
    //o	 It can’t be less than zero. In these cases, throw an IllegalArgumentException with message "Capacity has to be greater than 0"
    //•	numberOfPeople - int the count of people who want a table.
    //o	 cannot be less or equal to 0. In these cases, throw an IllegalArgumentException with message "Cannot place zero or less people!"
    //•	pricePerPerson – double the price per person for the table
    //•	isReserved - boolean returns true if the table is reserved, otherwise false.
    //•	price – double calculates the price for all people

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        setReserved(true);
    }

    @Override
    public void orderFood(BakedFood food) {

    }

    @Override
    public void orderDrink(Drink drink) {

    }

    @Override
    public double getBill() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public String getFreeTableInfo() {
        return null;
    }
}
