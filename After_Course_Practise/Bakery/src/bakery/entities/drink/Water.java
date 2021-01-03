package bakery.entities.drink;

public class Water extends BaseDrink {
    private static final double price = 1.5;

    public Water(String name, int portion, String brand) {
        super(name, portion, price, brand);
    }
}
