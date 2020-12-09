package onlineShop.models.products.components;

public class Motherboard extends BaseComponent {
    private static final double OVERALL_PERFORMENCE = 1.25;

    public Motherboard(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, OVERALL_PERFORMENCE * overallPerformance, generation);
    }
}
