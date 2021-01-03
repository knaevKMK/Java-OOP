package bakery.entities.bakedfood;

public class Bread extends BaseFood {
    private static final double InitialBreadPortion = 200;

    public Bread(String name, double price) {
        super(name, InitialBreadPortion, price);
    }
}
