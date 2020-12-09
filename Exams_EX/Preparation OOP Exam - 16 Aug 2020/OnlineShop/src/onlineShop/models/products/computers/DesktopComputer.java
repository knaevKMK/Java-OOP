package onlineShop.models.products.computers;

public class DesktopComputer extends BaseComputer {
    private static final double OVERAL_PERFORMENCE = 15;

    public DesktopComputer(int id, String manufacturer, String model,
                           double price) {
        super(id, manufacturer, model, price, OVERAL_PERFORMENCE);
    }
}
