package bakery.core;

import bakery.core.interfaces.Controller;
import bakery.entities.interfaces.BakedFood;
import bakery.entities.interfaces.Drink;
import bakery.entities.interfaces.Table;
import bakery.repositories.DrinkRepositoryImpl;
import bakery.repositories.FoodRepositoryImpl;
import bakery.repositories.TableRepositoryImpl;
import bakery.repositories.interfaces.DrinkRepository;
import bakery.repositories.interfaces.FoodRepository;
import bakery.repositories.interfaces.TableRepository;

public class ControllerImpl implements Controller {
    private DrinkRepository<Drink> drinks;
    private FoodRepository<BakedFood> foods;
    private TableRepository<Table> tables;
    private double totalIncome;

    public ControllerImpl() {
        this.drinks = new DrinkRepositoryImpl();
        this.foods = new FoodRepositoryImpl();
        this.tables = new TableRepositoryImpl();
        this.totalIncome = 0.0;
    }

    @Override
    public String addFood(String type, String name, double price) {
        return null;
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        return null;
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        return null;
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        return null;
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        return null;
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        return null;
    }

    @Override
    public String leaveTable(int tableNumber) {
        return null;
    }

    @Override
    public String getFreeTablesInfo() {
        return null;
    }

    @Override
    public String getTotalIncome() {
        return null;
    }
}
